
#### webpack介绍
-  [官网](https://www.webpackjs.com/)
- loader
```
用于对模块源码的转换，loader描述了webpack如何处理非javascript模块，并且在buld中引入这些依赖。
loader可以将文件从不同的语言（如TypeScript）转换为JavaScript，或者将内联图像转换为data URL。比如说：CSS-Loader，Style-Loader等
```
- plugin
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
