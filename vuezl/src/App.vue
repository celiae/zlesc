<template>
  <Header />
  <router-view class="view" v-slot="{ Component }">
    <transition name="fade">
      <component :is="Component" />
    </transition>
  </router-view>
  <Footer />
</template>

<script lang="">
import { defineComponent } from "vue";
import Header from "@/components/Header.vue";
import Footer from "@/components/Foorter.vue";
export default defineComponent({
  name: "App",
  components: {
    Header,
    Footer,
  },
  data() {
    return {
      backend: "http://localhost:8081",
    };
  },
  methods: {
    isAdmin() {
      return this.$store.state.user.role === "admin";
    },
  },
});
</script>

<style lang="scss">
@import "@/assets/scss/theme.scss";

.view {
  min-height: 91vh;
  box-shadow: 0px 0px 10px $blue inset;
}
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: $dark;
}
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s ease;
}
.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}
</style>
