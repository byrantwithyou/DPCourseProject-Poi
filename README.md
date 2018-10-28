# DPCourseProject-Poi
This is the git repo for the "Design Pattern" course project given in School of Software Engineering, Tongji University, Fall 2018. The instructor is Jie Hou and Jinsong Feng.

##Git 使用规范

1. 分支说明
- master分支：不要管
- develop分支：稳定的开发分支，切忌**直接往develop分支提交代码**。
- feature/***：各个功能的开发分支。**请只在自己的功能分支下工作**。

2. 初次使用clone仓库
```
git clone git@github.com:byrantwithyou/DBCourseProject-Poi.git
```
3. 在develop分支的基础上创建新的功能分支feature/X

```
git checkout develop

git checkout -b feature/X
```

4. feature/X开发完成，首先要更新本地develop分支
```
git checkout deveop
git pull origin develop
```
5. 切换到feature/X分支，进行rebase操作
```
git checkout feature/X
git rebase develop（如果这时候有冲突，只能联系写这部分代码的人，手动合并。）
```
6. 将feature/X推入Github
```
git push origin feature/X
```
7. 去GitHub上发Pull Request请求:feature/X - > develop(**微信上提前告诉我一声再发Pull Request**)


##代码规范
1. 类名：首字母大写、驼峰
2. 变量、属性、方法：首字母小写、驼峰
3. 注释：尽量采用Java Doc规范

##时间节点

1. 刘博远同学在周日之前尽量完成framework基础部分。
2. 其他同学在周二之前完成各自设计模式以及对应的application、文档（尽量），周二下午碰头。
3. 涉及到两个同学公共部分在微信群里多交流。
4. 请务必遵循Git使用规范，代码规范。
