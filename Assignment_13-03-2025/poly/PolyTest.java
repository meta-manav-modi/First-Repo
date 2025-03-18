package poly;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/** class PolyTest, used to create test cases */
public class PolyTest {
    

    @Test
    public void testEvaluate() {
        Polynomial poly = new Polynomial(Arrays.asList(new Term(3,2), new Term(2,1),new Term(1,0)));
        assertEquals(17, poly.evaluate(2), 0.001);

    }

    @Test
    public void testDegree() {
        Polynomial poly = new Polynomial(Arrays.asList(new Term(3,2), new Term(2,1),new Term(1,0)));
        assertEquals(2, poly.degree());

    }

    @Test
    public void testAddPolynomial() {
        Polynomial poly1 = new Polynomial(Arrays.asList(new Term(3,2), new Term(1,1)));
        Polynomial poly2 = new Polynomial(Arrays.asList(new Term(2,2), new Term(4,0)));
        Polynomial result = Polynomial.addPoly(poly1, poly2);
        assertEquals(10, result.evaluate(1), 0.001);

    }

    @Test
    public void testAddPolynomial1() {
        Polynomial poly1 = new Polynomial(Arrays.asList(new Term(0,2), new Term(0,1)));
        Polynomial poly2 = new Polynomial(Arrays.asList(new Term(0,2), new Term(0,0)));
        Polynomial result = Polynomial.addPoly(poly1, poly2);
        assertEquals(-1, result.degree());

    }

    @Test
    public void testMultiplyPolynomial() {
        Polynomial poly1 = new Polynomial(Arrays.asList(new Term(3,2), new Term(1,1)));
        Polynomial poly2 = new Polynomial(Arrays.asList(new Term(2,2), new Term(4,0)));
        Polynomial result = Polynomial.multiplyPoly(poly1, poly2);
        assertEquals(24, result.evaluate(1), 0.001);

    }

}
