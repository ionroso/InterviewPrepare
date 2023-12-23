package easy;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(26));
    }
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber>0){
            int rest = columnNumber / 26;
            int modelo = columnNumber % 26;
            if (rest == 0) {
                sb.append((char) (modelo + 96));
            } else {
                sb.append("" + (char) (rest + 96) + (char) (modelo + 96));
            }
            columnNumber = columnNumber / 26;
        }

        return sb.toString().toUpperCase();
    }
}
