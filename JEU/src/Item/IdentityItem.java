package Item;

public class IdentityItem {
    private final int value;
    private final String name;
    private final String description;

    public IdentityItem(int value, String name, String description) {
        this.value = value;
        this.name = name;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

