import baseline.Solution46;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


class Solution46Test {

    @Test
    //Tests the checkWords function
    void checkWordsTest()
    {
        //Creates a new object for the class
        Solution46 testObject = new Solution46();

        //Creates an array of strings to pass through and test
        String[] testArray = {"a","a","c","b","c"};
        //This testMap will be set by the checkWords function, it will be compared to the correctMap
        Map<String, Integer> testMap;
        //Setting up correctMap
        HashMap<String,Integer> correctMap = new HashMap<>();
        correctMap.put("a",2);
        correctMap.put("c",2);
        correctMap.put("b",1);

        //Running the function
        testMap = testObject.checkWords(testArray);
        //Testing if the maps are equal
        Assertions.assertEquals(correctMap,testMap);
    }
}