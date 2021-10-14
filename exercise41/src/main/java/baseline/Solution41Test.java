package baseline;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class Solution41Test {

    @Test
    void sortTest() {

        Solution41 testObject = new Solution41();

        ArrayList<String> testList = new ArrayList<>();

        testList.add("Ling, Mai");
        testList.add("Johnson, Jim");
        testList.add("Zarnecki, Sabrina");
        testList.add("Jones, Chris");
        testList.add("Jones, Aaron");
        testList.add("Swift, Geoffrey");
        testList.add("Xiong, Fong");

        ArrayList<String> correctList = new ArrayList<>();
        correctList.add("Johnson, Jim");
        correctList.add("Jones, Aaron");
        correctList.add("Jones, Chris");
        correctList.add("Ling, Mai");
        correctList.add("Swift, Geoffrey");
        correctList.add("Xiong, Fong");
        correctList.add("Zarnecki, Sabrina");

        //Make the sort function public and non static to test
        //testList = testObject.sort(testList);

        assertEquals(correctList,testList);




    }
}