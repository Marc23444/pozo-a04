/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Marcelino Pozo
 */
/*
    PSUEDOCODE
    -Read in the data of the file using the scanner class
    -This operation is done in a function called input
    -Then that data is taken as an arrayList of strings and brought to a function called sort
        -The data will be sorted using nested for loops, a brute force method
    -The sorted array is then passed to an output function that will write the list in a tabular format
 */
package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution41 {

    //Driver class, will call input
    public static void main(String[] args) {
        input();
    }

    //Takes in input from a file and sends that data too sort
    private static void input()
    {
        ArrayList<String> names = new ArrayList<>();

        File input;
        input = new File("data\\exercise41_input.txt");


        try{

            Scanner in = new Scanner(input);

            while (in.hasNextLine())
                names.add(in.nextLine());

            in.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        output(sort(names));


    }

    //Sorts the data using a nested for loop and sends the sorted data to output
    //THIS IS ONLY PUBLIC IN THE FIRST COMMIT FOR TESTING PURPOSES
    private static ArrayList<String> sort(ArrayList<String> list)
    {
        String temp;
        for (int i = 0; i < list.size() ; i++) {

            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    // swapping
                    temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }


        return list;
    }

    //Displays the data in a tabular format
    private static void output(ArrayList<String> sortedList)
    {
        //Try catch block is used to write to the file using a FileWriter
        try
        {
            FileWriter myWriter = new FileWriter("data\\exercise41_output.txt");
            myWriter.write("Total of "+sortedList.size()+" names\n-----------------\n");

            for (String s : sortedList) {
                myWriter.write(s+"\n");
            }
            myWriter.close();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
