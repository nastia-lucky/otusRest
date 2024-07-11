FROM maven:3-amazoncorretto-11

USER root

RUN mkdir -p /home/ubuntu/api-tests
WORKDIR /home/ubuntu/api-tests

COPY . .


ENTRYPOINT ["./entrypoint.sh"]
