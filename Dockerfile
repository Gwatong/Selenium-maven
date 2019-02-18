FROM maven:latest

LABEL maintainer=""

ADD . /

CMD mvn test