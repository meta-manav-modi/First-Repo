package poly;

/** class NodePoly, used to initialize the values
 * and have getters to get value and degree of object
 */
public class Term {
    private int value;
    private int exponent;

    Term(int value, int exponent){
        this.value = value;
        this.exponent = exponent;
    }

    public int getCofficient(){
        return value;
    }
    public int getExponent(){
        return exponent;
    }
}
