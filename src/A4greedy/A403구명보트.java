package A4greedy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class A403구명보트 {
    public static void main(String[] args) {
        int[] people = {70,50,80,50};
        int limit = 100;
        int answer = 0;

        Arrays.sort(people);

        Deque<Integer> deque = new LinkedList<>();
        for (int i :  people) {
            deque.addLast(i);
        }

        while (!deque.isEmpty()) {
            if (deque.peekLast() + deque.peekFirst() <= limit) {
                deque.pollLast();
                deque.pollFirst();
                answer++;
            } else {
                deque.pollLast();
                answer++;
            }
        }
        System.out.println(answer);
    }
}
