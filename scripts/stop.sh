#!/usr/bin/env bash
# stop.sh

PROJECT_NAME="nirey-0.0.1"
PROJECT_FULL_PATH_01="/home/ec2-user/service/recorded-prdt"
JAR_FILE="$PROJECT_FULL_PATH_01/$PROJECT.jar"
LOG_PATH="$PROJECT_FULL_PATH_01/logs"

DEPLOY_LOG="$LOG_PATH/0_deploy.log"

NOW_DATETIME=$(date "+%Y-%m-%d-%aT%T")

if [ ! -d $LOG_PATH ]; then
    mkdir $LOG_PATH
fi

CURRENT_PID=$(pgrep -f $JAR_FILE)

if [ -z $CURRENT_PID ]; then
  echo "$NOW_DATETIME :: $JAR_FILE :: There is no process!" >> $DEPLOY_LOG
else
  echo "$NOW_DATETIME :: $JAR_FILE :: $CURRENT_PID stopped!" >> $DEPLOY_LOG  
  kill -9 $CURRENT_PID
fi
