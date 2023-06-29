# server-mgr


[README](README.md) | [中文文档](README_zh.md)

server-mgr is a family private server management application, including flexible resource backup strategy, Apple bark application message notification, email notification, server monitoring, etc.

## why server-mgr？

Deploy server-mgr on your home server, server-mgr can help you:

* Eliminate the need to buy expensive disk arrays.
* Keep family data safe with minimal resources.
* The bark application message and email will push the server status in real time.
* Server Status Monitoring.
* Provide server management page.
* Support Docker rapid deployment.

## development status

The current version 0.1.0 already supports the local file backup function(Support manual or task).

Subsequent functions will be developed in succession in the future.

Since there is only one person developing the project for the time being, subsequent iterations will be slower, please forgive me.

## Dashboard

[server-mgr-web](https://github.com/newbiebo/server-mgr-web/tree/master)

## Quick start

### Entry

To install docker, please refer to [docker doc](https://docs.docker.com/get-started/)

You can directly execute the following command without any action to experience it:
```
docker run -it -d --restart=always --name server-mgr newbiebo/server-mgr:latest
```
### Further

We recommend that you expose the port and mount the data file
```
docker run -it -d --restart=always --name server-mgr -p 8023:8023 -v ${PWD}/db:/home/server-mgr/db newbiebo/server-mgr:latest
```

## Email Me

📫:1186644190wxb@gmail.com

## status
![Repobeats analytic](https://repobeats.axiom.co/api/embed/37feeaf5e311f5920acab4b589a37d1465b08c5e.svg "Repobeats analytics image")




