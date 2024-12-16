public class Task3 {

    public static void main(String[] args) {
        printTask11Result(0.0001);
        printTask11Result(0.001);
        printTask11Result(0.01);
        printTask11Result(0.1);
        printTask11Result(1);
    }

    public static double Task11(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Точність epsilon повинна бути більшою за 0. Зараз epsilon = " + epsilon);
        }

        double sum = 0.0;
        int i = 1;

        while (true) {
            double term = 1.0 / (i * i);
            if (Math.abs(term) < epsilon) {
                break;
            }
            sum += term;
            i++;
        }

        return sum;
    }

    static void printTask11Result(double epsilon) {
        System.out.print("epsilon: " + epsilon + " result: ");
        try {
            System.out.println(Task11(epsilon));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
