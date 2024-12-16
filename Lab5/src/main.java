public class main {

    public static void selectionSort(long[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            long temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(long[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            long key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static long[] generateRandomArray(int size, int bound) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = (long) (Math.random() * bound); // Генеруємо випадкові числа
        }
        return array;
    }

    public static void arrayPrint (long[] array) {
        for (long num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arraySize = 20; // Розмір масиву
        int bound = 100;    // Межа значень у масиві

        // Генеруємо випадковий масив
        long[] randomArray1 = generateRandomArray(arraySize, bound);
        long[] randomArray2 = randomArray1.clone();

        arrayPrint(randomArray1);

        // Бенчмарк для Selection Sort
        long startTime = System.nanoTime();
        selectionSort(randomArray1);
        long endTime = System.nanoTime();
        System.out.println("Selection Sort Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Бенчмарк для Insertion Sort
        startTime = System.nanoTime();
        insertionSort(randomArray2);
        endTime = System.nanoTime();
        System.out.println("Insertion Sort Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        arrayPrint(randomArray1);
    }
}
