package medium;

public class DesignCircularQueue {
    public static void main(String[] args) {

    }

    static
    class MyCircularQueue {

        int capacity;
        int currSize;
        int[] queue;

        int front, rear;

        public MyCircularQueue(int k) {
            queue = new int[k];
        }

        public boolean enQueue(int value) {
            if(isFull()){
                return false;
            }

            if(rear == capacity-1){
                rear = 0;
            } else {
                rear++;
            }

            queue[rear] = value;

            return true;
        }

        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }

            if(front == capacity-1){
                front = 0;
            } else {
                front++;
            }

            return true;
        }

        public int Front() {
            return queue[front];
        }

        public int Rear() {
            return queue[rear];
        }

        public boolean isEmpty() {
            return currSize == 0;
        }

        public boolean isFull() {
            return  currSize == capacity;
        }
    }
}
