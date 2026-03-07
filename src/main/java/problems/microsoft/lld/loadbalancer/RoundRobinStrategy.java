package problems.microsoft.lld.loadbalancer;

import java.util.List;

public class RoundRobinStrategy implements LoadBalancingStrategy {
    private int index = 0;

    @Override
    public Server selectServer(List<Server> servers) {
        for (int i = 0; i < servers.size(); i++) {
            Server server = servers.get(index);
            index = (index + 1) % servers.size();

            if (isActive(server)) {
                return server;
            }
        }
        return null;
    }

    private boolean isActive(Server server) {
        return server.isHealthy();
    }
}
