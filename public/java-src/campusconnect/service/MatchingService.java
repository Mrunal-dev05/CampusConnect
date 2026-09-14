package campusconnect.service;

import campusconnect.model.FoundItem;
import campusconnect.model.LostItem;
import campusconnect.model.MatchResult;

import java.time.temporal.ChronoUnit;

public class MatchingService {
    public MatchResult calculateMatch(LostItem lost, FoundItem found) {
        int score = 0;

        if (lost.getCategory().equalsIgnoreCase(found.getCategory())) score += 30;
        if (lost.getLocation().equalsIgnoreCase(found.getLocation())) score += 25;

        long days = Math.abs(ChronoUnit.DAYS.between(lost.getDate(), found.getDate()));
        if (days == 0) score += 20;
        else if (days <= 3) score += 15;
        else if (days <= 7) score += 10;

        if (containsIgnoreCase(lost.getItemName(), found.getItemName())
                || containsIgnoreCase(found.getItemName(), lost.getItemName())) {
            score += 15;
        }

        score += keywordScore(lost.getDescription(), found.getDescription());
        return new MatchResult(lost, found, Math.min(score, 100));
    }

    private int keywordScore(String a, String b) {
        String[] words = a.toLowerCase().split("\\W+");
        String other = b.toLowerCase();
        int common = 0;
        for (String word : words) {
            if (word.length() >= 4 && other.contains(word)) common++;
            if (common == 2) break;
        }
        return common * 5;
    }

    private boolean containsIgnoreCase(String a, String b) {
        return a.toLowerCase().contains(b.toLowerCase());
    }
}
