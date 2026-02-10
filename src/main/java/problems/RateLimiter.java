package problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
    private final int limit;
    private final long windowSizeInMillis;
    private final Map<String, Deque<Long>> record;

    public RateLimiter(int limit, long windowSizeInMillis) {
        this.limit = limit;
        this.windowSizeInMillis = windowSizeInMillis;
        this.record = new ConcurrentHashMap<>();
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        if (!record.containsKey(userId)) {
            record.put(userId, new LinkedList<>());
        }
        Deque<Long> timestamp = record.get(userId);
        synchronized (timestamp) {
            while (!timestamp.isEmpty() && currentTime - timestamp.peekLast() > windowSizeInMillis) {
                timestamp.pollLast();
            }
            if (timestamp.size() < limit) {
                timestamp.add(currentTime);
                return true;
            } else  {
                return false;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(3, 5000); // 3 requests per 5 sec

        String user = "user1";

        for (int i = 1; i <= 16; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " allowed: " + allowed);
            Thread.sleep(1000);
        }
    }
}
