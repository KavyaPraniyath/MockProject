package problems;

public class Agent {
    private String id;
    private int totalRating;
    private int ratingCount;

    public Agent(String id) {
        this.id = id;
    }

    public void addRating(int rating) {
        this.totalRating += rating;
        this.ratingCount += 1;
    }

    public double getAverageRating() {
        if (ratingCount == 0) {
            return 0.0;
        }
        return totalRating / ratingCount;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id='" + id + '\'' +
                ", avgRating=" + getAverageRating() +
                ", ratingCount=" + ratingCount +
                '}';
    }
}
