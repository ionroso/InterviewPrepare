package easy;

public class StudentAttendanceRecordI {
    public static void main(String[] args) {
        System.out.println(new StudentAttendanceRecordI().checkRecord("ALLLA"));
    }

    public boolean checkRecord(String s) {
        int n = s.length();
        if(n < 5 ) return false;

        int countAs = 0;
        int countConsLs = 0, longestConsLs = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A') countAs++;

            if(s.charAt(i) == 'L'){
                countConsLs++;
                if(i+1 == s.length() || s.charAt(i+1) != 'L') {
                    longestConsLs = Math.max(longestConsLs, countConsLs);
                    countConsLs = 0;
                }
           }
       }

        return countAs < 2 && longestConsLs <=3;
    }

}
