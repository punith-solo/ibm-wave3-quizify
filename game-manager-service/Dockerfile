FROM openjdk:11

ADD ./target/game-manager-service-0.0.1-SNAPSHOT.jar /event/src/game-manager-service-0.0.1-SNAPSHOT.jar
EXPOSE 8102
WORKDIR event/src
ENTRYPOINT ["java","-jar","game-manager-service-0.0.1-SNAPSHOT.jar"]
