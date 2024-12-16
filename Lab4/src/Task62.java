public class Task62 {

    public static void main(String[] args) {
        int[] array = {6, 3, 9, 12, 33};
        try {
            int[] result = transformArray(array);
            System.out.println("Результат: " + java.util.Arrays.toString(result));
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static int[] transformArray(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int min = Integer.MAX_VALUE;
        for (int num : array) {
            min = Math.min(min, num);
        }

        int[] result = new int[array.length];
        if (min == 0) {
            for (int i = 0; i < array.length; i++) {
                result[i] = -10;
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i] / min;
            }
        }

        return result;
    }
}
