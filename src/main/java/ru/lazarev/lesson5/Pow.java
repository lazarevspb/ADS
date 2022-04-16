package ru.lazarev.lesson5;

public class Pow {

    public static void main(String[] args) {
        System.out.println(pow(5, 5));
        System.out.println(Math.pow(5, 5));
    }

    private static double pow(double base, int indicator) {
        double tmp = base;
        if (indicator == 1) {
            return base;
        }
        if (indicator == 0) {
            return 0;
        }

        if (indicator < 0) {
            indicator = indicator * -1;
            tmp = 1.0 * 1 / base;
        }
        return base * pow(tmp, indicator - 1);
    }
}
