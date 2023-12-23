import java.util.*;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
//        System.out.println(containsNearbyDuplicate(new int[]{1,1,1,1}, 3));
//        System.out.println(removeDuplicates("aaaaaaaa"));

//        int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
//        System.out.println(boxTypes[0][0]);
//        System.out.println(boxTypes[0][1]);
//        int truckSize = 10;
//        System.out.println(maximumUnits(boxTypes,truckSize));

        System.out.println(convertTime("11:00", "11:01"));


    }

    public static int convertTime(String current, String correct) {
        int[] opMin = new int[]{1, 5, 15, 60};
        int t1 = stringTimeToInt(current);
        int t2 = stringTimeToInt(correct);

        int currTime = t1;
        int opCount = 0;
        int i=opMin.length-1;
        while (i>=0 && currTime<=t2)
        {
            int times = (t2-currTime)/opMin[i];
            if(times > 0)
            {
                opCount+=times;
                currTime += times*opMin[i];
            }
            i--;
        }

        return opCount;
    }

    private static int stringTimeToInt(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        bubbleSort2(boxTypes);
        int n = boxTypes.length;
        int currSize=0, currUnits=0, i=0;
        while (i < n && currSize <= truckSize){
            int currBoxSize = boxSize(boxTypes, i);
            int j = currBoxSize;
            if(currSize + currBoxSize > truckSize){
               j = truckSize - currSize;
            }

            currSize+=j;
            currUnits+=(j * boxUnits(boxTypes, i));

            i++;
        }

        return currUnits;
    }

    public static int boxSize(int[][] boxTypes, int idx)
    {
        return boxTypes[idx][0];
    }

    public static int boxUnits(int[][] boxTypes, int idx)
    {
        return boxTypes[idx][1];
    }

    public static void bubbleSort2(int[][] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (arr[j][1] < arr[j+1][1])
                {
                    int temp = arr[j][1];
                    arr[j][1] = arr[j+1][1];
                    arr[j+1][1] = temp;

                    temp = arr[j][0];
                    arr[j][0] = arr[j+1][0];
                    arr[j+1][0] = temp;
                }
            }
        }
    }

    public boolean canPermutePalindrome(String s) {
        Set<Character> counts = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!counts.contains(c)){
                counts.add(c);
            } else {
                counts.remove(c);
            }
        }

        return counts.size() == 1 || counts.isEmpty();
    }

    static public int singleNumber(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(!counts.containsKey(nums[i])){
                counts.put(nums[i],i);
            } else {
                counts.remove(nums[i]);
            }
        }

        return counts.entrySet().iterator().next().getValue();
    }


    //Concatenation of Array
//    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6};
//
//        int n = nums.length;
//        int[] ans = new int[2*n];
//
//        for (int i = 0; i < n; i++) {
//            ans[i] = nums[i];
//            ans[i+n] = nums[i];
//        }
//        System.out.println();
//        for (int i = 0; i < 2*n; i++) {
//            System.out.print(ans[i]);
//        }
//    }
//Shuffle the Array
//    public static void main(String[] args) {
//        int[] nums = {1,3,5,2,4,6};
//        int n = nums.length;
//        int half = n/2;
//        int[] ans = new int[n];
//
//        int j = 0;
//        for (int i = 0; i < half; i++) {
//            ans[j++] = nums[i];
//            ans[j++] = nums[i+half];
//        }
//
//        System.out.println();
//        for (int i = 0; i < n; i++) {
//            System.out.print(ans[i]);
//        }
//    }

    //Number of Good Pairs
//    public static void main(String[] args) {
//        int[] nums = {1,1,1};
//        Map<Integer, Integer> freq = new HashMap<>();
//        for (int num : nums) {
//            if(!freq.containsKey(num))
//            {
//                freq.put(num, 1);
//                continue;
//            }
//
//            freq.put(num,freq.get(num)+1);
//        }
//
//        int count = 0;
//        for (int f : freq.values()) {
//            if(f>=2) {
//                count += num_good_pairs(f);
//            }
//        }
//        System.out.println(count);
//    }
//
    //Richest Customer Wealth
//    public static void main(String[] args) {
//        int[][] accounts = {{1, 1, 1},{2,2,2}};
//
//        int max = -1;
//        for (int[] account : accounts) {
//            max = Math.max(max, IntStream.of(account).sum());
//        }
//
//        System.out.println(max);
//    }

//Running Sum of 1d Array
//    public static void main(String[] args) {
//        // [1,2,3,4]
//        int[] nums = {1,2,3,4};
//        int[] output = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++ ) {
//            if(i==0)
//            {
//               output[0] = nums[0];
//               continue;
//            }
//
//            output[i] = output[i-1] + nums[i];
//        }
//
//        for (int i = 0; i < output.length; i++ ) {
//            System.out.println(output[i]);
//        }
//    }

    //1431. Kids With the Greatest Number of Candies
//    public static void main(String[] args) {
//        int[] candies = {2,3,5,1,3};
//        int extraCandies = 3;
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < candies.length; i++ ) {
//            max = Math.max(max, candies[i]);
//        }
//
//        List<Boolean> rez = new ArrayList<>();
//        for (int i = 0; i < candies.length; i++ ) {
//            rez.add(candies[i] + extraCandies >= max);
//        }
//
//        for (int i = 0; i < rez.size(); i++ ) {
//            System.out.println(rez.get(i));
//        }
//    }


//    //1281. Subtract the Product and Sum of Digits of an Integer
//    public static void main(String[] args) {
//        int[] digitAsArray = stringToIntArray(Integer.toString(234));
//        int rez = productIntArray(digitAsArray) - sumIntArray(digitAsArray);
//        System.out.println(rez);
//    }

//    //1528. Shuffle String
//    public static void main(String[] args) {
//        String s = "codeleet";
//        int[] indices = {4,5,6,7,0,2,1,3};
//        char[] shuffleChars = new char[s.length()];
//        int i = 0;
//        for (int index : indices) {
//            shuffleChars[index] = s.charAt(i++);
//        }
//
//        String rez = new String(shuffleChars);
//        System.out.println(rez);
//    }

//    public static void main(String[] args) {
//        String sentence =  "thequickbrownfoxjumpsoverthelazydog";
//        boolean[] present = new boolean[26];
//        for(int i = 0; i < sentence.length(); i++)
//        {
//            char c = sentence.charAt(i);
//            present[c-'a'] = true;
//        }
//
//        for(int i = 0; i < present.length; i++) {
//            if(!present[i])
//            {
//                return false;
//            }
//        }
//
//        return true;
//    }

//    public static void main(String[] args)
//    {
//        int[] arr = {3,2,1};
//        int n = arr.length;
//        int[] indx = bubbleSort(arr);
//
//        int[] output = new int[n];
//        for (int i = 0; i < n; i++)
//        {
//            int j=i;
//            while(j>=0 && arr[i]==arr[j])
//            {
//                j--;
//            }
//            output[indx[i]] = j+1;
//        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.println(output[i]);
//        }
//
//    }


//
//public static void main(String[] args)
//{
//    String s = "Let's take LeetCode contest";
//    Stack<String> stack = new Stack<>();
//    StringBuilder sb = new StringBuilder();
//    int i = s.length()-1;
//    while (i>=0)
//    {
//        char c = s.charAt(i);
//        if(c != ' ')
//        {
//            sb.append(c);
//        } else
//        {
//            stack.push(" " + sb.toString());
//            sb.setLength(0);
//        }
//        i--;
//   }
//   stack.push(sb.toString());
//   sb.setLength(0);
//
//   while (!stack.isEmpty())
//   {
//       sb.append(stack.pop());
//   }
//
//   System.out.printf(sb.toString());
//}

public static String RemoveOutermostParentheses()
{
    String s = "(()())(())";

    StringBuilder output = new StringBuilder();
    StringBuilder loopSB = new StringBuilder();
    int op = 0, cl = 0;
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if(c == '(')
        {
            op++;
        }
        if(c == ')')
        {
            cl++;
        }
        loopSB.append(c);
        if(op == cl)
        {
            output.append(loopSB.substring(1,loopSB.length()-1));
            loopSB.setLength(0);
        }
    }

    return output.toString();
}


    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
        }


        List<Integer> list1 = new ArrayList<>();
        for (Integer val1 : set1) {
            if(!set2.contains(val1))
            {
                list1.add(val1);
            }
        }

        List<Integer> list2 = new ArrayList<>();
        for (Integer val2 : set2) {
            if(!set1.contains(val2))
            {
                list2.add(val2);
            }
        }

        List<List<Integer>> output = new ArrayList<>();
        output.add(list1);
        output.add(list2);

        return output;
    }


//    public static void main(String[] args) {
////        String[] strs = {"ab","a"};
////        System.out.println(longestCommonPrefix(strs));
//
//        String s = "Hello World";
//        String[] split = s.split(" ");
//        System.out.println(split[split.length-1].length());
//    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();

        int j=0;
        boolean lookedAtAllWords;
        while (true)
        {
            lookedAtAllWords = true;
            for (int i = 0; i < strs.length; i++) {
                if(j < strs[i].length()) {
                    set.add(strs[i].charAt(j));
                } else {
                    lookedAtAllWords = false;
                    break;
                }
            }

            if(!lookedAtAllWords || set.size()>1)
            {
                break;
            }

            sb.append(set.iterator().next());
            j++;
            set.clear();
        }

        return sb.toString();
    }

    public static int[] diStringMatch(String s) {
        int[] perm = new int[s.length()+1];
        for (int i = 0; i < perm.length; i++) {
            perm[i] = i;
        }

        List<Integer> list = new ArrayList<>();
        perm2(s, perm, list, perm.length);

        int[] output = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            output[i++]=integer;
        }

        return output;
    }
    private static boolean perm2(String rule, int[] perm, List<Integer> output, int n) {
        if (n == 1) {
            for (int i = 0; i < rule.length(); i++) {
                    boolean valid = rule.charAt(i) == 'I' && perm[i] < perm[i + 1] || rule.charAt(i) == 'D' && perm[i] > perm[i + 1];
                    if(!valid)
                        return false;
            }

            for (int i = 0; i < perm.length; i++) {
                output.add(perm[i]);
            }
            return true;
        }

        for (int i = 0; i < n; i++) {
            swap(perm, i, n-1);
            if(perm2(rule, perm, output,n-1))
            {
                return true;
            }
            swap(perm, i, n-1);
        }

        return false;
    }

    private static void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

//    public static void main(String[] args){
//      int[] rez =  diStringMatch("IDID");
//        for (int i = 0; i < rez.length; i++) {
//            System.out.println(rez[i]);
//        }
//    }








//public static void main(String[] args)
//{
//    int n = 3;
//    int[][] image = new int[n][n];
//    image[0] = new int[]{1,1,0};
//    image[1] = new int[]{1,0,1};
//    image[2] = new int[]{0,0,0};
//
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n/2; j++) {
//            int temp = image[i][j];
//            image[i][j] = flipOneOrZero(image[i][n-j-1]);
//            image[i][n-j-1] = flipOneOrZero(temp);
//        }
//    }
//
//    if( (n/2) % 2 != 0 )
//    {
//        for (int i = 0; i < n; i++) {
//            image[i][n/2] = flipOneOrZero(image[i][n/2]);
//        }
//    }
//
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n; j++) {
//            System.out.print(image[i][j]);
//        }
//        System.out.println();
//    }
//}

public static int flipOneOrZero(int val)
{
    if(val!=0 && val != 1)
    {
        return -1;
    }

    return val == 0? 1 : 0;
}
// public static void main(String[] args)
// {
//     int[] nums = {1,2,3,4};
//
////     List<List<Integer>> concatlist = new ArrayList<>();
////     int totalCount = 0;
////     for (int i = 0; i < nums.length-1; i+=2) {
////        List<Integer> sublists = new ArrayList<>();
////        for(int j = 0; j < nums[i]; j++)
////        {
////            sublists.add(nums[i+1]);
////            totalCount++;
////        }
////        concatlist.add(sublists);
////     }
////
////     int i = 0;
////     int[] output = new int[totalCount];
////     for (List<Integer> list : concatlist) {
////         for (Integer v : list) {
////             output[i++]=v;
////         }
////     }
//
//     int totalCount = 0;
//     for (int i = 0; i < nums.length-1; i+=2) {
//         totalCount+=nums[i];
//     }
//
//     int[] output = new int[totalCount];
//
//     int y=0;
//     for (int i = 0; i < nums.length-1; i+=2) {
//        for(int j = 0; j < nums[i]; j++)
//        {
//            output[y++]=nums[i+1];
//        }
//     }
//
//     for (int j = 0; j < totalCount; j++) {
//         System.out.println(output[j]);
//     }
// }
// public static void main(String[] args)
// {
//     String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
//     String[] words = {"gin","zen","gig","msg"};
//     Set<String> unique = new HashSet<>();
//
//     for (String word : words) {
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < word.length(); i++) {
//             sb.append(morse[word.charAt(i)-'a']);
//         }
//         unique.add(sb.toString());
//     }
//
//     System.out.println(unique.size());
//
// }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            s[i] = s[s.length-i-1];
        }
    }

//
//    public static void main(String[] args)
//    {
//        int[] nums = {1,2,5,2,3};
//        int target = 2;
//        List<Integer> output = new ArrayList<>();
//
//        bubbleSort1(nums);
//
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i]==target){
//                output.add(i);
//            }
//
//            if(nums[i]>target){
//                break;
//            }
//        }
//    }




//    public static void main(String[] args) {
////        int[] arr = {1,3,3,2};
////        System.out.println(uniqueOccurrences(arr));
//
//        List<List<Integer>> pt = generate(4);
//        for (List<Integer> integers : pt) {
//            for (Integer integer : integers) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }
//    }
    public static boolean uniqueOccurrences(int[] arr) {
        bubbleSort1(arr);

        Set<Integer> set = new HashSet<>();
        int i=0, j=0, count=0;
        while (i<=arr.length-1)
        {
            j = i+1;
            count = 1;
            while (j<arr.length && arr[j] == arr[i])
            {
                j++;
                count++;
            }

            i=j;

            if(set.contains(count))
            {
                return false;
            }

            set.add(count);
        }

        return true;
    }

    public static void bubbleSort1(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> levelOne = new ArrayList<>();
        levelOne.add(1);
        triangle.add(levelOne);

        for (int i = 1; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            List<Integer> prevLevel = triangle.get(i - 1);
            int countLevel = i+1;
            for (int j = 0; j < countLevel; j++) {
                if(j == 0)
                {
                    level.add(prevLevel.get(0));
                } else if(j == countLevel-1)
                {
                    level.add(prevLevel.get(prevLevel.size()-1));
                } else {
                    level.add(prevLevel.get(j)+prevLevel.get(j-1));
                }
            }
            triangle.add(level);
        }

        return triangle;
    }

    public static int prefixCount(String[] words, String pref) {
        int n = words.length;
        int p_n = pref.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(words[i].length() >= p_n)
            {
                for (int j = 0; j < p_n; j++) {
                    if(words[i].charAt(j) != pref.charAt(j))
                    {
                        break;
                    }
                }
                count++;
            }
        }

        return count;
    }

    static class MovingAverage {
        private int size;
        private int sumSoFar = 0;
        Queue<Integer> q = new ArrayDeque<>();

        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            if(q.size()+1>size)
            {
                sumSoFar-=q.poll();
            }

            q.offer(val);
            sumSoFar+=val;

            return (double) sumSoFar/ q.size();
        }
    }

    private static int sumIntArray(int[] digitAsArray) {
        return IntStream.of(digitAsArray).sum();
    }

    static class SortedArrayOriginalIndexes
     {
         int[] sortedArray;
         int[] originalIndexes;
         public SortedArrayOriginalIndexes(int[] sortedArray, int[] originalIndexes) {
             this.sortedArray = sortedArray;
             this.originalIndexes = originalIndexes;
         }
     }




    public static String removeDuplicates(String s) {
        if(s==null || s.isEmpty() || s.length() ==1)
            return s;

        StringBuilder sb = new StringBuilder(s);

        int i = findAdjDup(sb);
        if(i==-1)
        {
            return s;
        }

        while (i!=-1)
        {
            sb = sb.deleteCharAt(i);
            sb = sb.deleteCharAt(i);
            if(i-1>=0 && i<sb.length()-1 && sb.charAt(i) == sb.charAt(i-1))
            {
                i = i-1;
            } else {
                i = findAdjDup(sb);
            }

        }

        return sb.toString();
    }

    // 1245
    public static int findAdjDup(StringBuilder sb)
    {
        int i=0;
        while(i<sb.length()-2 && sb.charAt(i) != sb.charAt(i+1))
        {
            i++;
        }

        return (i+1 < sb.length() && sb.charAt(i) == sb.charAt(i+1)) ? i : -1;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i], i);
            }else{
                int diff = (i-map.get(nums[i]));
                if(diff <= k){
                    return true;
                }
                map.remove(nums[i]);
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            addIndexToMap(map,nums[i],i);
        }

        for (List<Integer> indexes : map.values()) {
            boolean flag = diffLessThanK(indexes, k,0, indexes.size()-1);
            if(flag){
                return true;
            }
        }


        return false;
    }

    public static boolean diffLessThanK(List<Integer> indexes, int k, int l, int h)
    {
        if(l>=h){
            return false;
        }

        if(indexes.get(h)-indexes.get(l) <= k)
        {
            return true;
        }

        return diffLessThanK(indexes, k, l+1, h)
                || diffLessThanK(indexes, k, l+1, h-1)
                || diffLessThanK(indexes, k, l, h-1);
    }

    public static List<Integer> addIndexToMap(Map<Integer, List<Integer>> map, int val, int idx)
    {
        List<Integer> list;
        if(!map.containsKey(val))
        {
            list = new ArrayList<>();
            map.put(val, list);
        } else {
            list = map.get(val);
        }

        list.add(idx);

        return list;
    }
    public static int[] bubbleSort(int[] arr)
    {
        int n = arr.length;
        int[] movedToIndices = new int[n];
        for (int i = 0; i < n; i++)
        {
            movedToIndices[i] = i;
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    temp = movedToIndices[j];
                    movedToIndices[j] = movedToIndices[j+1];
                    movedToIndices[j+1] = temp;
                }
            }
        }

        return movedToIndices;
    }

    private static int productIntArray(int[] digitAsArray) {
        int prod = 1;
        for (int val : digitAsArray)
        {
            prod *= val;
        }
        return prod;
    }

    private static int[] stringToIntArray(String str) {
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++){
            arr[i] = str.charAt(i) - '0';
        }
        return arr;
    }

    static int num_good_pairs(int n)
    {
        if(n < 2){
            return 0;
        }

        if(n==2)
        {
            return 1;
        }

        return (n-1) + num_good_pairs(n-1);
    }
}