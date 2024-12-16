public class Main {
    public static void main(String[] args) {
        System.out.println(task3(1.234, -3.12, 5.45, 2.0));
        System.out.println(task12(1.487, 9.26, 0.68, 2.24));
        System.out.println(task21(-2.54, 1.23, -2.14, -0.23));
    }

    public static double task3 (double a, double b, double c, double d) {

        return Math.pow(
                (2 * Math.sin(a) + Math.cos(Math.abs(b * Math.sqrt(c)))),
                d);
    }

    /*public  static double task3v2 (double a, double b, double c, double d) {

        double firstPart = 2 * Math.sin(a * (Math.PI / 180));
        double secondPart = Math.cos(Math.abs((b * Math.sqrt(c))));
        double result = Math.pow(firstPart + secondPart, d);

        return result;
    }*/

    public static double task12 (double a, double b, double c, double d) {
        double firstPart = 6 * Math.pow((Math.sin(Math.abs(2 * a))), Math.log10(b));
        double secondPart = Math.sqrt(c * Math.cosh(-d));

        return firstPart + secondPart;
    }

    public static double task21 (double a, double b, double c, double d) {
        double firstPart = (Math.log(Math.abs(a / b)));
        double secondPart = Math.sqrt(Math.cos(c) + Math.pow(Math.E, d));

        return 3 * (firstPart + secondPart);
    }

}