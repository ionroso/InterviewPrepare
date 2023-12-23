package medium;

import java.util.HashSet;
import java.util.Set;

public class DesignPhoneDirectory {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory(3);
        System.out.println(phoneDirectory.get());
        System.out.println(phoneDirectory.get());
        System.out.println(phoneDirectory.check(2));
        System.out.println(phoneDirectory.get());
        System.out.println(phoneDirectory.check(2));
        phoneDirectory.release(2);
        System.out.println(phoneDirectory.check(2));
    }


    static
    class PhoneDirectory {

        int maxNumbers;
        int[] notFree;

        int nextToUse;
        int currCount;

        public PhoneDirectory(int maxNumbers) {
            this.maxNumbers = maxNumbers;
            this.notFree = new int[maxNumbers];
            this.nextToUse = 0;
        }

        public int get() {
            if(isFull()){
                return -1;
            }

            int output = nextToUse;
            notFree[nextToUse] = -1;

            currCount++;
            setNextToUse();


            return output;
        }

        private void setNextToUse() {
            if(isFull()){
                return;
            }

            for (int i = nextToUse; i < maxNumbers ; i++) {
                if(check(i)){
                    nextToUse = i;
                    return;
                }
            }
            for (int i = 0; i < nextToUse ; i++) {
                if(check(i)){
                    nextToUse = i;
                    return;
                }
            }
        }

        public boolean check(int number) {
            return notFree[number] == 0;
        }

        public void release(int number) {
            if(check(number)){
                return;
            }
            notFree[number] = 0;
            currCount--;
            setNextToUse();
        }

        private boolean isFull() {
            return currCount == maxNumbers;
        }
    }


    class PhoneDirectory1 {

        int maxNumbers;
        Set<Integer> notFree;

        public PhoneDirectory1(int maxNumbers) {
            this.maxNumbers = maxNumbers;
            this.notFree = new HashSet<>();
        }

        public int get() {
            for (int i = 0; i < maxNumbers; i++) {
                if(!check(i)){
                    notFree.add(i);
                    return i;
                }
            }

            return -1;
        }

        public boolean check(int number) {
            return notFree.contains(number);
        }

        public void release(int number) {
            notFree.remove(number);
        }
    }

}
