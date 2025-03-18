package mirrorArray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

/** class MaxMirrorTest, used to create some test cases */
public class MaxMirrorTest {
    

    @Test
    public void splitArrayTest() {
        var operation = new Operation();
        int[] input = {1, 2, 3, 8, 9, 3, 2, 1};

        assertEquals(3, operation.maxMirror(input));

    }

    @Test
    public void splitArrayShouldThrowException() {
        Operation operation = new Operation();

        int[] input = {}; // empty input

        assertThrows(AssertionError.class, () -> {
            operation.maxMirror(input);
        });
    }

    @Test
    public void splitArrayTestShouldBe2() {
        var operation = new Operation();
        int[] input = {1, 2, 1, 4};

        assertEquals(3, operation.maxMirror(input));

    }

    @Test
    public void splitArrayTestShouldBe1() {
        var operation = new Operation();
        int[] input = {7, 1, 4, 9, 7, 4, 1};

        assertEquals(2, operation.maxMirror(input));

    }

    @Test
    public void splitArrayTestShouldBe7() {
        var operation = new Operation();
        int[] input = {1, 4, 5, 3, 5, 4, 1};

        assertEquals(7, operation.maxMirror(input));

    }

}
