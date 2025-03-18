package lcmhcf;

/** class Operation, is to perform findLcm and findHcf methods
 * and return the lcm and hcf of two numbers
 */

public class Operation {

    /** method findLcm, return the lcm of two numbers
     * @ param teo numbers x and y
     */
    public int findLcm(int x, int y, int maximum){
        if (maximum % x == 0 && maximum % y == 0)
            return maximum;
        else
            return findLcm(x, y, maximum + Math.max(x, y));
    }

    /** method findHcf, return the hcf of two numbers
     * @ param teo numbers x and y
     */
    public int findHcf(int x, int y){
        if (x == 0)
            return y;
        if (y == 0)
            return x;

        // Base case
        if (x == y)
            return x;

        if (x > y)
            return findHcf(x - y, y);
        return findHcf(x, y - x);
    }
}
