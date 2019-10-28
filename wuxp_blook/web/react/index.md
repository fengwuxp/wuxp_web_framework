
#### react
- [中文网](https://react.docschina.org/)
- [jsx](https://react.docschina.org/docs/introducing-jsx.html)  [深入JSX](https://react.docschina.org/docs/jsx-in-depth.html)  总之JSX的本质是函数调用
```
下面内容来自于官网：

const element = <h1>Hello, world!</h1>;

这个有趣的标签语法既不是字符串也不是 HTML。
它被称为 JSX，是一个 JavaScript 的语法扩展。我们建议在 React 中配合使用 JSX，
JSX 可以很好地描述 UI 应该呈现出它应有交互的本质形式。JSX 可能会使人联想到模版语言，
但它具有 JavaScript 的全部功能。

在编译之后，JSX 表达式会被转为普通 JavaScript 函数调用，并且对其取值后得到 JavaScript 对象
实际上，JSX 仅仅只是 React.createElement(component, props, ...children) 函数的语法糖
<MyButton color="blue" shadowSize={2}>
  Click Me
</MyButton>
会编译为：

React.createElement(
  MyButton,
  {color: 'blue', shadowSize: 2},
  'Click Me'
)
```
- [元素渲染](https://react.docschina.org/docs/rendering-elements.html),元素是构成 React 应用的最小砖块
```
React 元素其实就是一个简单JavaScript对象，一个React 元素和界面上的一部分DOM对应，描述了这部分DOM的结构及渲染效果。
与浏览器的 DOM 元素不同，React 元素是创建开销极小的普通对象。React DOM 会负责更新 DOM 来与 React 元素保持一致。
React 元素是不可变对象。一旦被创建，你就无法更改它的子元素或者属性。一个元素就像电影的单帧：它代表了某个特定时刻的 UI
``` 
- [组件](https://react.docschina.org/docs/components-and-props.html) 组件允许你将 UI 拆分为独立可复用的代码片段，并对每个片段进行独立构思
```
 React组件最核心的作用是返回React元素，组件是由元素构成的
 组件可以在其输出中引用其他组件。这就可以让我们用同一组件来抽象出任意层次的细节。按钮，表单，对话框，甚至整个屏幕的内容：在 React 应用程序中，这些通常都会以组件的形式表示

 // 类组件
 class Input extends React.Component<InputPops,InputState>{
 
   render(){
   return <input />
   }
 }
  
 //函数式组件 
 const FunctionComponent=(props:FunctionComponent)=>{

  return <div></div>
 } 
  
```
- [Props 只读性]
```
组件无论是使用函数声明还是通过 class 声明，都决不能修改自身的 props，即props is readonly
props 是对外可见的，在使用组件是需要显示的传入，本质上就是函数的参数（react的组件就是函数）
```
-[State & 生命周期]
```
state 是用来存储组件的内部状态的，对外不可见的
示例：
class Clock extends React.Component<ClockProps,ClockSate> {
  constructor(props) {
    super(props);
    this.state = {date: new Date()};
  }

  componentDidMount() {
  
  }

  componentWillUnmount() {

  }

  render() {
    return (
      <div>
        <h1>Hello, world!</h1>
        <h2>It is {this.state.date.toLocaleTimeString()}.</h2>
      </div>
    );
  }
}

State 的更新可能是异步的
出于性能考虑，React 可能会把多个 setState() 调用合并成一个调用。
更新state的方式为：
  this.setState({
    //支持部分更新
    ...new State
  },()=>{
    //回调，可选参数
  })
  
State 的更新会被合并
当你调用 setState() 的时候，React 会把你提供的对象合并到当前的 state。

例如，你的 state 包含几个独立的变量：

  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      comments: []
    };
  }
然后你可以分别调用 setState() 来单独地更新它们：

  componentDidMount() {
    fetchPosts().then(response => {
      this.setState({
        posts: response.posts
      });
    });

    fetchComments().then(response => {
      this.setState({
        comments: response.comments
      });
    });
  }
这里的合并是浅合并，所以 this.setState({comments}) 完整保留了 this.state.posts， 但是完全替换了 this.state.comments。

数据是向下流动的
不管是父组件或是子组件都无法知道某个组件是有状态的还是无状态的，并且它们也并不关心它是函数组件还是 class 组件。  

```
- [图解ES6中的React生命周期](https://blog.csdn.net/qq_25073545/article/details/82824839)
- [事件处理](https://react.docschina.org/docs/handling-events.html)
```
React 事件的命名采用小驼峰式（camelCase），而不是纯小写。
使用 JSX 语法时你需要传入一个函数作为事件处理函数，而不是一个字符串。

例如，传统的 HTML：

<button onclick="activateLasers()">
  Activate Lasers
</button>
在 React 中略微不同：

<button onClick={activateLasers}>
  Activate Lasers
</button>

事件处理本质上就是给组件传入一个函数类型的prop
事件处理函数中传入一个event参数，这个event是一个合成事件。React 根据W3C规范来定义这些合成事件，所以你不需要担心跨浏览器的兼容性问题

你必须谨慎对待 JSX 回调函数中的 this，在 JavaScript 中，class 的方法默认不会绑定 this。所有建议类里面读写箭头函数，不然要手动使用bind方法绑定this对象

向事件处理程序传递参数
在循环中，通常我们会为事件处理函数传递额外的参数。例如，若 id 是你要删除那一行的 ID，以下两种方式都可以向事件处理函数传递参数：

<button onClick={(e) => this.deleteRow(id, e)}>Delete Row</button>
<button onClick={this.deleteRow.bind(this, id)}>Delete Row</button>

```
-[条件渲染](https://react.docschina.org/docs/conditional-rendering.html) 在 React 中，你可以创建不同的组件来封装各种你需要的行为。然后，依据应用的不同状态，你可以只渲染对应状态下的部分内容
```
```
[列表 & Key](https://react.docschina.org/docs/lists-and-keys.html)
```
  <ul>
    return items.map((item,index)=>{
   
      return <li key={index}>{item}</li>
    })
  </ul>
```
- [表单](https://react.docschina.org/docs/forms.html) 在 React 里，HTML 表单元素的工作方式和其他的 DOM 元素有些不同，这是因为表单元素通常会保持一些内部的 state
- [非受控组件](https://react.docschina.org/docs/uncontrolled-components.html) [React中受控组件和非受控组件](https://segmentfault.com/a/1190000012962205)
- [状态提升](https://react.docschina.org/docs/lifting-state-up.html)通常，多个组件需要反映相同的变化数据，这时我们建议将共享状态提升到最近的共同父组件中去
- [组合 vs 继承](https://react.docschina.org/docs/composition-vs-inheritance.html) React 有十分强大的组合模式。我们推荐使用组合而非继承来实现组件间的代码重用
```
 面向对象的 is A 和 has A
```
- [React 哲学](https://react.docschina.org/docs/thinking-in-react.html) 我们认为，React 是用 JavaScript 构建快速响应的大型 Web 应用程序的首选方式。它在 Facebook 和 Instagram 上表现优秀

-[React 深入系列1：React 中的元素、组件、实例和节点](https://blog.csdn.net/xuchaobei123/article/details/79488099)

- 高阶组件 [高阶函数](https://baijiahao.baidu.com/s?id=1616366107595017691&wfr=spider&for=pc) [react系列（21）高阶组件](https://blog.csdn.net/zeping891103/article/details/84066554)
```
 高阶函数：高阶函数是对其他函数进行操作的函数，可以将它们作为参数或返回它们。 简单来说，高阶函数是一个函数，它接收函数作为参数或将函数作为输出返回
 高阶组件（HOC），它描述的便是接受React组件作为输入，输出一个新的React组件的组件。更通俗地描述为，高阶组件通过包裹（wrapped）被传入的React组件，
 经过一系列处理，最终返回一个相对增强（enhanced）的React组件，供其他组件调用。它只是处理统一包装（处理）其它组件的一种模式

```
#### react hooks
- [Hook](https://react.docschina.org/docs/hooks-intro.html) Hook 是 React 16.8 的新增特性。它可以让你在不编写 class 的情况下使用 state 以及其他的 React 特性
