#!/bin/bash

var1="Hello"

echo "starting"
echo "test 1: $var1"
echo "test 2: "

if [ -z "$var1" ]
then
    echo "empty"
else
    echo "not empty"
fi

echo "finished"







