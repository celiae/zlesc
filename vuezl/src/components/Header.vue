<template>
  <div class="header">
    <div class="nav">
      <button @click="this.$router.push('/')">主页</button>

      <div class="dropdown" @mouseleave="this.dropdown.car = false">
        <button
          to="/car"
          class="dropbtn"
          @mouseover="this.dropdown.car = true"
          @click="this.$router.push('/car')"
        >
          汽车
        </button>
        <div class="dropdown-content" v-if="dropdown.car">
          <button
            v-if="
              this.$store.state.isLogin == true &&
              this.$store.state.user.role === 'admin'
            "
            @click="this.$router.push('/car/add')"
            to="/car/add"
          >
            汽车增加
          </button>
          <button @click="this.$router.push('/')">汽车知识</button>
        </div>
      </div>

      <div
        class="dropdown"
        @mouseleave="this.dropdown.user = false"
        v-if="
          this.$store.state.isLogin === true &&
          this.$store.state.user.role === 'admin'
        "
      >
        <button
          to="/car"
          class="dropbtn"
          @mouseover="this.dropdown.user = true"
          @click="this.$router.push('/user')"
        >
          用户
        </button>
        <div class="dropdown-content" v-if="dropdown.user">
          <button @click="this.$router.push('/user/add')" to="/car/add">
            用户增加
          </button>
          <button @click="this.$router.push('/user')">用户详情</button>
        </div>
      </div>
      <button @click="login_logout()">
        {{ this.$store.state.isLogin == false ? "登陆" : "退出" }}
      </button>
    </div>
    <div class="user">
      <div class="greeting">
        {{ greeting }}
      </div>
      <div class="account">
        {{
          this.$store.state.isLogin == false
            ? "匿名用户"
            : this.$store.state.user.nickname
        }}
      </div>
    </div>
  </div>
</template>

<script>
import swal from "sweetalert";

import { defineComponent } from "vue";

export default defineComponent({
  name: "App",
  data() {
    return {
      greeting: "你好!",
      nickname: "",
      dropdown: {
        car: false,
        user: false,
      },
    };
  },
  computed: {
    login_or_logout() {
      return this.$store.state.isLogin == false ? "/login" : "/logout";
    },
  },
  methods: {
    login_logout() {
      if (this.$store.state.isLogin == true) {
        swal({
          title: "你确定要退出吗?",
          icon: "warning",
          buttons: true,
          dangerMode: true,
        }).then((willLogout) => {
          if (willLogout) {
            this.$store.commit("setIsLogin", false);
            this.$router.replace("/login");
          } else {
            swal("你保留了登陆状态!", {
              icon: "success",
            });
          }
        });
      } else {
        this.$router.push("/login");
      }
    },
  },
});
</script>

<style lang="scss" scoped>
@import "../assets/scss/theme.scss";

.header {
  padding: 5px;
  display: flex;
  .nav {
    display: flex;
    margin-right: 5rem;
    .dropdown {
      display: grid;
      place-items: center;
      margin: 10px;
      button {
        margin: 0;
      }
      button:hover {
        color: $yellow;
        background: #000;
      }
      .dropbtn {
        background: $dark;
      }
      .dropdown-content {
        position: absolute;
        top: 50px;
        z-index: 1;
      }
    }
  }
}
a {
  width: 10rem;
}
.user {
  display: flex;
  place-items: center;
  .account {
    margin: 10px;
    border-radius: 10px;
    padding-inline: 10px;
    background: $yellow;
  }
}
</style>
