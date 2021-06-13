/*  Colin Smith
    CS 202
    Program 4 & 5
    Date: June 2nd, 2020
    Sources: None */

// node class for the array of linear linked lists
public class NodeL
{
    private NodeL next;
    public Service post;

    // constructor
    public NodeL()
    {
        next = null;
        post = null;
    }

    // getter for the next node
    public NodeL getNext()
    {
        return next;
    }

    // sets the next node if needed
    public void setNext(NodeL next)
    {
        this.next = next;
    }
}
