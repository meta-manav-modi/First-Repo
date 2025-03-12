package lcmhcf;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/** class LcmHcfTest, used to create test cases */
public class LcmHcfTest {
    

    @Test
    public void findLcmTest1() {
        var operation = new Operation();

        assertEquals(60, operation.findLcm(10, 12, 12));

    }
    @Test
    public void findLcmTest2() {
        var operation = new Operation();

        assertEquals(195, operation.findLcm(13, 15, 15));

    }

    @Test
    public void findHcfTest1() {
        var operation = new Operation();

        assertEquals(2, operation.findHcf(10, 12));

    }

    @Test
    public void findHcfTest2() {
        var operation = new Operation();

        assertEquals(1, operation.findHcf(13, 15));

    }

}
