package medium;

import utility.IParser;
import utility.LeetcodeArgsParser;
import utility.LeetcodeInputIterator;
import utility.LeetcodeMethodsCallStackInputParser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SnapshotArrayTest {
    public static void main(String[] args) {
        new Test().test();
    }


    private static class Test {
        public void test() {
            LeetcodeInputIterator methodItr = new LeetcodeInputIterator(new LeetcodeMethodsCallStackInputParser(","),"[\"SnapshotArray\",\"set\",\"snap\",\"set\",\"snap\",\"get\",\"get\",\"set\",\"get\",\"set\"]");
            LeetcodeInputIterator inputItr = new LeetcodeInputIterator(new LeetcodeArgsParser(),"[[2],[0,4],[],[1,13],[],[1,1],[1,0],[1,3],[1,0],[0,5]]");

            SnapshotArray snapshotArr=null;


            Iterator<String> methodIterator = methodItr;
            Iterator<String> inputIterator = inputItr;
            int y = -1;
            while (methodIterator.hasNext()) {
                y++;

                String methodName = methodIterator.next();
                String val = inputIterator.next();


                switch (methodName) {
                    case "SnapshotArray": {
                        System.out.println(y + " constr");
                        snapshotArr = new SnapshotArray(2);
                        break;
                    }
                    case "snap": {
                        snapshotArr.snap();
                        break;
                    }
                    case "set": {
                        String[] split = val.split(",");
                        int val1 = Integer.valueOf(split[0]);
                        int val2 = Integer.valueOf(split[1]);
                        snapshotArr.set(val1, val2);
                        break;
                    }
                    case "get": {
                        String[] split = val.split(",");
                        int val1 = Integer.valueOf(split[0]);
                        int val2 = Integer.valueOf(split[1]);
                        snapshotArr.get(val1, val2);
                        break;
                    }
                }
            }
            System.out.println();

//            SnapshotArray snapshotArr= new SnapshotArray(1);;
//            snapshotArr.get(0, 0);
//            snapshotArr.set(0, 1);
//            int rez = snapshotArr.snap();
//            rez = snapshotArr.snap();
//            rez = snapshotArr.snap();
//            snapshotArr.set(0, 2);
//            snapshotArr.get(0, 0);
//            snapshotArr.get(0, 1);
//            snapshotArr.get(0, 2);
//            snapshotArr.snap();
//            snapshotArr.set(0, 4);
        }


        class SnapshotArray {
            class SnapVal {
                int val;
                int snapId;

                public SnapVal(int val, int snapId) {
                    this.val = val;
                    this.snapId = snapId;
                }
            }

            int snapSerialCtr;
            SnapVal[] array;
            Map<Integer, TreeMap<Integer, Integer>> cache;

            public SnapshotArray(int length) {
                array = new SnapVal[length];
                cache = new HashMap<>();
                for (int i = 0; i < length; i++) {
                    array[i] = new SnapVal(0, 0);
                }
            }

            public void set(int index, int val) {

                if(array[index].snapId != snapSerialCtr){
                    cache.computeIfAbsent(index, k->new TreeMap<>()).put(snapSerialCtr-1, array[index].val);
                }

                array[index] = new SnapVal(val, snapSerialCtr);
            }

            public int snap() {
                return snapSerialCtr++;
            }

            public int get(int index, int snap_id) {
                if(!cache.containsKey(index) || snap_id > cache.get(index).lastKey()){
                    return array[index].val;
                }

                if (cache.get(index).containsKey(snap_id)) {
                    return cache.get(index).get(snap_id);
                } else {
                    int ceilingKey = cache.get(index).ceilingKey(snap_id);
                    return cache.get(index).get(ceilingKey);
                }
            }
        }
    }
}
