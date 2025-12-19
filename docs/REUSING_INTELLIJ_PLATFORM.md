# 复用 IntelliJ 平台构建自定义客户端

本文档说明如何复用 IntelliJ IDEA 的启动流程和 UI 框架来构建新的客户端应用程序（如 MES 系统客户端）。

## 概述

IntelliJ IDEA 基于 IntelliJ Platform 构建，这是一个可扩展的平台，可以用于构建各种桌面应用程序。要复用其启动流程和 UI，您有以下几种方式：

### 方式 1: 基于 IntelliJ Platform SDK 开发独立应用（推荐）

这是最推荐的方式，可以创建一个基于 IntelliJ Platform 的独立应用程序。

#### 主要组件

1. **启动流程**
   - 主入口: `platform/bootstrap/src/com/intellij/idea/Main.kt`
   - 应用启动器: `platform/ide-core/src/com/intellij/openapi/application/ApplicationStarter.kt`
   - 启动流程由 `startApplication()` 函数管理

2. **UI 框架**
   - 主窗口: `com.intellij.openapi.wm.IdeFrame`
   - 工具窗口: `com.intellij.openapi.wm.ToolWindowFactory`
   - UI 组件: `platform/platform-api/src/com/intellij/ui/`

#### 实施步骤

**步骤 1: 设置项目结构**

```
your-mes-client/
├── build.gradle.kts          # 构建配置
├── src/
│   └── main/
│       ├── java/
│       └── resources/
│           └── META-INF/
│               └── plugin.xml  # 插件配置
└── resources/
    └── idea.properties        # 应用配置
```

**步骤 2: 配置 build.gradle.kts**

```kotlin
plugins {
    id("org.jetbrains.intellij") version "1.17.0"
    java
    kotlin("jvm") version "1.9.0"
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

intellij {
    version.set("2024.1")
    type.set("IC") // IntelliJ IDEA Community
    plugins.set(listOf(/* 需要的插件 */))
}

tasks {
    // 构建独立应用
    buildSearchableOptions {
        enabled = false
    }
}
```

**步骤 3: 创建自定义 ApplicationStarter**

```kotlin
// src/main/kotlin/com/example/mes/MESApplicationStarter.kt
package com.example.mes

import com.intellij.openapi.application.ApplicationStarter
import kotlin.system.exitProcess

class MESApplicationStarter : ApplicationStarter {
    override val commandName: String = "mes"
    
    override suspend fun start(args: List<String>) {
        // 初始化 MES 客户端
        println("Starting MES Client...")
        
        // 创建主窗口
        MESMainWindow.create()
    }
}
```

**步骤 4: 创建主窗口**

```kotlin
// src/main/kotlin/com/example/mes/MESMainWindow.kt
package com.example.mes

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import javax.swing.JLabel
import javax.swing.JPanel
import java.awt.BorderLayout

class MESMainWindow : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val contentFactory = ContentFactory.getInstance()
        val panel = createMESPanel()
        val content = contentFactory.createContent(panel, "MES Dashboard", false)
        toolWindow.contentManager.addContent(content)
    }
    
    private fun createMESPanel(): JPanel {
        val panel = JPanel(BorderLayout())
        // 在这里添加您的 MES UI 组件
        panel.add(JLabel("MES System Client"), BorderLayout.NORTH)
        // 添加生产监控、质量控制等组件...
        return panel
    }
    
    companion object {
        fun create() {
            // 创建并显示主窗口的逻辑
        }
    }
}
```

**步骤 5: 配置 plugin.xml**

```xml
<!-- src/main/resources/META-INF/plugin.xml -->
<idea-plugin>
    <id>com.example.mes-client</id>
    <name>MES Client</name>
    <version>1.0.0</version>
    <vendor>Your Company</vendor>
    
    <description>Manufacturing Execution System Client</description>
    
    <depends>com.intellij.modules.platform</depends>
    
    <extensions defaultExtensionNs="com.intellij">
        <!-- 注册工具窗口 -->
        <toolWindow id="MES Dashboard" 
                    factoryClass="com.example.mes.MESMainWindow"
                    anchor="left"/>
    </extensions>
    
    <applicationListeners>
        <!-- 添加应用监听器 -->
    </applicationListeners>
</idea-plugin>
```

### 方式 2: 直接修改 IntelliJ 源码（不推荐用于生产）

如果您想直接基于此仓库修改，可以：

1. **修改启动类**: 编辑 `platform/bootstrap/src/com/intellij/idea/Main.kt`
2. **替换 UI 组件**: 修改 `platform/platform-impl/src/com/intellij/openapi/wm/impl/` 中的窗口实现
3. **配置应用信息**: 修改 `platform/core-api/src/com/intellij/openapi/application/ApplicationNamesInfo.java`

### 方式 3: 使用 IntelliJ Platform Plugin

创建一个插件来扩展现有的 IntelliJ IDEA 功能：

```kotlin
// 创建 ToolWindow
class MESToolWindowFactory : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val mesPanel = MESPanel()
        val content = ContentFactory.getInstance().createContent(mesPanel, "", false)
        toolWindow.contentManager.addContent(content)
    }
}
```

## 关键 API 和组件

### 1. 应用程序生命周期

- **Application**: `com.intellij.openapi.application.Application` - 应用程序主对象
- **ApplicationManager**: 获取 Application 实例
- **ApplicationStarter**: 自定义应用启动逻辑

### 2. UI 框架

- **IdeFrame**: 主窗口框架
- **ToolWindow**: 工具窗口系统
- **JPanel/JComponent**: 标准 Swing 组件
- **DarculaUI**: IntelliJ 的 UI 主题系统

### 3. 配置系统

- **PathManager**: 管理应用路径
- **ApplicationInfo**: 应用程序信息
- **PersistentStateComponent**: 状态持久化

## MES 客户端具体实现示例

### 创建 MES 数据模型

```kotlin
data class ProductionOrder(
    val id: String,
    val productName: String,
    val quantity: Int,
    val status: OrderStatus
)

enum class OrderStatus {
    PENDING, IN_PROGRESS, COMPLETED, CANCELLED
}
```

### 创建 MES 服务

```kotlin
class MESService {
    fun connectToMESServer(url: String, credentials: Credentials) {
        // 连接到 MES 服务器
    }
    
    fun getProductionOrders(): List<ProductionOrder> {
        // 获取生产订单
        return emptyList()
    }
    
    fun updateOrderStatus(orderId: String, status: OrderStatus) {
        // 更新订单状态
    }
}
```

### 创建 UI 面板

```kotlin
class MESProductionPanel : JPanel(BorderLayout()) {
    private val orderTable = JBTable()
    private val mesService = MESService()
    
    init {
        val scrollPane = JBScrollPane(orderTable)
        add(scrollPane, BorderLayout.CENTER)
        
        // 添加工具栏
        val toolbar = createToolbar()
        add(toolbar, BorderLayout.NORTH)
        
        // 加载数据
        loadOrders()
    }
    
    private fun createToolbar(): JPanel {
        val toolbar = JPanel()
        toolbar.add(JButton("刷新").apply {
            addActionListener { loadOrders() }
        })
        toolbar.add(JButton("新建订单"))
        return toolbar
    }
    
    private fun loadOrders() {
        val orders = mesService.getProductionOrders()
        // 更新表格数据
    }
}
```

## 构建和运行

### 构建独立应用

```bash
# 使用 Gradle 构建
./gradlew buildPlugin

# 运行应用
./gradlew runIde
```

### 打包分发

```bash
# 创建可分发的应用程序
./gradlew buildSearchableOptions
./gradlew jar
```

## 注意事项

1. **许可证**: IntelliJ Platform 使用 Apache 2.0 许可证，确保遵守许可证要求
2. **依赖管理**: 仔细管理依赖，避免包含不必要的模块
3. **性能优化**: IntelliJ Platform 功能强大但也较重，考虑只包含需要的模块
4. **UI 定制**: 可以完全自定义 UI，但保持与平台的一致性会获得更好的用户体验

## 参考资源

- [IntelliJ Platform SDK 文档](https://plugins.jetbrains.com/docs/intellij/)
- [IntelliJ Platform Plugin 开发指南](https://plugins.jetbrains.com/docs/intellij/welcome.html)
- [Platform UI Guidelines](https://jetbrains.github.io/ui/)
- [源码参考](https://github.com/JetBrains/intellij-community)

## 示例项目结构

```
mes-client-platform/
├── build.gradle.kts
├── settings.gradle.kts
├── src/
│   └── main/
│       ├── kotlin/
│       │   └── com/example/mes/
│       │       ├── MESApplication.kt          # 应用主类
│       │       ├── MESMainWindow.kt           # 主窗口
│       │       ├── services/
│       │       │   ├── MESService.kt          # MES 业务服务
│       │       │   └── MESConnectionManager.kt # 连接管理
│       │       ├── ui/
│       │       │   ├── ProductionPanel.kt      # 生产面板
│       │       │   ├── QualityPanel.kt         # 质量控制面板
│       │       │   └── InventoryPanel.kt       # 库存面板
│       │       └── models/
│       │           ├── ProductionOrder.kt
│       │           ├── QualityCheck.kt
│       │           └── InventoryItem.kt
│       └── resources/
│           ├── META-INF/
│           │   └── plugin.xml
│           └── messages/
│               └── MESBundle.properties
└── README.md
```

## 快速开始

1. 克隆或创建基于 IntelliJ Platform 的新项目
2. 配置 `build.gradle.kts` 以包含必要的平台模块
3. 实现自定义的 `ApplicationStarter` 或 `ToolWindowFactory`
4. 开发您的 MES 特定功能（生产监控、质量控制等）
5. 使用 `./gradlew runIde` 运行和测试
6. 使用 `./gradlew buildPlugin` 构建分发包

这样，您就可以复用 IntelliJ 平台强大的启动流程和 UI 框架，同时构建完全自定义的 MES 客户端应用程序。
