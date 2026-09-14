package campusconnect;

import campusconnect.model.FoundItem;
import campusconnect.model.LostItem;
import campusconnect.model.MatchResult;
import campusconnect.service.MatchingService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<LostItem> lostItems = new ArrayList<>();
    private static final List<FoundItem> foundItems = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MatchingService matcher = new MatchingService();

        while (true) {
            System.out.println("\n=== CAMPUSCONNECT ===");
            System.out.println("1. Report Lost Item");
            System.out.println("2. Report Found Item");
            System.out.println("3. Find Matches");
            System.out.println("4. View Reports");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> reportLost(scanner);
                    case "2" -> reportFound(scanner);
                    case "3" -> showMatches(matcher);
                    case "4" -> showReports();
                    case "5" -> {
                        System.out.println("Thank you for using CampusConnect.");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid option. Please choose 1-5.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Input error: " + e.getMessage());
            }
        }
    }

    private static void reportLost(Scanner scanner) {
        System.out.println("\n--- Report Lost Item ---");
        System.out.print("Item name: ");
        String name = required(scanner.nextLine(), "Item name");
        System.out.print("Category: ");
        String category = required(scanner.nextLine(), "Category");
        System.out.print("Location: ");
        String location = required(scanner.nextLine(), "Location");
        System.out.print("Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine().trim());
        System.out.print("Description: ");
        String description = required(scanner.nextLine(), "Description");

        lostItems.add(new LostItem(nextId++, name, category, location, date, description));
        System.out.println("Lost item reported successfully.");
    }

    private static void reportFound(Scanner scanner) {
        System.out.println("\n--- Report Found Item ---");
        System.out.print("Item name: ");
        String name = required(scanner.nextLine(), "Item name");
        System.out.print("Category: ");
        String category = required(scanner.nextLine(), "Category");
        System.out.print("Location: ");
        String location = required(scanner.nextLine(), "Location");
        System.out.print("Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine().trim());
        System.out.print("Description: ");
        String description = required(scanner.nextLine(), "Description");

        foundItems.add(new FoundItem(nextId++, name, category, location, date, description));
        System.out.println("Found item reported successfully.");
    }

    private static void showMatches(MatchingService matcher) {
        List<MatchResult> results = new ArrayList<>();
        for (LostItem lost : lostItems) {
            for (FoundItem found : foundItems) {
                results.add(matcher.calculateMatch(lost, found));
            }
        }

        results.sort(Comparator.comparingInt(MatchResult::getScore).reversed());
        System.out.println("\n--- Potential Matches ---");
        if (results.isEmpty()) {
            System.out.println("No reports available for matching.");
            return;
        }
        for (MatchResult result : results) {
            System.out.printf("Lost: %s | Found: %s | Score: %d/100%n",
                    result.getLostItem().getItemName(),
                    result.getFoundItem().getItemName(),
                    result.getScore());
        }
    }

    private static void showReports() {
        System.out.println("\n--- Lost Reports ---");
        lostItems.forEach(item -> System.out.println(item.getId() + ". " + item.getItemName()
                + " | " + item.getCategory() + " | " + item.getLocation() + " | " + item.getDate()));
        System.out.println("\n--- Found Reports ---");
        foundItems.forEach(item -> System.out.println(item.getId() + ". " + item.getItemName()
                + " | " + item.getCategory() + " | " + item.getLocation() + " | " + item.getDate()));
    }

    private static String required(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " cannot be empty.");
        }
        return value.trim();
    }
}
