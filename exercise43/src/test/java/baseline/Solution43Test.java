package baseline;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


class Solution43Test {

    @Test
    void testCreateHTMLFile() {

        Solution43 testObj = new Solution43();

        //Creates the html file
        testObj.createHTMLFile("TestName","TestAuthor","data\\");

        File file = new File("data\\index.html");

        String fileData = "";
        String correctData = "<title>TestName</title><meta name=\"author\" content=\"TestAuthor\">";

        //Grabs all the data from the created HTML file
        try(Scanner fileIn = new Scanner(file))
        {
            while (fileIn.hasNextLine())
                fileData+= fileIn.nextLine();


        }catch (IOException e)
        {
            e.printStackTrace();
        }

        //Compares the data put into the file to the data that should be in the file
        Assertions.assertEquals(correctData,fileData);

    }
}