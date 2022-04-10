<template>
  <div class="user-add">
    <div class="row-input">
      <label>邮箱</label>
      <input type="text" placeholder="foo@bar.com" v-model="email" />
    </div>
    <div class="row-input">
      <label>用户名</label>
      <input type="text" placeholder="foobar" v-model="username" />
    </div>
    <div class="row-input">
      <label>昵称</label>
      <input type="text" placeholder="foobar_happy" v-model="nickname" />
    </div>
    <div class="row-input">
      <label>手机号</label>
      <input type="text" placeholder="18234913512" v-model="phone" />
    </div>
    <div class="row-input">
      <label>描述</label>
      <input type="text" placeholder="喜欢豪车" v-model="description" />
    </div>
    <div class="row-input">
      <label>密码</label>
      <input
        type="text"
        placeholder="(想一个强而有效的密码)"
        v-model="password"
      />
    </div>
    <div class="row-input">
      <label>注册时间</label>
      <input type="text" placeholder="" v-model="create_at" disabled />
    </div>
    <div class="row-input">
      <label>角色</label>
      <input type="text" placeholder="管理员" v-model="role" />
    </div>
    <div class="row-input">
      <label>状态</label>
      <input type="text" placeholder="激活" v-model="status" />
    </div>
    <button @click="create_user()">提交</button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      email: "ceelia0@163.com",
      username: "haha",
      nickname: "happy",
      phone: "18627193396",
      description: "haha",
      password: "celiae",
      created_at: "2022-01-03T00:00:00.000Z",
      role: "1",
      status: true,
    };
  },
  methods: {
    create_user: function () {
      axios
        .post(this.$root.backend + "/user", {
          email: this.email,
          username: this.username,
          nickname: this.nickname,
          phone: this.phone,
          description: this.description,
          password: this.password,
          regTime: this.created_at,
          role: this.role,
          status: this.status,
        })
        .then(() => {
          this.$router.replace("/reload/user");
        });
    },
  },
};
</script>

<style lang="scss" scoped>
@import "@/assets/scss/theme.scss";

</style>
