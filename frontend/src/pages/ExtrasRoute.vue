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
           ref="inputtext"
    >
    <br>


    <el-row class='rol'>
      <el-col class='col' :span="11" v-for="(o, index) in 3" :key="o">
        <el-card class='cardbody' :body-style="{
          padding: '0px',
          background: '#0D0E0FFF',
          color: '#fff',
          fontWeight: 'bold',
          // border: '0px solid gray',
          borderBottom: '10px solid #E94AE3FF',
        }">

          <div class="itemsbg"></div>
          <img src="../assets/extras/extras1.png" class="image">


          <div style="padding: 14px;" class="textbody">
            <span class="name">符文槽</span>
            <div class="bottom clearfix">
              <div class="origin">￥45.5</div>
              <br>
              <div class="now">￥25.5</div>
              <br>
              <!-- <time class="time">{{ currentDate }}</time>-->
              <el-button type="text" class="button">
                <span class="viewitems">查看物品信息
                  <i class="el-icon-right"></i>
                </span>

              </el-button>
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

/*
 *因为特殊原因,请勿讲以下两个el和elcard移动至extraroute.css,否则样式不会生效
 *更多疑问请直接访问css import语法规则和 elementui语法规则
 */


/*配置卡身 这里是设置了卡的背景颜色和border样式*/
.el-card {
  border-radius: 0px;
  border: 1px solid #555656;
  background-color: #0d0e0f;
  color: #303133;
  transition: .3s;
}

/*卡身动画*/
/*TODO: 缺少关键帧*/
.el-card:hover {
  position: relative;
  top: -10px;
  opacity: 0.8;
}

/*非外部样式内容*/

input:focus {
  border-style: solid;
  border-width: 1px;
  border-radius: 6px;
  border-color: yellow;
}

/*输入框*/
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