<template>
  <HeaderView />
  <router-view class="view" v-slot="{ Component }">
    <transition name="fade">
      <component :is="Component" />
    </transition>
  </router-view>
  <FoorterView />
</template>

<script>
import HeaderView from "@/components/page/HeaderView.vue";
import FoorterView from "@/components/page/FoorterView.vue";
export default {
  name: "App",
  components: {
    HeaderView,
    FoorterView,
  },
  data() {
    return {
      backend: "http://localhost:8081",
    };
  },
  computed: {
    isAdmin() {
      return (
        // this.$store.state.isLogin == true &&
        // this.$store.state.user.role === "admin"
        true
      );
    },
  },
};
</script>

<style>
:root {
  --dark: rgb(46, 46, 46);
  --blue: rgb(17, 164, 217);
  --yellow: rgb(246, 255, 74);
  --red: rgb(223, 73, 73);
  --white: rgb(255, 255, 255);
}
@import url("https://fonts.googleapis.com/css2?family=Rubik+Wet+Paint&display=swap");
/* GLOBAL CSS */
body {
  margin: 0;
  padding: 0;
}
* {
  box-sizing: border-box;
}
a {
  text-decoration: none;
  font-weight: bold;
  color: var(--blue);
}
button {
  width: 5rem;
  background: var(--dark);
  color: #fff;
  border: none;
  padding: 10px;
  border-radius: 5px;
  margin: 10px;
  cursor: pointer;
  transition: all 0.5s ease;
}
button:hover {
  box-shadow: 10px 0px 10px var(--blue) inset, -10px 0px 10px var(--blue) inset;
}
#app {
  font-family: Rubik Wet Paint;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: var(--dark);
  background: var(--white);
}
.view {
  min-height: 85vh;
}
</style>
