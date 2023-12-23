package easy;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Logger {
    public static final int TimeRange = 10;
    Queue<Message> queue;
    Map<String, Integer> map;

    public Logger() {
        queue = new ArrayDeque<>();
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            queue.offer(new Message(timestamp, message));
            map.put(message,timestamp+TimeRange);
            //cleanUp(timestamp);
            return true;
        }

        Integer nextTime = map.get(message);
        if(timestamp < nextTime){
            return false;
        }

        nextTime = timestamp + TimeRange;
        map.put(message,nextTime);
        queue.offer(new Message(nextTime, message));

        //cleanUp(timestamp);

        return true;
    }

    private void cleanUp(int timestamp){
        Message peek = queue.peek();
        while (!queue.isEmpty() && peek.time < timestamp-10)
        {
            peek = queue.poll();
            Integer valFromMap = map.get(peek.message);
            if(valFromMap!=null && valFromMap < timestamp - 10)
            {
                map.remove(peek.message);
            }
        }
    }

    private class Message {
        public int time;
        public String message;

        public Message(int time, String message) {
            this.time = time;
            this.message = message;
        }
    }

    public static void main(String[] args) {
        Logger obj = new Logger();
        System.out.println(obj.shouldPrintMessage(6,"A0"));
        System.out.println(obj.shouldPrintMessage(30,"A0"));
        System.out.println(obj.shouldPrintMessage(33,"A0"));
    }
}