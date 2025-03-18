package clump;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

/** class ClumpTest, used to create test cases */
public class ClumpTest {
    

    @Test
    public void splitArrayTest() {
        var operation = new Operation();
        int[] input = {1, 2, 2, 3, 4, 4};

        assertEquals(2, operation.numClump(input));

    }

    @Test
    public void splitArrayShouldThrowException() {
        Operation operation = new Operation();

        int[] input = {}; // empty input

        assertThrows(AssertionError.class, () -> {
            operation.numClump(input);
        });
    }

    @Test
    public void splitArrayTestShouldBe2() {
        var operation = new Operation();
        int[] input = {1, 1, 2, 1, 1};

        assertEquals(2, operation.numClump(input));

    }

    @Test
    public void splitArrayTestShouldBe1() {
        var operation = new Operation();
        int[] input = {1, 1, 1, 1, 1};

        assertEquals(1, operation.numClump(input));

    }

}
