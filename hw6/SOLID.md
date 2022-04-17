# 依赖倒置原则——Dependency inversion principle
## 一、定义
- 抽象不应该依赖于细节。细节应该依赖于抽象。
- 依赖倒置原则主要体现在两个方面：
    1. 高层模块不应该依赖于低层模块，二者都应该依赖于抽象。
    2. 抽象不应该依赖于具体实现细节，而具体实现细节应该依赖于抽象。

## 二、实现
- **为什么要遵循DIP?**
  现在考虑一个问题，当高层模块依赖于低层模块时意味着什么。高层模块包含了一个应用程序中的重要的策略选择和业务模型。正是这些高层模块才使得其所在的应用程序区别于其他。然而，如果这些高层模块依赖于低层模块，那么对低层模块的改动就会直接影响到高层模块，从而迫使它们依次做出改动。若遵循依赖倒置原则则，底层模块依赖于高层模块，则不会出现这样的情况。
- **遵循DIP的类结构**
  按照该原则的做法设计一个类结构，该类的结构从高层模块开始到低层模块是这样的：
    High Level Classes –> Abstraction Layer –> Low Level Classes

## 三、例子
> 例子：
> 一个拷贝模块，从键盘上读取字符并将其写入打印机设备。
包含逻辑的高层模块类是Copy类。低层模块类是KeyboardReader和PrinterWriter。

*在未遵循DIP的设计中，高层模块类直接使用，并且很大程度上依赖于低层模块类。*
**非DIP代码如下：**
```java
// Dependency Inversion Principle - Bad example

class Worker 
{
public:
    void work() 
    {
        // ....working
    }
};



class Manager 
{
private:
    Worker worker;
public:
    void setWorker(Worker w) 
    {
        worker = w;
    }
     void manage() 
    {
        worker.work();
    }
};

class SuperWorker
{
public:
    void work()
    {
        //.... working much more
    }
};
```
>在这种情况下，如果我们想要更改设计，将输出到一个新的FileWriter类中，那么我们必须在Copy类中进行更改。
(假设它是一个非常复杂的类，逻辑复杂并且难以进行测试，类似log可以输出到屏幕，文件，远程计算上等)

>为了避免这些问题，我们可以在高层模块类和低层模块类之间引入一个抽象层。由于高层模块包含复杂的逻辑，所以它们不应该依赖于低层模块，因此新的抽象层不应该基于低层模块创建。低层模块基于抽象层创建。两边都依赖于抽象层。

*下面的代码支持依赖倒置原则。在这个新设计中，通过IWorker接口添加了一个新的抽象层。现在，上述代码的问题得到了解决(考虑到高层逻辑中没有变化)。*

**DIP代码如下：**
```java
// Dependency Inversion Principle - Good example
class IWorker
{
public:
    void work() {}
};

class Worker :public IWorker
{
public:
    void work()
    {
        // ....working
    }
};

class SuperWorker :public IWorker
{
public: void work()
{
    //.... working much more
}
};

class Manager
{
private:
    IWorker worker;

public:
    void setWorker(IWorker w)
    {
        worker = w;
    }

    void manage()
    {
        worker.work();
    }
};
```

## 四、总结

- 依赖倒置原则（Dependency Inversion Principle）是很多面向对象技术的根基。它特别适合应用于构建可复用的软件框架，其对于构建弹性地易于变化的代码也特别重要。并且，因为抽象和细节已经彼此隔离，代码也变得更易维护。