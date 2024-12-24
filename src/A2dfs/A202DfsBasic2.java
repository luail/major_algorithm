package A2dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A202DfsBasic2 {
    static List<List<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {4, 9}, {5, 10}};

        for (int i = 0; i < 11; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] a : arr) {
            adjList.get(a[0]).add(a[1]);
        }

        List<List<Integer>> answer = new ArrayList<>();

        boolean[] visited = new boolean[11];

//        {1,2,4,8}, {1,2,4,9}, {1,2,5,10}, {1,3,6}, {1,3,7}
        List<Integer> temp = new ArrayList<>();

        visited[1] = true;
        temp.add(1);

        dfs(1, answer, temp);
        System.out.println(answer);


    }

    static void dfs(int start, List<List<Integer>> answer, List<Integer> temp) {
        if (adjList.get(start).isEmpty()) {
            answer.add(new ArrayList<>(temp));
        }

        for (int target : adjList.get(start)) {
                temp.add(target);
                dfs(target, answer, temp);
                temp.remove(temp.size()-1);
        }
    }
}