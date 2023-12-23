package easy;

public class DesignHashMap {
    class MyHashMap {
        boolean[] keys;
        int[] values;

        int capacity = 0;

        public MyHashMap() {
            keys = new boolean[10];
            values = new int[capacity];
        }

        public void put(int key, int value) {
            if(key < capacity){
                keys[key] = true;
                values[key] = value;
            } else {
                int capTemp = 10;
                while(capTemp < key )
                {
                    capTemp += capTemp;
                }
                boolean[] keysTemp  = new boolean[capTemp];
                int[] valuesTemp  = new int[capTemp];
                for (int i = 0; i < capacity; i++) {
                    keysTemp[i] = keys[i];
                    valuesTemp[i] = values[i];
                }

                capacity = capTemp;
                keys = keysTemp;
                values = valuesTemp;

                keys[key] = true;
                values[key] = value;
            }
        }

        public int get(int key) {
           return keys[key] ? values[key] : -1;
        }

        public void remove(int key) {
            keys[key] = false;
        }
    }
}
