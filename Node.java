/*  Colin Smith
    CS 202
    Program 4 & 5
    Date: May 27th, 2020
    Sources: None */

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
