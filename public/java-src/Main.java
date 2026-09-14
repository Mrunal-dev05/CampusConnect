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
            System.out.print("Choose: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> lostItems.add(readLostItem(scanner));
                case "2" -> foundItems.add(readFoundItem(scanner));
                case "3" -> showMatches(scanner, matcher);
                case "4" -> showReports();
                case "5" -> { System.out.println("Thank you for using CampusConnect!"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static LostItem readLostItem(Scanner s) {
        return new LostItem(nextId++, read(s, "Item name: "), read(s, "Category: "),
                read(s, "Location: "), readDate(s), read(s, "Description: "));
    }

    private static FoundItem readFoundItem(Scanner s) {
        return new FoundItem(nextId++, read(s, "Item name: "), read(s, "Category: "),
                read(s, "Location: "), readDate(s), read(s, "Description: "));
    }

    private static void showMatches(Scanner s, MatchingService matcher) {
        if (lostItems.isEmpty() || foundItems.isEmpty()) {
            System.out.println("Add at least one lost and one found report first.");
            return;
        }
        System.out.print("Enter lost item ID: ");
        int id;
        try { id = Integer.parseInt(s.nextLine()); }
        catch (NumberFormatException e) { System.out.println("Enter a numeric ID."); return; }
        LostItem lost = lostItems.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (lost == null) { System.out.println("Lost item not found."); return; }
        List<MatchResult> results = new ArrayList<>();
        for (FoundItem found : foundItems) results.add(matcher.calculateMatch(lost, found));
        results.sort(Comparator.comparingInt(MatchResult::getScore).reversed());
        System.out.println("\nPotential matches:");
        for (MatchResult r : results) {
            System.out.printf("Found #%d - %s | Match Score: %d%%%n",
                    r.getFoundItem().getId(), r.getFoundItem().getItemName(), r.getScore());
        }
    }

    private static void showReports() {
        System.out.println("\nLost reports: " + lostItems.size());
        lostItems.forEach(x -> System.out.println("#" + x.getId() + " " + x.getItemName()));
        System.out.println("Found reports: " + foundItems.size());
        foundItems.forEach(x -> System.out.println("#" + x.getId() + " " + x.getItemName()));
    }

    private static String read(Scanner s, String prompt) {
        System.out.print(prompt);
        return s.nextLine().trim();
    }

    private static LocalDate readDate(Scanner s) {
        while (true) {
            try { return LocalDate.parse(read(s, "Date (YYYY-MM-DD): ")); }
            catch (Exception e) { System.out.println("Use YYYY-MM-DD format."); }
        }
    }
}