#!/bin/bash

set -a
source .debug_env
source run_common.sh

docker-compose -f docker-compose.yaml -f docker-compose.debug.yaml -p "$CONTAINER_PREFIX"_ up