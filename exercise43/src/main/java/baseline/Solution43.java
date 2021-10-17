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
import java.io.FileWriter;
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
        String name;
        String author;
        String choiceJS;
        String choiceCSS;
        String pathname;

        System.out.println("Site name: ");
        name = in.nextLine();

        pathname = "data\\website\\" + name;
        File directory = new File(pathname);

        if(!directory.mkdirs())
        {
            System.out.println("Directory Creation failed.");
        }


        System.out.println("Author: ");
        author = in.nextLine();

        System.out.println("Do you want a folder for JavaScript?");
        choiceJS = in.nextLine();

        if(choiceJS.equals("y"))
            jsFolder(pathname);

        System.out.println("Do you want a folder for CSS?");
        choiceCSS = in.nextLine();

        if(choiceCSS.equals("y"))
            cssFolder(pathname);

        createHTMLFile(name,author,pathname);

        String outputStatement = "Created ./website/";

        System.out.println(outputStatement+name);
        System.out.println(outputStatement+name+"/index.html");
        if(choiceJS.equals("y"))
            System.out.println(outputStatement+name+"/js/");

        if(choiceCSS.equals("y"))
            System.out.println(outputStatement+name+"/css/");
    }

    //Creates a folder inside the main folder called js
    private static void jsFolder(String path)
    {
        File jsFolderDir = new File(path + "\\js");

        if(!jsFolderDir.mkdirs())
        {
            System.out.println("Directory Creation failed.");
        }

    }

    //Creates a folder inside the main folder called css
    private static void cssFolder(String path)
    {
        File cssFolderDir = new File(path + "\\css");

        if(!cssFolderDir.mkdirs())
        {
            System.out.println("Directory Creation failed.");
        }
    }

    //Creates and writes to the index.html file and places it in the main folder
    public static void createHTMLFile(String siteName, String author, String path)
    {
        //Creates the html file and inserts the html code
        File htmlFile = new File(path+"\\index.html");
        try(FileWriter myWriter = new FileWriter(htmlFile))
        {
            if(!htmlFile.exists())
                System.out.println("File already exists");
            myWriter.write("<title>"+siteName+"</title><meta name=\"author\" content=\""+author+"\">");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
