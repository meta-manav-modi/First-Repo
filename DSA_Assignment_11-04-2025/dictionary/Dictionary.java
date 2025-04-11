package dictionary;

/** class Dictionary, used to store the values of a node and its left and right childs references */
public class Dictionary {
    private String key;
    private String value;
    Dictionary left;
    Dictionary right;

    public Dictionary(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Getters and Setters
    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
    public void setKey(String key) {
        this.key = key;
    }
    
}
