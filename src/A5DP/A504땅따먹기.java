package A5DP;

import java.util.Arrays;

public class A504땅따먹기 {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int max = 0;
                for (int k = 0; k < land[0].length; k++) {
                    if (j == k) {
                        continue;
                    }
                    int tempMax = land[i][j] + land[i-1][k];
                    if (max < tempMax) {
                        max = tempMax;
                    }
                }
                land[i][j] = max;
            }
        }
        answer = Arrays.stream(land[land.length-1]).max().getAsInt();
        System.out.println(answer);
    }
}
