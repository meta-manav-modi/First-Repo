package polynomial;

import java.util.ArrayList;
import java.util.List;

/** class Polynomial , maintain nested list having all the values
 * nd performing the method to find the degree of the polunomial
 */
public class Polynomial {
    private List<List<Object>> terms;

    public Polynomial(){
        this.terms = new ArrayList<>();
    }

    /** method addTerm, used to add cofficient, and nested list of variables to terms
     * @ param, int cofficient
     * @ param nested list havig variables and its specific exponents
     */
    public void addTerm(int cofficient, List<List<Object>> variables){
        List<Object> term = new ArrayList<>();
        term.add(cofficient);
        term.add(variables);
        terms.add(term);
    }

    /** method getDegree, used to find the degree of the polynomial
     * @ return degree of the polynomial 
     */
    public int getDegree(){
        int maxDegree = 0;
        for(List<Object> term : terms){
            List<List<Object>> variables = (List<List<Object>>) term.get(1);
            int degree = 0;
            for(List<Object> var : variables){
                degree += (int) var.get(1);
            }
            if(degree > maxDegree){
                maxDegree = degree;
            }
        }
        return maxDegree;
    }

    @Override
    public String toString(){
        return terms.toString();
    }
}
