# Table Components Architecture Diagrams

## 1. Class Hierarchy

```mermaid
classDiagram
    class JTable {
        <<Swing>>
        +getModel()
        +getColumnModel()
        +getSelectionModel()
    }
    
    class JBTable {
        +StatusText myEmptyText
        +ExpandableItemsHandler myExpandableItemsHandler
        +setVisibleRowCount(int)
        +getEmptyText()
        +setStriped(boolean)
    }
    
    class BaseTableView {
        +store(PropertiesComponent, String, JTable)
        +restore(PropertiesComponent, String, JTable)
    }
    
    class TableView~Item~ {
        +getListTableModel()
        +setModelAndUpdateColumns()
        +updateColumnSizes()
        +setSelection(Collection)
    }
    
    class TreeTable {
        -TreeTableTree myTree
        -TreeTableModel myTableModel
        +getTree()
        +setModel(TreeTableModel)
    }
    
    class JBTreeTable {
        +TreeTable functionality
        +Additional JB features
    }
    
    class JBTableWithResizableCells {
        +Cell resizing support
        +Mouse drag handling
    }
    
    JTable <|-- JBTable
    JBTable <|-- BaseTableView
    BaseTableView <|-- TableView
    JBTable <|-- TreeTable
    JBTable <|-- JBTreeTable
    JBTable <|-- JBTableWithResizableCells
```

## 2. Data Model Architecture

```mermaid
classDiagram
    class TableModel {
        <<interface>>
        +getRowCount()
        +getColumnCount()
        +getValueAt(row, col)
    }
    
    class AbstractTableModel {
        <<abstract>>
        +fireTableChanged()
        +fireTableRowsInserted()
    }
    
    class TableViewModel~Item~ {
        <<abstract>>
        +getRowValue(row)
        +getColumnInfos()
        +getItems()
    }
    
    class ListTableModel~Item~ {
        -ColumnInfo[] myColumnInfos
        -List~Item~ myItems
        +setItems(List)
        +addRow(Item)
        +removeRow(int)
    }
    
    class ColumnInfo~Item,Aspect~ {
        <<abstract>>
        -String myName
        +valueOf(Item)*
        +getRenderer(Item)
        +getEditor(Item)
        +getComparator()
    }
    
    TableModel <|.. AbstractTableModel
    AbstractTableModel <|-- TableViewModel
    TableViewModel <|-- ListTableModel
    ListTableModel "1" *-- "many" ColumnInfo
```

## 3. Renderer System

```mermaid
classDiagram
    class TableCellRenderer {
        <<interface>>
        +getTableCellRendererComponent()
    }
    
    class SimpleColoredComponent {
        +append(String, SimpleTextAttributes)
        +setIcon(Icon)
        +clear()
    }
    
    class SimpleColoredRenderer {
        +acquireState(table, selected, hasFocus, row, col)
        +getCellState()
    }
    
    class ColoredTableCellRenderer {
        <<abstract>>
        +customizeCellRenderer()*
        -rendererComponentInner()
    }
    
    class BooleanTableCellRenderer {
        +renders checkboxes
    }
    
    class ComboBoxTableCellRenderer {
        +renders combo boxes
    }
    
    class IconTableCellRenderer {
        +renders icons
    }
    
    TableCellRenderer <|.. SimpleColoredComponent
    SimpleColoredComponent <|-- SimpleColoredRenderer
    SimpleColoredRenderer <|-- ColoredTableCellRenderer
    TableCellRenderer <|.. BooleanTableCellRenderer
    TableCellRenderer <|.. ComboBoxTableCellRenderer
    TableCellRenderer <|.. IconTableCellRenderer
```

## 4. Editor System

```mermaid
classDiagram
    class TableCellEditor {
        <<interface>>
        +getTableCellEditorComponent()
        +getCellEditorValue()
        +stopCellEditing()
    }
    
    class AbstractTableCellEditor {
        <<abstract>>
        +listeners handling
    }
    
    class ComboBoxTableCellEditor {
        +combo box editing
    }
    
    class BooleanTableCellEditor {
        +checkbox editing
    }
    
    class StringTableCellEditor {
        +text editing
    }
    
    class CodeFragmentTableCellEditorBase {
        +code fragment editing
    }
    
    class JBTableRowEditor {
        +row-level editing
        +custom panel support
    }
    
    TableCellEditor <|.. AbstractTableCellEditor
    AbstractTableCellEditor <|-- ComboBoxTableCellEditor
    AbstractTableCellEditor <|-- BooleanTableCellEditor
    AbstractTableCellEditor <|-- StringTableCellEditor
    AbstractTableCellEditor <|-- CodeFragmentTableCellEditorBase
    TableCellEditor <|.. JBTableRowEditor
```

## 5. Component Interaction Flow

```mermaid
sequenceDiagram
    participant User
    participant JBTable
    participant ListTableModel
    participant ColumnInfo
    participant Renderer
    participant Editor
    
    User->>JBTable: Click cell
    JBTable->>ListTableModel: getValueAt(row, col)
    ListTableModel->>ColumnInfo: valueOf(item)
    ColumnInfo-->>ListTableModel: value
    ListTableModel-->>JBTable: value
    JBTable->>ColumnInfo: getRenderer(item)
    ColumnInfo-->>JBTable: renderer
    JBTable->>Renderer: getTableCellRendererComponent()
    Renderer-->>JBTable: component
    JBTable->>User: Display cell
    
    User->>JBTable: Double click cell
    JBTable->>ColumnInfo: getEditor(item)
    ColumnInfo-->>JBTable: editor
    JBTable->>Editor: getTableCellEditorComponent()
    Editor-->>JBTable: component
    JBTable->>User: Edit cell
    
    User->>Editor: Enter new value
    Editor->>JBTable: stopCellEditing()
    JBTable->>Editor: getCellEditorValue()
    Editor-->>JBTable: new value
    JBTable->>ColumnInfo: setValue(item, value)
    ColumnInfo->>ListTableModel: update item
    ListTableModel->>JBTable: fireTableCellUpdated()
```

## 6. TableView with ColumnInfo Pattern

```mermaid
flowchart TD
    A[TableView~Person~] --> B[ListTableModel~Person~]
    B --> C[ColumnInfo~Person, String~ Name]
    B --> D[ColumnInfo~Person, Integer~ Age]
    B --> E[ColumnInfo~Person, String~ Email]
    
    C --> F[valueOf: person.getName]
    C --> G[getRenderer: ColoredRenderer]
    C --> H[getEditor: StringEditor]
    
    D --> I[valueOf: person.getAge]
    D --> J[getRenderer: DefaultRenderer]
    D --> K[getEditor: NumberEditor]
    
    E --> L[valueOf: person.getEmail]
    E --> M[getRenderer: ColoredRenderer]
    E --> N[getEditor: StringEditor]
    
    style A fill:#e1f5ff
    style B fill:#ffe1e1
    style C fill:#e1ffe1
    style D fill:#e1ffe1
    style E fill:#e1ffe1
```

## 7. Utility and Support Components

```mermaid
graph LR
    A[JBTable] --> B[TableUtil]
    A --> C[TableToolbarDecorator]
    A --> D[TableSpeedSearch]
    A --> E[TableHoverListener]
    A --> F[ExpandableItemsHandler]
    
    B --> B1[removeSelectedItems]
    B --> B2[scrollSelectionToVisible]
    B --> B3[selectRows]
    
    C --> C1[Add Button]
    C --> C2[Remove Button]
    C --> C3[Up/Down Buttons]
    
    D --> D1[Incremental Search]
    D --> D2[Custom Converter]
    
    E --> E1[Hover Highlighting]
    
    F --> F1[Cell Content Expansion]
    
    style A fill:#e1f5ff
    style B fill:#ffe1e1
    style C fill:#ffe1e1
    style D fill:#ffe1e1
    style E fill:#ffe1e1
    style F fill:#ffe1e1
```

## 8. TreeTable Architecture

```mermaid
graph TB
    A[TreeTable] --> B[TreeTableTree]
    A --> C[TreeTableModel]
    A --> D[TreeTableCellRenderer]
    A --> E[TreeTableCellEditor]
    
    B --> B1[JTree embedded in first column]
    C --> C1[Combines tree and table data]
    D --> D1[Renders tree nodes as cells]
    E --> E1[Edits tree nodes in cells]
    
    A --> F[Selection Synchronization]
    F --> F1[Tree Selection]
    F --> F2[Table Selection]
    
    style A fill:#e1f5ff
    style B fill:#e1ffe1
    style C fill:#e1ffe1
    style D fill:#ffe1e1
    style E fill:#ffe1e1
    style F fill:#fff4e1
```

## 9. Data Flow in TableView

```mermaid
flowchart LR
    A[User Action] --> B{Action Type}
    
    B -->|View| C[Get Data]
    C --> D[ListTableModel]
    D --> E[ColumnInfo.valueOf]
    E --> F[Renderer]
    F --> G[Display]
    
    B -->|Edit| H[Start Edit]
    H --> I[ColumnInfo.getEditor]
    I --> J[Editor Component]
    J --> K[User Input]
    K --> L[stopCellEditing]
    L --> M[ColumnInfo.setValue]
    M --> D
    
    B -->|Sort| N[Click Header]
    N --> O[ColumnInfo.getComparator]
    O --> P[Sort List]
    P --> D
    
    B -->|Add/Remove| Q[Toolbar Action]
    Q --> R[ListTableModel.addRow/removeRow]
    R --> D
    
    D --> S[fireTableChanged]
    S --> T[Table Refresh]
    
    style A fill:#e1f5ff
    style D fill:#ffe1e1
    style T fill:#e1ffe1
```

## 10. Performance Optimization Strategies

```mermaid
mindmap
    root((Performance))
        Lazy Calculation
            Row Height
            Column Width
            Cell Values
        Caching
            Renderer Components
            Column Info
            Computed Values
        Virtualization
            Visible Rows Only
            On-Demand Loading
        Limits
            Max Items for Size Calc
            Batch Updates
        Smart Repainting
            Partial Repaint
            Viewport Only
            Event Merging
```

## 11. Extension Points

```mermaid
graph TD
    A[Custom Table] --> B{Choose Base}
    
    B -->|Simple| C[JBTable]
    B -->|Persistence| D[BaseTableView]
    B -->|Type-Safe| E[TableView~T~]
    B -->|Tree-Table| F[TreeTable]
    
    C --> G[Override Methods]
    D --> G
    E --> G
    F --> G
    
    G --> H[Custom Rendering]
    G --> I[Custom Editing]
    G --> J[Custom Behavior]
    
    H --> K[Extend ColoredTableCellRenderer]
    I --> L[Extend AbstractTableCellEditor]
    J --> M[Override Table Methods]
    
    style A fill:#e1f5ff
    style C fill:#e1ffe1
    style D fill:#e1ffe1
    style E fill:#e1ffe1
    style F fill:#e1ffe1
```

## 12. Common Usage Patterns

```mermaid
stateDiagram-v2
    [*] --> Create: Create TableView
    Create --> Configure: Set ColumnInfo
    Configure --> PopulateData: Add Items
    PopulateData --> Display: Show Table
    
    Display --> Edit: User Edit
    Edit --> Validate: Check Input
    Validate --> Save: Valid
    Validate --> Edit: Invalid
    Save --> Display: Update View
    
    Display --> Sort: User Sort
    Sort --> Display: Refresh
    
    Display --> Filter: User Filter
    Filter --> Display: Update View
    
    Display --> AddRow: User Add
    AddRow --> Display: Refresh
    
    Display --> RemoveRow: User Remove
    RemoveRow --> Display: Refresh
    
    Display --> [*]: Dispose
```

---

These diagrams provide a visual representation of the table component architecture in IntelliJ IDEA Community. They can be rendered using any Mermaid-compatible viewer or editor.
