package splitArray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

/** class SplitArrayTest, used to create some test cases */
public class SplitArrayTest {
    

    @Test
    public void splitArrayTestShouldBe3() {
        var operation = new Operation();
        int[] input = {1, 1, 1, 2, 1};

        assertEquals(3, operation.toSplitArray(input));

    }

    @Test
    public void splitArrayShouldThrowException() {
        Operation operation = new Operation();

        int[] input = {}; // empty input

        assertThrows(AssertionError.class, () -> {
            operation.toSplitArray(input);
        });
    }

    @Test
    public void splitArrayTest() {
        var operation = new Operation();
        int[] input = {2, 1, 1, 2, 1};

        assertEquals(-1, operation.toSplitArray(input));

    }

    @Test
    public void splitArrayTestShouldBe1() {
        var operation = new Operation();
        int[] input = {10, 10};

        assertEquals(1, operation.toSplitArray(input));

    }

}
