/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Marcelino Pozo
 */
/*
    PSUEDOCODE
    -Create a function called input which will take in user input
        -This input will be taken in through a scanner
    -Once the user enters something the function checkInventory will be called
        -If the function returns true the user input will be passed to a function
        called displayProduct
        -If checkInventory returns false, the user will be prompted to enter in new input
        this is accomplished through a while loop
    -If displayProduct is ran it will use the gson library to parse through and display the data
 */
package baseline;


import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution44 {

    //Driver function, calls input
    public static void main(String[] args) {
        input();

    }

    //Uses a scanner to take in input inside a while loop
    private static void input()
    {
        File file = new File("data\\exercise44_input.json");

        ArrayList<Product> productList = deserializeJson(jsonToString(file));

        try
        {
            Scanner userIn = new Scanner(System.in);
            String product;


            System.out.println("What is the product name?");
            product = userIn.nextLine();


            while(!checkInventory(productList,product))
            {
                System.out.println("Sorry, that product was not found in our inventory.");
                System.out.println("What is the product name?");
                product = userIn.nextLine();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    //Uses the fromJson() to convert the json file
    //Also uses the File class to grab the file
    //Is public only for testing
    public static boolean checkInventory(ArrayList<Product> products, String item)
    {
        for (Product product : products) {
            if (item.equals(product.getName())) {

                displayProduct(product);
                return true;
            }
        }

        return false;
    }

    //Uses the Gson class to create an object called product based off the date found in the json file
    public static ArrayList<Product> deserializeJson(ArrayList<String> jsonStrings)
    {
        Gson gson = new Gson();

        ArrayList<Product> products = new ArrayList<>();

        for (String jsonString : jsonStrings) {
            products.add(gson.fromJson(jsonString, Product.class));
        }

        return products;
    }

    //Converts the json file into json strings in an arrayList of strings
    private static ArrayList<String> jsonToString(File file)
    {
        ArrayList<String> jsonStrings = new ArrayList<>();

        try(Scanner fileIn = new Scanner(file))
        {
            fileIn.nextLine();
            fileIn.nextLine();

            String json;

            json = fileIn.nextLine();
            jsonStrings.add(json.substring(0,json.length()-1));
            json = fileIn.nextLine();
            jsonStrings.add(json.substring(0,json.length()-1));
            json = fileIn.nextLine();
            jsonStrings.add(json);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return jsonStrings;
    }

    //Displays the data
    private static void displayProduct(Product item)
    {
        System.out.println("Name: "+item.getName());
        System.out.println("Price: "+item.getPrice());
        System.out.println("Quantity: "+item.getQuantity());
    }
}
