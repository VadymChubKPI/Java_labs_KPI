public class Task53 {

    public static void main(String[] args) {
        int[] array = {3, -5, 8, -2, 2, 7, 10, -9};
        try {
            System.out.println("Добуток: " + productOfMinMaxAtEvenIndices(array));
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static int productOfMinMaxAtEvenIndices(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean foundEvenIndex = false;

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {  // Парні індекси
                foundEvenIndex = true;
                int value = array[i];
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
        }

        if (!foundEvenIndex) {
            throw new IndexOutOfBoundsException("Не знайдено елементів на парних індексах");
        }

        return Math.abs(min) * Math.abs(max);
    }
}
