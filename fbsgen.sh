#!/bin/sh

CURRENT_DIR=$PWD

PROPS_FILE=_.properties

if [ ! -e $CURRENT_DIR/$PROPS_FILE ]; then
    PROPS_FILE=codegen.properties
    [ ! -e $CURRENT_DIR/$PROPS_FILE ] && echo "$PROPS_FILE not found on current dir." && exit 0
fi

SCRIPT_DIR=$CURRENT_DIR

if [ ! -d $SCRIPT_DIR/fbsgen-compiler ]; then
    
    SCRIPT=$(readlink -f "$0")
    # Absolute path this script is in
    SCRIPT_DIR=$(dirname "$SCRIPT")
fi

JAR_FILE=$SCRIPT_DIR/fbsgen-compiler/target/fbsgen.jar
#[ -e $SCRIPT_DIR/templates/fbsgen.jar ] && JAR_FILE=$SCRIPT_DIR/templates/fbsgen.jar

if [ ! -n "$TEMPLATE_PATH" ]; then
    TEMPLATE_PATH=.,$SCRIPT_DIR/templates
    [ -d $CURRENT_DIR/templates ] && TEMPLATE_PATH=templates,$SCRIPT_DIR/templates
fi

if [ ! -n "$PROTO_PATH" ]; then
    if [ -d ../proto/base ]; then
        PROTO_PATH=../proto/base,proto/shared,proto/server
    elif [ -d ../p ]; then
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
    -Dproto_search_strategy=4 \
    -Dfbsgen.print_stack_trace=false \
    -Dfbsgen.sequential_field_numbers=true \
    -jar $JAR_FILE $PROPS_FILE $@
