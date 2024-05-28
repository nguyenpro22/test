package utils;

import java.util.Scanner;

public class Inputer {

    private static final Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inpMsg, String errMsg, boolean update) {
        while (true) {
            System.out.print(inpMsg);
            try {
                String userInput = sc.nextLine();

                if (update && (userInput.isBlank() || userInput.isEmpty())) {
                    return Integer.MIN_VALUE - 1;
                }

                return Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public static int getAnInteger(String inpMsg, String errMsg,
                                   int lowerBound, int upperBound, boolean update) {
        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }

        int number;
        while (true) {
            System.out.print(inpMsg);
            try {
                String userInput = sc.nextLine();

                if (update && (userInput.isBlank() || userInput.isEmpty())) {
                    return Integer.MIN_VALUE - 1;
                }

                number = Integer.parseInt(userInput);

                if (number > upperBound || number < lowerBound) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    public static double getADouble(String inpMsg, String errMsg, boolean update) {
        double number;
        while (true) {
            System.out.print(inpMsg);
            try {
                String userInput = sc.nextLine();

                if (update && (userInput.isBlank() || userInput.isEmpty())) {
                    return Double.NaN; // Or another suitable default value
                }

                number = Double.parseDouble(userInput);
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    public static double getADouble(String inpMsg, String errMsg,
                                    double lowerBound, double upperBound, boolean update) {
        if (lowerBound > upperBound) {
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }

        double number;
        while (true) {
            System.out.print(inpMsg);
            try {
                String userInput = sc.nextLine();

                if (update && (userInput.isBlank() || userInput.isEmpty())) {
                    return Double.NaN; // Or another suitable default value
                }

                number = Double.parseDouble(userInput);

                if (number > upperBound || number < lowerBound) {
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    public static String getString(String inpMsg, String errMsg, boolean update) {
        while (true) {
            try {
                System.out.print(inpMsg);
                String str = sc.nextLine();

                if (update && (str.isBlank() || str.isEmpty())) {
                    return ""; // Or another suitable default value
                }

                if (str.isEmpty() || str.isBlank()) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    public static String getString(String inpMsg, String errMsg, String regex, boolean update) {
        while (true) {
            try {
                System.out.print(inpMsg);
                String str = sc.nextLine();

                if (update && (str.isBlank() || str.isEmpty())) {
                    return ""; // Or another suitable default value
                }

                if (str.isEmpty() || str.isBlank() || !str.matches(regex)) {
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
}
