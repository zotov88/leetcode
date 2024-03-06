package javasolution.easy.goal_parser_interpretation;

public class Main {
    public static void main(String[] args) {
        String command = "(al)G(al)()()G";
        System.out.println(interpret(command));
    }

    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length(); ) {
            char c = command.charAt(i);
            if (c == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append("o");
                    i += 2;
                } else {
                    sb.append("al");
                    i += 4;
                }
            } else {
                sb.append("G");
                i++;
            }
        }

        return sb.toString();
    }

    public static String interpret2(String command) {
        return command.replaceAll("\\(al\\)", "al").replaceAll("\\(\\)", "o");
    }
}
