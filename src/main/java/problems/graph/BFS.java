package problems.graph;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        List<List<Integer>> adjList  = new ArrayList<>();
        int V = 5;
        adjList.add(Arrays.asList(2,3,1));
        adjList.add(Arrays.asList(0));
        adjList.add(Arrays.asList(0,4));
        adjList.add(Arrays.asList(0));
        adjList.add(Arrays.asList(2));
        List<Integer> bfs = bfs(V, adjList);
        System.out.println(bfs);
    }

    private static List<Integer> bfs(int v, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[v];
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int next : adjList.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }

        }
        return result;
    }
}
