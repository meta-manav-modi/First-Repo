package fixXY;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** class FixXYTest, used to create test cases */
public class FixXYTest {
    @Test
    public void fixXYTest1() {
        var operation = new Operation();
        int[] input = {5, 4, 9, 4, 9, 5};
        int[] output = {9, 4, 5, 4, 5, 9};

        assertArrayEquals(output, operation.changedArray(input, 4, 5));
    }

      @Test
    public void splitArrayShouldThrowException() {
        Operation operation = new Operation();

        int[] input = {}; // empty input

        assertThrows(AssertionError.class, () -> {
            operation.changedArray(input, 0, 0);
        });
    }

    @Test
    public void fixXYTest2() {
        var operation = new Operation();
        int[] input = {1, 4, 1, 5};
        int[] output = {1, 4, 5, 1};

        assertArrayEquals(output, operation.changedArray(input, 4, 5));
    }

    @Test
    public void fixXYTest3() {
        var operation = new Operation();
        int[] input = {1, 4, 1, 5, 5, 4, 1};
        int[] output = {1, 4, 5, 1, 1, 4, 5};

        assertArrayEquals(output, operation.changedArray(input, 4, 5));
    }
}
