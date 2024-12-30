package A7이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1920번
public class A702수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs1 = br.readLine().split(" ");
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(inputs1[i]);
            a[i] = temp;
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        String[] inputs2 = br.readLine().split(" ");
        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(inputs2[i]);
            b[i] = temp;
        }

        for (int i = 0; i < b.length; i++) {
            int target = b[i];

            int start = 0;
            int end = a.length-1;

            while (true) {

                if (start > end) {
                    System.out.println(0);
                    break;
                }

                int mid = (start+end)/2;

                if (a[mid] == target) {
                    System.out.println(1);
                    break;
                }

                if (a[mid] > target) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }
    }
}
