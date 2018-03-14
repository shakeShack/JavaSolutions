import java.util.*;

public class RemoveNNumbersInOrderToGenerateLowestValueNumber {
    public static void main(String... args) {
        System.out.println(GenerateLowestNumber("4205123", 4));
        System.out.println(GenerateLowestNumber("216504", 3));
        System.out.println(GenerateLowestNumber("4205123", 3));
        System.out.println(GenerateLowestNumber("4205123", 1));
        System.out.println(GenerateLowestNumber("4205633", 4));
        System.out.println(GenerateLowestNumber("1122334455", 6));
        System.out.println(GenerateLowestNumber("987089", 2));
        System.out.println(GenerateLowestNumber("111111111", 4));
        System.out.println(GenerateLowestNumber("", 4));
        System.out.println(GenerateLowestNumber("1", 4));
        System.out.println(GenerateLowestNumber("12345", 0));
        System.out.println(GenerateLowestNumber("12345", 2));
        System.out.println(GenerateLowestNumber("54321", 0));
        System.out.println(GenerateLowestNumber("54321", 2));

    }

    public static String GenerateLowestNumber(String value, int n) {
        if (n == 0) {
            return value;
        }
        //handles empty string as well
        if (n >= value.length()) {
            return "0";
        }
        // handle null string
        // handle negatives

        int resultLength = value.length() - n;
        char[] result = new char[value.length()];
        int head = 0;
        // n keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when n is larger than 0
        for (int i = 0; i < value.length(); ++i) {
            char currentCharacter = value.charAt(i);
            while (head > 0 && result[head - 1] > currentCharacter && n > 0) {
                head -= 1;
                n -= 1;
            }
            result[head++] = currentCharacter;
        }
        return new String(result, 0, resultLength);
    }
}
