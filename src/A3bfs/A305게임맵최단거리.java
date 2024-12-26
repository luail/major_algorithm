package A3bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A305게임맵최단거리 {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int []{0,0,1});

        int answer = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            if (temp[0] == maps.length-1 && temp[1] == maps[0].length-1) {
                answer = temp[2];
            }

            int a = temp[0];  // y축
            int b = temp[1];  // x축
            int c = temp[2];

            if (a-1 >= 0 && maps[a-1][b] == 1 && !visited[a-1][b]) {
                queue.add(new int[]{a-1, b, c+1});
                visited[a-1][b] = true;
            }
            if (b-1 >= 0 && maps[a][b-1] == 1 && !visited[a][b-1]) {
                queue.add(new int[]{a,b-1, c+1});
                visited[a][b-1] = true;
            }
            if (a+1 < maps.length && maps[a+1][b] == 1 && !visited[a+1][b]) {
                queue.add(new int[]{a+1,b, c+1});
                visited[a+1][b] = true;
            }
            if (b+1 < maps[0].length && maps[a][b+1] == 1 && !visited[a][b+1]) {
                queue.add(new int[]{a,b+1, c+1});
                visited[a][b+1] = true;
            }
        }
        System.out.println(answer);
    }
}
