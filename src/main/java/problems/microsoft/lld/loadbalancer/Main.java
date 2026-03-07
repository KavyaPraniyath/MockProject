package problems.microsoft.lld.loadbalancer;

public class Main {

    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer(new RoundRobinStrategy());

        Server s1 = new Server("S1", "10.0.0.1");
        Server s2 = new Server("S2", "10.0.0.2");
        Server s3 = new Server("S3", "10.0.0.3");
        loadBalancer.registerServer(s1);
        loadBalancer.registerServer(s2);
        loadBalancer.registerServer(s3);

        HealthChecker checker = new HealthChecker();

        for (int i = 0; i < 5; i++) {

            System.out.println("\n--- Running Health Check ---");

            checker.checkServers(loadBalancer.getServers());

            System.out.println("--- Routing Requests ---");

            for (int j = 0; j < 6; j++) {

                Server s = loadBalancer.routeRequest();

                if (s == null) {
                    System.out.println("No healthy servers available");
                } else {
                    System.out.println("Request routed to " + s.serverId);
                }
            }
        }
    }
}
