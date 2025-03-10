package stringoperations;
import java.util.*;

/** class Operations, used to perform all methods calculations like,
 * compare, reverse, change casing, maximum length word from a string
 */

public class Operations{

    /** Method toCompare, return true if strings are equal, otherwise false 
     * @ param first and second string 
    */
    public boolean toCompare(String firstString, String secondString){
        if(firstString.length() != secondString.length() ){
            return false;
        }else{
            for(int index = 0; index < firstString.length(); index++ ){
                if(firstString.charAt(index) != secondString.charAt(index) ){
                    return false;
                }
            }
            return true;
        }
    }   

    /** Method reverse, return the reversed string 
     * @ param string to reverse
    */
    public String reverse(String str){
      String res="";

      for(int index = str.length() -1; index >= 0; index--){
        res += str.charAt(index);
      }
    return res;
    }
    
    /** Method changeCasing, return the string after change the casing of each alphabet 
     * @ param string to change casing
    */
    public String changeCasing(String str){
        String res = ""; 
        char ch;
        for(int index =0; index < str.length(); index++){
            if(str.charAt(index) >= 'a' && str.charAt(index) <= 'z'){
                 ch = (char)((int)str.charAt(index) - 32);
                 res += ch;
            }
            else if(str.charAt(index) >= 'A' && str.charAt(index) <= 'Z'){
                 ch = (char)((int)str.charAt(index) + 32);
                 res += ch;
            }
        }
        return res;
    }

    /** Method maxWord, return the word which is maximum in length 
     * @ param string to find maximum length word
    */
    public String maxWord(String str){
        String largestWord = "";
        int maxLength = 0;
        StringBuilder currentWord = new StringBuilder();
         
         // loop to find max length word
         for(int index = 0; index < str.length(); index++){
            char currentChar = str.charAt(index);
            if(currentChar != ' '){
                currentWord.append(currentChar);
            }else{
                if(currentWord.length() >= maxLength){
                    maxLength = currentWord.length();
                    largestWord = currentWord.toString();
                }
            currentWord.setLength(0);
            }
        }

        // check last word
        if(currentWord.length() >= maxLength){
            largestWord = currentWord.toString();
        }
        return largestWord;
    }

}