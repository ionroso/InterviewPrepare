package easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {

    }


    class MyStack {
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();

        public MyStack() {
        }

        public void push(int x) {
            queue1.offer(x);
        }

        public int pop() {
            int output=-1;
            while (!queue1.isEmpty()){
                output = queue1.poll();
                if(queue1.size()!=0){
                    queue2.offer(output);
                }
            }

            while (!queue2.isEmpty()){
                    queue1.offer(queue2.poll());
            }

            return output;
        }

        public int top() {
            int output=-1;
            while (!queue1.isEmpty()){
                output = queue1.poll();
                queue2.offer(output);
            }

            while (!queue2.isEmpty()){
                queue1.offer(queue2.poll());
            }

            return output;
        }

        public boolean empty() {
            return queue1.size() == 0;
        }

        public void moveData(Queue<Integer> q1, Queue<Integer> q2)
        {

        }
    }

}
