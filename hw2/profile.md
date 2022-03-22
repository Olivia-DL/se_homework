### 使用profile工具探究插入排序中什么操作最耗时
![3](./3.jpg)
从图中可以看出Sort.sort()在Sort.main()之前，可知Sort.sort()更耗时。程序运行的主要时间是消耗在Sort.sort()函数上，即进行插入排序操作的函数耗时最多。