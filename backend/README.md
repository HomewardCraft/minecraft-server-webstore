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

PO 从数据库表中查出来的最原始的数据, 封装到BO中  
BO 封装了PO, 由业务层传输到控制器  
VO 将BO传输到view

# 模块

## com.homeward.webstore

### aop
+ advice
    > CustomExceptionCatch - 捕获特定的运行时异常, 返回给前端数据  
    > PlayerInformationLog - 玩家在首次登录, 其uuid与name被记录到数据库时记录到日志
+ annotations
    > JoinPointSymbol - 自定义注解, 用于辅助构建切入点表达式
+ pointcuts
    > CustomExceptionCatch - advice中CustomExceptionCatch的命名切入点  
    > PlayerInformationLog - advice中PlayerInformationLog的命名切入点

### common
+ consts
    > SystemConst - 核心常量
+ enums
    > BaseEnum - 枚举类接口, 用于在返回给前端的对象中直接使用枚举  
    > StatusEnum - 状态枚举
+ utils
    > CartUtil - 购物车的工具类  
    > ConstUtil - 常量工具类  
    > CookieUtil - cookie工具类(目前没用)  
    > JsonResult - jsonResult工具类(目前没用)  
    > JsonUtil - json工具类(目前没用)  
    > JwtUtil - JWT工具类  
    > RedisUtil - redis工具类(目前没用)  
    > SpringContextUtil - spring上下文工具类

### config
+ 
    > AspectConfig - 切面配置  
    > BootStartConfig - 启动容器时一些初始化的配置  
    > CustomWebMvcConfig - 拦截器的配置  
    > DefaultFastjsonConfig - fastjson配置  
    > LogDirConfig - logback路径配置  
    > MybatisPlusConfig - mybatisplus配置(目前没用)  
    > RedisConfig - redis配置(目前没用)  
    > SimpleBeanConfig - 一些简单bean的配置

### controller
+  
    > CartController - 购物车的controller  
    > PlayerInfoController - 玩家信息的controller  
    > StoreController - 商品的controller

### handler
+ interceptor
    > LoginInterceptor - 验证登陆状态的拦截器
+ listener(目前没用)
    > MetaObjectHandler - 数据库元数据自动插入  
    > RedisExpirationListener - redis数据过期通知

### mapper
+ 
    > AuthenticationMapper - 用于校验数据的mapper  
    > CartMapper - 对购物车进行操作的mapper  
    > PlayerInfoMapper - 玩家信息操作的mapper  
    > StoreMapper - 对商品操作的mapper

### pojo(结构混乱, 摆大烂)
+ merchandise 商品pojo
    > ItemsList - 商品的属性, 内部封装OnSale
    > OnSale - 记录折扣信息
+ playerinfo
    > 玩家的属性
+ userapi 屁用没有
+ BasePojo 基础pojo

### service
+ order
    > CartService - 购物车的service  
    > CartServiceImpl - 购物车的service实现类
+ player
    > PlayerInfoService - 玩家信息的service  
    > PlayerInfoServiceImpl - 玩家信息的service实现类
+ store
    > StoreService - 商品的service  
    > StoreServiceImpl - 商品service的实现类

### vo
+ 
    > items - useless  
    > R - 目前在用的, 用于封装给前端的返回值  
    > UserAPIResult - useless

### WebstoreApplication 主启动类

## classpath

### mappers
+ 
    > AuthenticationMapper.xml - 用作对数据校验操作  
    > CartMapper.xml - 用作对购物车的操作  
    > PlayerInfoMapper.xml - 用作对玩家信息的操作  
    > StoreMapper.xml - 用作对商店的操作

### static 烂的

### application.yml 主配置文件

### logback-spring.xml logback配置文件

## 特别鸣谢

为什么我的不算呢？

