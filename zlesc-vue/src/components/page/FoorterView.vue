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

<style scoped>
.footer {
  bottom: 0;
  width: 100%;
  background: var(--dark);
  color: var(--white);
  font-size: 1.2rem;
  text-align: center;
  line-height: 3rem;
}
</style>
