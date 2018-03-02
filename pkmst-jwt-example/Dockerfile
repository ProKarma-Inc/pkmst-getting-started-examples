FROM frolvlad/alpine-oraclejdk8:slim
COPY target/mstfj-jwt.jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dserver.port=8081","/app.jar"]
ENV HOST_NAME mdt-product
ENV HOST_PORT 8081
ENV REGISTRY_DOCKER_URL mdt-registry:8761
ENV ZIPKIN_DOCKER_URL mdt-zipkin:9411
ENV SPRING_ADMIN_DOCKER_URL mdt-spring-admin:8080
