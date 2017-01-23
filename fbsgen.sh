#!/bin/sh

CURRENT_DIR=$PWD
# locate
if [ ! -n "$BASH_SOURCE" ]; then
    SCRIPT_DIR=`dirname "$(readlink -f "$0")"`
else
    F=$BASH_SOURCE
    while [ -h "$F" ]; do
        F="$(readlink "$F")"
    done
    SCRIPT_DIR=`dirname "$F"`
fi

# ==================================================

PROPS_FILE=_.properties

if [ ! -e $CURRENT_DIR/$PROPS_FILE ]; then
    PROPS_FILE=codegen.properties
    [ ! -e $CURRENT_DIR/$PROPS_FILE ] && echo "$PROPS_FILE not found on current dir." && exit 0
fi

JAR_FILE=$SCRIPT_DIR/fbsgen-compiler/target/fbsgen.jar
[ ! -e $JAR_FILE ] && [ -e $SCRIPT_DIR/templates/fbsgen.jar ] && JAR_FILE=$SCRIPT_DIR/templates/fbsgen.jar

if [ ! -n "$TEMPLATE_PATH" ]; then
    TEMPLATE_PATH=.,$SCRIPT_DIR/templates
    [ -d $CURRENT_DIR/templates ] && TEMPLATE_PATH=templates,$SCRIPT_DIR/templates
fi

if [ ! -n "$PROTO_PATH" ]; then
    if [ -d ../proto/base ]; then
        PROTO_PATH=../proto/base,proto/shared,proto/server
    elif [ -d p ]; then
        # raw dirs
        PROTO_PATH=..
    elif [ -d ../p ]; then
        # symlinked dirs
        PROTO_PATH=../p
    elif [ -d proto ]; then
        PROTO_PATH=proto
    else
        PROTO_PATH=.
    fi
fi

# proto search strategy
# setting it to 4 will search in this order: proto_path, relative_path, classpath
[ -n "$PROTO_SS" ] || PROTO_SS=4

# The search strategy for templates is in this order: template_path, classpath 

java -Dtemplate_path=$TEMPLATE_PATH \
    -Dproto_path=$PROTO_PATH \
    -Dproto_search_strategy=$PROTO_SS \
    -Dfbsgen.print_stack_trace=false \
    -Dfbsgen.sequential_field_numbers=true \
    -jar $JAR_FILE $PROPS_FILE $@
