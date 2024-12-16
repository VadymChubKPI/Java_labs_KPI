public class Task23 {
    
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 3, 0, -1, 0};
        System.out.println("Кількість нулів: " + countZeros(array));

        // Тест з пустим масивом
        try {
            System.out.println("Кількість нулів: " + countZeros(new int[0]));
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static int countZeros(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int count = 0;
        for (int num : array) {
            if (num == 0) {
                count++;
            }
        }
        return count;
    }
}
