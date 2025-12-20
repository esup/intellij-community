# Table Components Quick Reference Guide

## Quick Start

### Creating a Simple Table

```java
import com.intellij.ui.table.TableView;
import com.intellij.util.ui.ColumnInfo;
import com.intellij.util.ui.ListTableModel;

// Define your data class
class Person {
    private String name;
    private int age;
    // constructors, getters, setters
}

// Create column definitions
ColumnInfo<Person, String>[] columns = new ColumnInfo[] {
    new ColumnInfo<Person, String>("Name") {
        @Override
        public String valueOf(Person person) {
            return person.getName();
        }
    },
    new ColumnInfo<Person, Integer>("Age") {
        @Override
        public Integer valueOf(Person person) {
            return person.getAge();
        }
    }
};

// Create model and table
ListTableModel<Person> model = new ListTableModel<>(columns);
TableView<Person> table = new TableView<>(model);

// Add data
model.setItems(Arrays.asList(
    new Person("Alice", 30),
    new Person("Bob", 25)
));
```

### Adding a Toolbar

```java
import com.intellij.ui.ToolbarDecorator;

JPanel panel = ToolbarDecorator.createDecorator(table)
    .setAddAction(button -> {
        model.addRow(new Person("New Person", 0));
    })
    .setRemoveAction(button -> {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        }
    })
    .createPanel();
```

## Common Tasks

### 1. Custom Cell Renderer

```java
ColumnInfo<Person, String> statusColumn = new ColumnInfo<>("Status") {
    @Override
    public String valueOf(Person person) {
        return person.getStatus();
    }
    
    @Override
    public TableCellRenderer getRenderer(Person person) {
        return new ColoredTableCellRenderer() {
            @Override
            protected void customizeCellRenderer(
                @NotNull JTable table,
                @Nullable Object value,
                boolean selected,
                boolean hasFocus,
                int row,
                int column
            ) {
                String status = (String) value;
                if ("ACTIVE".equals(status)) {
                    append(status, SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
                    setIcon(AllIcons.RunConfigurations.TestPassed);
                } else if ("ERROR".equals(status)) {
                    append(status, SimpleTextAttributes.ERROR_ATTRIBUTES);
                    setIcon(AllIcons.RunConfigurations.TestError);
                } else {
                    append(status, SimpleTextAttributes.GRAYED_ATTRIBUTES);
                }
            }
        };
    }
};
```

### 2. Editable Cells

```java
ColumnInfo<Person, String> nameColumn = new ColumnInfo<>("Name") {
    @Override
    public String valueOf(Person person) {
        return person.getName();
    }
    
    @Override
    public boolean isCellEditable(Person person) {
        return true;
    }
    
    @Override
    public void setValue(Person person, String value) {
        person.setName(value);
    }
};
```

### 3. Custom Cell Editor

```java
ColumnInfo<Person, String> typeColumn = new ColumnInfo<>("Type") {
    @Override
    public String valueOf(Person person) {
        return person.getType();
    }
    
    @Override
    public TableCellEditor getEditor(Person person) {
        JComboBox<String> comboBox = new JComboBox<>(
            new String[]{"Student", "Teacher", "Staff"}
        );
        return new DefaultCellEditor(comboBox);
    }
    
    @Override
    public boolean isCellEditable(Person person) {
        return true;
    }
    
    @Override
    public void setValue(Person person, String value) {
        person.setType(value);
    }
};
```

### 4. Sortable Columns

```java
ColumnInfo<Person, Integer> ageColumn = new ColumnInfo<>("Age") {
    @Override
    public Integer valueOf(Person person) {
        return person.getAge();
    }
    
    @Override
    public Comparator<Person> getComparator() {
        return Comparator.comparing(Person::getAge);
    }
};
```

### 5. Enable Speed Search

```java
TableSpeedSearch.installOn(table, (obj, cell) -> {
    if (obj instanceof String) {
        return (String) obj;
    }
    return obj != null ? obj.toString() : "";
});
```

### 6. Setting Column Widths

```java
// Fixed width
ColumnInfo<Person, String> idColumn = new ColumnInfo<>("ID") {
    @Override
    public String valueOf(Person person) {
        return person.getId();
    }
    
    @Override
    public int getWidth(JTable table) {
        return 100; // Fixed width of 100 pixels
    }
};

// Preferred width based on content
ColumnInfo<Person, String> nameColumn = new ColumnInfo<>("Name") {
    @Override
    public String valueOf(Person person) {
        return person.getName();
    }
    
    @Override
    public String getPreferredStringValue() {
        return "WWWWWWWWWWWWWWWW"; // Width based on this string
    }
};
```

### 7. Empty Table Message

```java
table.getEmptyText().setText("No data available");
// Or with action
table.getEmptyText()
    .setText("No items to display. ")
    .appendText("Add new item", SimpleTextAttributes.LINK_ATTRIBUTES, e -> {
        // Add item action
    });
```

### 8. Row Selection Handling

```java
table.getSelectionModel().addListSelectionListener(e -> {
    if (!e.getValueIsAdjusting()) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            Person person = model.getItem(selectedRow);
            // Handle selection
        }
    }
});
```

### 9. Multi-Column Sorting

```java
// Enable sorting
table.setAutoCreateRowSorter(true);

// Or with custom sorter
TableRowSorter<ListTableModel<Person>> sorter = 
    new TableRowSorter<>(model);
table.setRowSorter(sorter);

// Set sort keys programmatically
sorter.setSortKeys(Arrays.asList(
    new RowSorter.SortKey(0, SortOrder.ASCENDING),
    new RowSorter.SortKey(1, SortOrder.DESCENDING)
));
```

### 10. Filtering Table Data

```java
TableRowSorter<ListTableModel<Person>> sorter = 
    new TableRowSorter<>(model);
table.setRowSorter(sorter);

// Filter by age >= 18
sorter.setRowFilter(new RowFilter<ListTableModel<Person>, Integer>() {
    @Override
    public boolean include(Entry<? extends ListTableModel<Person>, ? extends Integer> entry) {
        Person person = model.getItem(entry.getIdentifier());
        return person.getAge() >= 18;
    }
});
```

## Advanced Features

### 1. TreeTable

```java
import com.intellij.ui.treeStructure.treetable.*;

// Define tree-table model
TreeTableModel treeTableModel = new TreeTableModel() {
    // Implement required methods
};

// Create tree table
TreeTable treeTable = new TreeTable(treeTableModel);
```

### 2. Striped Table

```java
table.setStriped(true);
```

### 3. Show Busy Indicator

```java
table.setPaintBusy(true);
// Perform long operation
loadData();
table.setPaintBusy(false);
```

### 4. Custom Row Height

```java
// Fixed row height
table.setRowHeight(25);

// Auto-calculate row height
table.setRowHeight(-1);
```

### 5. Persist Table State

```java
// Save table state
BaseTableView.store(
    PropertiesComponent.getInstance(),
    "MyTablePrefix",
    table
);

// Restore table state
BaseTableView.restore(
    PropertiesComponent.getInstance(),
    "MyTablePrefix",
    table
);
```

### 6. Batch Updates

```java
// Disable updates during batch operation
model.setItems(Collections.emptyList()); // Clear first

List<Person> newData = loadDataFromDatabase();
model.setItems(newData); // Set all at once
```

### 7. Context Menu

```java
import com.intellij.openapi.actionSystem.*;

table.addMouseListener(new PopupHandler() {
    @Override
    public void invokePopup(Component comp, int x, int y) {
        DefaultActionGroup group = new DefaultActionGroup();
        group.add(new AnAction("Edit") {
            @Override
            public void actionPerformed(@NotNull AnActionEvent e) {
                // Edit action
            }
        });
        group.add(new AnAction("Delete") {
            @Override
            public void actionPerformed(@NotNull AnActionEvent e) {
                // Delete action
            }
        });
        
        ActionPopupMenu popupMenu = ActionManager.getInstance()
            .createActionPopupMenu("TablePopup", group);
        popupMenu.getComponent().show(comp, x, y);
    }
});
```

### 8. Validation

```java
ColumnInfo<Person, String> emailColumn = new ColumnInfo<>("Email") {
    @Override
    public String valueOf(Person person) {
        return person.getEmail();
    }
    
    @Override
    public boolean isCellEditable(Person person) {
        return true;
    }
    
    @Override
    public void setValue(Person person, String value) {
        if (value != null && value.contains("@")) {
            person.setEmail(value);
        } else {
            Messages.showErrorDialog(
                "Invalid email address",
                "Validation Error"
            );
        }
    }
};
```

## Performance Tips

1. **Limit visible rows**
```java
table.setVisibleRowCount(20);
```

2. **Limit size calculation**
```java
table.setMaxItemsForSizeCalculation(100);
```

3. **Use lazy rendering**
```java
// Don't compute values in renderer unless needed
@Override
protected void customizeCellRenderer(...) {
    if (value != null) {
        append(value.toString());
    }
}
```

4. **Batch model updates**
```java
// Bad: Multiple updates
for (Person p : persons) {
    model.addRow(p);
}

// Good: Single update
model.setItems(persons);
```

## Common Pitfalls

### 1. Forgetting to stop editing

```java
// Always stop editing before modifying data
if (table.isEditing()) {
    table.getCellEditor().stopCellEditing();
}
model.removeRow(selectedRow);
```

### 2. Not converting row indices

```java
// Wrong
int selectedRow = table.getSelectedRow();
Person person = model.getItem(selectedRow);

// Correct (with sorting/filtering)
int selectedRow = table.getSelectedRow();
int modelRow = table.convertRowIndexToModel(selectedRow);
Person person = model.getItem(modelRow);
```

### 3. Modifying model during iteration

```java
// Wrong
for (int i = 0; i < model.getRowCount(); i++) {
    if (shouldRemove(model.getItem(i))) {
        model.removeRow(i); // Modifies during iteration
    }
}

// Correct
List<Integer> toRemove = new ArrayList<>();
for (int i = 0; i < model.getRowCount(); i++) {
    if (shouldRemove(model.getItem(i))) {
        toRemove.add(i);
    }
}
Collections.reverse(toRemove);
for (int i : toRemove) {
    model.removeRow(i);
}
```

## Debugging Tips

1. **Check model state**
```java
System.out.println("Row count: " + model.getRowCount());
System.out.println("Column count: " + model.getColumnCount());
```

2. **Verify selection**
```java
System.out.println("Selected row: " + table.getSelectedRow());
System.out.println("Selected column: " + table.getSelectedColumn());
```

3. **Inspect column info**
```java
for (ColumnInfo<Person, ?> col : model.getColumnInfos()) {
    System.out.println("Column: " + col.getName());
}
```

## References

- **Main Analysis**: See `TABLE_COMPONENTS_ANALYSIS.md`
- **Architecture Diagrams**: See `TABLE_COMPONENTS_DIAGRAMS.md`
- **IntelliJ Platform SDK**: https://plugins.jetbrains.com/docs/intellij/
- **Source Code**: `platform/platform-api/src/com/intellij/ui/table/`

---

**Document Version**: 1.0  
**Last Updated**: 2025-12-20
