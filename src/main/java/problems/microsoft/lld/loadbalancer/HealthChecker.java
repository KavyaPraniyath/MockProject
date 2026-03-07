package problems.microsoft.lld.loadbalancer;

import java.util.List;
import java.util.Random;

public class HealthChecker {

    Random random = new Random();

    public void checkServers(List<Server> servers) {

        for (Server server : servers) {

            // simulate health check
            boolean healthy = random.nextBoolean();

            server.setHealthy(healthy);

            System.out.println("HealthCheck: " + server.serverId + " -> " + (healthy ? "UP" : "DOWN"));
        }
    }
}
