FROM openjdk:8-jdk-alpine

MAINTAINER WANGBO

RUN echo 'Asia/Shanghai' >/etc/timezone
RUN ln -sf /user/share/zoneinfo/Asia/Shanghai /etc/localtime

VOLUME /home/servermanager
RUN mkdir -p /home/servermanager

WORKDIR /home/servermanager

COPY ./target/servermanager-0.1.0.jar /home/servermanager/servermanager-0.1.0.jar
COPY start.sh /home/servermanager/start.v1.sh

ENTRYPOINT ["sh","start.sh"]
