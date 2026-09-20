import java.util.Scanner;

public class Utils {

    private Utils() {}

    public static String readNonEmptyString(Scanner scanner, String prompt) {
        String input = "";
        boolean valid = false;

        while(!valid) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if(input.isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }
            valid = true;
        }
        return input;
    }

    public static String readNonEmptyString(Scanner scanner, String prompt, int maxLength) {
        String input = "";
        boolean valid = false;

        while(!valid) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if(input.isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }
            if(input.length() > maxLength) {
                System.out.println("Input is too long.");
                continue;
            }
            valid = true;
        }
        return input;
    }

    public static String readValidString(Scanner scanner, int maxLength, String prompt, String format, String errorMessage) {
        String input = "";
        boolean valid = false;

        while(!valid) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if(input.isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }
            if(input.length() > maxLength) {
                System.out.println("Input is too long.");
                continue;
            }
            if(!input.matches(format)) {
                System.out.println(errorMessage);
                continue;
            }
            valid = true;
        }
        return input;
    }

    public static int readValidInt(Scanner scanner, String prompt, int min, int max, String errorMessage) {
        String input;
        int number = -1;
        boolean valid = false;

        while(!valid) {
            input = readNonEmptyString(scanner, prompt);
            try {
                number = Integer.parseInt(input);
                if(number >= min && number <= max) {
                    valid = true;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number only.");
            }
        }
        return number;
    }

    public static double readValidDouble(Scanner scanner, String prompt, double min, double max, String errorMessage) {
        String input;
        double number = -1;
        boolean valid = false;

        while(!valid) {
            input = readNonEmptyString(scanner, prompt);
            try {
                number = Double.parseDouble(input);
                if(number >= min && number <= max) {
                    valid = true;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number only.");
            }
        }
        return number;
    }

    public static void displayHeader(String headerName) {
        System.out.println("================ " + headerName + " ================");
    }

    public static String tableFormat(boolean hasType) {
        if(hasType) {
            return "%-30s%-30s%-10s%-10s%n";
        }
        return "%-30s%-30s%-10s%n";
    }
}
