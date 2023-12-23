package easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        ImplementQueueUsingStacks.MyQueue myQueue = new ImplementQueueUsingStacks.MyQueue();
    }


private static class MyQueue{
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue()
    {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.add(x);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }

        int rez = stack2.pop();

        while(!stack2.isEmpty()){
            stack1.add(stack2.pop());
        }

        return rez;
    }

    public int peek() {
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }

        int rez = stack2.peek();

        while(!stack2.isEmpty()){
            stack1.add(stack2.pop());
        }

        return rez;
    }

    public boolean empty() {
        return stack1.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
