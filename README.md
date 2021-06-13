# Binary-Search-Tree-Java
A Binary Search Tree that utilizes abstract classes in Java. For my Data Structures class; this program I had to work in Java as opposed to C++. So, this was a great challenge to convert my current knowledge of BSTs and apply them in a new syntax. This program abstractly hold services in an array, similar to a notice board. This data is also written to file for later reading.

## Code Snippets
> Service.java, the abstract base class.
```java
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
```
> Node.java 
```java
public class Node
{
    // private data that the setters and getters modifies
    private Node left;
    private Node right;
    public Service entry;

    // constructor when new is called
    public Node()
    {
        entry = null;
        left = null;
        right = null;
    }

    // return the left pointer of passed node
    public Node getLeft()
    {
        return left;
    }

    // returns the right pointer of passed node
    public Node getRight()
    {
        return right;
    }

    // sets the left pointer to the passed node
    public void setLeft(Node left)
    {
        this.left = left;
    }

    // sets the right pointer to the passed node
    public void setRight(Node right)
    {
        this.right = right;
    }
}
```
