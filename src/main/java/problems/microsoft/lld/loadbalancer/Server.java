package problems.microsoft.lld.loadbalancer;

public class Server {
    String serverId;
    String serverIp;
    boolean isHealthy;
    int activeConnections;

    public Server (String serverId, String serverIp) {
        this.serverId = serverId;
        this.serverIp = serverIp;
        this.isHealthy = true;
        this.activeConnections = 0;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy (boolean healthy) {
        this.isHealthy = healthy;
    }
}
