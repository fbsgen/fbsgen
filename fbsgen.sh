#!/bin/sh

CURRENT_DIR=$PWD

[ ! -e $CURRENT_DIR/codegen.properties ] && echo "codegen.properties not found on current dir." && exit 0

SCRIPT_DIR=$CURRENT_DIR

if [ ! -d $SCRIPT_DIR/fbsgen-compiler ]; then
    
    SCRIPT=$(readlink -f "$0")
    # Absolute path this script is in
    SCRIPT_DIR=$(dirname "$SCRIPT")
fi

JAR_FILE=$SCRIPT_DIR/fbsgen-compiler/target/fbsgen.jar
[ -e $SCRIPT_DIR/lib/fbsgen.jar ] && JAR_FILE=$SCRIPT_DIR/lib/fbsgen.jar

if [ -z $TEMPLATE_PATH ]; then
    TEMPLATE_PATH=.,$SCRIPT_DIR/templates
    [ -d $CURRENT_DIR/templates ] && TEMPLATE_PATH=templates,$SCRIPT_DIR/templates
fi

if [ -z $PROTO_PATH ]; then
    PROTO_PATH=.
    [ -d $CURRENT_DIR/proto ] && PROTO_PATH=proto
fi

# -Dproto_search_strategy=2 means search from classpath if the file is not found.
# The search strategy for templates is the same as above (except it cannot be changed).

java -Dtemplate_path=$TEMPLATE_PATH \
    -Dproto_path=$PROTO_PATH \
    -Dproto_search_strategy=2 \
    -Dfbsgen.print_stack_trace=false \
    -Dfbsgen.sequential_field_numbers=true \
    -Dfbsgen.resolve_enum_value_ref=true \
    -jar $JAR_FILE codegen.properties $@
