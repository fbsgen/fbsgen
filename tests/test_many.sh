#!/bin/sh

CURRENT_DIR=$PWD

SCRIPT_DIR=$CURRENT_DIR

if [ ! -e $SCRIPT_DIR/../fbsgen/base.stg ]; then
    
    SCRIPT=$(readlink -f "$0")
    # Absolute path this script is in
    SCRIPT_DIR=$(dirname "$SCRIPT")
fi

JAR_FILE=$SCRIPT_DIR/../fbsgen-compiler/target/fbsgen.jar
[ -e $SCRIPT_DIR/../lib/fbsgen.jar ] && JAR_FILE=$SCRIPT_DIR/../lib/fbsgen.jar

TEMPLATE_PATH=.
[ -d $CURRENT_DIR/templates ] && TEMPLATE_PATH=templates

TARGET_DIR=$SCRIPT_DIR/target/test_many
mkdir -p \
    $TARGET_DIR/first \
    $TARGET_DIR/second \
    $TARGET_DIR/third 

java -Dtemplate_path=$TEMPLATE_PATH,$SCRIPT_DIR/../templates \
    -Dcli.separator=! \
    -Dcli.imports=fbsgen/base,fbsgen/dict \
    -Dcli.options=hello:world,foo:bar \
    -jar $JAR_FILE ! -gp bar:baz \
    ! -i $SCRIPT_DIR -o $TARGET_DIR/first -p first:1 -- test.txt \
    ! -i $SCRIPT_DIR -o $TARGET_DIR/second -p second:2 -- test.txt \
    ! -i $SCRIPT_DIR -o $TARGET_DIR/third -p third:3 -- test.txt
