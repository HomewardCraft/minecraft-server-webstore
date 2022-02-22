<!-- extras的商品的页面 -->
<template>


  <div class="container">
    <div class="title">
      Extras
    </div>
    <input type="text"
           :placeholder="placeholder"
           @focus="focus"
           @blur="unfocus"
           ref= "inputtext"
    >
    <br>
    <el-row>
      <el-col :span="6" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 2 : 0">
        <el-card :body-style="{ padding: '0px' }">
          <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
          <div style="padding: 14px;">
            <span>好吃的汉堡</span>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
              <el-button type="text" class="button">操作按钮</el-button>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

  </div>


</template>

<script>
//TODO 建立搜索框 设置每页展示最大数
export default {
  name: "ExtrasRoute",
  data() {
    return {
      placeholder: "按 Enter 来聚焦搜索",
      currentDate: new Date()
    }
  },
  methods: {
    focus() {
      this.placeholder = " "
    },
    unfocus() {
      this.placeholder = "按 Enter 来聚焦搜索"
    },
    created() {

      //监控当前组件的键盘事件
      var _self = this;
      document.onkeydown = function () {
        var key = window.event.keyCode;
        if (key == 13) { //如果是空格
          _self.$refs.inputtext.focus(); //转移焦点
        }
      }

    }
  },
  mounted() {
    this.created()

  }

}
</script>

<style scoped>
/*导入外部数据*/
@import "~@/assets/css/extraroute.css";


input:focus {
  border-style: solid;
  border-width: 1px;
  border-radius: 6px;
  border-color: yellow;
}


input {

  padding: 12px 24px;
  font-size: 20px;
  color: #FFFFFF;

  margin: 20px;
  width: 500px;
  height: 30px;
  border-style: solid;
  border-width: 1px;
  border-radius: 6px;
  border-color: #555656;
  background-color: rgba(0, 0, 0, 0.08);


}

.container {
  margin: auto;

  padding-top: 40px;

  text-align: center;
  width: 1100px;
  display: block;
  /*border: 3px solid #9d66ac;*/
  /*background-color: #833f96;*/
}


.title {

  font-size: 42px;
  font-weight: bold;
  color: #FFFFFF;

}


</style>