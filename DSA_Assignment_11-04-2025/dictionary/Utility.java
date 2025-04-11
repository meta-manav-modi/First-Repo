package dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class Utility, used to declare the json and add its key value pairs to BST
 * and call other methods like
 * addPair, deletePair, searchPair, sortBST and print the specific output
 */
public class Utility {

    public void execute() {
        Scanner sc = new Scanner(System.in);
        BSTForDictionary bst = new BSTForDictionary();

        // JSON String
        String json = "[{\"key\": \"abundance\", \"meaning\": \"a very large quantity of something\"}," +
                "{\"key\": \"serendipity\", \"meaning\": \"the occurrence of events by chance in a happy or beneficial way\"},"
                +
                "{\"key\": \"effervescence\", \"meaning\": \"vivacity and enthusiasm\"}," +
                "{\"key\": \"quintessential\", \"meaning\": \"representing the most perfect or typical example of something\"},"
                +
                "{\"key\": \"ephemeral\", \"meaning\": \"lasting for a very short time\"}," +
                "{\"key\": \"halcyon\", \"meaning\": \"denoting a period of time in the past that was idyllically happy and peaceful\"}"
                +
                "]";

        // Get info from json string and add to the BST
        bst.jsonParseString(json);

        try {
            boolean run = true;
            while (run) {
                System.out.println("1. Insert a pair");
                System.out.println("2. Delete a pair");
                System.out.println("3. Search a pair");
                System.out.println("4. Find between range");
                System.out.println("5. Sort and print the list");
                System.out.println("6. Exit");
                System.out.println("Enter your choice");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the number of pairs you want to add");
                        int numPairs = sc.nextInt();
                        sc.nextLine();
                        if (numPairs <= 0) {
                            throw new AssertionError("Size cannot be less than 1");
                        }
                        for (int index = 0; index < numPairs; index++) {
                            System.out.println("Enter the key and value as pair");
                            String key = sc.nextLine();
                            String value = sc.nextLine();
                            bst.addPair(key, value);
                        }
                        break;

                    case 2:
                        String keyToDelete = sc.next();
                        bst.deletePair(keyToDelete);
                        System.out.println("Pair deleted");
                        break;

                    case 3:
                        String keyToSearch = sc.next();
                        Dictionary res = bst.searchPair(keyToSearch);
                        System.out.println(res.getKey() + " : " + res.getValue());
                        break;

                    case 4:
                        String key1ToSearch = sc.next();
                        String key2ToSearch = sc.next();
                        List<Dictionary> pairsInRange = new ArrayList<>();
                        pairsInRange = bst.pairsInRange(key1ToSearch, key2ToSearch);
                        for (Dictionary d : pairsInRange) {
                            System.out.println(d.getKey() + " : " + d.getValue());
                        }
                        break;

                    case 5:
                        bst.sortPairList();
                        break;

                    case 6:
                        run = false;
                        break;
                }
            }

        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unwanted error : " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
