<template>
  <div class="user-update">
    <div class="form">
      <div class="row-input">
        <label>邮箱</label>
        <input type="text" placeholder="foo@bar.com" v-model="user.email" />
      </div>
      <div class="row-input">
        <label>用户名</label>
        <input type="text" placeholder="foobar" v-model="user.username" />
      </div>
      <div class="row-input">
        <label>昵称</label>
        <input type="text" placeholder="foobar_happy" v-model="user.nickname" />
      </div>
      <div class="row-input">
        <label>手机号</label>
        <input
          type="text"
          placeholder="18234913512"
          v-model="user.phonenumber"
        />
      </div>
      <div class="row-input">
        <label>描述</label>
        <input type="text" placeholder="喜欢豪车" v-model="user.description" />
      </div>
      <div class="row-input">
        <label>密码</label>
        <input
          type="text"
          placeholder="(想一个强而有效的密码)"
          v-model="user.password"
        />
      </div>
      <div class="row-input">
        <label>注册时间</label>
        <input type="text" placeholder="" v-model="user.regTime" disabled />
      </div>
      <div class="row-input">
        <label>角色</label>
        <input type="text" placeholder="管理员" v-model="user.role" />
      </div>
      <div class="row-input">
        <label>状态</label>
        <input type="text" placeholder="激活" v-model="user.enabled" />
      </div>
      <button @click="update()">更新</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      user: {},
    };
  },
  created() {
    const item = this.$route.params.id;
    axios.get(this.$root.backend + "/user/" + item).then((res) => {
      this.user = res.data;
    });
  },
  methods: {
    update() {
      axios
        .put(this.$root.backend + "/user/" + this.user.id, this.user)
        .then((res) => {
          if (res.status === 200) {
            this.$router.push("/user");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>
