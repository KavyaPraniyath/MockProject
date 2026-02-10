package problems;

import java.util.*;

public class RatingSystem {
    private Map<String, Agent> map;
    private TreeSet<Agent> sortedAgents;

    public RatingSystem() {
        this.map = new HashMap<>();
        this.sortedAgents = new TreeSet<>((a, b) -> {
            int cmp = Double.compare(b.getAverageRating(),  a.getAverageRating());
            if (cmp == 0) {
                cmp = Integer.compare(b.getRatingCount(), a.getRatingCount());
            }
            if (cmp == 0) {
                cmp = a.getId().compareTo(b.getId());
            }
            return cmp;
        });
    }

    public void addRating(String agentId, int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("rating must be between 1 and 5");
        }
        Agent agent = map.get(agentId);
        if (agent == null) {
            agent = new Agent(agentId);
            agent.addRating(rating);
            map.put(agentId, agent);
        } else {
            sortedAgents.remove(map.get(agentId));
            agent.addRating(rating);
        }
        sortedAgents.add(agent);
    }

    public List<Agent> getSortedAgents(int k) {
        List<Agent> agents = new ArrayList<>();
        int count = 0;
        for (Agent agent : sortedAgents) {
            agents.add(agent);
            count++;
            if (count == k) break;
        }
        return agents;
    }

    public static void main(String[] args) {
        RatingSystem rs = new RatingSystem();

        rs.addRating("A1", 5);
        rs.addRating("A1", 4);

        rs.addRating("A2", 5);

        rs.addRating("A3", 3);
        rs.addRating("A3", 3);
        rs.addRating("A3", 5);

        rs.addRating("A4", 5);
        rs.addRating("A4", 5);
        rs.addRating("A4", 5);

        List<Agent> agents = rs.getSortedAgents(2);

        for (Agent a : agents) {
            System.out.println(a);
        }
    }
}
