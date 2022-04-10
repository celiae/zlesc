<template>
  <div class="header">
    <div class="nav">
      <button @click="this.$router.push('/')">主页</button>

      <div class="dropdown">
        <button class="dropdown-btn" @click="this.$router.push('/car')">
          汽车
        </button>
        <div class="dropdown-content">
          <button
            v-if="this.$root.isAdmin"
            @click="this.$router.push('/car/add')"
          >
            汽车增加
          </button>
          <button @click="this.$router.push('/')">汽车知识</button>
        </div>
      </div>

      <div class="dropdown">
        <button
          class="dropdown-btn"
          v-if="this.$root.isAdmin"
          @click="this.$router.push('/user')"
        >
          用户
        </button>
        <div class="dropdown-content">
          <button
            v-if="this.$root.isAdmin"
            @click="this.$router.push('/user/add')"
            to="/car/add"
          >
            用户增加
          </button>
          <button v-if="this.$root.isAdmin" @click="this.$router.push('/user')">
            用户详情
          </button>
        </div>
      </div>
    </div>
    <div class="user">
      <button @click="login_logout()">
        {{ this.$store.state.isLogin == false ? "登陆" : "退出" }}
      </button>
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

export default {
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
};
</script>
<style scoped>
.header {
  position: sticky;
  top: 0;
  width: 100%;
  background: #2c3e50;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.nav {
  display: flex;
  justify-content: space-around;
  align-items: center;
}
.dropdown {
  position: relative;
  display: inline-block;
  margin: 10px;
}
.dropdown-content {
  display: none;
  position: absolute;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  z-index: 1;
}
.dropdown:hover .dropdown-content {
  display: grid;
}
.dropdown button {
  margin: 0;
  border-radius: 0;
}
.user {
  display: flex;
  align-items: center;
  color: var(--white);
}
</style>
