package loopInList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;


public class LoopInListTest {

    @Test
    public void loopInLinkedListTest(){
        LoopInList list = new LoopInList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.createLoop(2);
        assertTrue(list.isLoopDetected());
    }

    @Test
    public void loopInLinkedListTest1(){
        LoopInList list = new LoopInList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.createLoop(7);
        assertFalse(list.isLoopDetected());
    }
}
