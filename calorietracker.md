

package model;

public enum Menu {
ADD(1, "Add a product"),
LIST(2, "Your list of products"),
REMOVE(3, "Remove a product"),
SAVE(4, "Save added products to file"),
LOAD(5, "Load added products from file"),
EXIT(6, "Exit");

private final int value;
private final String description;

Menu(int value, String description) {
this.value = value;
this.description = description;
}

public int getValue() {
return value;
}

public String getDescription() {
return description;
}

public static Menu fromValue(int value) {
for (Menu menu : values()) {
if (menu.value == value) {
return menu;
}
}
throw new IllegalArgumentException("Unknown value: " + value);
}
}
