package stringCharacters;

import java.util.Scanner;

/** class Utility, used to take imput and call the getUniqueCharacters function */
public class Utility {
    public void execute() {
        UniqueueCharacters unique = new UniqueueCharacters();
        Scanner scanner = new Scanner(System.in);
        try {
            System.err.println("Enter the input string");
            String str = scanner.nextLine();
            String[] parts = str.split(" ");
            for (int index = 0; index < parts.length; index++) {
                System.out.println(parts[index] + " having " + unique.getUniqueCharacters(parts[index])
                        + " unique characters");
            }
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unwanted error" + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
