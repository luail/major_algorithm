package A3bfs;

import java.util.*;

public class A301BfsBasic1 {
    public static void main(String[] args) {
//        방문할 수 있는 정점이 여러개인 경우, 정점번호가 작은것을 먼저 방문
//        bfs알고리즘 형식의 방문순서를 출력. 출발은 0부터.
        int[][] edge = {{0,1}, {0,2}, {1,3}, {2,3}, {2,4}};
//        dfs로 방문시 0 -> 1 -> 2 -> 3 -> 4

//        인접리스트에 담기. (양방향)
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
//        bfs알고리즘을 구현하기 위한 Queue생성.
        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(0);
        visited[0] = true;
//        queue가 비워질때까지 방문을 지속.
//        queue가 비워진다는것은 더 이상 갈 곳이 없을 때를 의미, 이 때 코드 종료.
        while (!myQue.isEmpty()) {
            int temp = myQue.poll();
            System.out.println(temp);

            for (int target : adjList.get(temp)) {
                if (!visited[target]) {
//                    queue에 add하는 시점에 boolean값 세팅.
                    visited[target] = true;
                    myQue.add(target);
                }
            }
        }

//        DFS와 BFS
    }
}
