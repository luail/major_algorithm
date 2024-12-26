package A3bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class A306숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int start = Integer.parseInt(arr[0]);
        int target = Integer.parseInt(arr[1]);
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[]{start, 0});
        int answer = 0;
        if(start != target){
            while (!myQueue.isEmpty()){
                int[] temp = myQueue.poll();
                if(temp[0] <0 || temp[0] > 10000)continue;
                myQueue.add(new int[]{temp[0]+1, temp[1]+1 });
                myQueue.add(new int[]{temp[0]-1, temp[1]+1 });
                myQueue.add(new int[]{temp[0]*2, temp[1]+1 });
                if(temp[0]+1 == target || temp[0]-1==target || temp[0]*2==target  ){
                    answer = temp[1]+1;
                    break;
                }
            }
        }
        System.out.println(answer);



    }
}
