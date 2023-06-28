# server-mgr

[README](README.md) | [中文文档](README_zh.md)

server-mgr 是一个家庭私人服务器管理应用，包括灵活的资源备份策略，苹果bark应用消息通知，邮件通知，服务器监控等。

## 为什么使用server-mgr？

在家庭服务器中部署server-mgr，server-mgr可以帮你：

* 省去购买昂贵的磁盘阵列。
* 可用极少的资源保证家庭数据安全。
* bark应用消息、邮件实时推送服务器状态。
* 服务器状态监控
* 提供服务器管理页面
* 支持docker快速部署

## 开发状态

目前0.1.0版本已经支持本地文件备份功能（支持手动或自动）。

后续功能将会在未来，陆续开发出来。

由于项目暂时只有一人维护，后续迭代会稍慢，请见谅。

## 仪表盘

[server-mgr-web](https://github.com/newbiebo/server-mgr-web/tree/master)

## 快速开始
安装docker请参考[docker官方文档](https://docs.docker.com/get-started/)

无需任何操作直接执行如下命令即可体验：
```
docker run xxx 
```
建议暴漏端口，挂载数据文件
```
docker run -it -d \
--name server-mgr \
-p 8023:8023 \
-v xxxx
```

## 联系我

📫:1186644190wxb@gmail.com

## 状态
![Repobeats analytic](https://repobeats.axiom.co/api/embed/37feeaf5e311f5920acab4b589a37d1465b08c5e.svg "Repobeats analytics image")


