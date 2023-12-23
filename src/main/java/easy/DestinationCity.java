package easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> hasIncoming = new HashSet<>();
        Set<String> hasOutcoming = new HashSet<>();

        for (List<String> path : paths) {
            hasOutcoming.add(path.get(0));
            hasIncoming.add(path.get(1));
        }

        for (String city : hasIncoming) {
            if (!hasOutcoming.contains(city)){
                return city;
            }
        }

        return null;
    }
}
