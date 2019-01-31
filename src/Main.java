public class Main {
    public static void main(String[] args) {
        String s = "2+66+9*(5-9)";

        System.out.println(s.charAt(0));

        char temp = s.charAt(2);
        char temp1 = s.charAt(3);

        System.out.println(temp + " " + temp1);

        String t =  "";
        t += temp;
        t += temp1;

        char[] charArray = {temp, temp1};
        String str = String.valueOf(charArray);


        //System.out.println(Character.isDigit(temp));
        System.out.println(t);
        System.out.println(str);

        //System.out.println(s.contains("("));

        System.out.println("number of brackets: " + bracketCounter(s));
        System.out.println(isStringValid(s));

    }

    public static boolean isStringValid(String s) {

        char[] validSymbols = {'+', '-', '*', '/', '(', ')', '.'};

        char temp = s.charAt(0);
        if (!Character.isDigit(temp))
            return false;

        for (int i = 0; i < s.length() ; i++) {
            if (i+1 != s.length()){
                if (s.charAt(i) == '.' && s.charAt(i+1) == '.' )
                    return false;
            }
            if (!(Character.isDigit(s.charAt(i)) || isOp(s.charAt(i)) ||
                    s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '.'))
                return false;
        }

        return true;
    }

    public static int bracketCounter (String s) {
        int leftBracket = 0, rightBracket = 0;
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) == '(')
                leftBracket++;
            if (s.charAt(i) == ')')
                rightBracket++;
        }

        if (leftBracket != rightBracket)
            return -1;
        else if (leftBracket == 0 && rightBracket == 0)
            return 0;
        else
            return leftBracket;

    }

    /**
     * Функция проверяет, является ли текущий символ оператором
     */
    private static boolean isOp(char c) {
        switch (c) {
            case '-':
            case '+':
            case '*':
            case '/':
            //case '^':
                return true;
        }
        return false;
    }

    /**
     * Возвращает приоритет операции
     * @param op char
     * @return byte
     */
    private static byte opPrior(char op) {
        switch (op) {
            case '^':
                return 3;
            case '*':
            case '/':
            case '%':
                return 2;
        }
        return 1; // Тут остается + и -
    }
}
