<template>
  <div class="car-detail">
    <!-- <div class="title">{{ title }}</div> -->
    <div>
      <img src="@/assets/logo.png" alt="" srcset="" />
    </div>
    <p>
      <span>
        {{ brand }}
        {{ car.brand }}
      </span>
      <span>
        {{ model }}
        {{ car.model }}
      </span>
      <span>
        {{ mileage }}
        {{ car.mileage }}
      </span>
    </p>
    <p>
      <span>
        {{ newprice }}
        {{ car.newprice }}
      </span>
      <span>
        {{ price }}
        {{ car.price }}
      </span>
      <span>
        {{ firstpayment }}
        {{ car.firstpayment }}
      </span>
    </p>

    <p>
      <span>
        {{ cc }}
        {{ car.cc }}
      </span>
      <span>
        {{ licensedate }}
        {{ car.licensedate }}
      </span>
    </p>
  </div>
  <div class="detail-table">
    <table>
      <tr>
        <td>
          <span>{{ ppowerseat }}</span>
        </td>
        <td>
          <span class="success" v-if="car.ppowerseat">V</span>
          <span class="error" v-if="!car.ppowerseat">X</span>
        </td>
      </tr>
      <tr>
        <td>
          <span>{{ spowerseat }}</span>
        </td>
        <td>
          <span class="success" v-if="car.spowerseat">V</span>
          <span class="error" v-if="!car.spowerseat">X</span>
        </td>
      </tr>
      <tr>
        <td>
          <span>{{ formerradar }}</span>
        </td>
        <td>
          <span class="success" v-if="car.formerradar">V</span>
          <span class="error" v-if="!car.formerradar">X</span>
        </td>
      </tr>
      <tr>
        <td>
          <span>{{ afterradar }}</span>
        </td>
        <td>
          <span class="success" v-if="car.afterradar">V</span>
          <span class="error" v-if="!car.afterradar">X</span>
        </td>
      </tr>
      <tr>
        <td>
          <span>{{ buttonstart }}</span>
        </td>
        <td>
          <span class="success" v-if="car.buttonstart">V</span>
          <span class="error" v-if="!car.buttonstart">X</span>
        </td>
      </tr>
      <tr>
        <td>
          <span>{{ gps }}</span>
        </td>
        <td>
          <span class="success" v-if="car.gps">V</span>
          <span class="error" v-if="!car.gps">X</span>
        </td>
      </tr>
      <tr>
        <td>
          <span>{{ mfl }}</span>
        </td>
        <td>
          <span class="success" v-if="car.mfl">V</span>
          <span class="error" v-if="!car.mfl">X</span>
        </td>
      </tr>
      <tr>
        <td>
          <span>{{ parkassist }}</span>
        </td>
        <td>
          <span class="success" v-if="car.parkassist">V</span>
          <span class="error" v-if="!car.parkassist">X</span>
        </td>
      </tr>
      <tr>
        <td>
          <span>{{ turbo }}</span>
        </td>
        <td>
          <span class="success" v-if="car.turbo">V</span>
          <span class="error" v-if="!car.turbo">X</span>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      title: "车辆详情",
      car: {},
      brand: "品牌",
      model: "型号",
      mileage: "公里数",
      price: "二手价",
      newprice: "新车价",
      firstpayment: "首付",
      cc: "排量",
      licensedate: "上牌日期",
      bhairbag: "后排头部气囊",
      bcentrearmrest: "后坐中央扶手",
      fhairbag: "前排头部气囊",
      fairbag: "前排侧气囊",
      fcentrearmrest: "前坐中央扶手",
      ppowerseat: "主驾驶电动座椅",
      spowerseat: "副驾驶电动座椅",
      afterradar: "后驻车雷达",
      buttonstart: "一键启动",
      formerradar: "前驻车雷达",
      gps: "GPS导航系统",
      immobilizer: "发动机电子防盗",
      mfl: "多功能方向盘",
      parkassist: "自动泊车",
      turbo: "涡轮增压",
    };
  },
  created() {
    const item = this.$route.params.id;
    axios.get(this.$root.backend + "/car/" + item).then((resp) => {
      this.car = resp.data;
    });
  },
};
</script>

<style scoped>
span {
  margin: 10px;
}
</style>
