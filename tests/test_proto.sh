#!/bin/sh

CURRENT_DIR=$PWD

SCRIPT_DIR=$CURRENT_DIR

if [ ! -e $SCRIPT_DIR/../fbsgen/base.stg ]; then
    
    SCRIPT=$(readlink -f "$0")
    # Absolute path this script is in
    SCRIPT_DIR=$(dirname "$SCRIPT")
    
    # change to this dir
    cd $SCRIPT_DIR
fi

#export TEMPLATE_PATH=$SCRIPT_DIR/templates
#export PROTO_PATH=$SCRIPT_DIR/proto
#./$SCRIPT_DIR/../fbsgen.sh

../fbsgen.sh
