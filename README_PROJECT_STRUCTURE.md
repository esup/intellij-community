# IntelliJ Community 项目结构分析 - 快速参考

本文档是 IntelliJ Community 项目结构分析的快速参考指南。

## 📋 文档索引

1. **[PROJECT_STRUCTURE_ANALYSIS.md](./PROJECT_STRUCTURE_ANALYSIS.md)** - 完整的项目结构分析
   - 项目概述和基本信息
   - 顶层目录结构详解
   - 核心模块分类说明
   - 开发工作流程
   - 技术栈总结

2. **[ARCHITECTURE_OVERVIEW.md](./ARCHITECTURE_OVERVIEW.md)** - 架构概览和设计模式
   - 整体架构图
   - 核心子系统详解（PSI、索引、编辑器等）
   - 数据流图
   - 模块依赖关系
   - 设计模式和最佳实践

3. **[MODULE_CATALOG.md](./MODULE_CATALOG.md)** - 详细模块清单
   - Platform 核心模块列表（~161个）
   - Plugins 插件模块列表（~94个）
   - Java/Python/XML 支持模块
   - 模块命名约定

4. **[DIRECTORY_TREE.md](./DIRECTORY_TREE.md)** - 可视化目录树
   - 完整的目录层次结构
   - 模块数量统计
   - 命名约定说明

5. **[STARTUP_FLOW_ANALYSIS.md](./STARTUP_FLOW_ANALYSIS.md)** - 启动流程分析
   - 完整的启动流程详解
   - 各阶段时序图和关键组件
   - 性能优化机制
   - 启动配置和问题诊断

## 🎯 快速了解

### 项目规模

- **版本**: 261.SNAPSHOT
- **代码文件**: 
  - Java: ~88,902 个
  - Kotlin: ~74,343 个
  - Python: ~13,928 个
- **主要目录**: 
  - plugins/ (833MB, 94个插件)
  - java/ (326MB)
  - platform/ (319MB, 161个模块)
  - python/ (246MB)

### 核心架构

```
插件层 (plugins/)
    ↓
语言层 (java/, python/, xml/)
    ↓
平台层 (platform/)
    ↓
构建系统 (Bazel, JPS, Ant)
```

### 关键目录

| 目录 | 用途 |
|------|------|
| `platform/` | IntelliJ Platform 核心框架 |
| `plugins/` | IDE 插件（Git, Gradle, Maven等） |
| `java/` | Java 语言支持 |
| `python/` | Python 语言支持 |
| `build/` | 构建脚本和配置 |
| `docs/` | 文档 |

## 🔑 核心概念

### PSI (Program Structure Interface)
代码的抽象语法树表示，是 IntelliJ Platform 的核心概念。

### 索引系统
快速查找和代码导航的基础，后台自动构建和更新。

### 插件系统
基于扩展点（Extension Points）的灵活插件架构。

### VCS 集成
统一的版本控制系统抽象层，支持 Git、SVN、Mercurial 等。

## 🛠️ 开发环境

### 前置要求
- JDK 21 (JetBrains Runtime without JCEF)
- IntelliJ IDEA 2023.2 或更高版本
- 最少 8GB RAM
- 约 2GB 磁盘空间

### 快速开始

```bash
# 1. 克隆仓库
git clone https://github.com/JetBrains/intellij-community.git
cd intellij-community

# 2. 获取 Android 模块（如需要）
./getPlugins.sh  # Linux/macOS
# 或
getPlugins.bat   # Windows

# 3. 用 IntelliJ IDEA 打开项目
# File | Open -> 选择 intellij-community 目录

# 4. 构建项目
# Build | Build Project

# 5. 运行 IDE
# Run | Run 'IDEA'
```

### 构建命令

```bash
# 构建当前操作系统的安装包
./installers.cmd -Dintellij.build.target.os=current

# 增量编译
./installers.cmd -Dintellij.build.incremental.compilation=true

# 运行测试
./tests.cmd -Dintellij.build.incremental.compilation=true
```

## 📚 核心模块速查

### Platform 核心

- **核心 API**: `platform/core-api/`, `platform/platform-api/`
- **编辑器**: `platform/editor/`, `platform/editor-ui-*`
- **项目模型**: `platform/project/`, `platform/projectModel-*`
- **索引**: `platform/indexing-api/`, `platform/indexing-impl/`
- **VCS**: `platform/vcs-api/`, `platform/vcs-impl/`, `platform/vcs-log/`
- **调试**: `platform/xdebugger-*`
- **代码分析**: `platform/analysis-*`, `platform/inspections/`

### 常用插件

- **Git**: `plugins/git4idea/`
- **Gradle**: `plugins/gradle/`
- **Maven**: `plugins/maven/`
- **Kotlin**: `plugins/kotlin/`
- **Terminal**: `plugins/terminal/`

### 语言支持

- **Java**: `java/java-psi-*/`, `java/java-analysis-*/`, `java/compiler/`
- **Python**: `python/python-psi-*/`, `python/ide/`, `python/python-sdk/`
- **XML**: `xml/xml-psi-*/`, `xml/xml-analysis-*/`

## 🏗️ 架构模式

### Extension Point Pattern
```xml
<extensionPoint name="myExtension" interface="com.example.MyInterface"/>
```

### Service Pattern
- **Application Service**: 全局单例
- **Project Service**: 每个项目一个实例
- **Module Service**: 每个模块一个实例

### PSI Visitor Pattern
```java
file.accept(new PsiRecursiveElementVisitor() {
    @Override
    public void visitElement(PsiElement element) {
        // 处理元素
        super.visitElement(element);
    }
});
```

## 🔍 查找资源

### 查找文件
```bash
# 查找特定类型的文件
find . -name "*.java" -path "*/platform/editor/*"

# 使用 Bazel 查询
bazel query "//platform/editor/..."
```

### 搜索代码
```bash
# 在 IDEA 中使用 Shift+Shift 全局搜索
# 或 Ctrl+Shift+F 在文件中查找
```

## 📊 统计信息

### 代码量分布
- Platform: 319MB (~161 modules)
- Plugins: 833MB (~94 plugins)
- Java Support: 326MB
- Python Support: 246MB
- XML Support: 76MB

### 文件类型
- Java 源文件: 50.1% (~88,902)
- Kotlin 源文件: 41.9% (~74,343)
- Python 源文件: 7.9% (~13,928)

## 🔗 相关链接

- **官方文档**: https://plugins.jetbrains.com/docs/intellij/
- **GitHub 仓库**: https://github.com/JetBrains/intellij-community
- **贡献指南**: [CONTRIBUTING.md](./CONTRIBUTING.md)
- **构建系统**: Bazel (主要), Ant (传统)

## 📝 注意事项

1. **分支选择**: master 分支是最新开发版本
2. **Android 模块**: 需要单独获取（使用 getPlugins 脚本）
3. **JDK 要求**: 必须使用 JetBrains Runtime 21 without JCEF
4. **内存设置**: 建议至少 8GB RAM，可增加 heap size
5. **增量编译**: 开发时启用增量编译以提高效率

## 🚀 下一步

1. 阅读 [CONTRIBUTING.md](./CONTRIBUTING.md) 了解贡献指南
2. 浏览 [platform/docs/](./platform/docs/) 查看技术文档
3. 查看 [.idea/runConfigurations/](./.idea/runConfigurations/) 了解运行配置
4. 加入 JetBrains Platform Slack 社区

---

**生成日期**: 2025-12-19  
**项目版本**: 261.SNAPSHOT  
**文档版本**: 1.0

如需更详细的信息，请查看上述完整文档。
