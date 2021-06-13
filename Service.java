/*  Colin Smith
    CS 202
    Program 4 & 5
    Date: June 2nd, 2020
    Sources: None */

import java.util.Scanner;

// abstract base class, all similar data has been pushed up to here
public abstract class Service
{
    // protected data so extended classes can modify if need be
    protected String title;
    protected String description;
    protected Scanner input;

    public Service()
    {
        title = null;
        description = null;
        input = null;
    }

    // copy constructor that is called by the copy constructors of extended classes
    public Service(Service toCopy)
    {
        title = "";
        description = "";

        title = toCopy.title;
        description = toCopy.description;
        input = toCopy.input;
    }

    // all functions are abstract and implemented in the extended classes
    abstract public int create();
    abstract public void display();
    abstract public int compare(String check);
    abstract public int compare(Service check);
    abstract public void remove();
    abstract public int getType();
    abstract public void fileWrite();
    abstract public void listFileWrite();

}
