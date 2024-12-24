package A2dfs;

public class A203피로도 {
    static int answer;
    static int static_k;
    static int static_count;
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};
        static_k = k;
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons,visited);
    }

    static void dfs(int[][] dungeons, boolean[] visited){
        if(static_count > answer){
            answer = static_count;
        }
        for (int i=0; i<dungeons.length;i++){
            if(dungeons[i][0] <= static_k && !visited[i]){
                visited[i] = true;
                static_k -= dungeons[i][1];
                static_count+=1;
                dfs(dungeons, visited);
                visited[i] = false;
                static_k += dungeons[i][1];
                static_count-=1;
            }
        }
    }
}

//    static void dfs2(int[][] dungeons, boolean[] visited, int k, int count){
//        if(count > answer){
//            answer = count;
//        }
//        for (int i=0; i<dungeons.length;i++){
//            if(dungeons[i][0] <= k && !visited[i]){
//                visited[i] = true;
//                dfs(dungeons, visited, k-dungeons[i][1], count+1);
//                visited[i] = false;
//            }
//        }
//    }
//}
