FROM openjdk:8-jdk-alpine

MAINTAINER WANGBO

RUN echo 'Asia/Shanghai' >/etc/timezone
RUN ln -sf /user/share/zoneinfo/Asia/Shanghai /etc/localtime

VOLUME /home/servermgr
RUN mkdir -p /home/servermgr

WORKDIR /home/servermgr

COPY ./target/server-mgr-RELEASE.jar /home/servermgr/server-mgr-RELEASE.jar
COPY start.sh /home/servermgr/start.sh

ENTRYPOINT ["sh","start.sh"]
