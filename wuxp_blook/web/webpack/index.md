
#### webpack介绍
-  [官网](https://www.webpackjs.com/)

- [入口(entry)](https://www.webpackjs.com/concepts/#%E5%85%A5%E5%8F%A3-entry-)
- [出口(output)](https://www.webpackjs.com/concepts/#%E5%87%BA%E5%8F%A3-output-)
```
publicPath:
  官方文档中对publicPath的解释是，webpack 提供一个非常有用的配置，该配置能帮助你为项目中的所有资源指定一个基础路径，它被称为公共路径(publicPath)
  其实这里说的所有资源的基础路径是指项目中引用css，js，img等资源时候的一个基础路径，这个基础路径要配合具体资源中指定的路径使用，所以其实打包后资源的访问路径可以用如下公式表示：
  静态资源最终访问路径 = output.publicPath + 资源loader或插件等配置路径
  
  example:
   
   publicPath='/web/'
   那么访问资源的路径= "http://xxx.com/web/xxx.js"
   一般来说我们在开发环境把这个路径设置为 "/"，生产环境则可以按照部署的目录来设置

```
- [loader](https://www.webpackjs.com/concepts/loaders/)
```
用于对模块源码的转换，loader描述了webpack如何处理非javascript模块，并且在buld中引入这些依赖。
loader可以将文件从不同的语言（如TypeScript）转换为JavaScript，或者将内联图像转换为data URL。比如说：CSS-Loader，Style-Loader等
```
- [plugin](https://www.webpackjs.com/concepts/plugins/)
```
目的在于解决loader无法实现的其他事，从打包优化和压缩，到重新定义环境变量，功能强大到可以用来处理各种各样的任务。
webpack提供了很多开箱即用的插件，例如：CommonChunkPlugin主要用于提取第三方库和公共模块，避免首屏加载的bundle文件，或者按需加载的bundle文件体积过大，导致加载时间过长，是一把优化的利器。而在多页面应用中，更是能够为每个页面间的应用程序共享代码创建bundle
```
- loader和plugin的不同
```
 webpack中loader和plugin这两个概念很容易为初学者混淆，
 对于loader，它就是一个转换器，将A文件进行编译形成B文件，这里操作的是文件，比如将A.scss或A.less转变为B.css，单纯的文件转换过程；
 
 对于plugin，它就是一个扩展器，它丰富了wepack本身，针对是loader结束后，webpack打包的整个过程，
 它并不直接操作文件，而是基于事件机制工作，会监听webpack打包过程中的某些节点，例如
 
 run：开始编译
 make：从entry开始递归分析依赖并对依赖进行build
 build-moodule：使用loader加载文件并build模块
 normal-module-loader：对loader加载的文件用acorn编译，生成抽象语法树AST
 program：开始对AST进行遍历，当遇到require时触发call require事件
 seal：所有依赖build完成，开始对chunk进行优化（抽取公共模块、加hash等）
 optimize-chunk-assets：压缩代码
 emit：把各个chunk输出到结果文件
 通过对节点的监听，从而找到合适的节点对文件做适当的处理。
 
 以上说明来自：https://blog.csdn.net/yq_oxygen/article/details/78107696

```
- 多环境(env或profile)支持
```
 webpack 默认支持 development和production两种环境，在生产环境下会开启
 代码压缩，JS Tree Sharking(UglifyJsPlugin支持Tree Sharking，字面意思为“摇树”，在webpack中可以理解成打包过程中移除未使用的js、css等)
```
- [modules 模块](https://www.webpackjs.com/concepts/modules/) [js模块](http://es6.ruanyifeng.com/#docs/module)
```
 通过 loader 可以支持各种语言和预处理器编写模块。loader 描述了 webpack 如何处理 非 JavaScript(non-JavaScript) _模块_，并且在 bundle 中引入这些依赖。 webpack 社区已经为各种流行语言和语言处理器构建了 loader，
  包括：
  CoffeeScript
  TypeScript
  ESNext (Babel)
  Sass
  Less
  Stylus

 而js模块多种多样，这里主要讲一下commonjs和 esm模块(ECMAScript modules)

 1:CommonJS 模块输出的是一个值的拷贝，ES6 模块输出的是值的引用。
 2: CommonJS 模块是运行时加载，ES6 模块是编译时输出接口。
 
 其他的js模块规范还有 CMD、AMD、等

```
