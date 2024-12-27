package A6투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A601TwoPointerBasic {
    public static void main(String[] args) {
//        아래 배열에서 target이 될 수 있는 두 수의 조합을 모두 찾아내라
//        배열에 중복된 수는 없다고 가정.
        int[] nums = {7,8,9,2,4,5,1,3,6};
        int target = 10;

        List<int[]> myList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
//                    myList.add(new int[]{nums[i],nums[j]});
                }
            }
        }

//        for (int[] i : myList) {
//            System.out.println(Arrays.toString(i));
//        }

//        투포인터를 활용한 조합찾기.
        Arrays.sort(nums); // n*log(n)
//        System.out.println(Arrays.toString(nums));
        int start = 0;
        int end = nums.length-1;
        while (start<end) {
            int targetNum = 10;

            if (nums[start] + nums[end] > targetNum ) {
                end--;
            } else if (nums[start] + nums[end] < targetNum) {
                start++;
            } else {
                myList.add(new int[]{nums[start],nums[end]});
                start++;
            }
        }

        for (int[] i : myList) {
            System.out.println(Arrays.toString(i));
        }
    }
}
