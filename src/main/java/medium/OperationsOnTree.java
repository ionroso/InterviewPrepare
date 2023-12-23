package medium;

import utility.IParser;
import utility.LeetcodeArgsParser;
import utility.LeetcodeInputIterator;
import utility.LeetcodeMethodsCallStackInputParser;

import java.util.*;

public class OperationsOnTree {
    public static void main(String[] args) {
        new Test().test();
    }
    
    private static class Test {
        public void test() {

            String methods = "[[\"LockingTree\",\"upgrade\",\"upgrade\",\"upgrade\",\"upgrade\",\"lock\",\"upgrade\",\"lock\",\"upgrade\",\"lock\",\"lock\",\"lock\",\"upgrade\",\"upgrade\",\"upgrade\",\"upgrade\",\"lock\",\"upgrade\",\"lock\",\"upgrade\",\"unlock\"]]";
            String input = "[[],[8,39],[5,28],[6,33],[9,24],[5,22],[1,3],[5,20],[0,38],[5,14],[6,34],[6,28],[3,23],[4,45],[8,7],[2,18],[3,35],[2,16],[3,21],[1,41],[5,22]]";

            LeetcodeInputIterator methodItr = new LeetcodeInputIterator(new LeetcodeMethodsCallStackInputParser(","), methods);
            LeetcodeInputIterator inputItr = new LeetcodeInputIterator(new LeetcodeArgsParser(), input);


            LockingTree lt = new LockingTree(new int[]{-1,0,8,0,7,4,2,3,3,1});

            Iterator<String> methodIterator = methodItr;
            Iterator<String> inputIterator = inputItr;
            int y = -1;
            while (methodIterator.hasNext()) {
                y++;

                String methodName = methodIterator.next();
                String val = inputIterator.next();
                System.out.print(y + " ");

                switch (methodName) {

                    case "LockingTree": {
                        System.out.println(y + " constr");
                        break;
                    }

                    case "lock": {
                        String[] split = val.split(",");
                        System.out.print(lt.lock(Integer.valueOf(split[0]), Integer.valueOf(split[1])));
                        break;
                    }
                    case "unlock": {
                        String[] split = val.split(",");
                        System.out.print(lt.unlock(Integer.valueOf(split[0]), Integer.valueOf(split[1])));
                        break;
                    }
                    case "upgrade": {
                        String[] split = val.split(",");
                        System.out.print(lt.upgrade(Integer.valueOf(split[0]), Integer.valueOf(split[1])));
                        break;
                    }
                }

                System.out.println();
            }

//            LockingTree lockingTree = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
//            System.out.println(lockingTree.lock(2, 2));    // return true because node 2 is unlocked.
//            // Node 2 will now be locked by user 2.
//            System.out.println(lockingTree.unlock(2, 3));  // return false because user 3 cannot unlock a node locked by user 2.
//            System.out.println(lockingTree.unlock(2, 2));  // return true because node 2 was previously locked by user 2.
//            // Node 2 will now be unlocked.
//            System.out.println(lockingTree.lock(4, 5));    // return true because node 4 is unlocked.
//            // Node 4 will now be locked by user 5.
//            System.out.println(lockingTree.upgrade(0, 1)); // return true because node 0 is unlocked and has at least one locked descendant (node 4).
//            // Node 0 will now be locked by user 1 and node 4 will now be unlocked.
//            System.out.println(lockingTree.lock(0, 1));    // return false because node 0 is already locked.
        }

        private class LockingTree {
            int[] parent;
            
            Map<Integer, List<Integer>> children;
            
            int[] locked;
            public LockingTree(int[] parent) {
                this.parent = parent;
                this.children = new HashMap<>();

                for (int i = 1; i < parent.length; i++) {
                    children.computeIfAbsent(parent[i], k->new ArrayList<>()).add(i);
                }

                this.locked = new int[parent.length];
            }

            public boolean lock(int num, int user) {
                if (isLocked(num)) {
                    return false;
                }

                locked[num] = user;
                return true;
            }

            private boolean isLocked(int num) {
                return !(locked[num] == 0);
            }

            private boolean isLockedByMe(int num, int user) {
                return locked[num] == user;
            }

            public boolean unlock(int num, int user) {
                if(!isLocked(num)) {
                    return false;
                }

                if(!isLockedByMe(num, user)) {
                    return false;
                }

                locked[num] = 0;

                return true;
            }

            public boolean upgrade(int num, int user) {
                if(isLocked(num)) {
                    return false;
                }

                if(!hasAtLeastOneLockedDescendant(num) || hasAnyLockedAncestors(num)) {
                    return false;
                }


                unlockDDescendants(num);

                lock(num, user);

                return true;
            }

            private void unlockDDescendants(int num) {
                Stack<Integer> stack = new Stack<>();
                stack.add(num);
                while (!stack.isEmpty()){
                    int parent = stack.pop();
                    locked[parent] = 0;
                    List<Integer> children = this.children.getOrDefault(parent, new ArrayList<>());
                    for (Integer child : children) {
                        stack.add(child);
                    }
                }
            }

            private boolean hasAnyLockedAncestors(int num) {
                while (num !=-1 ){
                    if(isLocked(num)) {
                        return true;
                    }

                    num = parent[num];
                }
                return false;
            }

            private boolean hasAtLeastOneLockedDescendant(int num) {
                Stack<Integer> stack = new Stack<>();
                stack.add(num);
                while (!stack.isEmpty()){
                    int parent = stack.pop();
                    List<Integer> children = this.children.getOrDefault(parent, new ArrayList<>());
                    for (Integer child : children) {
                        if(isLocked(child)){
                            return true;
                        }

                        stack.add(child);
                    }
                }

                return false;
            }
        }
    }
}
