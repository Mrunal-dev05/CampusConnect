package campusconnect.model;

import java.time.LocalDate;

public abstract class Item {
    private final int id;
    private final String itemName;
    private final String category;
    private final String location;
    private final LocalDate date;
    private final String description;

    protected Item(int id, String itemName, String category, String location,
                   LocalDate date, String description) {
        this.id = id;
        this.itemName = itemName;
        this.category = category;
        this.location = location;
        this.date = date;
        this.description = description;
    }

    public int getId() { return id; }
    public String getItemName() { return itemName; }
    public String getCategory() { return category; }
    public String getLocation() { return location; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }
}