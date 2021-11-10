# 1. 组员（1人）

## 21210240419  张超  计算机学院  电子信息专业

# 2. 运行
### 代码语言为 Haskell
```
ghc .\final.hs
.\final.exe
```
对非法输入仅会提示 `Reboot please, before the machine break down.` ,不会做特殊处理，输入不规范数据可能会出现异常，内存泄漏等。

## 3.example

```
PS D:\9709\Desktop\works\fdu_asdt> .\final.exe
Please input your position like this:
o..
x.o
.xo
Now please input yours:
...
...
x.o
Now tell me if you are 'x' or 'o':
x
Let me tell you something about the future...
It shows that you will win, there must be something wrong
```
```
PS D:\9709\Desktop\works\fdu_asdt> .\final.exe
Please input your position like this:
o..
x.o
.xo
Now please input yours:
...
...
x.o
Now tell me if you are 'x' or 'o':
o
Let me tell you something about the future...
Go out and do not play this game again
PS D:\9709\Desktop\works\fdu_asdt> 
```