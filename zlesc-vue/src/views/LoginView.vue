<template>
  <div class="login">
    <div class="form">
      <h3>{{ title }}</h3>
      <div class="row-input">
        <input
          type="text"
          v-model="username_email_phone"
          :placeholder="ph_user"
          autofocus
        />
      </div>
      <div class="row-input">
        <input type="password" v-model="password" :placeholder="ph_pwd" />
      </div>
      <div id="isRegisterd" v-if="isRegisterd">此账号已注册,请直接登录</div>
      <div>
        <button @click="LoginOrSignup()">{{ buttonMsg }}</button>
      </div>
      <div class="login-error" v-if="showLoginErr">error</div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import swal from "sweetalert";

export default {
  data() {
    return {
      title: "登陆&注册",
      username_email_phone: "celiae",
      password: "celiae",
      ph_user: "用户名 手机号 密码", //placeholder ph_
      ph_pwd: "密码",
      buttonMsg: "登陆或注册",
      showLoginErr: false,

      isRegisterd: false,
      users: [],
    };
  },
  methods: {
    LoginOrSignup: function () {
      let registerd = false;
      axios
        .get(this.$root.backend + "/user")
        .then((res) => {
          if (res !== null) {
            this.users = res.data;
            this.users.forEach((user) => {
              if (
                user.email === this.username_email_phone ||
                user.phonenumber === this.username_email_phone ||
                user.username === this.username_email_phone
              ) {
                registerd = true;
                this.isRegisterd = true;
              }
            });
            if (registerd) {
              this.login();
            } else {
              this.signup();
            }
          } else {
            console.log("res is null");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    login: function () {
      axios
        .post(this.$root.backend + "/login", {
          username_email_phone: this.username_email_phone,
          password: this.password,
        })
        .then((res) => {
          if (res.status === 200) {
            this.$store.commit("setUserId", res.data.id);
            this.$store.commit("setUserEmail", res.data.email);
            this.$store.commit("setUserUsername", res.data.username);
            this.$store.commit("setUserNickname", res.data.nickname);
            this.$store.commit("setUserPhonenumber", res.data.phonenumber);
            this.$store.commit("setUserDescription", res.data.description);
            this.$store.commit("setUserPassword", res.data.password);
            this.$store.commit("setUserRegTime", res.data.regTime);

            if (res.data.role === 0) {
              this.$store.commit("setUserRole", "admin");
            } else if (res.data.role === 1) {
              this.$store.commit("setUserRole", "user");
            } else {
              this.$store.commit("setUserRole", "guest");
            }

            this.$store.commit("setUserEnabled", res.data.enabled);
            this.$store.commit("setIsLogin", true);
            this.$router.push("/");
          } else {
            console.log("error");
          }
        })
        .catch(() => {
          this.showLoginErr = true;
        });
    },
    signup: function () {
      swal({
        title: "是否要注册?",
        text: "检测到该用户未注册",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      }).then((willSignup) => {
        if (willSignup) {
          let email = null;
          let phonenumber = null;
          let username = null;
          let reg_email =
            /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
          let reg_phonenumber = /^1[3-9]\d{9}$/;
          let reg_username = /^[a-zA-Z0-9_.-]{4,16}$/;
          if (reg_email.test(this.username_email_phone)) {
            console.log("email");
            email = this.username_email_phone;
          } else if (reg_phonenumber.test(this.username_email_phone)) {
            console.log("phonenumber");
            phonenumber = this.username_email_phone;
          } else if (reg_username.test(this.username_email_phone)) {
            console.log("username");
            username = this.username_email_phone;
          } else {
            console.log("error");
          }

          axios
            .post(this.$root.backend + "/user", {
              email: email,
              username: username,
              phonenumber: phonenumber,
              password: this.password,
              regTime: new Date(),
              role: 1,
              enabled: true,
            })
            .catch((err) => {
              console.log(err);
            });

          this.$router.replace("/login");
        } else {
          swal("你取消了注册!", {
            icon: "error",
          });
        }
      });
      console.log("signup");
    },
  },
};
</script>

<style scoped>
.login {
  display: grid;
  place-items: center;
}
button {
  width: 10rem;
}
</style>
