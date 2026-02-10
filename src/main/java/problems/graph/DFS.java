package problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        List<List<Integer>> adjList  = new ArrayList<>();
        int V = 5;
        adjList.add(Arrays.asList(2,3,1));
        adjList.add(Arrays.asList(0));
        adjList.add(Arrays.asList(0,4));
        adjList.add(Arrays.asList(0));
        adjList.add(Arrays.asList(2));
        List<Integer> dfs = dfs(adjList);
        System.out.println(dfs);
    }

    private static List<Integer> dfs(List<List<Integer>> adjList) {
        List<Integer> res = new ArrayList<>();
        int[] visited = new int[adjList.size()];
        dfsRecurrsion(0, adjList, visited, res);
        return res;
    }

    private static void dfsRecurrsion(int node, List<List<Integer>> adjList, int[] visited, List<Integer> res) {
        visited[node] = 1;
        res.add(node);
        for (int nextNode : adjList.get(node)) {
            if (visited[nextNode] == 0) {
                dfsRecurrsion(nextNode, adjList, visited, res);
            }
        }
    }
}
