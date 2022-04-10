<template>
  <div class="car">

    <div class="title">
      {{ title }}
    </div>
    <!-- <div class="subtitle">
      {{ subtitle }}
    </div> -->
    <div class="car-wrapper">
      <div class="car" v-for="car in cars" :key="car.id">
        <img src="@/assets/logo.png" alt="" />
        <div class="this-car">
          {{ car.brand }}
          {{ car.model }}
        </div>
        <div class="mileage">
          <span>公里数:</span>
          <span>
            {{ car.mileage }}
          </span>
        </div>
        <div class="base-info">
          <span>
            <span>二手价:</span>
            <span>
              {{ car.price }}
            </span>
          </span>
          <span>
            <span>首付:</span>
            <span>
              {{ car.firstpayment }}
            </span>
          </span>
        </div>
        <button
          v-if="
            this.$store.state.isLogin === true &&
            this.$store.state.user.role === 'admin'
          "
          @click="update(car.id)"
        >
          更新
        </button>
        <button
          v-if="
            this.$store.state.isLogin === true &&
            this.$store.state.user.role === 'admin'
          "
          @click="del(car.id)"
        >
          删除
        </button>
        <button @click="detail(car.id)">详情</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import swal from "sweetalert";

export default {
  data() {
    return {
      show: false,
      title: "ZLESC",
      subtitle: "全部车辆",
      cars: [],
    };
  },
  created() {
    axios.get(this.$root.backend + "/car").then((resp) => {
      this.cars = resp.data;
    });
  },
  methods: {
    del(id) {
      swal({
        title: "你确定要删除吗?",
        text: "一旦删除,此车辆信息将不会恢复!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      }).then((willDelete) => {
        if (willDelete) {
          axios.delete(this.$root.backend + "/car/" + id).then((resp) => {
            this.$router.replace("/reload/car");
          });
          swal("好的,已完成车辆删除", {
            icon: "success",
          });
        } else {
          swal("你保留了此车辆信息!");
        }
      });
    },
    update(id) {
      this.$router.push("/car/update/" + id);
    },
    detail(id) {
      this.$router.push("/car/" + id);
    },
  },
};
</script>

<style lang="scss" scoped>
@import "@/assets/scss/theme.scss";

.car {
  .add-car {
    margin: auto;
    border: 0;
    width: 10rem;
    color: $white;
    background: $dark;
  }
  .car-wrapper {
    display: grid;
    grid-template-columns: auto auto;
    .car {
      // border: 1px solid $dark;
      box-shadow: 1px 1px 1rem $dark ;
      margin: 1rem;
      span {
        margin: 5px;
      }
      .mileage {
        margin: 10px;
      }
      .base-info {
        background: $blue;
      }
    }
  }
  @media screen and (max-width: 768px) {
    .car-wrapper {
      grid-template-columns: auto;
    }
  }
}
</style>
