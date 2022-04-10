<template>
  <div class="footer">ALL RIGHTS RESERVE&copy; {{ year }} zlesc</div>
</template>

<script>
export default {
  data() {
    return {
      year: new Date().getFullYear(),
    };
  },
};
</script>

<style lang="scss" scoped>
@import "../assets/scss/theme.scss";

</style>
