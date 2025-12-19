# IntelliJ Community 项目结构分析

## 项目概述

**IntelliJ Community** 是 JetBrains IDE 开源代码库的核心部分，也是 IntelliJ Platform 开发的基础。这个仓库包含了 IntelliJ IDEA Community Edition、PyCharm Community Edition 等产品的源代码。

### 基本信息

- **项目版本**: 261.SNAPSHOT
- **主要编程语言**: 
  - Java 源文件: ~88,902 个
  - Kotlin 源文件: ~74,343 个
  - Python 源文件: ~13,928 个
- **构建系统**: Bazel + Ant
- **开发要求**: JDK 21 (JetBrains Runtime)

## 顶层目录结构

### 核心目录（按大小排序）

| 目录 | 大小 | 说明 |
|------|------|------|
| `plugins/` | 833MB | IDE 插件模块集合（~94个插件目录） |
| `java/` | 326MB | Java 语言支持核心实现 |
| `platform/` | 319MB | IntelliJ Platform 核心框架（~161个子模块） |
| `python/` | 246MB | Python 语言支持实现 |
| `xml/` | 76MB | XML 语言支持 |
| `jvm/` | 4.4MB | JVM 分析工具 |

### 平台核心 (platform/)

包含 IntelliJ Platform 的核心功能模块，约 161 个子模块，主要包括：

#### 核心 API 和实现
- `core-api/` - 平台核心 API
- `core-impl/` - 核心功能实现
- `core-ui/` - 核心 UI 组件
- `platform-api/` - 平台公共 API
- `platform-impl/` - 平台实现

#### 编辑器相关
- `editor/` - 编辑器核心
- `editor-ui-api/` - 编辑器 UI API
- `editor-ui-ex/` - 扩展编辑器 UI

#### 项目和代码管理
- `project/` - 项目模型
- `projectModel-api/` - 项目模型 API
- `projectModel-impl/` - 项目模型实现
- `vcs-api/` - 版本控制系统 API
- `vcs-impl/` - 版本控制实现
- `vcs-log/` - VCS 日志查看器

#### 构建和执行
- `build-scripts/` - 构建脚本
- `execution/` - 程序执行框架
- `execution-impl/` - 执行实现
- `compiler/` - 编译器集成

#### 代码分析
- `analysis-api/` - 代码分析 API
- `analysis-impl/` - 代码分析实现
- `indexing-api/` - 索引 API
- `indexing-impl/` - 索引实现

#### 调试
- `xdebugger-api/` - 调试器 API
- `xdebugger-impl/` - 调试器实现
- `xdebugger-testFramework/` - 调试测试框架

#### 代码编辑增强
- `completion/` - 代码补全
- `inline-completion/` - 内联补全
- `refactoring/` - 重构支持

#### 用户界面
- `ide-core/` - IDE 核心
- `ide-core-impl/` - IDE 核心实现
- `new-ui-onboarding/` - 新 UI 引导
- `navbar/` - 导航栏
- `searchEverywhere/` - 全局搜索

#### 存储和配置
- `configuration-store-impl/` - 配置存储
- `settings/` - 设置管理
- `settings-sync-core/` - 设置同步

#### 机器学习
- `ml-api/` - 机器学习 API
- `ml-impl/` - 机器学习实现

#### 远程开发
- `remote-core/` - 远程开发核心
- `remote-driver/` - 远程驱动
- `remoteDev-util/` - 远程开发工具

### 插件目录 (plugins/)

约 94 个插件模块，覆盖各种编程语言、框架和工具：

#### 版本控制系统
- `git4idea/` - Git 集成
- `github/` - GitHub 集成
- `gitlab/` - GitLab 集成
- `hg4idea/` - Mercurial 集成
- `svn4idea/` - Subversion 集成

#### 构建工具
- `gradle/` - Gradle 支持
- `maven/` - Maven 支持
- `ant/` - Ant 支持

#### 编程语言
- `kotlin/` - Kotlin 语言支持
- `groovy/` - Groovy 语言支持
- `markdown/` - Markdown 支持
- `yaml/` - YAML 支持
- `toml/` - TOML 支持
- `sh/` - Shell 脚本支持

#### 框架支持
- `javaFX/` - JavaFX 支持
- `junit/` - JUnit 测试框架
- `testng/` - TestNG 测试框架
- `lombok/` - Lombok 支持

#### 开发工具
- `terminal/` - 终端集成
- `copyright/` - 版权管理
- `coverage/` - 代码覆盖率
- `java-decompiler/` - Java 反编译器
- `java-i18n/` - 国际化支持

#### IDE 增强
- `completion-ml-ranking/` - ML 驱动的代码补全排序
- `search-everywhere-ml/` - ML 驱动的全局搜索
- `ide-features-trainer/` - IDE 功能培训
- `emojipicker/` - Emoji 选择器

#### 云服务
- `space/` - JetBrains Space 集成
- `marketplace-ml/` - 插件市场 ML 功能

### Java 支持 (java/)

包含 Java 语言的完整支持实现：

- `java-psi-api/` - Java PSI (Program Structure Interface) API
- `java-psi-impl/` - Java PSI 实现
- `java-analysis-api/` - Java 代码分析 API
- `java-analysis-impl/` - Java 代码分析实现
- `java-impl/` - Java 核心实现
- `java-impl-inspections/` - Java 代码检查
- `java-impl-refactorings/` - Java 重构
- `compiler/` - Java 编译器集成
- `debugger/` - Java 调试器
- `execution/` - Java 程序执行
- `structuralsearch-java/` - Java 结构化搜索
- `testFramework/` - Java 测试框架

### Python 支持 (python/)

完整的 Python IDE 功能实现：

- `python-psi-api/` - Python PSI API
- `python-psi-impl/` - Python PSI 实现
- `python-syntax/` - Python 语法
- `python-parser/` - Python 解析器
- `python-ast/` - Python AST
- `ide/` - Python IDE 功能
- `ide-common/` - IDE 通用功能
- `python-sdk/` - Python SDK 管理
- `python-terminal/` - Python 终端
- `helpers/` - Python 辅助工具
- `python-poetry/` - Poetry 集成
- `pipenv/` - Pipenv 集成
- `python-venv/` - 虚拟环境支持

### 其他重要目录

#### 构建和工具
- `build/` - 构建脚本和配置
- `jps/` - JPS (JetBrains Project System) 构建系统
- `tools/` - 开发工具集
- `native/` - 本地代码
- `bin/` - 可执行脚本和配置

#### 资源和文档
- `resources/` - 应用程序资源
- `resources-en/` - 英文资源
- `community-resources/` - 社区版资源
- `docs/` - 文档
- `images/` - 图像资源
- `license/` - 许可证文件

#### 其他模块
- `xml/` - XML 语言支持
- `json/` - JSON 支持
- `uast/` - 统一抽象语法树
- `RegExpSupport/` - 正则表达式支持
- `spellchecker/` - 拼写检查
- `updater/` - 更新程序
- `grid/` - Grid 系统
- `fleet/` - Fleet IDE 相关
- `jupyter/` - Jupyter Notebook 支持
- `notebooks/` - Notebook 支持

## 构建系统

### Bazel 构建
项目使用 Bazel 作为主要构建系统：

- `BUILD.bazel` - 根构建文件
- `MODULE.bazel` - Bazel 模块定义
- `.bazelrc` - Bazel 配置
- `common.bazelrc` - 通用 Bazel 配置
- `bazel.cmd` - Bazel 命令脚本

### Ant 构建
传统的 Ant 构建支持：

- `build.xml` - Ant 构建文件

### 构建脚本
- `installers.cmd` - 构建安装包
- `tests.cmd` - 运行测试
- `bazel-build-all-community.cmd` - 构建所有社区版组件

## 开发环境配置

### IDE 配置
- `.idea/` - IntelliJ IDEA 项目配置
- `.editorconfig` - 编辑器配置
- `intellij.yaml` - IntelliJ 配置
- `intellij.idea.community.main.iml` - 主模块文件

### Git 配置
- `.gitignore` - Git 忽略文件
- `.gitattributes` - Git 属性
- `.git-blame-ignore-revs` - Git blame 忽略的提交

### 代码质量
- `qodana.yaml` - Qodana 代码质量配置
- `grazie.pro.qodana.yaml` - Grazie Pro 配置

## 测试框架

项目包含广泛的测试基础设施：

- `platform/testFramework/` - 平台测试框架
- `platform/platform-tests/` - 平台测试
- `java/testFramework/` - Java 测试框架
- `java/java-tests/` - Java 测试
- `python/testFramework/` - Python 测试框架
- `python/testSrc/` - Python 测试源码

## 外部依赖

- `libraries/` - 外部库依赖（~97个库目录）
- `lib/` - 核心库文件
- `aether-dependency-resolver/` - Maven 依赖解析器

## 特殊目录

### Android 支持
- `android-customization/` - Android 定制

### Docker 支持
- `Dockerfile` - Docker 构建文件

### 辅助工具
- `commandInterface/` - 命令接口
- `graalvm-debugger/` - GraalVM 调试器
- `wintools/` - Windows 工具

## 项目架构特点

### 1. 模块化设计
项目采用高度模块化的架构，每个功能都被组织成独立的模块，便于维护和扩展。

### 2. 插件架构
强大的插件系统使得可以轻松添加新的语言支持、工具集成和 IDE 功能。

### 3. 多语言支持
核心代码混合使用 Java 和 Kotlin，体现了 JetBrains 对 Kotlin 的投入。

### 4. 统一的平台
IntelliJ Platform 为所有 JetBrains IDE 提供统一的基础设施。

### 5. 现代构建系统
采用 Bazel 作为主要构建系统，支持增量编译和分布式构建。

### 6. 完善的测试体系
每个主要模块都有对应的测试框架和测试用例。

## 开发工作流

### 1. 获取源码
```bash
git clone https://github.com/JetBrains/intellij-community.git
cd intellij-community
./getPlugins.sh  # 获取 Android 模块
```

### 2. 构建项目
```bash
# 在 IDE 中打开项目
# 或使用命令行构建
./installers.cmd -Dintellij.build.target.os=current
```

### 3. 运行 IDE
在 IntelliJ IDEA 中使用预配置的 "IDEA" 运行配置。

### 4. 运行测试
```bash
./tests.cmd -Dintellij.build.incremental.compilation=true
```

## 技术栈总结

- **编程语言**: Java, Kotlin, Python, Groovy, XML, Shell
- **构建工具**: Bazel, Ant, Maven, Gradle
- **测试框架**: JUnit, TestNG
- **版本控制**: Git
- **UI 框架**: Swing, 自定义 UI 框架
- **插件系统**: IntelliJ Platform Plugin SDK

## 代码统计摘要

- 总计约 **177,173** 个源文件（Java + Kotlin + Python）
- 平台核心：**160** 个子模块
- 插件模块：**93** 个
- 代码库总大小：约 **2GB**

## 贡献指南

详细的贡献指南请参考：
- `CONTRIBUTING.md` - 贡献指南
- `CODE_OF_CONDUCT.md` - 行为准则
- `SECURITY.md` - 安全政策

---

**生成时间**: 2025-12-19  
**分析版本**: 261.SNAPSHOT  
**仓库**: https://github.com/JetBrains/intellij-community
