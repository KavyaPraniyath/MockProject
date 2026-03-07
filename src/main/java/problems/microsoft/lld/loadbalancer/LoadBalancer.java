package problems.microsoft.lld.loadbalancer;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {
    private List<Server> servers;
    private LoadBalancingStrategy strategy;

    public LoadBalancer(LoadBalancingStrategy strategy) {
        this.servers = new ArrayList<>();
        this.strategy = strategy;
    }

    public void registerServer(Server server) {
        servers.add(server);
    }

    public Server routeRequest() {
        return strategy.selectServer(servers);
    }

    public List<Server> getServers() {
        return servers;
    }
}
