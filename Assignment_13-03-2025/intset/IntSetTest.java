package intset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/** class IntSetTest, used to create test cases */
public class IntSetTest {
    

    @Test
    public void sizeTest() {
        int[] input = {1,2,3,4,5};
        IntSet is = new IntSet(input);

        assertEquals(5, is.size());

    }
    @Test
    public void unionTest() {
        int[] input = {1,2,3};
        int[] input1 = {6,7,8};
        IntSet set1 = new IntSet(input);
        IntSet set2 = new IntSet(input1);

        IntSet unionSet = set1.union(set2);
        int[] output = {1, 2, 3, 6, 7, 8, };
        assertArrayEquals(output, unionSet.getSet());

    }

    @Test
    public void intersectionTest() {
        int[] input = {1,2,3,4};
        int[] input1 = {4,6,7,8};
        IntSet set1 = new IntSet(input);
        IntSet set2 = new IntSet(input1);

        IntSet intersectionSet = set1.intersection(set2);
        int[] output = {4,};
        assertArrayEquals(output, intersectionSet.getSet());

    }

    @Test
    public void differenceTest() {
        int[] input = {1,2,3,4};
        int[] input1 = {4,6,7,8};
        IntSet set1 = new IntSet(input);
        IntSet set2 = new IntSet(input1);

        IntSet differenceSet = set1.difference(set2);
        int[] output = {1,2,3,};
        assertArrayEquals(output, differenceSet.getSet());

    }

    

    @Test
    public void testIsSubset(){
        IntSet set1 = new IntSet(new int[]{1,2,3,4,5});
        IntSet set2 = new IntSet(new int[]{1,2,3});
        IntSet set3 = new IntSet(new int[]{1,2,3,7,8});

        assertTrue(set1.isSubset(set2));
        assertFalse(set1.isSubset(set3));
    }

    @Test
    public void testIsMember(){
        IntSet set1 = new IntSet(new int[]{1,2,3,4,5});

        assertTrue(set1.isMemeber(1));
        assertFalse(set1.isMemeber(9));
    }



}
