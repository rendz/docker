#!/bin/bash

set -a
source .prod_env

source run_common.sh

docker-compose -f docker-compose.yaml -f docker-compose-prod.yaml  -p "$CONTAINER_PREFIX"_ up --scale fortune=2 -d