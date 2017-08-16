#!/bin/bash

set -a
source .debug_env

docker stop simpleservice_fortune_1
docker rm simpleservice_fortune_1

docker stop simpleservice_fortune_2
docker rm simpleservice_fortune_2

docker stop simpleservice_mysqldb_1
docker rm simpleservice_mysqldb_1

docker stop simpleservice_web_1
docker rm simpleservice_web_1

docker-compose build
docker-compose scale fortune=1

docker-compose -p simpleservice_ up

