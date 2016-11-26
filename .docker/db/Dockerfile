FROM postgres:9.3
MAINTAINER rocketeerbkw@gmail.com

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD xyz
ENV POSTGRES_DB tdash

COPY admin/tdashDB.sql /docker-entrypoint-initdb.d/tdashDB.sql
COPY admin/db /docker-entrypoint-initdb.d/
