// Example MES Main Window Factory
// Demonstrates how to create a custom UI using IntelliJ Platform's UI framework

package com.example.mes.client.ui

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.components.JBTabbedPane
import com.intellij.ui.content.ContentFactory
import java.awt.BorderLayout
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.border.EmptyBorder

/**
 * MES Main Window Factory
 * Register in plugin.xml:
 * <extensions defaultExtensionNs="com.intellij">
 *   <toolWindow id="MES Dashboard" 
 *               factoryClass="com.example.mes.client.ui.MESMainWindowFactory"
 *               anchor="left"
 *               icon="/icons/mes.png"/>
 * </extensions>
 */
class MESMainWindowFactory : ToolWindowFactory, DumbAware {
    
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val mainPanel = createMainPanel()
        val contentFactory = ContentFactory.getInstance()
        val content = contentFactory.createContent(mainPanel, "", false)
        toolWindow.contentManager.addContent(content)
    }
    
    private fun createMainPanel(): JPanel {
        val mainPanel = JBPanel<JBPanel<*>>(BorderLayout()).apply {
            border = EmptyBorder(10, 10, 10, 10)
        }
        
        // Add header
        val header = createHeader()
        mainPanel.add(header, BorderLayout.NORTH)
        
        // Add tabbed pane with different MES modules
        val tabbedPane = createTabbedPane()
        mainPanel.add(tabbedPane, BorderLayout.CENTER)
        
        return mainPanel
    }
    
    private fun createHeader(): JPanel {
        val header = JBPanel<JBPanel<*>>(BorderLayout()).apply {
            border = EmptyBorder(0, 0, 10, 0)
        }
        
        val title = JBLabel("MES 制造执行系统").apply {
            font = font.deriveFont(18f)
        }
        header.add(title, BorderLayout.WEST)
        
        val toolbar = createToolbar()
        header.add(toolbar, BorderLayout.EAST)
        
        return header
    }
    
    private fun createToolbar(): JPanel {
        val toolbar = JPanel().apply {
            layout = GridLayout(1, 3, 5, 0)
        }
        
        toolbar.add(JButton("连接服务器").apply {
            addActionListener { 
                // Connect to MES server
                println("Connecting to MES server...")
            }
        })
        
        toolbar.add(JButton("刷新数据").apply {
            addActionListener {
                // Refresh data
                println("Refreshing MES data...")
            }
        })
        
        toolbar.add(JButton("设置").apply {
            addActionListener {
                // Open settings
                println("Opening settings...")
            }
        })
        
        return toolbar
    }
    
    private fun createTabbedPane(): JBTabbedPane {
        val tabbedPane = JBTabbedPane()
        
        // Production monitoring tab
        tabbedPane.addTab("生产监控", createProductionPanel())
        
        // Quality control tab
        tabbedPane.addTab("质量控制", createQualityPanel())
        
        // Inventory management tab
        tabbedPane.addTab("库存管理", createInventoryPanel())
        
        // Reports tab
        tabbedPane.addTab("报表", createReportsPanel())
        
        return tabbedPane
    }
    
    private fun createProductionPanel(): JPanel {
        val panel = JBPanel<JBPanel<*>>(BorderLayout())
        
        val label = JBLabel("生产订单列表")
        panel.add(label, BorderLayout.NORTH)
        
        // Add production order table here
        val content = JBPanel<JBPanel<*>>().apply {
            add(JBLabel("订单 #001 - 进行中"))
            add(JBLabel("订单 #002 - 已完成"))
            add(JBLabel("订单 #003 - 待开始"))
        }
        
        val scrollPane = JBScrollPane(content)
        panel.add(scrollPane, BorderLayout.CENTER)
        
        return panel
    }
    
    private fun createQualityPanel(): JPanel {
        val panel = JBPanel<JBPanel<*>>(BorderLayout())
        
        val label = JBLabel("质量检查记录")
        panel.add(label, BorderLayout.NORTH)
        
        // Add quality check table here
        val content = JBPanel<JBPanel<*>>().apply {
            add(JBLabel("检查 #001 - 合格"))
            add(JBLabel("检查 #002 - 待审核"))
        }
        
        val scrollPane = JBScrollPane(content)
        panel.add(scrollPane, BorderLayout.CENTER)
        
        return panel
    }
    
    private fun createInventoryPanel(): JPanel {
        val panel = JBPanel<JBPanel<*>>(BorderLayout())
        
        val label = JBLabel("库存概览")
        panel.add(label, BorderLayout.NORTH)
        
        // Add inventory table here
        val content = JBPanel<JBPanel<*>>().apply {
            add(JBLabel("原材料 A - 库存: 1000"))
            add(JBLabel("原材料 B - 库存: 500"))
            add(JBLabel("成品 X - 库存: 200"))
        }
        
        val scrollPane = JBScrollPane(content)
        panel.add(scrollPane, BorderLayout.CENTER)
        
        return panel
    }
    
    private fun createReportsPanel(): JPanel {
        val panel = JBPanel<JBPanel<*>>(BorderLayout())
        
        val label = JBLabel("生产报表")
        panel.add(label, BorderLayout.NORTH)
        
        // Add reports here
        val content = JBPanel<JBPanel<*>>().apply {
            add(JBLabel("日报 - 2025-12-19"))
            add(JBLabel("周报 - 第50周"))
            add(JBLabel("月报 - 12月"))
        }
        
        val scrollPane = JBScrollPane(content)
        panel.add(scrollPane, BorderLayout.CENTER)
        
        return panel
    }
}
