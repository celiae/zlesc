<template>
  <div class="car-add">
    <div class="upload-img">
      <input type="file" ref="image" />
      <button @click="uploadimg">确认添加</button>
    </div>
    <div class="form">
      <div class="inputs">
        <div class="input-wrapper">
          <div class="row-input" v-for="item in items" :key="item.id">
            <span> {{ item.name }} </span>
            <input :type="item.type" v-model="item.value" />
          </div>
        </div>
        <div class="row-input">
          <span>排量</span>
          <input type="text" v-model="cc" />
          <input type="radio" name="turbo" value="true" v-model="turbo" />
          <label for="html">涡轮增压</label><br />
          <input type="radio" name="not_turbo" value="false" v-model="turbo" />
          <label for="css">自然吸气</label><br />
        </div>
      </div>
      <div class="checkboxes">
        <div class="select-all">
          <span>全选</span>
          <input
            @change="select_all_change"
            type="checkbox"
            v-model="checked_all"
          />
        </div>
        <div class="input-wrapper">
          <div class="row-input" v-for="item in checkbox_items" :key="item.id">
            <span>{{ item.name }}</span>
            <input :type="item.type" v-model="item.value" />
          </div>
        </div>
      </div>
    </div>
    <button @click="create_car()">提交</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      checked_all: false,

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
      ],
      checkbox_items: [
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
  methods: {
    create_car: function () {
      console.log(this.cc, this.turbo);
      axios
        .post(this.$root.backend + "/car", {
          brand: this.items[0].value,
          model: this.items[1].value,
          mileage: this.items[2].value,
          newprice: this.items[3].value,
          price: this.items[4].value,
          firstpayment: this.items[5].value,
          cc: this.cc,
          licensedate: this.items[6].value,

          //checkbox
          bhairbag: this.checkbox_items[0].value,
          bcentrearmrest: this.checkbox_items[1].value,
          fhairbag: this.checkbox_items[2].value,
          fairbag: this.checkbox_items[3].value,
          fcentrearmrest: this.checkbox_items[4].value,
          ppowerseat: this.checkbox_items[5].value,
          spowerseat: this.checkbox_items[6].value,
          afterradar: this.checkbox_items[7].value,
          buttonstart: this.checkbox_items[8].value,
          formerradar: this.checkbox_items[9].value,
          gps: this.checkbox_items[10].value,
          immobilizer: this.checkbox_items[11].value,
          mfl: this.checkbox_items[12].value,
          parkassist: this.checkbox_items[13].value,
          turbo: this.turbo,
          u_id: this.$store.state.id,
        })
        .then(() => {
          this.$router.replace("/reload/car");
        });
    },
    select_all_change: function () {
      this.checkbox_items.forEach((item) => {
        if (item.type === "checkbox") item.value = this.checked_all;
      });
    },
    uploadimg: function () {
      let image = this.$refs.image;
      if (image.files.length !== 0) {
        let fromdata = new FormData();
        fromdata.append("file", image.files[0]);
        axios.post(this.$root.backend + "/car/image", fromdata).then((res) => {
          console.log(res);
        });
      }
    },
  },
};
</script>
