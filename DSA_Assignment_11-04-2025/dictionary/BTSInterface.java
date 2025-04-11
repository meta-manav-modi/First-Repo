package dictionary;

import java.util.List;

/** Interface for the BST */
public interface BTSInterface {
    void addPair(String key, String value);
    void deletePair(String key);
    void sortPairList();
    Dictionary searchPair(String key);
    List<Dictionary> pairsInRange(String key1, String key2);
} 
