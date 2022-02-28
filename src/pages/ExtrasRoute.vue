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
      <el-col class='col' :span="11" v-for="(o, index) in data.length" :key="o">
        <el-card class='cardbody' :body-style="{
          padding: '0px',
          background: '#0D0E0FFF',
          color: '#fff',
          fontWeight: 'bold',
          // border: '0px solid gray',
          borderBottom: '10px solid #E94AE3FF',
        }" @click.native="detail()">

          <div class="itemsbg"></div>
          <img src="../assets/extras/extras1.png" class="image">

          <!--{{o.itemBasicInfo.name}}}-->
          <div style="padding: 14px;" class="textbody">
            <span class="name"
                  ref="itemname"
                  :data-id="data[index].itemBasicInfo.id"
                  :data-name="data[index].itemBasicInfo.name">

              <!--依照data列表的数组index来获取数组中对应的元素-->
              {{ data[index].itemBasicInfo.name }}

            </span>
            <div class="bottom clearfix">
              <div class="origin"
                   ref="originprice"
                   :data-price="data[index].itemBasicInfo.price">
                ￥{{ data[index].itemBasicInfo.price }}
              </div>
              <br>
              <div class="now" ref="currentprice"
                   :data-cprice="data[index].itemBasicInfo.price * data[index].itemSaleInfo.onsalePercent * 0.01">
                ￥{{ data[index].itemBasicInfo.price * data[index].itemSaleInfo.onsalePercent * 0.01 }}
              </div>
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
      currentDate: new Date(),
      category: null,
      // 测试数据-要与后端保持一致
      "data": this.$store.state.itemList.itemArray
    }
  },
  computed: {
    // 失效方法，使用传统解决方案
    // price(index)  {
    //   return this.data[index].itemBasicInfo.price
    // }
  },
  methods: {
    detail() {

      this.$router.push({
        // 目标路由
        name: 'product',
        params: {
          //示例数据
          category: 'extras',
          amount: 1,
          id: this.$refs.itemname[0].dataset.id,
          name: this.$refs.itemname[0].dataset.name,
          originPrice: this.$refs.originprice[0].dataset.price,
          currentPrice: this.$refs.currentprice[0].dataset.cprice
        }
      })
    },
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

    },
  },
  mounted() {

    this.$store.dispatch('itemList/getItemList', 'extras')
    this.created()
  }

}
</script>

<style scoped>
/*导入外部数据*/
@import "./../assets/css/extraroute.css";

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