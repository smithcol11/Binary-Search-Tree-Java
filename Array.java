/*  Colin Smith
    CS 202
    Program 4 & 5
    Date: June 2nd, 2020
    Sources: None */

// array of linear linked lists
public class Array
{
    // data members
    private final int size = 2;
    private NodeL[] head;

    // constructor, new NodeL of size
    public Array()
    {
        head = new NodeL[size];
    }

    // Wrapper functions for the private recursive functions below ********************************

    // passes in object retrieved from BST
    public void insert(Service toAdd)
    {
        insert(head, toAdd);
    }

    // displays all in the array of LLL
    public void displayAll()
    {
        if(head == null)
        {
            System.out.println("List is empty");
            return;
        }
        for(int i = 0; i < size; ++i)
        {
            displayAll(head[i]);
        }

    }

    // appends to the file after program finishes running
    public void fileWrite()
    {
        for(int i = 0; i < size; ++i)
        {
            fileWrite(head[i]);
        }
    }


    // Recursive functions from wrappers above ****************************************************

    // passes in object retrieved from BST to corrects array position
    private void insert(NodeL [] head, Service toAdd)
    {
        int type = toAdd.getType();
        if(type == 0)
        {
            head[0] = insertList(head[0], toAdd, type);
        }
        else
        {
            head[1] = insertList(head[1], toAdd, type);
        }
    }

    // creates new node and dynamically calls copy constructors
    private NodeL insertList(NodeL head, Service toAdd, int type)
    {
        if(head == null)
        {
            head = new NodeL();

            if(type == 1)
            {
                head.post = new Errand((Errand) toAdd);
            }
            else
            {
                head.post = new Chore((Chore) toAdd);
            }
            return head;
        }
        insertList(head.getNext(), toAdd, type);
        return head;
    }

    // displays all for the array of LLL
    private void displayAll(NodeL head)
    {
        if(head == null)
        {
            return;
        }
        head.post.display();
        displayAll(head.getNext());
    }

    // appends to end of the out file
    private void fileWrite(NodeL head)
    {
        if(head == null)
        {
            return;
        }
        head.post.listFileWrite();
        fileWrite(head.getNext());
    }
}
