package medium;

public class DesignMemoryAllocator {
    public static void main(String[] args) {
        /*
        Allocator loc = new Allocator(10); // Initialize a memory array of size 10. All memory units are initially free.
        loc.allocate(1, 1); // The leftmost block's first index is 0. The memory array becomes [1,_,_,_,_,_,_,_,_,_]. We return 0.
        loc.allocate(1, 2); // The leftmost block's first index is 1. The memory array becomes [1,2,_,_,_,_,_,_,_,_]. We return 1.
        loc.allocate(1, 3); // The leftmost block's first index is 2. The memory array becomes [1,2,3,_,_,_,_,_,_,_]. We return 2.
        loc.free(2); // Free all memory units with mID 2. The memory array becomes [1,_, 3,_,_,_,_,_,_,_]. We return 1 since there is only 1 unit with mID 2.
        loc.allocate(3, 4); // The leftmost block's first index is 3. The memory array becomes [1,_,3,4,4,4,_,_,_,_]. We return 3.
        loc.allocate(1, 1); // The leftmost block's first index is 1. The memory array becomes [1,1,3,4,4,4,_,_,_,_]. We return 1.
        loc.allocate(1, 1); // The leftmost block's first index is 6. The memory array becomes [1,1,3,4,4,4,1,_,_,_]. We return 6.
        loc.free(1); // Free all memory units with mID 1. The memory array becomes [_,_,3,4,4,4,_,_,_,_]. We return 3 since there are 3 units with mID 1.
        loc.allocate(10, 2); // We can not find any free block with 10 consecutive free memory units, so we return -1.
        loc.free(7); // Free all memory units with mID 7. The memory array remains the same since there is no memory unit with mID 7. We return 0.
        */

        Allocator loc = new Allocator(3);
        loc.allocate(3, 1);
        loc.allocate(5, 2);
        System.out.println(loc.free(1));
        System.out.println(loc.free(3));
    }

    static
    class Allocator {
        int n;
        int[] memory;

        public Allocator(int n) {
            this.n = n;
            this.memory = new int[n];
        }

        public int allocate(int size, int mID) {
            int i=0;
            while (i<n){
                if(memory[i]==0){
                    int bufferSize = hasEnoughSpace(i, size);
                    if(bufferSize==size){
                        setMID(i, size, mID);

                        return i;
                    }
                    i+=bufferSize-1;
                }
                i++;
            }

            return -1;
        }

        private void setMID(int i, int size, int mID) {
            int j=i;
            while (j<n && j-i<=size-1){
                memory[j] = mID;
                j++;
            }
        }

        private int hasEnoughSpace(int i, int size) {
            int buffSize = 0;
            int j=i;
            while (j<n && j-i<=size-1 && memory[j] == 0){
                j++;
            }

            return  j-i;
        }

        public int free(int mID) {
            int nrBlocks = 0;
            for (int i = 0; i < n; i++) {
                if(memory[i]==mID){
                    memory[i] = 0;
                    nrBlocks++;
                }
            }

            return nrBlocks;
        }
    }
}
