#!/bin/sh

CURRENT_DIR=$PWD

SCRIPT_DIR=$CURRENT_DIR

if [ ! -d $SCRIPT_DIR/../fbsgen-compiler ]; then
    
    SCRIPT=$(readlink -f "$0")
    # Absolute path this script is in
    SCRIPT_DIR=$(dirname "$SCRIPT")
    
    # change to this dir
    cd $SCRIPT_DIR
fi

echo '--------------------------------------- pipe'
./test_pipe.sh
echo '--------------------------------------- one'
./test_one.sh
echo '--------------------------------------- many'
./test_many.sh
echo '--------------------------------------- proto'
./test_proto.sh
