# Project Management Platform

## Intro

A J2EE project using **Springboot**, **Thymeleaf**, **Semantic UI** and **MySQL**.

Demo: [project.homans.world](https://project.homans.world)



## Main Pages

1. Login

2. Register

3. Homepage

4. Personal Profile

5. Project Application

6. Project Management



## Main Features

为测试项目，为各个身份设置一个测试账号（账号同密码）：

1. 学生：
   * 账号：100010
   * 姓名：学生1
2. 项目导师：
   * 账号：100020
   * 姓名：项目导师1
3. 评审导师：
   * 账号：100030
   * 姓名：评审导师1
4. 管理员：
   * 账号：1000
   * 姓名：root

各身份的功能：

* 学生成员：注册、登录、个人信息管理、我的项目（组队信息）、提交项目，修改项目信息、查看项目状态信息。
* 项目导师：登录，确认学生选题，查看负责项目信息，对项目提出建议。
* 评审导师：登录，可查看项目，下载附件，对项目评价审核，打分。
* 管理员：项目类别管理，项目管理，项目成绩管理。



## Semantic UI

Semantic UI 提供了丰富的组件和可以自定义主题的功能，同时我们通过使用 Semantic UI 实现了在移动端使用的响应式设计。

### Build

要使用 Semantic UI 需要通过 npm 安装社区版的 Fomantic UI。项目中已经编译好的 css / js 文件存放在 `/src/main/resources/static/dist/` 下。如需修改 UI 风格也可自行修改 `/semantic` 中的配置文件进行编译。

Reference: <https://semantic-ui.com/introduction/build-tools.html>

* To build Semantic UI asset files run `gulp build` under `/semantic`.
* To change output path, edit `/semantic.json`.
* The output folder is currently set to `/src/main/resources/static/dist/`.



## Thymeleaf

通过使用 Thymeleaf 模板技术，我们可以实现前端设计与后端开发的分离。相对于 jsp 开发，Thymeleaf 模板文件更加直观，能够解决通过 jsp 开发时需要启动 Tomcat 才能显示页面的问题。同时，通过 Thymeleaf 引用模板 html 中的片段可以大大简化其它页面的文件大小。图为在 IDEA 中直接通过浏览器打开 common.html 模板的效果。通过 Springboot 启动后，用户名字和学工号等信息会被 Thymeleaf 模板引擎进行相应替换。

![img_0.png](assets/img_0.png)
![img_2.png](assets/img_2.png)



## GitHub Link

https://github.com/homanw104/ProjectManagement



## Authors

* 王皜民：前端设计与搭建、后端数据库、服务器部署等全栈开发
* 苏建锐：项目需求分析、前端搭建、后端数据库对接、实验报告的撰写等
* 林颂家：项目需求分析、数据库表格设计等



## Licence

This project is licenced under GPL-3.
