package A1sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class A102명예의전당 {
    public static void main(String[] args) {
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        int[] answer = new int[score.length];
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            if (pq.size() == k){
                if (pq.peek() < score[i]) {
                    pq.poll();
                    pq.add(score[i]);
                    answer[i] = pq.peek();
                } else if (pq.peek() >= score[i]) {
                    answer[i] = pq.peek();
                }
            } else if (pq.size() < k) {
                pq.add(score[i]);
                answer[i] = pq.peek();
            }
        }
    }
}
