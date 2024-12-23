package A1sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class A103야근지수 {
    public static void main(String[] args) {
        int n = 4;
        int[] works = {4,3,3};
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i : works) {
            pq.add(i);
        }

        for (int i = 0; i < n; i++) {
            int a = pq.poll();
            pq.add(a-1);
        }

        long answer = 0;

        if (pq.peek() <= 0) {
            System.out.println(0);
        } else {
            while (!pq.isEmpty()) {
                int a = pq.poll();
                answer += a*a;
            }
            System.out.println(answer);
        }
    }
}
