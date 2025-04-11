package dictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * class BSTForDictionary, used to define all the methods to perform diff
 * operations on BST
 * like, add, delete, search, sort and their helping methods
 */
public class BSTForDictionary implements BTSInterface {
    Dictionary root;

    public BSTForDictionary() {
        root = null;
    }

    /**
     * Add a key-value pair to BST
     * @param key
     * @param value
     */
    public void addPair(String key, String value) {
        root = insertRecursion(root, key, value);
    }

    /**
     * Delete a key-value pair from BST
     * @param key
     */
    public void deletePair(String key) {
        root = deleteRecursion(root, key);
    }

    // Sort the BST
    public void sortPairList() {
        sortPairListRecursion(root);
    }

    /**
     * Read the kry-value pairs from json and add them to BST
     * @param json
     */
    public void jsonParseString(String json) {

        json = json.substring(1, json.length() - 1).trim(); 
        String[] pairs = json.split("\\},\\{"); 

        for (String pair : pairs) {
            pair = pair.replace("{", "").replace("}", "").trim();
            String[] fields = pair.split(",");

            String key = null;
            String meaning = null;

            for (String field : fields) {
                String[] keyValue = field.split(":");
                String parsedKey = keyValue[0].replace("\"", "").trim();
                String parsedValue = keyValue[1].replace("\"", "").trim(); 

                if (parsedKey.equals("key")) {
                    key = parsedValue;
                } else if (parsedKey.equals("meaning")) {
                    meaning = parsedValue;
                }
            }

            if (key != null && meaning != null) {
                addPair(key, meaning);
            }
        }
    }

    /**
     * earch a key-value pair from BST
     * @param key
     * @return the node if it is present
     */
    public Dictionary searchPair(String key) {
        Dictionary result = searchRecursive(root, key);
        if (result != null) {
            return result;
        } else {
            throw new AssertionError("Ememnt not found");
        }
    }

    /**
     * Find all key-value pair from BST in a particular range
     * @param key1
     * @param key2
     * @return list of pairs between the range
     */
    public List<Dictionary> pairsInRange(String key1, String key2) {
        List<Dictionary> pairsInRange = new ArrayList<>();
        rangeSearch(pairsInRange, key1, key2, root);
        return pairsInRange;
    }

    /**
     * Recursion function for insertion in BST
     * @param root
     * @param key
     * @param value
     * @return the root
     */
    private Dictionary insertRecursion(Dictionary root, String key, String value) {
        if (root == null) {
            root = new Dictionary(key, value);
            return root;
        }
        if (key.compareTo(root.getKey()) < 0)
            root.left = insertRecursion(root.left, key, value);
        else if (key.compareTo(root.getKey()) > 0)
            root.right = insertRecursion(root.right, key, value);
        return root;
    }

    /**
     * Recursion function for Search an pair in BST
     * @param root
     * @param key
     * @return node when it is finds
     */
    private Dictionary searchRecursive(Dictionary root, String key) {
        if (root == null)
            return null;
        if (root.getKey().equals(key))
            return root;
        if (root.getKey().compareTo(key) < 0)
            return searchRecursive(root.right, key);
        return searchRecursive(root.left, key);
    }

    /**
     * Recursion function for sorting in BST Or inorder traversal
     * @param root
     */
    private void sortPairListRecursion(Dictionary root) {
        if (root != null) {
            sortPairListRecursion(root.left);
            System.out.print(root.getKey() + " : " + root.getValue() + "\n");
            sortPairListRecursion(root.right);
        }
    }

    /**
     * Recursion function for deletion in BST
     * @param root
     * @param key
     * @return the root to delete
     */
    private Dictionary deleteRecursion(Dictionary root, String key) {

        if (root == null)
            return root;
        if (key.compareTo(root.getKey()) < 0)
            root.left = deleteRecursion(root.left, key);
        else if (key.compareTo(root.getKey()) > 0)
            root.right = deleteRecursion(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            String childKey = minValue(root.right);
            root.setKey(childKey);
            root.right = deleteRecursion(root.right, childKey);
        }
        return root;
    }

    // Helper method for deletion recursion method
    private String minValue(Dictionary root) {
        String min = root.getKey();
        while (root.left != null) {
            root = root.left;
            min = root.getKey();
        }
        return min;
    }

    /**
     * Recursion function for search elemnets in range in BST
     * @param pairsInRange
     * @param key1
     * @param key2
     * @param node
     */
    private void rangeSearch(List<Dictionary> pairsInRange, String key1, String key2, Dictionary node) {
        if (node == null)
            return;
        if (key1.compareTo(node.getKey()) < 0) {
            rangeSearch(pairsInRange, key1, key2, node.left);
        }
        if (key1.compareTo(node.getKey()) <= 0 && key2.compareTo(node.getKey()) >= 0) {
            pairsInRange.add(node);
        }
        if (key2.compareTo(node.getKey()) > 0) {
            rangeSearch(pairsInRange, key1, key2, node.right);
        }
    }
}
