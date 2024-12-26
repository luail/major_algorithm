package A5DP;

import java.util.Arrays;

public class A501DpBasic {
    public static void main(String[] args) {
//        1,4,5로 13을 만들 수 있는 조합중에 가장 작은 조합의 개수
//        greedy로 풀 경우 : 5개(5*2 + 1*3)
//        dfs,bfs로 풀 경우 일반적으로 시간초과 나도록 설계.

//        dp로 풀 경우 : 3개(4*2 + 5*1)
//        Min(f(n-1), f(n-2) ...) + 1
        int target = 3;
        int[] numbers = {1,4,5};
        int[] dp = new int[target+1];

        dp[1] = 1;

        for (int i = 2; i < 14; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < numbers.length; j++) {
                if (i - numbers[j] > -1) {
                    min = Math.min(min,dp[i-numbers[j]]);
                }
            }
            dp[i] = min+1;
        }
        System.out.println(Arrays.toString(dp));
    }
}
