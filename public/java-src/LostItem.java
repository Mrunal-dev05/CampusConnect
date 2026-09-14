package campusconnect.model;

import java.time.LocalDate;

public class LostItem extends Item {
    public LostItem(int id, String itemName, String category, String location,
                    LocalDate date, String description) {
        super(id, itemName, category, location, date, description);
    }
}