<template>
  <div class="user">
    <router-link
      to="/user/add"
      v-if="
        this.$store.state.isLogin === true &&
        this.$store.state.user.role === 'admin'
      "
      >添加用户</router-link
    >
    <div class="single-user" v-for="user in users" :key="user.id">
      <div class="row-info">
        <div class="label">标识</div>
        <div class="value">
          {{ user.id }}
        </div>
      </div>
      <div class="row-info">
        <div class="label">邮箱</div>
        <div class="value">
          {{ user.email }}
        </div>
      </div>
      <div class="row-info">
        <div class="label">用户名</div>
        <div class="value">{{ user.username }}</div>
      </div>
      <div class="row-info">
        <div class="label">昵称</div>
        <div class="value">{{ user.nickname }}</div>
      </div>
      <div class="row-info">
        <div class="label">手机号</div>
        <div class="value">{{ user.phonenumber }}</div>
      </div>
      <div class="row-info">
        <div class="label">描述</div>
        <div class="value">{{ user.description }}</div>
      </div>
      <div class="row-info">
        <div class="label">密码</div>
        <div class="value">{{ user.password }}</div>
      </div>
      <div class="row-info">
        <div class="label">注册时间</div>
        <div class="value">{{ user.regTime }}</div>
      </div>
      <div class="row-info">
        <div class="label">身份</div>
        <div class="value">{{ user.role }}</div>
      </div>
      <div class="row-info">
        <div class="label">状态</div>
        <div class="value">{{ user.enabled }}</div>
      </div>
      <div
        v-if="
          this.$store.state.isLogin === true &&
          this.$store.state.user.role === 'admin'
        "
      >
        <button @click="del(user.id)">删除</button>
        <button @click="update(user.id)">更新</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "UserView",
  data() {
    return {
      show: false,
      users: [],
    };
  },
  created() {
    axios
      .get(this.$root.backend + "/user")
      .then((res) => {
        this.users = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  },
  methods: {
    addUser() {
      this.$router.push("/user/add");
    },
    update(id) {
      this.$router.push("/user/update/" + id);
    },
    del(id) {
      axios
        .delete(this.$root.backend + "/user/" + id)
        .then((res) => {
          //reload
          if (res.status === 200) {
            this.users = this.users.filter((user) => user.id !== id);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>
