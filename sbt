#!/usr/bin/env bash

IMAGE=gdelca5/sbt

## Setup KEY=VALUE env variables for sbt
source .envrc 2>/dev/null || touch .envrc

docker run --env-file .envrc -it -p 8080:8080 --rm -v ~/.aws:/root/.aws:ro -v ~/.ivy2:/root/.ivy2 -v ~/.sbt:/root/.sbt -v $PWD:/app -w /app $IMAGE sbt "$@"