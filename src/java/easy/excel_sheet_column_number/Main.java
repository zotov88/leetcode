package java.easy.excel_sheet_column_number;

public class Main {

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        int digit = 0;

        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            result += (int) (Math.pow(26, digit++) * (columnTitle.charAt(i) - 64));
        }

        return result;
    }

}
