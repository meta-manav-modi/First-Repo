package stringCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/** class UniqueCharacters, used to performa  function count the number of unique characters in a string */
public class UniqueueCharacters {
    private Map<String, Integer> cache = new HashMap<>();

    /** method used to count number of unique characters
     * @ param string
     * @return integer value
     */
    public int getUniqueCharacters(String str){
        if(cache.containsKey(str)){
            System.out.println("Already exists");
            return cache.get(str);
        }

        HashSet<Character> unique = new HashSet<Character>();
        for(int index = 0; index < str.length(); index++){
            unique.add(str.charAt(index));
        }
        int uniqueCharCount = unique.size();
        cache.put(str, uniqueCharCount);
        return uniqueCharCount;
    }
}
