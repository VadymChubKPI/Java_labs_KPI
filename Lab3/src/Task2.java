public class Task2 {
    public static void main(String[] args) {
        printTask7Result(10, 1);
        printTask7Result(10, 2);
        printTask7Result(-3, 2);
        printTask7Result(6, 7);
        printTask7Result(-6, 7);
        printTask7Result(-3, -3);
        printTask7Result(3, Integer.MIN_VALUE);
    }

    public static double task7 (int t, int i) {
        if(t <= 0 && (i == 1 || i == 2)) throw new IllegalArgumentException("Incorrect value for t: " + t);

        if (i == 1 || i == 2){
            return Math.log(t);
        } else if (i > 2) {
            double sum = 0;
            for (int k = 1; k < i; k++ ) {
                sum += Math.sin(t) / k;
            }
            return sum;
        }
        else throw new IllegalArgumentException("Incorrect value for i: " + i);
    }

    public static void printTask7Result (int t, int i){
        System.out.print("t: " + t + " i: " + i + " result: ");
        try {
            System.out.println(task7(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
