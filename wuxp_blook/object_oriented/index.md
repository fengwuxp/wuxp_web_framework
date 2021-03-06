
#### 面向对象
- 对象
```
    由数据及其操作所构成的封装体，是系统中用来描述客观事物的一个模块，是构成系统的基本单位。
    用计算机语言来描述，对象是由一组属性和对这组属性进行的操作构成的。
    准确地说，对象是一个自包含的实体，用一组可识别的特性、行为来表示。
    
    对象包含3个基本要素，分别是对象标识、对象状态和对象行为
    例如，对于姓名（标识）为joe的教师而言，其包含性别、年龄、职位等个人状态信息，同时还具有授课等行为特征，joe就是封装后的一个典型对象。
    
```

- 类、属性、方法、访问权限控制(public、protected、默认、private)
```

   class A {
     private t:string;
     protected c:string;
   
   }
   
   class B extends A{
   
      private test=()=>{
       // this.t error
       // super.t error
       // super.c success
       // this.c success
      
      }
   
   }
   
   类和实例 //类是一种类型
   //类静态
   
   let a1:A=new A();
   let a2:A=new A();
   let a3:A=new A();
   
   let a={}   



```
#### 三大特性
- 封装
```
 将内部状态（属性）和动作（方法）进行封装，并提供公共的方法给外部使用
 
 封装是把客观事物抽象成类，并且把自己的属性和方法让可信的类或对象操作，对不可信的隐藏。
```
- 继承
```
继承是指这样一种能力：它可以使用现有类的所有功能，并在无需重新编写原来的类的情况下对这些功能进行扩展。

继承得到的新类称为“子类”或“派生类”。被继承的父类称为“基类”、“父类”或“超类”。
继承的过程是一个从一般到特殊的的过程。
继承概念的实现方式有二类：实现继承与接口继承。实现继承是指直接使用基类的属性和方法而无需额外编码的能力；接口继承是指仅使用属性和方法的名称、但是子类必须提供实现的能力；

继承与接口与抽象类
 接口可以继承接口，但用extends 而不是implement。
 接口不能继承抽象类，抽象类可以实现（implement）接口。原因是接口的实现和抽象类的继承都要重写父类的抽象方法。而接口里只能有抽象方法，抽象类里则允许有抽象方法和非抽象方法。
 抽象类可以继承实体类。
```
- 多态
```
多态性（polymorphisn）是允许你将父对象设置成为和一个或更多的他的子对象相等的技术，赋值之后，父对象就可以根据当前赋值给它的子对象的特性以不同的方式运作。
这就意味着虽然针对不同对象的具体操作不同，但通过一个公共的类，它们（那些操作）可以通过相同的方式予以调用。

实现多态，有二种方式，覆盖，重载。
覆盖，是指子类重新定义父类的虚函数的做法。
重载，是指允许存在多个同名函数，而这些函数的参数表不同（或许参数个数不同，或许参数类型不同，或许两者都不同）。

```

#### 五大基本设计原则（S.O.L.I.D）
- 单一功能
- 开闭原则
- 里氏替换
- 接口隔离
- 依赖反转
