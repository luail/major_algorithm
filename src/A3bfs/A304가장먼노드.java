package A3bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A304가장먼노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
//        방문처리를 위해 굳이 visited를 안두고 distance를 -1로 세팅한 뒤
//        distance가 -1이면 방문을 안했다는 의미이므로 visited를 따로 안둬도 된다!

        Queue<Integer> que = new LinkedList<>();

        que.add(1);
        visited[1] = true;

        int max = 0;

        while (!que.isEmpty()) {
            int node = que.poll();

            for (int a : graph.get(node)) {
                if (!visited[a]) {
                    que.add(a);
                    visited[a] = true;
                    distance[a] = distance[node] + 1;
                    if (max < distance[a]) {
                        max = distance[a];
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < distance.length; i++) {
            if (max == distance[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
