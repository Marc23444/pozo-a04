/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Marcelino Pozo
 */
/*
    **SINCE THIS PROGRAM ONLY TAKES IN AND PRINTS OUT DATA I DECIDED NOT TO CREATE
    ANY UNIT TESTING FOR IT**
    PSUEDOCODE
    -Read in the csv file using a scanner and the File class
        -Add each comma seperated line to an arrayList of strings
    -Send that list of strings to a function called output
    -Display the data in a tabular format
 */
package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution42 {

    //Driver function, will call input
    public static void main(String[] args) {
        input();
    }

    //Will use a scanner and a File class to take in the data
    private static void input()
    {
        ArrayList<String> data = new ArrayList<>();

        File input;
        input = new File("data\\exercise42_input.txt");


        //Try catch block to make sure the file exists
        try{

            Scanner in = new Scanner(input);
            String temp;

            while (in.hasNextLine())
            {
                temp = in.nextLine();
                String[] tokens = temp.split(",");

                for (int i = 0; i < tokens.length; i++)
                {
                    data.add(tokens[i]);
                }

            }


            in.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        output(data);

    }

    //Will display the data in a tabular format
    private static void output(ArrayList<String> list)
    {
        int count =0;
        System.out.println("Last      First     Salary");
        System.out.println("--------------------------");


        //Uses printf formatting too display the data
        for (int i = 0; i < list.size(); i++)
        {
            System.out.printf("%-12s",list.get(i));
            count++;
            if(count % 3 == 0)
            {
                System.out.println();
            }

        }
    }
}
