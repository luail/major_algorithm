package A7이분탐색;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A701BinaryBasic2 {
    public static void main(String[] args) {
//        target이 arr에 있다면 index값 return
//        target이 arr에 없다면 있어야 할 자리의 index를 return
        int[] arr = {1,3,5,7,9,11,13,15,17,19};
        int target = 2;
        
        int answer = -1;
        
        int start = 0;
        int end = arr.length-1;
        
        while (start <= end) {
            int middle = (start+end)/2;

            if (arr[middle] == target) {
                answer = middle;
                break;
            } else if (arr[middle] > target) {
                end = middle -1;
                answer=middle;
            } else {
                start = middle+1;
            }
        }
//        System.out.println(answer);

//        System.out.println(Arrays.binarySearch(arr,0));
//        System.out.println(Arrays.binarySearch(arr,2));
//        System.out.println(Arrays.binarySearch(arr,20));

//        만약 값이 없다면 binarySearch를 했을 경우 음수가 튀어 나온다.
//        이럴 때 나온 값에 절댓값을 씌운 뒤 -1을 하면 원래 있어야 할 자리로 나온다.
        int answer2 = Arrays.binarySearch(arr,30);

        if (answer2 < 0) {
            System.out.println(Math.abs(answer2)-1);
        } else {
            System.out.println(answer2);
        }
    }
}
