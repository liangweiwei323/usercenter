# 使用 adoptopenjdk 11 版本的基础镜像
#FROM openjdk:21.0-jre-buster
#
## 拷贝应用程序代码到容器中
#WORKDIR /app
#COPY user-center-0.0.1-SNAPSHOT.jar ./app.jar
#
## 构建应用程序
#
## 运行应用程序
#CMD ["java", "-jar", "/app/app.jar","--spring.profiles.active=prod"]
# Docker 镜像构建
FROM maven:3.5-jdk-8-alpine as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package -DskipTests

# Run the web service on container startup.
CMD ["java","-jar","/app/target/user-center-backend-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]
