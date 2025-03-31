package subList;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**class subListTest, used to perform all the test cases of functions */
public class subListTest {
    @Test
    public void rotateSubListTest(){
        SubListWithRotate list = new SubListWithRotate();
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);

        list.rotateSubList(2, 5, 2);
        assertEquals("2->5->6->3->4->7->NULL", list.display());
    }

    @Test
    public void rotateSubListTest1(){
        SubListWithRotate list = new SubListWithRotate();
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);

        list.rotateSubList(1, 5, 1);
        assertEquals("6->2->3->4->5->7->NULL", list.display());
    }


    @Test
    public void rotateSubListTest2(){
        SubListWithRotate list = new SubListWithRotate();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        list.rotateSubList(1, 2, 1);
        assertEquals("2->1->3->NULL", list.display());
    }
}
