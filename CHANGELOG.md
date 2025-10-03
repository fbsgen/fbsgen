## 1.2.0 (2025-10-03)

* Refactor core api to have no deps

## 1.1.2 (2024-09-13)

* add helper functions for List/Map instances

## 1.1.1 (2024-09-06)

* allow references inside list/map values embedded in options/annotations

## 1.1.0 (2023-06-07)

* list/map support for option/annotation values

## 1.0.6 (2018-02-22)

* jetg output_dir resolution

## 1.0.5 (2017-08-22)

* add the option 'cas_protected' to field_acces_bits

## 1.0.4 (2017-07-29)

* allow negative index param on Writable.substr

## 1.0.3

* Validate field numbers of messages annotated with ```@MergeParent(partial = true)```

## 1.0.2

* Added kebab-case to the formatter

## 1.0.1

* Added fbsgen-fatjar module (standalone executable jar with dependencies)

## 1.0.0

* codegen using templates via:
  * [st4](https://github.com/antlr/stringtemplate4)
    - templates are always compiled to st4-bytecode when parsed and executed by st4 at runtime
    - the st4-bytecode is not cached
  * [jetg](https://github.com/fbsgen/jetg)
    - templates are compiled to java source files when parsed, and then compiled to .class files, and then added to classpath
    - non-modified template's output class is cached on disk which means this generates code faster after the first run (skips parsing and javac)

* project scaffolding
  * uses [st4](https://github.com/antlr/stringtemplate4) templates for the files
  * interpolation on file/folder names via mustache syntax ```{{ }}```
