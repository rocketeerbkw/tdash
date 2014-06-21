#!/usr/bin/env bash

# System deps
apt-get update
apt-get install -y default-jre unzip git postgresql

# Program deps
mkdir /vagrant/bin
wget https://github.com/downloads/yui/yuicompressor/yuicompressor-2.4.2.zip
unzip yuicompressor-2.4.2.zip
cp yuicompressor-2.4.2/build/yuicompressor-2.4.2.jar /vagrant/bin/
wget http://repo.typesafe.com/typesafe/ivy-releases/org.scala-tools.sbt/sbt-launch/0.10.0/sbt-launch.jar
cp sbt-launch.jar /vagrant/bin/sbt-launch_0.10.jar
wget http://downloads.sourceforge.net/project/winstone/winstone/v0.9.10/winstone-0.9.10.jar
cp winstone-0.9.10.jar /vagrant/bin/

# Create database
sudo -u postgres -H sh -c "createdb tdash"
sudo -u postgres -H sh -c "echo \"ALTER ROLE postgres WITH PASSWORD 'xyz'\" | psql tdash"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/tdashDB.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion2.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion3.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion4.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion5.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion6.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion7.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion8.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion9.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion10.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion11.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion12.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion13.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion14.sql"
sudo -u postgres -H sh -c "psql tdash < /vagrant/admin/db/updateToVersion15.sql"
