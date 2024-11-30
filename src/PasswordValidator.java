import java.util.Scanner;


public class PasswordValidator {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the password to validate: ");
        String password = scanner.nextLine();


        System.out.println(isValidPassword(password) ? "The password is valid." : "The password is invalid.");


        scanner.close();
    }


    public static boolean isValidPassword(String password) {
        // Check if length is valid
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }


        // Define character categories
        int categoryCount = 0;
        boolean[] categories = new boolean[4]; // Lowercase, Uppercase, Digit, Special


        for (char c : password.toCharArray()) {
            if (!categories[0] && Character.isLowerCase(c)) {
                categories[0] = true;
                categoryCount++;
            } else if (!categories[1] && Character.isUpperCase(c)) {
                categories[1] = true;
                categoryCount++;
            } else if (!categories[2] && Character.isDigit(c)) {
                categories[2] = true;
                categoryCount++;
            } else if (!categories[3] && "~!@#$%^&*()-=+_".indexOf(c) != -1) {
                categories[3] = true;
                categoryCount++;
            }


            // Early exit if at least 3 categories are found
            if (categoryCount >= 3) {
                return true;
            }
        }


        return false; // Not enough categories met
    }
}





