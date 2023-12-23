package medium;

import utility.IParser;
import utility.LeetcodeArgsParser;
import utility.LeetcodeInputIterator;
import utility.LeetcodeMethodsCallStackInputParser;

import java.util.*;

public class DesignUndergroundSystem {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test(){

            String methods = "[\"UndergroundSystem\",\"checkIn\",\"checkIn\",\"checkIn\",\"checkOut\",\"checkOut\",\"checkOut\",\"getAverageTime\",\"getAverageTime\",\"checkIn\",\"getAverageTime\",\"checkOut\",\"getAverageTime\"]";
            String input = "[[],[45,\"Leyton\",3],[32,\"Paradise\",8],[27,\"Leyton\",10],[45,\"Waterloo\",15],[27,\"Waterloo\",20],[32,\"Cambridge\",22],[\"Paradise\",\"Cambridge\"],[\"Leyton\",\"Waterloo\"],[10,\"Leyton\",24],[\"Leyton\",\"Waterloo\"],[10,\"Waterloo\",38],[\"Leyton\",\"Waterloo\"]]";

            IParser p = new LeetcodeMethodsCallStackInputParser(",");
            IParser p1 = new LeetcodeArgsParser();
            LeetcodeInputIterator methodItr = new LeetcodeInputIterator(p,methods);
            LeetcodeInputIterator inputItr = new LeetcodeInputIterator(p1,input);

            UndergroundSystem undergroundSystem = null;

            Iterator<String> methodIterator = methodItr;
            Iterator<String> inputIterator = inputItr;
            int y = -1;
            while (methodIterator.hasNext()) {
                y++;

                String methodName = methodIterator.next();
                String val = inputIterator.next();


                switch (methodName) {
                    case "UndergroundSystem": {
                        undergroundSystem = new UndergroundSystem();
                        System.out.println(y + " constr");
                        break;
                    }
                    case "checkIn": {
                        String[] split = val.split(",");
                        System.out.println(y + " " + val + " ");
                        undergroundSystem.checkIn(Integer.valueOf(split[0]), split[1], Integer.valueOf(split[2]));
                        break;
                    }
                    case "checkOut": {
                        String[] split = val.split(",");
                        System.out.println(y + " " + val + " ");
                        undergroundSystem.checkOut(Integer.valueOf(split[0]), split[1], Integer.valueOf(split[2]));
                        break;
                    }
                    case "getAverageTime": {
                        System.out.print(y + " " + val + " ");
                        String[] split = val.split(",");
                        System.out.println(undergroundSystem.getAverageTime(split[0], split[1]));
                        break;
                    }

                }
            }
    //
    //
    //            undergroundSystem.checkIn(45, "Leyton", 3);
    //            undergroundSystem.checkIn(32, "Paradise", 8);
    //            undergroundSystem.checkIn(27, "Leyton", 10);
    //            undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
    //            undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
    //            undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
    //            undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
    //            undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
    //            undergroundSystem.checkIn(10, "Leyton", 24);
    //            undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
    //            undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
    //            undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
         }

        class UndergroundSystem {
            Map<Integer, CheckInInfo> traveling;
            Map<String, AvgItem> average;
            public UndergroundSystem() {
                traveling = new HashMap<>();
                average = new HashMap<>();
            }

            public void checkIn(int id, String stationName, int t) {
                traveling.put(id, new CheckInInfo(stationName, t));
            }

            public void checkOut(int id, String stationName, int t) {
                CheckInInfo checkInInfo = traveling.get(id);
                String keyName = checkInInfo.stationName+"_"+stationName;
                AvgItem currAvg = average.computeIfAbsent(keyName, k->new AvgItem());
                currAvg.count++;
                currAvg.sum+=t - checkInInfo.t;

                traveling.remove(id);
            }

            public double getAverageTime(String startStation, String endStation) {
                String keyName = startStation+"_"+endStation;
                return (double) average.get(keyName).sum / average.get(keyName).count;
            }

            private class AvgItem {
                int sum;
                int count;
            }
            private class CheckInInfo {
                private final String stationName;
                private final int t;

                public CheckInInfo(String stationName, int t) {
                    this.stationName = stationName;
                    this.t = t;
                }
            }
        }
    }
}
