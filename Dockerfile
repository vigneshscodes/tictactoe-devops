# Dockerfile for running TicTacToe Java application
FROM eclipse-temurin:17-jdk-alpine
LABEL maintainer="devopsuser@gmail.com"
COPY target/tictactoe-devops-0.1-jar-with-dependencies.jar /home/tictactoe-devops-0.1-jar-with-dependencies.jar
CMD ["java","-jar","/home/tictactoe-devops-0.1-jar-with-dependencies.jar","1","4","2","5","3"]

