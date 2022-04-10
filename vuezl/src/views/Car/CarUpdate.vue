<template>
  <div class="car-update">
    <div>{{ title }}</div>
    <div class="input-wrapper">
      <div class="row-input" v-for="item in items" :key="item.id">
        <label>{{ item.name }}</label>
        <input :type="item.type" v-model="item.value" />
      </div>
      <button @click="update()">提交</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      title: "update",
      items: [
        {
          type: "text",
          name: "品牌",
          value: "honda",
        },
        {
          type: "text",
          name: "型号",
          value: "civic",
        },
        {
          type: "text",
          name: "公里数",
          value: "2000",
        },
        {
          type: "text",
          name: "新车价",
          value: "3000",
        },
        {
          type: "text",
          name: "二手价",
          value: "4000",
        },
        {
          type: "text",
          name: "首付",
          value: "5000",
        },
        {
          type: "date",
          name: "上牌日期",
          value: "2020-01-01T11:25:00.000Z",
        },
        {
          type: "checkbox",
          name: "后坐头部气囊",
          value: false,
        },
        {
          type: "checkbox",
          name: "后排中央扶手",
          value: false,
        },
        {
          type: "checkbox",
          name: "前排头部气囊",
          value: false,
        },
        {
          type: "checkbox",
          name: "前排气囊",
          value: false,
        },
        {
          type: "checkbox",
          name: "前排中央扶手",
          value: false,
        },
        {
          type: "checkbox",
          name: "主驾驶电动座椅",
          value: false,
        },
        {
          type: "checkbox",
          name: "副驾驶电动座椅",
          value: false,
        },
        {
          type: "checkbox",
          name: "后方倒车雷达",
          value: false,
        },
        {
          type: "checkbox",
          name: "一键启动",
          value: false,
        },
        {
          type: "checkbox",
          name: "前方雷达",
          value: false,
        },
        {
          type: "checkbox",
          name: "GPS定位",
          value: false,
        },
        {
          type: "checkbox",
          name: "发动机防盗",
          value: false,
        },
        {
          type: "checkbox",
          name: "多功能方向盘",
          value: false,
        },
        {
          type: "checkbox",
          name: "自动泊车",
          value: false,
        },
      ],
      cc: "1.5",
      turbo: true,
    };
  },
  components: {},
  created() {
    const item = this.$route.params.id;
    axios.get(this.$root.backend + "/car/" + item).then((res) => {
      this.items[0].value = res.data.brand;
      this.items[1].value = res.data.model;
      this.items[2].value = res.data.mileage;
      this.items[3].value = res.data.newprice;
      this.items[4].value = res.data.price;
      this.items[5].value = res.data.firstpayment;
      this.cc = res.data.cc;
      this.items[6].value = res.data.licensedate;
      this.items[7].value = res.data.bhairbag;
      this.items[8].value = res.data.bcentrearmrest;
      this.items[9].value = res.data.fhairbag;
      this.items[10].value = res.data.fairbag;
      this.items[11].value = res.data.fcentrearmrest;
      this.items[12].value = res.data.ppowerseat;
      this.items[13].value = res.data.spowerseat;
      this.items[14].value = res.data.afterradar;
      this.items[15].value = res.data.buttonstart;
      this.items[16].value = res.data.formerradar;
      this.items[17].value = res.data.gps;
      this.items[18].value = res.data.immobilizer;
      this.items[19].value = res.data.mfl;
      this.items[20].value = res.data.parkassist;
      this.turbo = res.data.turbo;
      this.u_id = res.data.u_id;
    });
  },
  methods: {
    update() {
      axios
        .put(this.$root.backend + "/car/" + this.$route.params.id, {
          brand: this.items[0].value,
          model: this.items[1].value,
          mileage: this.items[2].value,
          newprice: this.items[3].value,
          price: this.items[4].value,
          firstpayment: this.items[5].value,
          cc: this.cc,
          licensedate: this.items[6].value,
          bhairbag: this.items[7].value,
          bcentrearmrest: this.items[8].value,
          fhairbag: this.items[9].value,
          fairbag: this.items[10].value,
          fcentrearmrest: this.items[11].value,
          ppowerseat: this.items[12].value,
          spowerseat: this.items[13].value,
          afterradar: this.items[14].value,
          buttonstart: this.items[15].value,
          formerradar: this.items[16].value,
          gps: this.items[17].value,
          immobilizer: this.items[18].value,
          mfl: this.items[19].value,
          parkassist: this.items[20].value,
          turbo: this.turbo,
          u_id: this.u_id,
        })
        .then((res) => {
          if (res.status === 200) {
            this.$router.push("/reload/car");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style lang="scss" scoped>
@import "@/assets/scss/theme.scss";
</style>
