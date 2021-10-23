import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a text");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i =0 ; i < 4 ; i++){
            int a = scanner.nextInt();
        }
        System.out.println(getCryptoString(input));
        System.out.println("Enter a text :");
        String nextInput = scanner.nextLine();
        System.out.println(checkRegex(nextInput));
    }

    public static int getFibonacciNumber(int n) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    public static String getCryptoString(String input) {
        char[] inputsInChar = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputsInChar.length; i++) {
            char a = inputsInChar[i];
            int aInInteger = a;
            if (aInInteger == 32) {
                stringBuilder.append(' ');
                continue;
            }
            int fibonacciNumber = getFibonacciNumber(i);
            aInInteger += fibonacciNumber;
            while (true) {
                if (aInInteger <= 122 && aInInteger >= 97)
                    break;
                else if (aInInteger > 122)
                    aInInteger -= 26;
                else
                    aInInteger += 26;
            }
            stringBuilder.append((char) aInInteger);
        }
        return stringBuilder.toString();
    }

    public static String checkRegex(String input) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]+@([a-zA-Z0-9-]+)\\.[a-zA-Z0-9]+$");
        String[] inputInStrings = input.split("\\s+");
        for (String s : inputInStrings) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return "Not found";
    }
}
