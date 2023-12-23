package easy;

public class DefangingAnIPAddress {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }
    static public String defangIPaddr(String address) {
        String[] split = address.split("\\.");
        StringBuilder output = new StringBuilder();

        output.append(split[0]);
        for (int i = 1; i < split.length; i++) {
            output.append("[.]");
            output.append(split[i]);
        }

        return output.toString();
    }
}
