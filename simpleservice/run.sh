#!/bin/bash

set -a
source .prod_env

source run_common.sh

docker-compose -p "$CONTAINER_PREFIX"_ up --scale fortune=2 -d