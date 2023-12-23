package medium;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;

public class DesignLogStorageSystem {
    public static void main(String[] args) throws ParseException {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");

        // return [3,2,1], because you need to return all logs between 2016 and 2017.
//        List<Integer> rez1 = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
//        rez1.forEach(i -> System.out.print(i + " ") );
//        System.out.println();
        // return [2,1], because you need to return all logs between Jan. 1, 2016 01:XX:XX and Jan. 1, 2017 23:XX:XX.
        // Log 3 is not returned because Jan. 1, 2016 00:00:00 comes before the start of the range.
        List<Integer> rez2 = logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
        rez2.forEach(i -> System.out.print(i + " ") );
        System.out.println();
    }

    static
    class LogSystem {

        private static final String[] GRAVITY_VALUES = new String[]{"Year", "Month", "Day", "Hour", "Minute", "Second"};
        private static final boolean[] GRAVITY_ALL = new boolean[]{true, true, true, true, true, true};
        private static final  SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");

        Map<Integer, String> idToDate = new HashMap<>();
        public LogSystem() {

        }

        public void put(int id, String timestamp) {
            idToDate.put(id, timestamp);
        }

        public List<Integer> retrieve(String start, String end, String granularity) {
           boolean[] granularityBits = getGranularityBits(granularity);
           Predicate<String> filter = formatDateFilter(start, end, granularityBits);
           return idToDate.entrySet().stream()
                   .filter(entry -> filter.test(entry.getValue()))
                   .map(entry -> entry.getKey())
                   .sorted(((o1, o2) -> o2 - o1))
                   .toList();
        }


        private Predicate<String> formatDateFilter(String start, String end, boolean[] granularityBits) {
            Date startDate = getDate(formatDateString(start,  granularityBits));
            Date endDate = getDate(formatDateString(end,  granularityBits));

            return (date) -> {
                Date temp = getDate(formatDateString(date,  granularityBits));
                return temp.compareTo(startDate) >= 0 && temp.compareTo(endDate) <= 0;
            } ;
        }

        private static boolean[] getGranularityBits(String granularity) {
            boolean[] granularityBits = new boolean[6];
            int i=0;
            for (String gravityValue : GRAVITY_VALUES) {
                granularityBits[i++]=true;
                if(gravityValue.equals(granularity)){
                    break;
                }
            }
            return granularityBits;
        }

        private Date getDate(String date){
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        private String formatDateString(String start, boolean[] granularityBits) {
            String[] split = start.split(":");
            return String.format("%s:%s:%s:%s:%s:%s",
                granularityBits[0] ? split[0] : "00",
                granularityBits[1] ? split[1] : "00",
                granularityBits[2] ? split[2] : "00",
                granularityBits[3] ? split[3] : "00",
                granularityBits[4] ? split[4] : "00",
                granularityBits[5] ? split[5] : "00");
        }
    }
}
