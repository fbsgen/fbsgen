#!/bin/sh

CURRENT_DIR=$PWD

SCRIPT_DIR=$CURRENT_DIR

if [ ! -d $SCRIPT_DIR/../fbsgen-compiler ]; then
    
    SCRIPT=$(readlink -f "$0")
    # Absolute path this script is in
    SCRIPT_DIR=$(dirname "$SCRIPT")
fi

JAR_FILE=$SCRIPT_DIR/../fbsgen-compiler/target/fbsgen.jar
[ -e $SCRIPT_DIR/../lib/fbsgen.jar ] && JAR_FILE=$SCRIPT_DIR/../lib/fbsgen.jar

TEMPLATE_PATH=.
[ -d $CURRENT_DIR/templates ] && TEMPLATE_PATH=templates

java -Dtemplate_path=$TEMPLATE_PATH,$SCRIPT_DIR/../templates \
    -Dcli.imports=fbsgen/base \
    -Dcli.options=hello:world,foo:bar \
    -jar $JAR_FILE one:1 two:2 $@ <<EOF
«module.o:{k|option «k»:«module.o.(k)»}; separator="\n"»
«params:{k|param «k»:«params.(k)»}; separator="\n"»
EOF
