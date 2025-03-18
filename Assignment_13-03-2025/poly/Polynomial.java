package poly;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/** class Polynomial , to perform all operations like
 * add and multiply two polynomials
 * get degree and execute methods also
 */
public class Polynomial {
    private List<Term> terms;
    public Polynomial(List<Term> terms) {
        this.terms = new ArrayList<>();
        for (Term term : terms) {
            if (term.getCofficient() != 0) {
                this.terms.add(term);
            }
        }
        Collections.sort(this.terms, (a, b) -> Integer.compare(b.getExponent(), a.getExponent()));
    }

    /**
     * Method execute, calculate result after doing all calculation
     * @ param float value
     */

    public float evaluate(float value) {
        float result = 0;
        for (Term term : terms) {
            result += term.getCofficient() * Math.pow(value, term.getExponent());
        }
        return result;
    }

    // /**
    //  * Method degree, return the degree of polynomial
    //  */
    public int degree() {
        if (terms.isEmpty()) {
            return -1;
        }
        return terms.get(0).getExponent();
    }

    /**
     * Method addPoly, return the resulted collficient array after adding
     * @ param coggicient array of two polunomials
     */
    public static Polynomial addPoly(Polynomial p1, Polynomial p2) {

        List<Term> res = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        while (index1 < p1.terms.size() && index2 < p2.terms.size()) {
            Term term1 = p1.terms.get(index1);
            Term term2 = p2.terms.get(index2);

            if (term1.getExponent() == term2.getExponent()) {
                res.add(new Term(term1.getCofficient() + term2.getCofficient(), term1.getExponent()));
                index1++;
                index2++;
            } else if (term1.getExponent() > term2.getExponent()) {
                res.add(new Term(term1.getCofficient(), term1.getExponent()));
                index1++;
            } else {
                res.add(new Term(term2.getCofficient(), term2.getExponent()));
                index2++;
            }
        }

        while (index1 < p1.terms.size()) {
            res.add(p1.terms.get(index1));
            index1++;

        }
        while (index2 < p2.terms.size()) {
            res.add(p2.terms.get(index2));
            index2++;
        }

        return new Polynomial(res);
    }

    /**
     * Method multiplyPoly, return the resulted collficient array after multiplying
     * @ param coggicient array of two polunomials
     */
    public static Polynomial multiplyPoly(Polynomial p1, Polynomial p2){
        List<Term> res = new ArrayList<>();
        for(Term term1 : p1.terms){
            for(Term term2 : p2.terms){
                int newExponent = term1.getExponent() + term2.getExponent(); 
                int newCoff = term1.getCofficient() * term2.getCofficient();

                boolean found = false;
                for(Term resTerm : res){
                    if(resTerm.getExponent() == newExponent){
                        resTerm = new Term(resTerm.getCofficient() + newCoff, resTerm.getExponent());
                        found = true;
                        break;
                    }
                }
                if(!found){
                    res.add(new Term(newCoff,newExponent));
                }
            }
        }
        Collections.sort(res,(a,b) -> Integer.compare(a.getExponent(),b.getExponent()));
        return new Polynomial(res);
    }

    /** to return the complete polunomail with its expression format */
    public String toString(){
        if(terms.isEmpty()){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int index1 = 0;index1 < terms.size(); index1++){
            Term term = terms.get(index1);
            if(term.getCofficient() > 0 && index1>0){
                sb.append(" + ");
            }
            sb.append(term.getCofficient());
            if(term.getExponent() != 0){
                sb.append("x^").append(term.getExponent());
            }
        }
        return sb.toString();
    }
}
