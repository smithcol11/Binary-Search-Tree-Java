/*  Colin Smith
    CS 202
    Program 4 & 5
    Date: June 2nd, 2020
    Sources: None */

import java.util.Scanner;

public class App
{
    // main method
    public static void main(String[] args)
    {
        // all variable and object that will be used in main are listed below!
        int choice = -1;
        int place;
        int result = 1;
        Scanner inputInt = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);
        String name;
        Errand errand;
        Chore chore;
        Tree tree = new Tree();
        Array list = new Array();

        System.out.println("\nWelcome to my trash Java program!");
        System.out.println("Select options from the menus below to modify service listings.\n");

        // while loop so the user can drive the menu
        while(choice != 0)
        {
            System.out.println("Select an option. To exit, type '0'. \n");
            System.out.println("    Add Entry:      (1)");
            System.out.println("    Retrieve Entry: (2)");
            System.out.println("    Display Entry:  (3)");
            System.out.println("    Remove Entry:   (4)");
            System.out.println("    Display All:    (5)");
            System.out.println("    Remove All:     (6)");
            System.out.println("    DONE:           (0)");
            choice = inputInt.nextInt();

            // will add a new service to the entries and BST
            if(choice == 1)
            {
                System.out.println("Which type of service would you like to add?");
                System.out.println("    Errand (1)");
                System.out.println("    Chore  (2)");
                place = inputInt.nextInt();
                if(place == 1)
                {
                    errand = new Errand();
                    result = errand.create();
                    result += tree.insert(errand, place);
                }
                else if(place == 2)
                {
                    chore = new Chore();
                    result = chore.create();
                    result += tree.insert(chore, place);
                }
                if(result == 0)
                {
                    System.out.println("Unable to add data!\n");
                }
            }
            // retrieves an object and sends it back here to main
            else if(choice == 2)
            {
                System.out.println("What is the name of the service you would like to find?");
                name = inputStr.nextLine();
                Service temp = tree.retrieve(name);
                if(temp == null)
                {
                    System.out.println("Unable to locate specified service by that title.\n");
                }
                else
                {
                    System.out.println("Data found!\n");
                    temp.display();
                }
            }
            // will display an object's data by title name
            else if(choice == 3)
            {
                System.out.println("What is the name of the service you would like to display?");
                name = inputStr.nextLine();
                result = tree.display(name);
                if(result == 0)
                {
                    System.out.println("Unable to find and display that service by title.\n");
                }
            }
            // removes an object's data and node by title name
            else if(choice == 4)
            {
                System.out.println("What is the name of the entry you would like to remove?");
                name = inputStr.nextLine();
                if(tree.remove(name) == 0)
                {
                    System.out.println("Entry not located, unable to remove.\n");
                }
                else
                {
                    System.out.println("Entry removed!\n");
                }
            }
            // displays all data in tree
            else if(choice == 5)
            {
                if(tree.displayAll() == 0)
                {
                    System.out.println("No data to display.\n");
                }
            }
            // removes all data in tree
            else if(choice == 6)
            {
                if(tree.removeAll() == 0)
                {
                    System.out.println("No data to remove.\n");
                }
                else
                {
                    System.out.println("All data has been eradicated.\n");
                }
            }
        }

        choice = -1;
        System.out.println("\nNow, search the existing tree and add it to the list.");
        System.out.println("This will be appended to a file when done. \n");
        while(choice != 0)
        {
            System.out.println("What would you like to do?");
            System.out.println("    Search tree and add to list (1)");
            System.out.println("    Display all in list         (2)");
            System.out.println("    EXIT                        (0)");
            choice = inputInt.nextInt();
            if(choice == 1)
            {
                System.out.println("Which entry would you like to find? Search by title.");
                name = inputStr.nextLine();
                Service temp = tree.retrieve(name);
                if(temp != null)
                {
                    list.insert(temp);
                }
            }
            else if(choice == 2)
            {
                list.displayAll();
            }
        }

        // calls a wrapper function to then recursively navigate tree and write to file
        tree.fileWrite();
        list.fileWrite();
    }

}
