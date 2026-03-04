package problems.interview.microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a data structure that supports the following operations:
 *
 * register(serverId)
 *
 * Registers a server with unique ID serverId.
 *
 * Stores the current system timestamp (milliseconds) as the server's last seen time.
 *
 * If the server already exists, update its last seen timestamp.
 *
 * heartbeat(serverId)
 *
 * Updates the last seen timestamp for the given serverId to System.currentTimeMillis(), only if it is already registered.
 *
 * getNextServer()
 *
 * Returns the next active server ID in round‑robin order.
 *
 * A server is active if it has sent a heartbeat (or was registered) in the last 5 seconds.
 *
 * If no active server exists, return null.
 */
public class ServerManager {

    private Map<Integer, Long> lastSeen;  // serverId -> last heartbeat timestamp
    private List<Integer> servers;         // round-robin order
    private int pointer;                   // current round-robin index
    private static final long TIMEOUT = 5000; // 5 seconds in milliseconds

    public ServerManager() {
        lastSeen = new HashMap<>();
        servers = new ArrayList<>();
        pointer = 0;
    }

    // Register a server with current timestamp
    public void register(int serverId) {
        long now = System.currentTimeMillis();
        if (!lastSeen.containsKey(serverId)) {
            servers.add(serverId);
        }
        lastSeen.put(serverId, now);
    }

    // Heartbeat updates last seen timestamp
    public void heartbeat(int serverId) {
        if (lastSeen.containsKey(serverId)) {
            long now = System.currentTimeMillis();
            lastSeen.put(serverId, now);
        }
    }

    // Get next active server in round-robin order
    public Integer getNextServer() {
        if (servers.isEmpty()) return null;

        int n = servers.size();
        int checked = 0;
        long now = System.currentTimeMillis();

        while (checked < n) {
            int serverId = servers.get(pointer);
            pointer = (pointer + 1) % n;
            checked++;

            if (isActive(serverId, now)) {
                return serverId;
            }
        }

        return null; // No active server available
    }

    // Check if server is active
    private boolean isActive(int serverId, long currentTime) {
        return currentTime - lastSeen.get(serverId) <= TIMEOUT;
    }

    // Optional: remove inactive servers (to avoid scanning inactive ones repeatedly)
    public void removeInactiveServers() {
        long now = System.currentTimeMillis();
        servers.removeIf(serverId -> !isActive(serverId, now));
    }

    // For debugging
    public void printServers() {
        long now = System.currentTimeMillis();
        System.out.println("Servers status:");
        for (int id : servers) {
            System.out.println("Server " + id + " lastSeen=" + lastSeen.get(id) +
                    " active=" + isActive(id, now));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ServerManager sm = new ServerManager();

        sm.register(1);
        sm.register(2);
        sm.register(3);

        Thread.sleep(3000); // 3 seconds

        sm.heartbeat(1); // server 1 updates heartbeat

        System.out.println(sm.getNextServer()); // likely 1
        System.out.println(sm.getNextServer()); // likely 2
        System.out.println(sm.getNextServer()); // likely 1 again if 2 inactive

        sm.printServers();
    }
}
