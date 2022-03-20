# Homeward WebStore Bridge

<p align="center">
<img src = "https://user-images.githubusercontent.com/39553613/145566584-494920e6-bdac-4c23-985d-9d00187c90e1.jpg">
</p>

<h4 align="center">为什么不写一个可以把指令转换成物品的插件呢 ？</h4>


<p align="center">
<a href="https://www.codefactor.io/repository/github/caishangqi/homeward-gemdeposit"><img src="https://www.codefactor.io/repository/github/caishangqi/homeward-gemdeposit/badge" alt="CodeFactor" /></a>
<img alt="Lines of code" src="https://img.shields.io/tokei/lines/github/Caishangqi/Homeward-GemDeposit">
<img alt="Lines of code" src="https://img.shields.io/badge/paper-1.18.1-green">
<img alt="GitHub branch checks state" src="https://img.shields.io/github/checks-status/Caishangqi/Homeward-GemDeposit/master?label=build">
<img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/Caishangqi/Homeward-GemDeposit">
</p>


## 介绍 Introduction

    通过网络购物的形式把指令转换成Minecraft物品并保存在购买者GUI中
    

![main](https://user-images.githubusercontent.com/39553613/159148443-bba892c3-4b22-4b22-8c27-d0223242fc7f.gif)
![info](https://user-images.githubusercontent.com/39553613/159148533-9bedef73-3ea2-48f1-97bc-051378ec2d6f.png)


## 特性 Features

- 无需使用任何 **rcon**，你只需要往数据库中储存指定类型的数据
- 安全的中断缓解，无论是崩溃或者玩家掉线都可以最大程度地保存数据
- 只要你想，理论上可以支持任何插件的自定义物品

## 表内容 Context



|  uuid  | item_id | amount | command |
|:------:|:-------:|:------:|:-------:|
| 玩家唯一标识 |  物品的编号  |   数量   |  执行指令   |

你**需要操作**的表是 `player_cart` 该表的信息上

其中 `command` 的写法如下 [类型] + [名称] + [数量]

例如：`minecraft apple 2` 意味着2个原版苹果

例如 `itemsadder ruby 2` 意味着 ItemsAdder 类型的物品 2个 ruby 

物品编号不是强制要求可以不用填写，插件在进行表转换时会将`amount`替换成物品栏位的格子数 **(slot)**

------


| id  |  uuid  | item_stack | amount | item_id |
|:---:|:------:|:----------:|:------:|:-------:|
| 表主键 | 玩家唯一标识 |  物品二进制数据   |   数量   |  物品格子   |
 
你**无需操作**的表为 `cart_item` 它是 表 `player_cart` 进行转换后的表格，这并不意味这你不需要了解它，它包含了实质物品byte数据，如果遇到了任何问题，你可以在这张表进行修改操作。


其中 `item_stack` 的物品数据你可以使用指令 `/deserialize` 来进行游戏内的反序列化来进行物品调试，相反你可以使用 `/serialize` 来对手持物品进行序列化，输出结果会显示在聊天框。


切记，玩家每次关闭GUI时都会将GUI内的物品储存在该表中，**你使用 /reload 重启服务器的指令会清空GUI内的物品缓存，请别这样做！**

## 未来计划 TODO

- 提供更加完整的Log并且完善配置文件
- 添加MMOItems，ItemsAdder，以及Crates类型物品的支持
- 更加安全的数据库操作，为每个步骤添加事物回滚

## 特别说明 Special Information

这是一个专门给服务器使用的插件，主要需求会依照服务器需求进行配置，您的需求可能会被延后，感谢谅解。

_This is a plug-in specially used for the server. The main requirements will be configured according to the server
requirements. Your requirements may be delayed. Thank you for your understanding._

你必参考文档来进行数据库配置，否则此插件无法读取到正确的物品值。

_You must refer to the documentation for database configuration, otherwise this plugin cannot read the correct item value._ 
