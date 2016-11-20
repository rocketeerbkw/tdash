FROM postgres:9.3
MAINTAINER rocketeerbkw@gmail.com

ENV POSTGRES_USER docker
ENV POSTGRES_PASSWORD docker

COPY admin/tdashDB.sql /docker-entrypoint-initdb.d/tdashDB.sql
COPY admin/db /docker-entrypoint-initdb.d/
