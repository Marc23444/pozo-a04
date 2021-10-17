/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Marcelino Pozo
 */
/*
    PSUEDOCODE
    -First we have a function called fileIn that takes in the file as a string using a scanner
        -This string is then split at each space to create a list of words
    -This list of words is then sent to a function called checkWords which will keep track of the
    total number of each word
        -It will do this using maps, each word will be a key and the number of times that word appears
        will be the value
    -This data is then sent to a function called output
        -The data is then displayed as a histogram after being converted to a list of keys and values
 */
package baseline;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Solution46 {

    //Driver function runs fileIn
    public static void main(String[] args) {
        fileIn();
    }

    private static void fileIn()
    {
        //Opens the file
        File file = new File("data\\exercise46_input.txt");
        String words = "";

        //Uses a try catch block to scan through and read the data
        try(Scanner fileScan = new Scanner(file))
        {
            while(fileScan.hasNextLine())
                words += fileScan.nextLine();
            String[] wordList = words.split(" ");

            output(checkWords(wordList));


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

    //Returns a map of strings and integers, uses a for loop to update the map
    public static Map<String,Integer> checkWords(String[] words)
    {
        //Creates a hashMap called unique words
        HashMap<String,Integer> uniqueWords = new HashMap<>();

        //Uses a forEach to check each word in the words array and adds them to the map
        for (String word : words) {

            if (uniqueWords.containsKey(word)) {
                uniqueWords.put(word, uniqueWords.get(word) + 1);

            } else {
                uniqueWords.put(word, 1);
            }


        }
        return uniqueWords;

    }

    //Will display data as a histogram, takes in a HashMap and converts it into 2 Lists in order to properly display the data
    private static void output(Map<String,Integer> wordMap)
    {
        //Turns the hashmap wordmap into a list that can be traversed in a foreach loop. It then sorts it
        List<Map.Entry<String,Integer>> list = new ArrayList<>(wordMap.entrySet());
        list.sort(Map.Entry.comparingByValue());

        List<String> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        //Fills the key and value lists
        for(Map.Entry<String,Integer> entry : list)
        {
            keys.add(entry.getKey());
            values.add(entry.getValue());
        }

        //Displays the lists as histograms
        for (int i = 2; i >=0; i--)
        {
            System.out.print(keys.get(i)+": ");
            for (int j = 0; j < values.get(i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }



    }


}
