public class Task1 {
    public static void main(String[] args) {
        printTask3Result(0, 0);
        printTask3Result(3, 6);
        printTask3Result(-6, 7);
        printTask3Result(4, 15);
        printTask3Result(1, Integer.MAX_VALUE);
        printTask3Result(3, Integer.MIN_VALUE);
        }

    public static double task3 (int z, int k){
        if(k >= 15 || k < 1) throw new IllegalArgumentException("Incorrect value for k: " + k);
        if(z <= 0) throw new IllegalArgumentException("Incorrect value for z: " + z);
        double sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += (1 / Math.sqrt(z * i)) + Math.tan(k / i);
        }
        return sum;
    }

    public static void printTask3Result (int z, int k){
        System.out.print("z: " + z + " k: " + k + " result: ");
        try {
            System.out.println(task3(z, k));
        } catch (IllegalArgumentException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}