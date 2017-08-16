#!/bin/sh
docker run --net=host -it --rm --name maven-build -v "$PWD":/usr/src/project -v /home/user/workspace/volumes/maven:/root/.m2 -v /var/run/docker.sock:/var/run/docker.sock  -w /usr/src/project maven:alpine mvn package
