## web前端相关

#### 前置资料库(可以优先参考)
- [javaScript学习笔记](https://github.com/anbang/javascript-notes)

#### 基础知识概览(必须掌握、熟练使用) (文末有附图)

- html5  [开发指南](https://developer.mozilla.org/zh-CN/docs/Web/Guide/HTML/HTML5) [教程](https://www.w3school.com.cn/html5/html_5_app_cache.asp)
```
  html5相关标准，以及语义化标签(组件)
  新的组件，例如：canvas、SVG、video、audio、等
  新的API， 例如：地理定位、Web存储（localStorage,sessionStorage,indexDB）
```
- css3 [教程](https://www.w3school.com.cn/css3/index.asp) [张鑫旭个人主页](https://www.zhangxinxu.com/)
```
  css基础、flex布局、盒模型、transform(2D、3D转换、矩阵变换)、动画、字体图标等
```
- [less](https://www.baidu.com/link?url=c6W8f3kFhgSKMIWGFf10qEfjb4ZVedtpldLI7pJrHKu&wd=&eqid=d5442794004780a0000000065d80eb4b)、[sass](http://sass.bootcss.com/)等 css预编译语言

- javascript，[阮一峰ECMAScript入门，很重要](http://es6.ruanyifeng.com/) [Node.js v12.10.0 文档](http://nodejs.cn/api/esm.html)
```
  js基础、面向对象基础、闭包、变量命名提升、事件轮询机制等。
  es5、es6、es7、es8等ECMAScript规范
  
  类、解构赋值、块级作用域、Promise、fetch、异步编程（async/await）
  模块和导出，commonjs amd等
  
```
- babel [中文官网,Babel 是一个JavaScript编译器](https://www.babeljs.cn/docs/index.html) 
```
 babel是一个JavaScript 编译器
 babel是一个工具链，主要用于将ECMAScript 2015+ 版本的代码转换为向后兼容的 JavaScript 语法，以便能够运行在当前和旧版本的浏览器或其他环境中。
 下面列出的是 Babel 能为你做的事情：
   语法转换
   通过 Polyfill 方式在目标环境中添加缺失的特性 (通过 @babel/polyfill 模块)
   源码转换 (codemods)
   更多请参考官网..
```
- nodejs和npm [中文网](http://nodejs.cn/)
```
  Node.js 是一个基于 Chrome V8 引擎的 JavaScript 运行环境。 Node.js 使用了一个事件驱动、非阻塞式 I/O 的模型。
  npm是一个nodejs的包管理工具
```
- 打包工具 [webpack中文网](https://www.webpackjs.com/)  [四大流行前端打包工具使用入门](https://www.ctolib.com/topics-109560.html)
```
 由于前端（js）开发进入了工程化，使用了npm、babel等工具，所以引入了各种打包工具，
 主流的工具有：
   webpack
   grunt 
   gulp 
   rollup
  
  日常开发中主要使用webpack的比较多，rollup主要是用来打包库的，例如react,reactDOM等知名的第三方库  

```
#### 前端框架 (react、vue、angular至少要掌握一个)
```
   严格来说除了angular,react和vue只能算是ui框架，主要是解决了ui渲染和ui组件抽象的问题，而不是一个完整的前端框架。  
   如状态管理：react一般额外集成 react-redux，mobx等状态管理工具，vue则提供了vuex
   路由管理：  react一般使用官方提供的react-router，vue则提供了vue-router

   angular则是一个大而全的框架，强制使用typescript，有着完善的状态管理(rxjs)，路由管理等，包括依赖注入，独立的打包工具
```
- [react](https://github.com/facebook/react) 
- [vue](https://github.com/vuejs/vue)
- [angular](https://github.com/angular/angular)
- 状态管理 [redux](https://github.com/reduxjs/redux) [中文文档](http://cn.redux.js.org/)
- 响应式编程，[rxjs](https://github.com/ReactiveX/rxjs) [响应式编程简述](https://www.jianshu.com/p/1765f658200a)

#### 社区开源库（需要了解）
- 阿里开源的 ant-design系列，包括pc端到移动端到react-native，react angular、vue应有尽有 [ant-design](https://github.com/ant-design)
- [element-ui]https://github.com/ElemeFE)
- [loadsh]()
- 小程序开发，京东[tarojs](https://github.com/NervJS/taro-ui)

#### 跨平台开发(可以了解，需要有android或ios开发等相关基础)
- [react-native](https://reactnative.cn/)
- [weex](https://weex.apache.org/cn/)

#### web component (可以了解)
- [官网](https://developer.mozilla.org/zh-CN/docs/Web/Web_Components)
- [Web Components 入门实例教程](http://www.ruanyifeng.com/blog/2019/08/web_components.html)

#### typescript (需要掌握)
- [中文官网](https://www.tslang.cn/)
```
  typescript是js的超集，一切js支持的，typescript都支持。
  typescript是为了微软和谷歌解决在项目（中大型）中，由于js的动态性（灵活性、不可控）而发明的语言。
  
  typescript通过静态类型来明确代码的类型，防止变量在复杂的程序中传递导致类型变更，发生的一系列
  难以预料的问题。
  
  typescript完全兼容js，以及es的标准，例如 Promise、异步编程等，通过打包工具(webpack),或者自带的
  tsc工具，可以将typescript的代码编译为不同版本（es5、es6、esnext等）不通模块(commonjs、adm等)的js代码

```

#### 进阶相关（花时间慢慢啃）
- http协议
- 网络相关
- 前端性能优化


#### 附上一张盗来的文章和图片
- [前端开发进阶之路](https://www.jianshu.com/p/8a3ca612f599)
- <img src="https://img-blog.csdnimg.cn/20181206170348997.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Byb2dyYW1tZXJfZmVuZw==,size_16,color_FFFFFF,t_70">
