#!/bin/bash

if pgrep -f "tictactoe-devops-0.1-jar-with-dependencies.jar" > /dev/null; then
  echo "OK - TicTacToe JAR is running"
  exit 0
else
  echo "CRITICAL - TicTacToe JAR is not running"
  exit 2
fi

