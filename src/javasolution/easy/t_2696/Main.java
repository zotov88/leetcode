package javasolution.easy.t_2696;

public class Main {
    public static void main(String[] args) {
        String s = "CDDC";
        System.out.println(minLength(s));
    }

    public static int minLength(String s) {
        int startIndex = 0;
        int endIndex = 0;
        while (s.contains("AB") || s.contains("CD")) {

            if (s.contains("AB")) {
                startIndex = s.indexOf("AB");
                endIndex = startIndex + 1;
            } else if (s.contains("CD")) {
                startIndex = s.indexOf("CD");
                endIndex = startIndex + 1;
            }

            String leftPart = s.substring(0, startIndex);
            String rightPart = s.substring(endIndex + 1);

            s = leftPart + rightPart;
        }

        return s.length();
    }
}
