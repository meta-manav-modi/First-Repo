package convertor;

/** Calculator class to perform methods like
 * check comparity ( greater, less and equal to)
 * convert hexadecimal to decimal 
 * convert decimal to headecimal
 */

public class Calculator{
     
    // Function to check greater than operation :
    public boolean greaterTo(String value1, String value2){
        if(hexaToDeci(value1) > hexaToDeci(value2)){
            return true;
        }else{
            return false;
        }
    }

    // Function to check Less than operation :
    public boolean equalTo(String value1, String value2){
        if(hexaToDeci(value1) == hexaToDeci(value2)){
            return true;
        }else{
            return false;
        }
    }

    // Function to check Eual to operation :
    public boolean lessTo(String value1, String value2){
        if(hexaToDeci(value1) < hexaToDeci(value2)){
            return true;
        }else{
            return false;
        }
    }

    // Function to convert hexadecimal to decimal :
    public int hexaToDeci(String value){
        int result = 0;
        int base = 1;
        int len = value.length();

        // loop condition
        for( int index = len -1; index >= 0; index-- ){
            if(value.charAt(index) >= '0' && value.charAt(index) <= '9'){
                result += (value.charAt(index) - 48) * base;
                base = base * 16;
            }
            else if(value.charAt(index) >= 'A' && value.charAt(index) <= 'F'){
                result += (value.charAt(index) - 55) * base;
                base = base * 16;
            }
        }
        return result;
    }

    // Function to Convert Decimal To Hexadecimal
    public String deciToHeca(int value){
        String result = "";
        int[] hexaValue = new int[100];
        int index=0;
        while(value != 0 ){
              hexaValue[index] = value % 16;
              value = value / 16;
              index++;
        }

        for (int j = index - 1; j >= 0; j--) {
            if (hexaValue[j] > 9)
                result += (char)(55 + hexaValue[j]);
            else
                result += hexaValue[j];
        }
    return result;
    }
}