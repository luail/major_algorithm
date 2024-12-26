package A4greedy;

import java.util.Arrays;

public class A402체육복 {
    public static void main(String[] args) {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        int answer = 0;
        int[] arr = new int[n+1];
        Arrays.fill(arr,1);
        arr[0] = -1;

        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]]++;
        }

        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]]--;
        }

        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i] == 2) {
                if (arr[i-1] == 0) {
                    arr[i-1]++;
                    arr[i]--;
                } else if (arr[i+1] == 0) {
                    arr[i+1]++;
                    arr[i]--;
                }
            }
        }

        if (arr[arr.length-1] == 2 && arr[arr.length-2] == 0) {
            arr[arr.length-1]--;
            arr[arr.length-2]++;
        }

        for (int i = 0; i < arr.length; i++ ) {
            if (arr[i] >= 1) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
