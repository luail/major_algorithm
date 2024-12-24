package A3bfs;

import java.util.*;

public class A302BfsBasic2 {
    public static void main(String[] args) {
//        모든 노드의 거리 구하기.(모두 최단거리)
        int[][] edge = {{0,1}, {0,2}, {1,3}, {2,3}, {2,4}};
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < edge.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            adjList.get(edge[i][0]).add(edge[i][1]);
            adjList.get(edge[i][1]).add(edge[i][0]);
        }

        for (List<Integer> a : adjList) {
            a.sort(Comparator.naturalOrder());
        }

        boolean[] visited = new boolean[adjList.size()];

        int[] distance = new int[5];



        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(0);
        visited[0] = true;

        while (!myQue.isEmpty()) {
            int temp = myQue.poll();
            System.out.println(temp);

            for (int target : adjList.get(temp)) {
                if (!visited[target]) {

                    myQue.add(target);
                    visited[target] = true;
                    distance[target] = distance[temp]+1;
                }
            }
        }

        System.out.println(Arrays.toString(distance));


    }
}
