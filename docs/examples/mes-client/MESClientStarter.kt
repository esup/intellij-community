// Example MES Client Application Starter
// This demonstrates how to create a custom application based on IntelliJ Platform

package com.example.mes.client

import com.intellij.openapi.application.ApplicationStarter
import com.intellij.openapi.wm.WindowManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Custom application starter for MES Client
 * Register this in plugin.xml:
 * <applicationStarter implementation="com.example.mes.client.MESClientStarter"/>
 */
class MESClientStarter : ApplicationStarter {
    override val commandName: String = "mes-client"
    
    override val requiredModality: Int
        get() = ApplicationStarter.NOT_IN_EDT
    
    override suspend fun start(args: List<String>) {
        println("Starting MES Client Application...")
        
        // Initialize MES-specific services
        initializeMESServices()
        
        // Create and show main window
        withContext(Dispatchers.Main) {
            createMainWindow()
        }
        
        println("MES Client Application started successfully")
    }
    
    private fun initializeMESServices() {
        // Initialize connection to MES server
        // Load configuration
        // Start background services
        println("Initializing MES services...")
    }
    
    private fun createMainWindow() {
        val windowManager = WindowManager.getInstance()
        // Create custom MES window
        println("Creating MES main window...")
    }
}
