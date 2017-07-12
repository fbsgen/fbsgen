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
