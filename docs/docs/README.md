# 简易静态导航网站生成

灵感来自于 https://github.com/ChaosCoffee/site

## 效果

![uz9or2](https://cdn.jsdelivr.net/gh/mikusugar/PictureBed@master/uPic/2022/02/uz9or2.png)

https://mikusugar.me/SugarHome/cn/index.html

## 简述

利用了java 模版引擎读取模版生成html，利用了GitHub ACTION 打包生成静态网页并存放在web分支。

## 使用步骤

+ 依据需要修改 src/main/resources/in.json 配置文件。

+ 依据需要修改 src/main/resources/example.html 的模版文件，一般情况主要改title和页脚。

+ 在GitHub 仓库设置添加secrets  SSH_KEY 可以推送GitHub 的ssh私钥。![siRmdc](https://cdn.jsdelivr.net/gh/mikusugar/PictureBed@master/uPic/2022/02/siRmdc.png)

+ 依据需要修改 .github/workflows/build.yml ，一般情况主要是改git信息。

+ 推送到GitHub 后如果不出意外会触发Action，接着会有一个新分支出现，最后在GitHub setting的page指定page得路径即可。

  ![agJPTt](https://cdn.jsdelivr.net/gh/mikusugar/PictureBed@master/uPic/2022/02/agJPTt.png)

  
