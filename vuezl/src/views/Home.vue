<template>
  <div class="home">
    <div class="title-wrapper">
      <div class="title">{{ title }}</div>
      <div class="subtitle">{{ subtitle }}</div>
      <div>
        <div class="made-by">{{ message }}</div>
        <p>{{ description }}</p>
      </div>
    </div>
    <div class="list-wrapper">
      <div class="list" v-for="usage in usages" :key="usage.id">
        {{ usage }}
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Home",
  data() {
    return {
      title: "ZLESC",
      subtitle: "真亮二手车",
      message: "Made By Celiae",
      description:
        "此系统是私人车商管理助手，致力于为私人车商提供一个方便的管理平台,欢迎您的使用！",
      usages: ["信息预览", "心中有数", "配置大全", "汽车科普"],
    };
  },
  components: {},
});
</script>

<style lang="scss" scoped>
@import "../assets/scss/theme.scss";
.home {
  .title-wrapper {
    font-size: 2rem;
    .made-by {
      background: $yellow;
      margin: 5rem;
      border-radius: 5rem;
    }
  }
  .list-wrapper {
    background: $blue;
    display: grid;
    grid-template-columns: auto auto auto auto;
    .list {
      margin: 5px;
    }
  }
}
</style>
