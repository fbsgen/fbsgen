# fbsgen - codegen and scaffolding

code generator with a custom dsl on top of proto files with flatbuffers semantics.

### Codegen via templates
[st4](https://github.com/antlr/stringtemplate4)
  - templates are always compiled to st4-bytecode when parsed and executed by st4 at runtime
  - the st4-bytecode is not cached
  - delimiters: ```«»```

[jetg](https://github.com/fbsgen/jetg)
  - templates are compiled to java source files when parsed, and then compiled to .class files, and then added to classpath
  - non-modified template's output class is cached on disk which means this generates code faster after the first run (skips parsing and javac)
  - delimiters: ```«»``` (check out https://github.com/fbsgen/jetg#overview for more details)

### Project scaffolding
  * uses [st4](https://github.com/antlr/stringtemplate4) templates for the files
  * interpolation on file/folder names via mustache syntax ```{{ }}```

