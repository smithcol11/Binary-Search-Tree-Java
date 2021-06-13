/*  Colin Smith
    CS 202
    Program 4 & 5
    Date: June 2nd, 2020
    Sources: None */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// derived from Service class which holds the base and similar information
public class Chore extends Service
{
    // type of chore to be done
    protected String type;

    public Chore()
    {
        type = null;
    }

    // copy constructor that is used to copy the data of passed objects into tree
    public Chore(Chore toCopy)
    {
        super(toCopy);
        type = "";
        type = toCopy.type;
    }

    // called from main to create the object's data
    public int create()
    {
        input = new Scanner(System.in);
        title = "";
        description = "";
        type = "";

        System.out.println("Please enter a title. ");
        title = input.nextLine();
        System.out.println("Enter a description. ");
        description = input.nextLine();
        System.out.println("Enter a type. ");
        type = input.nextLine();
        return 1;
    }

    // displays the current node's data
    public void display()
    {
        if(title == null)
        {
            return;
        }
        System.out.println("Chore");
        System.out.println("    Title: " + title);
        System.out.println("    Description: " + description);
        System.out.println("    Type: " + type + "\n");
    }

    // will compare the title with the passed string and return an int
    public int compare(String check)
    {
        if(title.equals(check))
        {
            return 0;
        }
        else if(title.compareTo(check) < 0)
        {
            return 1;
        }
        else if(title.compareTo(check) > 0)
        {
            return -1;
        }
        return 0;
    }

    // will compare the title of this object to the title of the passed
    public int compare(Service check)
    {
        if(title.equals(check.title))
        {
            return 0;
        }
        else if(title.compareTo(check.title) < 0)
        {
            return 1;
        }
        else if(title.compareTo(check.title) > 0)
        {
            return -1;
        }
        return 0;
    }

    // removes the current data, is determined by compare function
    public void remove()
    {
        if (title != null)
        {
            title = null;
            description = null;
            type = null;
        }
    }

    public int getType()
    {
        return 0;
    }

    // writes to file and returns to tree
    public void fileWrite()
    {
        try(FileWriter writeOut = new FileWriter("writeOut.txt", true))
        {
            writeOut.write("Chore\n");
            writeOut.write("    Title:  " + title + "\n");
            writeOut.write("    Description:  " + description + "\n");
            writeOut.write("    Type:  " + type + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // writes to file and returns to tree
    public void listFileWrite()
    {
        try(FileWriter writeOut = new FileWriter("ListOut.txt", true))
        {
            writeOut.write("Chore\n");
            writeOut.write("    Title:  " + title + "\n");
            writeOut.write("    Description:  " + description + "\n");
            writeOut.write("    Type:  " + type + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
