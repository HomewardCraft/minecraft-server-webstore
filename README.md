# 基于SpringBoot的拓展商城 

<p align="center">
<img src = "https://user-images.githubusercontent.com/39553613/151072271-e9ecf618-5c54-46d3-b77d-f159083993bb.png">
</p>

<h4 align="center">请在此描述最合适最牛逼的介绍</h4>

<p align="center">
<img alt="CodeFactor Grade" src="https://www.codefactor.io/repository/github/ba1oretto/minecraft-server-webstore/badge/master">
<img alt="Lines of code" src="https://img.shields.io/tokei/lines/github/Ba1oretto/Minecraft-Server-WebStore">
<img alt="code" src="https://img.shields.io/badge/Spring-boot-green">
<img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/y/Ba1oretto/Minecraft-Server-WebStore">
<img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/Ba1oretto/Minecraft-Server-WebStore">
</p> 

## 概述
Vue 框架 2.0 开发版本

`<script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>`


## 模块(service中的结构)
### Order模块, 通过redis实现, 只有登陆了才可以访问(拦截器)
#### 创建购物车
+ 以post请求显式的传入值 `http://127.0.0.1:50012/checkout/packages/add/{id}/single`
+ 首先通过拦截器判断用户是否有名为`HOMEWARD_ORDER_INFO`的cookie, 有则不放行, 没有则放行.
+ 用户首次添加物品时先通过名为`HOMEWARD_USER_INFO`的cookie获取值user的id, 再创建一个名为`HOMEWARD_ORDER_INFO`的cookie值为user的id, 这是接下来更新和删除操作判断用户是否拥有购物车的关键, 具体实现在拦截器里.
+ 接着向redis创建有时效的键值对, key为user的id(游戏内的id, 如果是正版用户则可以当成唯一标识), value为json形式的字符串(`{itemsId:amount}`), 里面存放了商品的id(唯一标识)与数量
#### 修改购物车中商品的数量
+ 以post请求隐式的传入值 `http://127.0.0.1:50012/checkout/update`. form-data: key: `quantity[itemsId]`, value: `amount`
+ 以修改键值对中json格式的值的数量的形式进行, 利用map接收form data的键值, 遍历获取键与值, 格式化后存储为json格式的字符串.
+ 从名`HOMEWARD_ORDER_INFO`的cookie中获取值user的id, 通过user的id来更新redis中这个user存储在redis中的value的值为先前的json字符串 
#### 删除购物车
+ 以post请求显式的传入值`http://127.0.0.1:50012/checkout/packages/remove/{id}`
+ 从名`HOMEWARD_ORDER_INFO`的cookie中获取值user的id, 在redis中以user的id删除键值对, 将cookie清除


### Player模块, 数据库与mojangAPI结合
#### 登录请求
+ 判断用户是否有过成功的登录为查数据库
+ 判断用户是否已经登陆为查cookie
+ 实现用户的伪登录(给个游戏内名字, 在mojang有记录就让你登录), 只有用户登陆了, 才可以使用购物车的功能, 具体实现为拦截器获取cookie


### Store模块
#### 商品信息
+ 返回商品信息, 没什么好说的




### 特别鸣谢

为什么我的不算呢？

