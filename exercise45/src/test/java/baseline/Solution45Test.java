package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution45Test {

    @Test
    void checkString() {
        Solution45 test = new Solution45();

        String[] testString = {"use","utilize","utilize"};
        String[] finalString = {"use","use","use"};



        testString = test.checkString(testString);


        assertArrayEquals(finalString,testString);
    }
}