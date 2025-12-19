# IntelliJ Community 详细模块清单

本文档提供 IntelliJ Community 项目中所有主要模块的详细清单和说明。

## 目录

1. [Platform 核心模块](#platform-核心模块)
2. [Plugins 插件模块](#plugins-插件模块)
3. [Java 支持模块](#java-支持模块)
4. [Python 支持模块](#python-支持模块)
5. [其他语言支持](#其他语言支持)
6. [构建和工具](#构建和工具)

---

## Platform 核心模块

Platform 目录包含约 160 个子模块，是 IntelliJ Platform 的核心基础设施。

### 核心 API 和实现

| 模块 | 说明 |
|------|------|
| `core-api/` | 平台核心 API 定义 |
| `core-impl/` | 核心 API 的实现 |
| `core-ui/` | 核心 UI 组件 |
| `core-nio-fs/` | 基于 NIO 的文件系统实现 |
| `platform-api/` | 平台公共 API |
| `platform-impl/` | 平台实现 |
| `platform-resources/` | 平台资源文件 |
| `platform-resources-en/` | 英文资源文件 |
| `util/` | 通用工具类 |
| `util-rt/` | 运行时工具类 |
| `util-ex/` | 扩展工具类 |
| `util-class-loader/` | 类加载器工具 |
| `util-io/` | IO 工具 |

### 编辑器相关

| 模块 | 说明 |
|------|------|
| `editor/` | 编辑器核心功能 |
| `editor-ui-api/` | 编辑器 UI API |
| `editor-ui-ex/` | 扩展编辑器 UI 功能 |
| `code-style-api/` | 代码样式 API |
| `code-style-impl/` | 代码样式实现 |
| `foldings/` | 代码折叠功能 |
| `syntax/` | 语法支持 |

### IDE 核心

| 模块 | 说明 |
|------|------|
| `ide-core/` | IDE 核心功能 |
| `ide-core-impl/` | IDE 核心实现 |
| `main/` | IDE 主入口 |
| `boot/` | IDE 启动器 |
| `bootstrap/` | 引导程序 |
| `starter/` | 启动器 |
| `warmup/` | 预热功能 |

### 项目模型

| 模块 | 说明 |
|------|------|
| `project/` | 项目模型 |
| `projectModel-api/` | 项目模型 API |
| `projectModel-impl/` | 项目模型实现 |
| `workspace/` | 工作区管理 |

### 代码分析和索引

| 模块 | 说明 |
|------|------|
| `analysis-api/` | 代码分析 API |
| `analysis-impl/` | 代码分析实现 |
| `indexing-api/` | 索引 API |
| `indexing-impl/` | 索引实现 |
| `indexing-tests/` | 索引测试 |
| `inspect/` | 代码检查 |
| `structuralsearch/` | 结构化搜索 |
| `duplicates-analysis/` | 重复代码分析 |

### 语言支持基础

| 模块 | 说明 |
|------|------|
| `lang-api/` | 语言 API |
| `lang-core/` | 语言核心 |
| `lang-impl/` | 语言实现 |
| `polySymbols/` | 多态符号 |
| `pratt/` | Pratt 解析器 |

### 代码编辑增强

| 模块 | 说明 |
|------|------|
| `completion/` | 代码补全 |
| `inline-completion/` | 内联补全 |
| `refactoring/` | 重构支持 |
| `find/` | 查找功能 |
| `searchEverywhere/` | 全局搜索 |
| `usageView/` | 使用视图 |
| `usageView-impl/` | 使用视图实现 |

### 调试支持

| 模块 | 说明 |
|------|------|
| `xdebugger-api/` | 调试器 API |
| `xdebugger-impl/` | 调试器实现 |
| `xdebugger-testFramework/` | 调试器测试框架 |
| `script-debugger/` | 脚本调试器 |

### 版本控制系统

| 模块 | 说明 |
|------|------|
| `vcs-api/` | VCS API |
| `vcs-impl/` | VCS 实现 |
| `vcs-log/` | VCS 日志查看器 |
| `vcs-tests/` | VCS 测试 |
| `dvcs-api/` | 分布式 VCS API |
| `dvcs-impl/` | 分布式 VCS 实现 |
| `lvcs-api/` | 本地历史 API |
| `lvcs-impl/` | 本地历史实现 |

### 构建和执行

| 模块 | 说明 |
|------|------|
| `build-scripts/` | 构建脚本 |
| `buildData/` | 构建数据 |
| `buildView/` | 构建视图 |
| `execution/` | 程序执行框架 |
| `execution-impl/` | 执行实现 |
| `execution-process-elevation/` | 进程提权 |
| `execution-process-mediator/` | 进程中介 |
| `execution.dashboard/` | 执行仪表板 |
| `execution.serviceView/` | 服务视图 |

### 外部系统集成

| 模块 | 说明 |
|------|------|
| `external-system-api/` | 外部系统 API |
| `external-system-impl/` | 外部系统实现 |
| `external-system-rt/` | 外部系统运行时 |
| `external-process-auth-helper/` | 外部进程认证助手 |

### UI 框架

| 模块 | 说明 |
|------|------|
| `navbar/` | 导航栏 |
| `recentFiles/` | 最近文件 |
| `favoritesTreeView/` | 收藏夹树视图 |
| `todo/` | TODO 视图 |
| `bookmarks/` | 书签 |
| `structure-view-impl/` | 结构视图实现 |
| `new-ui-onboarding/` | 新 UI 引导 |
| `new-users-onboarding/` | 新用户引导 |
| `non-modal-welcome-screen/` | 非模态欢迎屏幕 |
| `whatsNew/` | 新功能介绍 |
| `tips-of-the-day/` | 每日提示 |

### 配置和存储

| 模块 | 说明 |
|------|------|
| `configuration-store-impl/` | 配置存储实现 |
| `settings/` | 设置管理 |
| `settings-local/` | 本地设置 |
| `settings-sync-core/` | 设置同步核心 |
| `credential-store/` | 凭据存储 |
| `credential-store-impl/` | 凭据存储实现 |
| `credential-store-ui/` | 凭据存储 UI |

### 插件系统

| 模块 | 说明 |
|------|------|
| `pluginManager/` | 插件管理器 |
| `plugins/` | 插件加载 |
| `extensions/` | 扩展点系统 |
| `service-container/` | 服务容器 |
| `instanceContainer/` | 实例容器 |

### 机器学习

| 模块 | 说明 |
|------|------|
| `ml-api/` | 机器学习 API |
| `ml-impl/` | 机器学习实现 |
| `ml-logs/` | ML 日志 |

### 远程开发

| 模块 | 说明 |
|------|------|
| `remote-core/` | 远程开发核心 |
| `remote-driver/` | 远程驱动 |
| `remote-servers/` | 远程服务器 |
| `remoteDev-util/` | 远程开发工具 |
| `remote-topics/` | 远程主题 |
| `eel/` | 执行环境层 |
| `eel-impl/` | EEL 实现 |
| `eel-provider/` | EEL 提供者 |
| `eel-tcp/` | EEL TCP |

### 高级功能

| 模块 | 说明 |
|------|------|
| `ijent/` | IJent（远程执行代理） |
| `kernel/` | 内核功能 |
| `platform-frontend/` | 前端平台 |
| `backend/` | 后端服务 |
| `collaboration-tools/` | 协作工具 |
| `feedback/` | 反馈系统 |

### 性能和诊断

| 模块 | 说明 |
|------|------|
| `diagnostic/` | 诊断工具 |
| `statistics/` | 统计信息 |
| `tracing/` | 跟踪系统 |
| `tracing-ide/` | IDE 跟踪 |
| `progress/` | 进度指示 |
| `threadDumpParser/` | 线程转储解析器 |

### 测试框架

| 模块 | 说明 |
|------|------|
| `testFramework/` | 测试框架 |
| `platform-tests/` | 平台测试 |
| `testRunner/` | 测试运行器 |
| `smRunner/` | SMRunner 测试运行器 |

### 其他功能模块

| 模块 | 说明 |
|------|------|
| `diff-api/` | 差异比较 API |
| `diff-impl/` | 差异比较实现 |
| `tasks-platform-api/` | 任务平台 API |
| `tasks-platform-impl/` | 任务平台实现 |
| `built-in-server/` | 内置服务器 |
| `built-in-server-api/` | 内置服务器 API |
| `scopes/` | 作用域管理 |
| `macro/` | 宏系统 |
| `forms_rt/` | 表单运行时 |
| `icons/` | 图标 |
| `libraries/` | 库管理 |
| `sqlite/` | SQLite 支持 |
| `managed-cache/` | 托管缓存 |
| `markdown-utils/` | Markdown 工具 |
| `observable/` | 可观察对象 |
| `object-serializer/` | 对象序列化器 |
| `multiplatformSupport/` | 多平台支持 |
| `monolith/` | 单体架构支持 |
| `locking.impl/` | 锁定实现 |
| `jbr/` | JetBrains Runtime |
| `jewel/` | Jewel UI 框架 |
| `jps-bootstrap/` | JPS 引导 |
| `runtime/` | 运行时 |
| `experiment/` | 实验功能 |
| `compose/` | Compose UI |
| `wsl-impl/` | WSL 实现 |
| `ui.jcef/` | JCEF UI (Chromium Embedded Framework) |
| `smart-update/` | 智能更新 |
| `distribution-content/` | 分发内容 |

---

## Plugins 插件模块

Plugins 目录包含约 93 个插件模块。

### 版本控制系统插件

| 模块 | 说明 |
|------|------|
| `git4idea/` | Git 集成 |
| `github/` | GitHub 集成 |
| `gitlab/` | GitLab 集成 |
| `hg4idea/` | Mercurial 集成 |
| `svn4idea/` | Subversion 集成 |
| `git-modal-commit/` | Git 模态提交 |
| `git-features-trainer/` | Git 功能培训 |

### 构建工具插件

| 模块 | 说明 |
|------|------|
| `gradle/` | Gradle 支持 |
| `gradle-maven/` | Gradle Maven 互操作 |
| `maven/` | Maven 支持 |
| `maven-model/` | Maven 模型 |
| `maven-server-api/` | Maven 服务器 API |
| `ant/` | Ant 支持 |

### 编程语言插件

| 模块 | 说明 |
|------|------|
| `kotlin/` | Kotlin 语言支持 |
| `groovy/` | Groovy 语言支持 |
| `groovy-live-templates/` | Groovy 实时模板 |
| `markdown/` | Markdown 支持 |
| `yaml/` | YAML 支持 |
| `toml/` | TOML 支持 |
| `sh/` | Shell 脚本支持 |
| `IntelliLang/` | 语言注入 |
| `jsonpath/` | JSONPath 支持 |
| `xpath/` | XPath 支持 |
| `restructuredtext/` | reStructuredText 支持 |
| `textmate/` | TextMate 语法高亮 |

### 测试框架插件

| 模块 | 说明 |
|------|------|
| `junit/` | JUnit 支持 |
| `junit_rt/` | JUnit 运行时 |
| `junit5_rt/` | JUnit 5 运行时 |
| `junit5_rt_tests/` | JUnit 5 测试 |
| `junit6_rt/` | JUnit 6 运行时 |
| `junit6_rt_tests/` | JUnit 6 测试 |
| `testng/` | TestNG 支持 |
| `testng_rt/` | TestNG 运行时 |
| `cucumber-jvm-formatter/` | Cucumber JVM 格式化器 |
| `cucumber-jvm-formatter3/` | Cucumber JVM 3 |
| `cucumber-jvm-formatter4/` | Cucumber JVM 4 |
| `cucumber-jvm-formatter5/` | Cucumber JVM 5 |

### Java 相关插件

| 模块 | 说明 |
|------|------|
| `javaFX/` | JavaFX 支持 |
| `lombok/` | Lombok 支持 |
| `java-decompiler/` | Java 反编译器 |
| `java-i18n/` | Java 国际化 |
| `jshell/` | JShell 支持 |
| `ByteCodeViewer/` | 字节码查看器 |

### 开发工具插件

| 模块 | 说明 |
|------|------|
| `terminal/` | 终端集成 |
| `devkit/` | 插件开发工具包 |
| `properties/` | 属性文件支持 |
| `editorconfig/` | EditorConfig 支持 |
| `copyright/` | 版权管理 |
| `eclipse/` | Eclipse 项目导入 |

### 代码质量和分析

| 模块 | 说明 |
|------|------|
| `coverage/` | 代码覆盖率 |
| `coverage-common/` | 覆盖率通用代码 |
| `grazie/` | 语法和拼写检查 |
| `stream-debugger/` | Stream 调试器 |
| `stream-debugger-core/` | Stream 调试器核心 |

### UI 和主题

| 模块 | 说明 |
|------|------|
| `ui-designer/` | UI 设计器 |
| `ui-designer-core/` | UI 设计器核心 |
| `classic-ui/` | 经典 UI |
| `laf/` | 外观和感觉 |
| `color-schemes/` | 颜色方案 |
| `keymaps/` | 键盘映射 |
| `emojipicker/` | Emoji 选择器 |

### 机器学习插件

| 模块 | 说明 |
|------|------|
| `completion-ml-ranking/` | ML 代码补全排序 |
| `completion-ml-ranking-models/` | 补全 ML 模型 |
| `search-everywhere-ml/` | ML 全局搜索 |
| `findUsagesMl/` | ML 查找使用 |
| `filePrediction/` | 文件预测 |
| `marketplace-ml/` | 插件市场 ML |
| `ml-local-models/` | 本地 ML 模型 |

### 培训和帮助

| 模块 | 说明 |
|------|------|
| `ide-features-trainer/` | IDE 功能培训 |
| `built-in-help/` | 内置帮助 |

### 开发环境和配置

| 模块 | 说明 |
|------|------|
| `env-files-support/` | 环境文件支持 |
| `configuration-script/` | 配置脚本 |
| `settings-repository/` | 设置仓库 |
| `settings-sync/` | 设置同步 |

### 性能和统计

| 模块 | 说明 |
|------|------|
| `performanceTesting/` | 性能测试 |
| `stats-collector/` | 统计收集器 |
| `compilation-charts/` | 编译图表 |

### 云服务和集成

| 模块 | 说明 |
|------|------|
| `space/` | JetBrains Space 集成 |
| `mcp-server/` | MCP 服务器 |
| `repository-search/` | 仓库搜索 |
| `remote-control/` | 远程控制 |

### 其他插件

| 模块 | 说明 |
|------|------|
| `tasks/` | 任务管理 |
| `commander/` | 命令面板 |
| `ide-startup/` | IDE 启动 |
| `dev/` | 开发工具 |
| `evaluation-plugin/` | 评估插件 |
| `htmltools/` | HTML 工具 |
| `webp/` | WebP 支持 |
| `xslt-debugger/` | XSLT 调试器 |
| `turboComplete/` | 涡轮补全 |
| `compose/` | Compose 支持 |
| `rareJavaRefactorings/` | 少见的 Java 重构 |

---

## Java 支持模块

Java 目录包含完整的 Java 语言支持实现。

| 模块 | 说明 |
|------|------|
| `java-psi-api/` | Java PSI API |
| `java-psi-impl/` | Java PSI 实现 |
| `java-analysis-api/` | Java 分析 API |
| `java-analysis-impl/` | Java 分析实现 |
| `java-indexing-api/` | Java 索引 API |
| `java-indexing-impl/` | Java 索引实现 |
| `java-impl/` | Java 核心实现 |
| `java-impl-inspections/` | Java 代码检查 |
| `java-impl-refactorings/` | Java 重构 |
| `java-features-trainer/` | Java 功能培训 |
| `java-frontback-impl/` | Java 前后端实现 |
| `java-frontback-psi-api/` | Java 前后端 PSI API |
| `java-frontback-psi-impl/` | Java 前后端 PSI 实现 |
| `java-frontback-tests/` | Java 前后端测试 |
| `java-structure-view/` | Java 结构视图 |
| `java-syntax/` | Java 语法 |
| `java-terminal/` | Java 终端 |
| `java-runtime/` | Java 运行时 |
| `compiler/` | Java 编译器集成 |
| `debugger/` | Java 调试器 |
| `execution/` | Java 程序执行 |
| `ide-customization/` | IDE 定制 |
| `ide-resources/` | IDE 资源 |
| `idea-ui/` | IDEA UI |
| `openapi/` | Java OpenAPI |
| `plugin/` | Java 插件 |
| `remote-servers/` | 远程服务器 |
| `structuralsearch-java/` | Java 结构化搜索 |
| `testFramework/` | Java 测试框架 |
| `java-tests/` | Java 测试 |
| `typeMigration/` | 类型迁移 |
| `unscramble/` | 堆栈跟踪解码 |
| `manifest/` | Manifest 文件支持 |
| `langInjection/` | 语言注入 |
| `jsp-base-openapi/` | JSP 基础 OpenAPI |
| `jsp-openapi/` | JSP OpenAPI |
| `jsp-openapi-no-deps/` | JSP OpenAPI 无依赖 |
| `jsp-spi/` | JSP SPI |
| `live.templates/` | 实时模板 |
| `jdkAnnotations/` | JDK 注解 |
| `mockJDK-1.4/` | Mock JDK 1.4 |
| `mockJDK-1.7/` | Mock JDK 1.7 |
| `mockJDK-1.8/` | Mock JDK 1.8 |
| `mockJDK-1.9/` | Mock JDK 1.9 |
| `codeserver/` | 代码服务器 |
| `performancePlugin/` | 性能插件 |
| `vcs/` | VCS 集成 |

---

## Python 支持模块

Python 目录包含完整的 Python IDE 功能。

| 模块 | 说明 |
|------|------|
| `python-psi-api/` | Python PSI API |
| `python-psi-impl/` | Python PSI 实现 |
| `python-syntax/` | Python 语法 |
| `python-syntax-core/` | Python 语法核心 |
| `python-parser/` | Python 解析器 |
| `python-ast/` | Python AST |
| `python-core-impl/` | Python 核心实现 |
| `python-features-trainer/` | Python 功能培训 |
| `python-markdown/` | Python Markdown |
| `python-terminal/` | Python 终端 |
| `python-sdk/` | Python SDK 管理 |
| `python-sdk-ui/` | Python SDK UI |
| `python-sdk-configurator/` | Python SDK 配置器 |
| `python-poetry/` | Poetry 集成 |
| `pipenv/` | Pipenv 集成 |
| `python-venv/` | 虚拟环境支持 |
| `python-hatch/` | Hatch 支持 |
| `python-uv/` | uv 支持 |
| `python-pyproject/` | pyproject.toml 支持 |
| `python-restructuredtext/` | reStructuredText 支持 |
| `python-copyright/` | Python 版权 |
| `python-grazie/` | Python Grazie |
| `python-process-output/` | Python 进程输出 |
| `python-exec-service/` | Python 执行服务 |
| `python-common-tests/` | Python 通用测试 |
| `ide/` | Python IDE |
| `ide-common/` | IDE 通用 |
| `openapi/` | Python OpenAPI |
| `common/` | 通用代码 |
| `services/` | Python 服务 |
| `helpers/` | Python 辅助工具 |
| `helpersTests/` | 辅助工具测试 |
| `helpersTestResources/` | 辅助工具测试资源 |
| `pydevSrc/` | PyDev 源码 |
| `thrift/` | Thrift 支持 |
| `tools/` | Python 工具 |
| `installer/` | Python 安装器 |
| `testFramework/` | Python 测试框架 |
| `testSrc/` | 测试源码 |
| `testData/` | 测试数据 |
| `testResources/` | 测试资源 |
| `pluginCore/` | 插件核心 |
| `pluginMinor/` | 插件次要功能 |
| `pluginMinorRider/` | Rider 插件次要功能 |
| `pluginJava/` | Java 插件 |
| `pluginResources/` | 插件资源 |
| `pluginTestResources/` | 插件测试资源 |
| `resources/` | Python 资源 |
| `compatibilityResources/` | 兼容性资源 |
| `IntelliLang-python/` | Python 语言注入 |
| `interpreters/` | Python 解释器 |
| `setup-test-environment/` | 测试环境设置 |
| `gen/` | 生成代码 |
| `src/` | 源代码 |
| `build/` | 构建配置 |
| `help/` | 帮助文档 |
| `huggingFace/` | HuggingFace 集成 |
| `aliasProvider/` | 别名提供者 |
| `junit5Tests-framework/` | JUnit 5 测试框架 |
| `intellij.python.ml.features/` | Python ML 特性 |
| `intellij.python.community.communityOnly/` | 社区版专用 |
| `impl.helperLocator/` | 辅助定位器实现 |

---

## 其他语言支持

### XML 支持

| 模块 | 说明 |
|------|------|
| `xml/xml-psi-api/` | XML PSI API |
| `xml/xml-psi-impl/` | XML PSI 实现 |
| `xml/xml-analysis-api/` | XML 分析 API |
| `xml/xml-analysis-impl/` | XML 分析实现 |
| `xml/xml-syntax/` | XML 语法 |
| `xml/xml-parser/` | XML 解析器 |
| `xml/xml-structure-view-api/` | XML 结构视图 API |
| `xml/xml-structure-view-impl/` | XML 结构视图实现 |
| `xml/xml-ui-common/` | XML UI 通用 |
| `xml/dom-openapi/` | DOM OpenAPI |
| `xml/dom-impl/` | DOM 实现 |
| `xml/dom-tests/` | DOM 测试 |
| `xml/impl/` | XML 实现 |
| `xml/relaxng/` | RelaxNG 支持 |
| `xml/xmlbeans/` | XMLBeans 支持 |
| `xml/emmet/` | Emmet 支持 |
| `xml/langInjection/` | 语言注入 |
| `xml/tests/` | XML 测试 |
| `xml/testFramework/` | XML 测试框架 |

### JSON 支持

| 模块 | 说明 |
|------|------|
| `json/` | JSON 语言支持 |

### 正则表达式支持

| 模块 | 说明 |
|------|------|
| `RegExpSupport/` | 正则表达式支持 |

### JVM 分析

| 模块 | 说明 |
|------|------|
| `jvm/jvm-analysis-api/` | JVM 分析 API |
| `jvm/jvm-analysis-impl/` | JVM 分析实现 |
| `jvm/jvm-analysis-java-tests/` | JVM Java 测试 |
| `jvm/jvm-analysis-kotlin-tests-k1/` | JVM Kotlin K1 测试 |
| `jvm/jvm-analysis-kotlin-tests-k2/` | JVM Kotlin K2 测试 |
| `jvm/jvm-analysis-testFramework/` | JVM 测试框架 |

### UAST (统一抽象语法树)

| 模块 | 说明 |
|------|------|
| `uast/` | UAST 核心 |

---

## 构建和工具

### 构建系统

| 模块 | 说明 |
|------|------|
| `build/` | 构建脚本和配置 |
| `jps/` | JPS 构建系统 |
| `aether-dependency-resolver/` | Maven 依赖解析器 |

### 工具集

| 模块 | 说明 |
|------|------|
| `tools/` | 开发工具集 |
| `native/` | 本地代码 |
| `updater/` | 更新程序 |
| `spellchecker/` | 拼写检查器 |
| `commandInterface/` | 命令接口 |

### 其他

| 模块 | 说明 |
|------|------|
| `grid/` | Grid 系统 |
| `fleet/` | Fleet IDE 相关 |
| `jupyter/` | Jupyter Notebook 支持 |
| `notebooks/` | Notebook 支持 |
| `images/` | 图像资源 |
| `resources/` | 应用程序资源 |
| `resources-en/` | 英文资源 |
| `community-resources/` | 社区版资源 |
| `lib/` | 核心库文件 |
| `libraries/` | 外部库依赖 |
| `license/` | 许可证文件 |
| `bin/` | 可执行脚本和配置 |
| `docs/` | 文档 |
| `graalvm-debugger/` | GraalVM 调试器 |
| `wintools/` | Windows 工具 |
| `android-customization/` | Android 定制 |

---

## 模块关系说明

### 依赖层次

1. **底层**: `platform/core-*`, `platform/util-*`
2. **平台层**: `platform/*-api`, `platform/*-impl`
3. **语言层**: `java/`, `python/`, `xml/`
4. **插件层**: `plugins/*`
5. **应用层**: IDE 产品

### 模块命名约定

- `-api`: API 定义模块
- `-impl`: 实现模块
- `-tests`: 测试模块
- `-testFramework`: 测试框架
- `-rt`: 运行时模块
- `-openapi`: 公开 API

---

**文档版本**: 1.0  
**最后更新**: 2025-12-19  
**模块总数**: ~300+
