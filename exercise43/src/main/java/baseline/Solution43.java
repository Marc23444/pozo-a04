/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Marcelino Pozo
 */
/*
    PSUEDOCODE
    -First input will be prompted and taken from the user using a scanner
        -This will happen in a function called input
    -A main folder will then be created using the file class.
    -If the user wants a folder for JavaScript files the function jsFolder will be called
        -The folder will be created using the File class
    -If the user wants a fold for CSS files the function cssFolder will be called
        -The folder will be created using the File class
    -Finally the function createHTMLFile will be called and the Site name and Author strings will be passed through
        -This method will use the File and FileWriter class to create and write to the .html file


 */
package baseline;

import java.io.File;
import java.util.Scanner;

public class Solution43 {

    //Driver function, used to run input
    public static void main(String[] args) {
        input();
    }

    //Takes input through a scanner, will call all other functions based on input
    private static void input()
    {
        Scanner in = new Scanner(System.in);
        String name, author, choice, pathname;



        System.out.println("Site name: ");
        name = in.nextLine();

        pathname = "data\\website\\" + name;
        File directory = new File(pathname);

        if(!directory.exists())
        {
            directory.mkdirs();
        }


        System.out.println("Author: ");
        author = in.nextLine();

        System.out.println("Do you want a folder for JavaScript?");
        choice = in.nextLine();

        if(choice.equals("y"))
            jsFolder(pathname);

        System.out.println("Do you want a folder for CSS?");
        choice = in.nextLine();

        if(choice.equals("y"))
            cssFolder(pathname);


    }

    //Creates a folder inside the main folder called js
    private static void jsFolder(String path)
    {
        File jsFolderDir = new File(path + "\\js");

        if(!jsFolderDir.exists())
            jsFolderDir.mkdirs();

    }

    //Creates a folder inside the main folder called css
    private static void cssFolder(String path)
    {
        File cssFolderDir = new File(path + "\\css");

        if(!cssFolderDir.exists())
            cssFolderDir.mkdirs();

    }

    //Creates and writes to the index.html file and places it in the main folder
    public static void createHTMLFile(String siteName, String author, String path)
    {
        
    }

}
