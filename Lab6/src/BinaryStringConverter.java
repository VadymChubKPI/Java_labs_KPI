public class BinaryStringConverter {

    public static int binaryStringToInt(String s) {
        if (s == null) {
            throw new NullPointerException("Input string cannot be null");
        }
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be empty");
        }

        int result = 0; // Результуюче число
        int power = 0;  // Поточний степінь двійки

        for (int i = s.length() - 1; i >= 0; i--) {
            char bit = s.charAt(i);
            if (bit == '1') {
                result += Math.pow(2, power);
            } else if (bit != '0') {
                throw new IllegalArgumentException("Invalid character in binary string: " + bit);
            }
            power++;
        }

        return result;
    }

    // Метод main - точка входу
    public static void main(String[] args) {
        // Тестові випадки
        String[] testCases = {
                "10101", // Валідний: 21
                "1111",  // Валідний: 15
                "0",     // Валідний: 0
                "1",     // Валідний: 1
                "100000", // Валідний: 32
                "1010A1", // Невалідний: містить недопустимий символ
                "",       // Невалідний: порожній рядок
                null      // Невалідний: null
        };

        for (String testCase : testCases) {
            try {
                int result = binaryStringToInt(testCase);
                System.out.println("Binary string: " + testCase + " -> Decimal: " + result);
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println("Binary string: " + testCase + " -> Error: " + e.getMessage());
            }
        }
    }
}
