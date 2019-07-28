FROM mysql:8

ENV LANG C.UTF-8
ENV TZ Asia/Tokyo

ARG MYSQL_ROOT_PASSWORD=password
ENV MYSQL_ROOT_PASSWORD $MYSQL_ROOT_PASSWORD

ADD ./docker-entrypoint-initdb.d /docker-entrypoint-initdb.d

EXPOSE 3306
