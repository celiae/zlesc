<template>
  <div class="reload">reload...</div>
</template>

<script>
export default {
  created() {
    const target = this.$route.params.target;
    this.$router.replace({
      path: "/" + target,
    });
  },
};
</script>

<style></style>
