package medium;

import java.util.*;

public class DesignAFileSharingSystem {
    public static void main(String[] args) {
        FileSharing fileSharing = new FileSharing(4); // We use the system to share a file of 4 chunks.

        fileSharing.join(List.of(1, 2));    // A user who has chunks [1,2] joined the system, assign id = 1 to them and return 1.

        fileSharing.join(List.of(2, 3));    // A user who has chunks [2,3] joined the system, assign id = 2 to them and return 2.

        fileSharing.join(List.of(4));       // A user who has chunk [4] joined the system, assign id = 3 to them and return 3.

        fileSharing.request(1, 3);   // The user with id = 1 requested the third file chunk, as only the user with id = 2 has the file, return [2] . Notice that user 1 now has chunks [1,2,3].

        fileSharing.request(2, 2);   // The user with id = 2 requested the second file chunk, users with ids [1,2] have this chunk, thus we return [1,2].

        fileSharing.leave(1);        // The user with id = 1 left the system, all the file chunks with them are no longer available for other users.

        fileSharing.request(2, 1);   // The user with id = 2 requested the first file chunk, no one in the system has this chunk, we return empty list [].

        fileSharing.leave(2);        // The user with id = 2 left the system.

        fileSharing.join(List.of());        // A user who doesn't have any chunks joined the system, assign id = 1 to them and return 1. Notice that ids 1 and 2 are free and we can reuse them.
    }

    static
    class FileSharing {

        class AssignIdHelper{
            int lastUsed;
            PriorityQueue<Integer> pq;

            public AssignIdHelper() {
                this.lastUsed = 0;
                this.pq = new PriorityQueue<>();
            }

            int getNextId(){
                int nextId;
                if(pq.isEmpty())
                {
                    nextId = ++lastUsed;
                } else {
                    nextId = pq.poll();
                }

                return nextId;
            }
        }

        AssignIdHelper assignIdHelper;
        PriorityQueue<Integer>[] chucks;
        Map<Integer, List<Integer>> userOwnChunks;

        public FileSharing(int m) {
            assignIdHelper = new AssignIdHelper();
            chucks = new PriorityQueue[m+1];
            userOwnChunks = new HashMap<>();
        }

        public int join(List<Integer> ownedChunks) {
            int userId = assignIdHelper.getNextId();
            userOwnChunks.computeIfAbsent(userId, k->new ArrayList<>());
            if(ownedChunks.isEmpty()) {
                return userId;
            }

            ownedChunks.forEach(item->{
                if(chucks[item] == null){
                    chucks[item] = new PriorityQueue<>();
                }
                chucks[item].offer(userId);
                userOwnChunks.get(userId).add(item);
            });

            return userId;
        }

        public void leave(int userID) {
            List<Integer> usersChunks = userOwnChunks.get(userID);
            for (Integer chunk : usersChunks) {
                chucks[chunk].remove(Integer.valueOf(userID));
                if(chucks[chunk].isEmpty()){
                    chucks[chunk] = null;
                }
            }

            assignIdHelper.pq.offer(userID);
            userOwnChunks.remove(userID);
        }

        public List<Integer> request(int userID, int chunkID) {
            List<Integer> output = new ArrayList<>();

            if(chucks[chunkID]==null){
                return output;
            }

            if(!userOwnChunks.get(userID).contains(chunkID)){
                userOwnChunks.get(userID).add(chunkID);
            }

            PriorityQueue<Integer> chunkPQ = chucks[chunkID];
            while (!chunkPQ.isEmpty()){
                output.add(chunkPQ.poll());
            }

            PriorityQueue<Integer> temp = new PriorityQueue<>();
            for (Integer item : output) {
                temp.offer(item);
            }

            if(!temp.contains(userID)){
                temp.offer(userID);
            }

            chucks[chunkID] = temp;

            return output;
        }
    }
}
