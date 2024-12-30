package A7이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A703과자나눠주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs1 = br.readLine().split(" ");
        int bros = Integer.parseInt(inputs1[0]);
        int snacks = Integer.parseInt(inputs1[1]);

        String[] inputs2 = br.readLine().split(" ");
        int[] snackLength = new int[inputs2.length];

        for (int i = 0; i < snacks; i++) {
            int a = Integer.parseInt(inputs2[i]);
            snackLength[i] = a;
        }

        Arrays.sort(snackLength);

        int start = 1;
        int end = snackLength[snackLength.length-1];
        int maxLength = 0;

//        과자의 길이가 대상이 되어야 한다.

        while (start <= end) {
            int count = 0;
            int mid = (start+end)/2;

            for (int i = 0; i < snackLength.length; i++) {
                count += snackLength[i]/mid;
            }

//            만약 같거나 크다가 아닌 같다라고만 조건을 설정할 경우
//            실제 최대값임에도 불구하고 count가 bros보다 더 많을 경우
//            제대로 값이 안담기게 된다 !!
            if (count >= bros) {
                start = mid +1;
                maxLength = mid;
            } else  {
                end = mid - 1;
            }
        }

        System.out.println(maxLength);
    }
}
