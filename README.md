### 1.项目说明

  本项目是基于朋友需求对应提供的个人开发微信小程序，本文档用于记录开发过程心得和经验分享。

### 2. 项目构成

小程序项目目录结构：

```
    |-- wechat_business_client    //小程序商家后台前端页面 
    |-- wechat_business_server    //小程序商家后台功能逻辑 
    |-- wechat_client_server      //小程序客户端后台功能逻辑   
    |-- wechat_client_template    //小程序客户端前端模板
        |-- README.md
        |-- app.js
        |-- app.json
        |-- app.wxss
        |-- components    //    公共组件库
        |-- config    //    基础配置
        |-- custom-tab-bar    //    自定义 tabbar
        |-- model    //    mock 数据
        |-- pages
        |   |-- cart    //    购物车相关页面
        |   |-- coupon    //    优惠券相关页面
        |   |-- goods    //    商品相关页面
        |   |-- home    //    首页
        |   |-- order    //    订单售后相关页面
        |   |-- promotion-detail    //    营销活动页面
        |   |-- usercenter    //    个人中心及收货地址相关页面
        |-- services    //    请求接口
        |-- style    //    公共样式与iconfont
        |-- utils    //    工具库
```

### 3. 数据

 

### 4. 添加新页面

1. 在 `pages `目录下创建对应的页面文件夹
2. 在 `app.json` 文件中的 ` "pages"` 数组中加上页面路径
3. [可选] 在 `project.config.json` 文件的 `"miniprogram-list"` 下添加页面配置

## :hammer: 构建运行

1. `npm install`
2. 小程序开发工具中引入工程
3. 构建 npm

## :art: 代码风格控制

`eslint` `prettier`

## :iphone: 基础库版本

最低基础库版本`^2.6.5`

SpringBoot版本`^5.2.20`

## :dart: 反馈联系

欢迎小伙伴提供建议意见，如有侵权可联系删除
邮件联系：dumbojxx@gmail.com

## :link: 后端技术栈待更新... ...

## :page_with_curl: 开源协议

PickLes_Shop遵循 [MIT 协议](https://github.com/DumboJ/Picles_Strore/blob/master/LICENSE))
