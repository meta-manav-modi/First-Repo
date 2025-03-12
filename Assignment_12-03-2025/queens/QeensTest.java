package queens;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** class QueensTest, used to create test cases */

public class QeensTest {
    @Test
    public void findNQueen1() {
        var operation = new Operation();
        int[][] output = {{ 0,  1,  0,  0},
                          { 0,  0,  0,  1},
                          { 1,  0,  0,  0},
                          { 0,  0,  1,  0}};

        assertArrayEquals(output, operation.nQueen(4));

    }
    @Test
    public void findNQueen2() {
        var operation = new Operation();
        int[][] output = {{1, 0, 0, 0, 0},
                          {0, 0, 1, 0, 0},
                          {0, 0, 0, 0, 1},
                          {0, 1, 0, 0, 0},
                          {0, 0, 0, 1, 0}}; 
        assertArrayEquals(output, operation.nQueen(5));
    }

    @Test
    public void findNQueen3() {
        Operation operation = new Operation();

        assertThrows(AssertionError.class, () -> {
            operation.nQueen(0);
        });
    }

    @Test
    public void findNQueen4() {
        Operation operation = new Operation();
        assertThrows(AssertionError.class, () -> {
            operation.nQueen(3);
        });
    }
    
}
