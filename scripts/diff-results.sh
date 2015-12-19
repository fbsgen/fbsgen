#!/bin/sh

TARGET_DIR=target

if [ ! -n $1 ]; then
  diff $TARGET_DIR/batch/$1 $TARGET_DIR/batch2/$1 > ~/Desktop/ggg.diff
  exit 0
fi

ARGS="test.fbs test.proto test.html test.h test_externc.cpp test_generated.h"
#ARGS="test_generated.h"

mkdir -p $TARGET_DIR/diff

for F in $ARGS; do
  diff $TARGET_DIR/batch/$F $TARGET_DIR/batch2/$F > $TARGET_DIR/diff/$F.diff
done
