package search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

/** class SearchTest, used to create test cases */
public class SearchTest {
    

    @Test
    public void findLinearSearchTest1() {
        var operation = new Operation();
        int[] input = {1, 2, 7, 6, 5};

        assertEquals(4, operation.findLinearSearch(input,0, 6));

    }

    @Test
    public void findLinearSearchTest2() {
        var operation = new Operation();
        int[] input = {8, 12, 12, 13, 9};

        assertEquals(2, operation.findLinearSearch(input,0, 12));

    }

    @Test
    public void findLinearSearchTest() {
        Operation operation = new Operation();
        int[] input = {};

        assertThrows(AssertionError.class, () -> {
            operation.findLinearSearch(input,0, 0);
        });
    }

    @Test
    public void findBinarySearchTest() {
        Operation operation = new Operation();
        int[] input = {};

        assertThrows(AssertionError.class, () -> {
            operation.findBinarySearch(input,0, 0);
        });
    }

    @Test
    public void findBinarySearchTest1() {
        var operation = new Operation();
        int[] input = {1, 2, 5, 6, 7};

        assertEquals(4, operation.findBinarySearch(input,5, 6));

    }

    @Test
    public void findBinarySearchTest2() {
        var operation = new Operation();
        int[] input = {8, 9, 12, 12, 14};

        assertEquals(3, operation.findBinarySearch(input,5, 12));

    }

}
