package javasolution.easy.excel_sheet_column_title;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(convertToTitle(703));
    }

    public static String convertToTitle(int columnNumber) {
        Map<Integer, Character> map = getFillMap();
        String s = "";
        int remainder = 1;

        while (columnNumber > 0) {
            if (columnNumber > 26) {
                remainder = columnNumber / map.size();
            } else {
                remainder = columnNumber;
            }

            if (remainder > 26) {
                s = convertToTitle(remainder);
            }

            s += map.get(remainder);
            int minus = remainder * map.size();
            columnNumber -= minus;
        }

        return s;
    }

    private static Map<Integer, Character> getFillMap() {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'A');
        map.put(2, 'B');
        map.put(3, 'C');
        map.put(4, 'D');
        map.put(5, 'E');
        map.put(6, 'F');
        map.put(7, 'G');
        map.put(8, 'H');
        map.put(9, 'I');
        map.put(10, 'J');
        map.put(11, 'K');
        map.put(12, 'L');
        map.put(13, 'M');
        map.put(14, 'N');
        map.put(15, 'O');
        map.put(16, 'P');
        map.put(17, 'Q');
        map.put(18, 'R');
        map.put(19, 'S');
        map.put(20, 'T');
        map.put(21, 'U');
        map.put(22, 'V');
        map.put(23, 'W');
        map.put(24, 'X');
        map.put(25, 'Y');
        map.put(26, 'Z');

        return map;
    }

    public static String convertToTitle2(int columnNumber) {

        HashMap<Integer, Character> hm = new HashMap<>();
        hm.put(0, 'Z');
        for (int i = 1; i <= 26; i++) {
            hm.put(i, (char) (64 + i));
        }
        StringBuilder sb = new StringBuilder("");
        int num = columnNumber;
        if (num < 27) {
            sb.append(hm.get(num));
        }
        while (num >= 27) {
            int mod = num % 26;
            num = num / 26;
            sb.append(hm.get(mod));
            if (mod == 0) {
                num--;
            }
            if (num < 27) {
                sb.append(hm.get(num));
            }
        }
        sb.reverse();
        return sb.toString();
    }
}
