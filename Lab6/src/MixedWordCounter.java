public class MixedWordCounter {

    public static int countLetterDigitCombinations(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        String[] words = input.split("\\s+"); // Розділяємо рядок на слова
        int count = 0;

        for (String word : words) {
            boolean hasLetter = false;
            boolean hasDigit = false;

            // Перевіряємо, чи слово містить літери та цифри
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    hasLetter = true;
                } else if (Character.isDigit(c)) {
                    hasDigit = true;
                }
                // Якщо в слові є і букви, і цифри, це комбінація
                if (hasLetter && hasDigit) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    // Точка входу
    public static void main(String[] args) {
        // Тестовий приклад
        String input = "The user with the nickname koala757677 this month wrote 3 times more " +
                "comments than the user with the nickname croco181dile920 4 months ago";

        try {
            int result = countLetterDigitCombinations(input);
            System.out.println("Input: \"" + input + "\"");
            System.out.println("Number of letter-digit combinations: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
