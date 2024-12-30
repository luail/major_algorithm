package A7이분탐색;

public class A701BinaryBasic1 {
    public static void main(String[] args) {
        
//        이분탐색은 사전에 데이터가 오름차순 정렬이 되어 있어야 가능한 알고리즘.
//        복잡도는 log n.
        int[] arr = {1,3,5,7,9,11,13,15,17,19};
        int target = 17;
        
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
            } else {
                start = middle+1;
            }
        }

        System.out.println(answer);
    }
}
