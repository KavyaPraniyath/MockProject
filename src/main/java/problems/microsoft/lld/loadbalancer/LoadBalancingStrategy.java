package problems.microsoft.lld.loadbalancer;

import java.util.List;

public interface LoadBalancingStrategy {

    Server selectServer(List<Server> servers);
}
