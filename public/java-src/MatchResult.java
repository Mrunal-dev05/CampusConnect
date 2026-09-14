package campusconnect.model;

public class MatchResult {
    private final LostItem lostItem;
    private final FoundItem foundItem;
    private final int score;

    public MatchResult(LostItem lostItem, FoundItem foundItem, int score) {
        this.lostItem = lostItem;
        this.foundItem = foundItem;
        this.score = score;
    }

    public LostItem getLostItem() { return lostItem; }
    public FoundItem getFoundItem() { return foundItem; }
    public int getScore() { return score; }
}