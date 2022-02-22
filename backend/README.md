# 结构

java
  - com.homeward.webstore
    - aop
      - advice
          > CustomExceptionAdvice - 捕获特定的运行时异常, 返回给前端数据  
          > PlayerInformationAdvice - 玩家在首次登录, 其uuid与name被记录到数据库时记录到日志
      - annotations
          > JoinPointSymbol - 自定义注解, 用于辅助构建切入点表达式
      - pointcuts
          > CustomExceptionAdvice - advice中CustomExceptionCatch的命名切入点  
          > PlayerInformationAdvice - advice中PlayerInformationLog的命名切入点
    - common
      - consts
          > BaseConst - 常量接口  
          > SystemConst - 核心常量  
          > DateEnum 日期枚举
      - enums
          > BaseEnum - 枚举类接口, 用于在返回给前端的对象中直接使用枚举  
          > StatusEnum - 状态枚举
      - utils
          > CartUtil - 购物车的工具类  
          > ConstUtil - 常量工具类  
          > CookieUtil - cookie工具类  
          > JsonResult - jsonResult工具类  
          > JsonUtil - json工具类  
          > JwtUtil - JWT工具类  
          > RedisUtil - redis工具类  
          > SpringContextUtil - spring上下文工具类
    - config
        > AspectConfig - 切面配置  
        > BootStartConfig - 启动容器时一些初始化的配置  
        > CustomWebMvcConfig - 拦截器的配置  
        > DefaultFastjsonConfig - fastjson配置  
        > LogDirConfig - logback路径配置  
        > MybatisPlusConfig - mybatisplus配置  
        > RedisConfig - redis配置  
        > SimpleBeanConfig - 一些简单bean的配置
    - controller
        > CartController - 购物车的controller  
        > ItemController - 商品的controller  
        > PlayerController - 玩家信息的controller
    - handler
      - interceptor
          > LoginInterceptor - 验证登陆状态的拦截器
      - listener
          > MetaObjectHandler - 数据库元数据自动插入  
          > RedisExpirationListener - redis数据过期通知
    - java.bean
      - BO
          > ItemInfoBO - 商品信息的封装对象  
          > PlayerInfoBO - 玩家信息的封装对象
      - PO
          > BasicPersistentObject - PO接口  
          > ItemBasicInfo - 商品的基础信息PO  
          > ItemSaleInfo - 商品的售价信息PO  
          > PlayerBasicInfo - 玩家的基础信息PO
      - VO
          > R - 返回给前端的对象
    - mapper
        > AuthenticationMapper - 用于校验数据的mapper  
        > CartMapper - 对购物车操作的mapper  
        > ItemMapper - 对商品操作的mapper  
        > PlayerMapper - 对玩家操作的mapper
    - service
        > CartService - 购物车service的接口  
        > CartServiceImpl - 购物车service的实现类  
        > ItemService - 商品service的接口  
        > ItemServiceImpl - 商品service的实现类  
        > PlayerService - 玩家service的接口  
        > PlayerServiceImpl - 玩家service的实现类
    - WebstoreApplication 主启动类

resources
  - mappers
      > AuthenticationMapper.xml - 用作对数据校验操作  
      > CartMapper.xml - 用作对购物车的操作  
      > ItemMapper.xml - 用作对商品的操作  
      > PlayerMapper.xml - 用作对玩家的操作
  - static - 前端文件位置
  - application.yml 主配置文件
  - logback-spring.xml logback配置文件