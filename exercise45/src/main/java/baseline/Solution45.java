/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Marcelino Pozo
 */
/*
    PSUEDOCODE
    -Create a function called fileIn that takes in the file a single string
        -The user will enter the name of the file
        -A try catch block will be used to make sure the file exists
    -Then split that string at each space character creating an array of strings
    -Pass that string array to a function called checkString that looks for all
    occurrences of the word utilize and replaces them with the word use
    -Then pass that modified array to a function called fileOut
    -Finally write this modified string array to a new file called "exercise45_output.txt"
 */
package baseline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution45 {


    //Driver function, calls fileIn
    public static void main(String[] args) {
        fileIn();
    }

    //Uses the File class and a scanner to copy the data from the file
    //It will then use regex to split the string into an array of strings
    private static void fileIn()
    {
        //Creates a scanner to take in data from the user
        Scanner userScan = new Scanner(System.in);
        String data = "";

        System.out.println("Enter file name:");
        File file = new File("data\\"+userScan.nextLine()+".txt");

        try(Scanner fileScan = new Scanner(file)){

            while(fileScan.hasNextLine())
                data += fileScan.nextLine();

            String[] dataArray = data.split(" ");

            fileOut(checkString(dataArray));
        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    //Checks each word in the string and looks for the string "utilize", replaces every
    //instance of utilize with use
    public static String[] checkString(String[] words)
    {
        //Goes through each word in the string and replaces utilize with use
        for (int i = 0; i < words.length; i++) {

            if(words[i].contains("utilize"))
            {
                //If utilize is in brackets
                if(words[i].startsWith("\""))
                {
                    words[i] = "\"use\"";
                }
                //Iff utilize ends with an s
                else if(words[i].endsWith("s"))
                {
                    words[i] = "uses";
                }
                else
                {
                    words[i] = "use";
                }
            }
        }

        return words;
    }

    //Creates a new file called "exercise45_output.txt" and writes to it
    private static void fileOut(String[] words)
    {
        //Creates a file Writer called myWriter to write to the file
        try(FileWriter myWriter = new FileWriter("data\\exercise45_output.txt")){

            File output = new File("data\\exercise45_output.txt");

            //Checks if the file exists
            if(!output.createNewFile())
            {
                System.out.println("File already exists");
            }

            //Writes all the data to the file
            for (String word : words) {

                myWriter.write(word + " ");
            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
