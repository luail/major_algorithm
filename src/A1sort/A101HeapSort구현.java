package A1sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class A101HeapSort구현 {
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1,6};
        //        최초힙구성 : n*log(n)
        for(int i=arr.length/2-1; i>=0; i--){
            heapify(arr, i, arr.length);
        }
        //      루트노드와 최하위 노드를 change하면서 heapify
        //      최하위 노드는 change 될 때마다 자리수가 -1
        for(int i=arr.length-1; i>=0; i--){
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));//     최소힙

//        pq를 통한 정렬방법
        int[] newArr = new int[arr.length];
//        pq를 쓰는 상황은 값이 중간중간에 add or poll 될때.
        Queue<Integer> pq = new PriorityQueue<>();
        for (int a : arr) {
            pq.add(a);
        }
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = pq.poll();
        }

    }
    static void heapify(int[] arr, int parent, int len){
        int left = parent*2+1;
        int right = parent*2+2;
//        check1 : 왼쪽, 오른쪽 노드가 배열의 길이보다 짧아야함
//        check2 : left, right 둘 중에 parent의 값보다 작은 값이 있을경우 자리 change 후 heapify 재귀호출.
        if(left >= len)return;
        if(right >= len){
//            left만 존재
            if(arr[parent] < arr[left]){
                int temp = arr[parent];
                arr[parent] = arr[left];
                arr[left] = temp;
                heapify(arr, left, len);
            }
        }else {
//            left, right 둘다 존재
            int index = 0;
            if(arr[parent] < arr[left] || arr[parent] < arr[right]){
                if(arr[left]< arr[right]){
                    index = right;
                }else {
                    index = left;
                }
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                heapify(arr, index, len);
            }
        }
    }
}
