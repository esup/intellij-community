# IntelliJ Community 目录树结构

本文档展示 IntelliJ Community 项目的完整目录树结构。

## 根目录结构

```
intellij-community/
├── .github/                    # GitHub Actions 和配置
├── .idea/                      # IntelliJ IDEA 项目配置
├── RegExpSupport/              # 正则表达式支持
├── aether-dependency-resolver/ # Maven 依赖解析器
├── android-customization/      # Android 定制
├── bin/                        # 可执行脚本和配置
│   ├── linux/                  # Linux 脚本
│   ├── mac/                    # macOS 脚本
│   └── win/                    # Windows 脚本
├── build/                      # 构建系统
│   ├── bazel-wrapper/          # Bazel 包装器
│   ├── conf/                   # 构建配置
│   ├── dependencies/           # 依赖管理
│   ├── jvm-rules/              # JVM 构建规则
│   ├── launch/                 # 启动配置
│   ├── protobuf/               # Protocol Buffers
│   ├── src/                    # 构建源码
│   ├── tasks/                  # 构建任务
│   ├── tests/                  # 构建测试
│   └── tools/                  # 构建工具
├── commandInterface/           # 命令接口
├── community-resources/        # 社区版资源
├── docs/                       # 文档
│   ├── dist-visualizer/        # 分发可视化
│   ├── notebooks/              # Notebook 文档
│   └── plugin-graph/           # 插件依赖图
├── fleet/                      # Fleet IDE 相关 (~21个子模块)
│   ├── kernel/                 # Fleet 内核
│   ├── rhizomedb/              # RhizomeDB
│   ├── rpc/                    # RPC 框架
│   └── ...
├── graalvm-debugger/           # GraalVM 调试器
├── grid/                       # Grid 系统
│   ├── api/                    # Grid API
│   ├── core-impl/              # 核心实现
│   ├── impl/                   # 实现
│   └── impl-ide/               # IDE 集成
├── idea/                       # IDEA 产品
│   └── customization/          # IDEA 定制
├── images/                     # 图像资源
├── java/                       # Java 语言支持 (~49个子模块)
│   ├── compiler/               # 编译器
│   ├── debugger/               # 调试器
│   ├── execution/              # 执行
│   ├── java-psi-api/           # PSI API
│   ├── java-psi-impl/          # PSI 实现
│   ├── java-analysis-api/      # 分析 API
│   ├── java-analysis-impl/     # 分析实现
│   ├── java-impl/              # 核心实现
│   ├── java-impl-inspections/  # 代码检查
│   ├── java-impl-refactorings/ # 重构
│   ├── testFramework/          # 测试框架
│   └── ...
├── jps/                        # JPS 构建系统 (~11个子模块)
│   ├── jps-builders/           # JPS 构建器
│   ├── jps-launcher/           # JPS 启动器
│   ├── model-api/              # 模型 API
│   ├── model-impl/             # 模型实现
│   └── standalone-builder/     # 独立构建器
├── json/                       # JSON 支持
├── jupyter/                    # Jupyter Notebook 支持
├── jvm/                        # JVM 分析 (~12个子模块)
│   ├── jvm-analysis-api/       # JVM 分析 API
│   ├── jvm-analysis-impl/      # JVM 分析实现
│   ├── jvm-analysis-java-tests/
│   ├── jvm-analysis-kotlin-tests-k1/
│   └── jvm-analysis-kotlin-tests-k2/
├── lib/                        # 核心库文件
│   ├── annotations/            # 注解
│   ├── ant/                    # Ant 库
│   ├── profiler/               # 分析器
│   └── src/                    # 库源码
├── libraries/                  # 外部依赖库 (~97个库)
│   ├── asm/                    # ASM 字节码操作
│   ├── guava/                  # Google Guava
│   ├── kotlin/                 # Kotlin 库
│   ├── netty/                  # Netty 网络库
│   ├── protobuf/               # Protocol Buffers
│   └── ...
├── license/                    # 许可证文件
├── native/                     # 原生代码 (~15个子模块)
│   ├── LinuxGlobalMenu/        # Linux 全局菜单
│   ├── MacLauncher/            # Mac 启动器
│   ├── WinLauncher/            # Windows 启动器
│   ├── WinProcessList/         # Windows 进程列表
│   ├── XPlatLauncher/          # 跨平台启动器
│   └── ...
├── notebooks/                  # Notebooks 支持 (~4个子模块)
├── platform/                   # IntelliJ Platform (~161个子模块)
│   ├── core-api/               # 核心 API
│   ├── core-impl/              # 核心实现
│   ├── core-ui/                # 核心 UI
│   ├── platform-api/           # 平台 API
│   ├── platform-impl/          # 平台实现
│   ├── editor/                 # 编辑器
│   ├── editor-ui-api/          # 编辑器 UI API
│   ├── editor-ui-ex/           # 扩展编辑器 UI
│   ├── ide-core/               # IDE 核心
│   ├── ide-core-impl/          # IDE 核心实现
│   ├── project/                # 项目模型
│   ├── projectModel-api/       # 项目模型 API
│   ├── projectModel-impl/      # 项目模型实现
│   ├── analysis-api/           # 分析 API
│   ├── analysis-impl/          # 分析实现
│   ├── indexing-api/           # 索引 API
│   ├── indexing-impl/          # 索引实现
│   ├── vcs-api/                # VCS API
│   ├── vcs-impl/               # VCS 实现
│   ├── vcs-log/                # VCS 日志
│   ├── xdebugger-api/          # 调试器 API
│   ├── xdebugger-impl/         # 调试器实现
│   ├── completion/             # 代码补全
│   ├── refactoring/            # 重构
│   ├── searchEverywhere/       # 全局搜索
│   ├── build-scripts/          # 构建脚本
│   ├── execution/              # 执行框架
│   ├── execution-impl/         # 执行实现
│   ├── pluginManager/          # 插件管理器
│   ├── testFramework/          # 测试框架
│   ├── ml-api/                 # 机器学习 API
│   ├── ml-impl/                # 机器学习实现
│   ├── remote-core/            # 远程开发核心
│   ├── remote-driver/          # 远程驱动
│   ├── settings/               # 设置管理
│   ├── navbar/                 # 导航栏
│   ├── util/                   # 工具类
│   └── ...
├── plugins/                    # 插件模块 (~94个插件)
│   ├── git4idea/               # Git 集成
│   ├── github/                 # GitHub 集成
│   ├── gitlab/                 # GitLab 集成
│   ├── svn4idea/               # SVN 集成
│   ├── hg4idea/                # Mercurial 集成
│   ├── gradle/                 # Gradle 支持
│   ├── maven/                  # Maven 支持
│   ├── ant/                    # Ant 支持
│   ├── kotlin/                 # Kotlin 支持
│   ├── groovy/                 # Groovy 支持
│   ├── junit/                  # JUnit 支持
│   ├── testng/                 # TestNG 支持
│   ├── terminal/               # 终端
│   ├── markdown/               # Markdown
│   ├── yaml/                   # YAML
│   ├── toml/                   # TOML
│   ├── sh/                     # Shell
│   ├── coverage/               # 代码覆盖率
│   ├── java-decompiler/        # Java 反编译器
│   ├── devkit/                 # 开发工具包
│   ├── completion-ml-ranking/  # ML 补全排序
│   ├── search-everywhere-ml/   # ML 全局搜索
│   ├── ide-features-trainer/   # 功能培训
│   ├── emojipicker/            # Emoji 选择器
│   ├── ui-designer/            # UI 设计器
│   ├── settings-repository/    # 设置仓库
│   ├── space/                  # Space 集成
│   └── ...
├── python/                     # Python 语言支持 (~64个子模块)
│   ├── python-psi-api/         # Python PSI API
│   ├── python-psi-impl/        # Python PSI 实现
│   ├── python-syntax/          # Python 语法
│   ├── python-parser/          # Python 解析器
│   ├── python-ast/             # Python AST
│   ├── ide/                    # Python IDE
│   ├── python-sdk/             # SDK 管理
│   ├── python-terminal/        # Python 终端
│   ├── python-poetry/          # Poetry 集成
│   ├── pipenv/                 # Pipenv 集成
│   ├── python-venv/            # 虚拟环境
│   ├── helpers/                # 辅助工具
│   ├── testFramework/          # 测试框架
│   └── ...
├── resources/                  # 应用程序资源
├── resources-en/               # 英文资源
├── spellchecker/               # 拼写检查器
├── tools/                      # 开发工具集 (~21个工具)
│   ├── intellij.tools.ide.metrics.collector/
│   ├── intellij.tools.ide.starter/
│   └── ...
├── uast/                       # 统一抽象语法树 (~8个子模块)
│   ├── uast-common/            # UAST 通用
│   ├── uast-java/              # Java UAST
│   ├── uast-kotlin/            # Kotlin UAST
│   └── ...
├── updater/                    # 更新程序 (~7个子模块)
│   ├── resources/              # 更新器资源
│   ├── src/                    # 更新器源码
│   └── testSrc/                # 更新器测试
├── wintools/                   # Windows 工具 (~5个子模块)
└── xml/                        # XML 语言支持 (~21个子模块)
    ├── xml-psi-api/            # XML PSI API
    ├── xml-psi-impl/           # XML PSI 实现
    ├── xml-analysis-api/       # XML 分析 API
    ├── xml-analysis-impl/      # XML 分析实现
    ├── xml-syntax/             # XML 语法
    ├── dom-openapi/            # DOM OpenAPI
    ├── dom-impl/               # DOM 实现
    ├── relaxng/                # RelaxNG
    ├── emmet/                  # Emmet
    ├── impl/                   # XML 实现
    ├── tests/                  # XML 测试
    └── ...
```

## 平台核心 (platform/) 详细结构

```
platform/
├── analysis-api/               # 代码分析 API
├── analysis-impl/              # 代码分析实现
├── backend/                    # 后端服务
├── bookmarks/                  # 书签
├── boot/                       # 启动器
├── bootstrap/                  # 引导程序
├── build-scripts/              # 构建脚本
├── buildData/                  # 构建数据
├── buildView/                  # 构建视图
├── built-in-server/            # 内置服务器
├── built-in-server-api/        # 内置服务器 API
├── code-style-api/             # 代码样式 API
├── code-style-impl/            # 代码样式实现
├── collaboration-tools/        # 协作工具
├── completion/                 # 代码补全
├── compose/                    # Compose UI
├── configuration-store-impl/   # 配置存储实现
├── core-api/                   # 核心 API
├── core-impl/                  # 核心实现
├── core-nio-fs/                # NIO 文件系统
├── core-ui/                    # 核心 UI
├── credential-store/           # 凭据存储
├── credential-store-impl/      # 凭据存储实现
├── credential-store-ui/        # 凭据存储 UI
├── diagnostic/                 # 诊断工具
├── diff-api/                   # 差异比较 API
├── diff-impl/                  # 差异比较实现
├── distribution-content/       # 分发内容
├── duplicates-analysis/        # 重复代码分析
├── dvcs-api/                   # 分布式 VCS API
├── dvcs-impl/                  # 分布式 VCS 实现
├── editor/                     # 编辑器核心
├── editor-ui-api/              # 编辑器 UI API
├── editor-ui-ex/               # 扩展编辑器 UI
├── eel/                        # 执行环境层
├── eel-impl/                   # EEL 实现
├── eel-provider/               # EEL 提供者
├── eel-tcp/                    # EEL TCP
├── execution/                  # 程序执行框架
├── execution-impl/             # 执行实现
├── execution-process-elevation/# 进程提权
├── execution-process-mediator/ # 进程中介
├── execution.dashboard/        # 执行仪表板
├── execution.serviceView/      # 服务视图
├── experiment/                 # 实验功能
├── extensions/                 # 扩展点系统
├── external-process-auth-helper/# 外部进程认证
├── external-system-api/        # 外部系统 API
├── external-system-impl/       # 外部系统实现
├── external-system-rt/         # 外部系统运行时
├── favoritesTreeView/          # 收藏夹树视图
├── feedback/                   # 反馈系统
├── find/                       # 查找功能
├── foldings/                   # 代码折叠
├── forms_rt/                   # 表单运行时
├── icons/                      # 图标
├── ide-core/                   # IDE 核心
├── ide-core-impl/              # IDE 核心实现
├── ijent/                      # IJent 远程代理
├── indexing-api/               # 索引 API
├── indexing-impl/              # 索引实现
├── indexing-tests/             # 索引测试
├── inline-completion/          # 内联补全
├── inspect/                    # 代码检查
├── instanceContainer/          # 实例容器
├── jbr/                        # JetBrains Runtime
├── jewel/                      # Jewel UI
├── jps-bootstrap/              # JPS 引导
├── kernel/                     # 内核功能
├── lang-api/                   # 语言 API
├── lang-core/                  # 语言核心
├── lang-impl/                  # 语言实现
├── libraries/                  # 库管理
├── locking.impl/               # 锁定实现
├── lvcs-api/                   # 本地历史 API
├── lvcs-impl/                  # 本地历史实现
├── macro/                      # 宏系统
├── main/                       # 主入口
├── managed-cache/              # 托管缓存
├── markdown-utils/             # Markdown 工具
├── ml-api/                     # 机器学习 API
├── ml-impl/                    # 机器学习实现
├── ml-logs/                    # ML 日志
├── monolith/                   # 单体架构
├── multiplatformSupport/       # 多平台支持
├── navbar/                     # 导航栏
├── new-ui-onboarding/          # 新 UI 引导
├── new-users-onboarding/       # 新用户引导
├── non-modal-welcome-screen/   # 非模态欢迎屏幕
├── object-serializer/          # 对象序列化
├── observable/                 # 可观察对象
├── platform-api/               # 平台 API
├── platform-frontend/          # 前端平台
├── platform-impl/              # 平台实现
├── platform-resources/         # 平台资源
├── platform-resources-en/      # 英文资源
├── platform-tests/             # 平台测试
├── platform-util-io/           # IO 工具
├── platform-util-io-impl/      # IO 工具实现
├── platform-util-netty/        # Netty 工具
├── pluginManager/              # 插件管理器
├── plugins/                    # 插件加载
├── polySymbols/                # 多态符号
├── pratt/                      # Pratt 解析器
├── progress/                   # 进度指示
├── project/                    # 项目模型
├── projectModel-api/           # 项目模型 API
├── projectModel-impl/          # 项目模型实现
├── rd-platform-community/      # RD 平台社区版
├── recentFiles/                # 最近文件
├── refactoring/                # 重构
├── remote-core/                # 远程开发核心
├── remote-driver/              # 远程驱动
├── remote-servers/             # 远程服务器
├── remote-topics/              # 远程主题
├── remoteDev-util/             # 远程开发工具
├── runtime/                    # 运行时
├── scopes/                     # 作用域管理
├── script-debugger/            # 脚本调试器
├── searchEverywhere/           # 全局搜索
├── service-container/          # 服务容器
├── settings/                   # 设置管理
├── settings-local/             # 本地设置
├── settings-sync-core/         # 设置同步核心
├── smRunner/                   # SMRunner
├── smart-update/               # 智能更新
├── sqlite/                     # SQLite
├── starter/                    # 启动器
├── statistics/                 # 统计信息
├── structuralsearch/           # 结构化搜索
├── structure-view-impl/        # 结构视图实现
├── syntax/                     # 语法支持
├── tasks-platform-api/         # 任务平台 API
├── tasks-platform-impl/        # 任务平台实现
├── testFramework/              # 测试框架
├── testRunner/                 # 测试运行器
├── threadDumpParser/           # 线程转储解析
├── tips-of-the-day/            # 每日提示
├── todo/                       # TODO 视图
├── tracing/                    # 跟踪系统
├── tracing-ide/                # IDE 跟踪
├── ui.jcef/                    # JCEF UI
├── usageView/                  # 使用视图
├── usageView-impl/             # 使用视图实现
├── util/                       # 工具类
├── util-class-loader/          # 类加载器工具
├── util-ex/                    # 扩展工具
├── util-rt/                    # 运行时工具
├── vcs-api/                    # VCS API
├── vcs-impl/                   # VCS 实现
├── vcs-log/                    # VCS 日志
├── vcs-tests/                  # VCS 测试
├── warmup/                     # 预热
├── whatsNew/                   # 新功能
├── workspace/                  # 工作区
├── wsl-impl/                   # WSL 实现
├── xdebugger-api/              # 调试器 API
├── xdebugger-impl/             # 调试器实现
└── xdebugger-testFramework/    # 调试器测试框架
```

## 统计信息

### 模块数量
- Platform: ~161 个子模块
- Plugins: ~94 个插件
- Java: ~49 个子模块
- Python: ~64 个子模块
- XML: ~21 个子模块
- JVM: ~12 个子模块
- Tools: ~21 个工具
- Libraries: ~97 个外部库
- Fleet: ~21 个子模块
- Build: ~15 个构建相关模块
- Native: ~15 个原生代码模块

### 总计
- **约 400+ 个模块和目录**
- **代码文件: 177,173+ 个**
- **代码库大小: ~2GB**

## 目录命名约定

### 后缀含义
- `-api`: API 定义模块
- `-impl`: 实现模块
- `-tests`: 测试模块
- `-testFramework`: 测试框架模块
- `-rt`: 运行时模块
- `-openapi`: 公开 API 模块
- `-ui`: UI 相关模块
- `-core`: 核心功能模块

### 特殊目录
- `resources/`: 资源文件
- `src/`: 源代码
- `gen/`: 生成的代码
- `testSrc/`: 测试源码
- `testData/`: 测试数据

---

**生成日期**: 2025-12-19  
**项目版本**: 261.SNAPSHOT

完整的模块说明请参考 [MODULE_CATALOG.md](./MODULE_CATALOG.md)
