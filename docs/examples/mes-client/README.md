# MES Client Example

This directory contains example code demonstrating how to reuse IntelliJ Platform's startup process and UI framework to build a custom MES (Manufacturing Execution System) client application.

## Files

- **MESClientStarter.kt** - Custom application starter that initializes the MES client
- **MESMainWindowFactory.kt** - Main UI window with tabs for production, quality, inventory, and reports
- **plugin.xml** - Plugin configuration showing how to register components
- **build.gradle.kts** - Build configuration for the MES client project

## Usage

These examples show the three main approaches:

1. **IntelliJ Platform Plugin** - Extend existing IntelliJ IDEA with MES capabilities
2. **Custom Application** - Build standalone MES client based on IntelliJ Platform
3. **Hybrid Approach** - Combine both for maximum flexibility

## Key Concepts Demonstrated

### Application Startup
- Custom `ApplicationStarter` implementation
- Service initialization
- Main window creation

### UI Framework
- `ToolWindowFactory` for creating tool windows
- Using IntelliJ UI components (JBPanel, JBLabel, JBTabbedPane, etc.)
- Layout management with BorderLayout and GridLayout
- Creating multi-tab interfaces

### Configuration
- plugin.xml structure
- Extension point registration
- Service declarations
- Action registration

## Next Steps

1. Copy these files to your new project
2. Modify package names and classes to match your needs
3. Implement actual MES business logic
4. Add database/API connections
5. Customize UI according to your requirements

For complete documentation, see: [REUSING_INTELLIJ_PLATFORM.md](../REUSING_INTELLIJ_PLATFORM.md)
