FROM ubuntu:trusty
MAINTAINER rocketeerbkw@gmail.com

RUN  apt-get update \
  && apt-get install -y wget unzip default-jre make

RUN wget -qO- https://deb.nodesource.com/setup_6.x | bash -
RUN wget -qO- https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -
RUN echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list

RUN  apt-get update \
  && apt-get install -y nodejs yarn

RUN mkdir -p /tdash/bin
RUN wget https://github.com/downloads/yui/yuicompressor/yuicompressor-2.4.2.zip
RUN wget http://repo.typesafe.com/typesafe/ivy-releases/org.scala-tools.sbt/sbt-launch/0.10.0/sbt-launch.jar
RUN unzip yuicompressor-2.4.2.zip
RUN cp yuicompressor-2.4.2/build/yuicompressor-2.4.2.jar /tdash/bin/
RUN cp sbt-launch.jar /tdash/bin/sbt-launch_0.10.jar

WORKDIR /tdash
