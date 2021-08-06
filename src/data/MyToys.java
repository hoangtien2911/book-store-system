package data;

import java.util.Scanner;

public class MyToys {

    private static Scanner sc = new Scanner(System.in);

    public static String getAString(String inputMsg, String errorMsg) {
        String n;
        do {
            System.out.print(inputMsg);
            n = sc.nextLine().trim().toUpperCase();
            if (n.length() == 0 || n.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return n;
            }
        } while (true);
    }

    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        do {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        do {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);

    }

    public static double getADouble(String inputMsg, String errorMsg) {
        double n;
        do {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);

    }
}
