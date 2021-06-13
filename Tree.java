/*  Colin Smith
    CS 202
    Program 4 & 5
    Date: May 27th, 2020
    Sources: None */

// tree class to manage the BST
public class Tree
{
    private Node root; // node which begins at root

    public Tree()
    {
        root = null;
    } // constructor to set root to null when new is called

    // Wrapper functions for the private recursive functions below ********************************
    // inserts a new node and extended object to the tree
    public int insert(Service toAdd, int place)
    {
        if(toAdd == null)
        {
            return 0;
        }
        root = insert(root, toAdd, place);
        return 1;
    }

    // will retrieve and send an object back to the calling routine
    public Service retrieve(String toFind)
    {
        if(root == null)
        {
            return null;
        }
        return retrieve(root, toFind);
    }

    // displays the passed title, will call compare functions
    public int display(String toShow)
    {
        if(root == null)
        {
            return 0;
        }
        return display(root, toShow);
    }

    // removes the passed title, also calls compare functions
    public int remove(String toDel)
    {
        if(root == null)
        {
            return 0;
        }
        root = remove(root, toDel);
        return 1;
    }

    // displays all data in the tree
    public int displayAll()
    {
        if(root == null)
        {
            return 0;
        }
        return displayAll(root);
    }

    // will remove all the data from the tree
    public int removeAll()
    {
        if(root == null)
        {
            return 0;
        }
        root = removeAll(root);
        return 1;
    }

    // this calls the recursive fileWrite function, traverses tree and appends file
    public void fileWrite()
    {
        fileWrite(root);
    }

    // Recursive functions from wrappers above ****************************************************
    // inserts a new node and extended object to the tree
    private Node insert(Node root, Service toAdd, int place)
    {
        if(root == null)
        {
            root = new Node();
            root.setLeft(null);
            root.setRight(null);
            if(place == 1)
            {
                root.entry = new Errand((Errand) toAdd);
            }
            else if(place == 2)
            {
                root.entry = new Chore((Chore) toAdd);
            }
            return root;
        }
        int direction = root.entry.compare(toAdd);
        if(direction < 0)
        {
            root.setLeft(insert(root.getLeft(), toAdd, place));
        }
        else
        {
            root.setRight(insert(root.getRight(), toAdd, place));
        }
        return root;
    }

    // will retrieve and send an object back to the calling routine
    private Service retrieve(Node root, String toFind)
    {
        if(root == null)
        {
            return null;
        }
        int match = root.entry.compare(toFind);
        if(match == 0)
        {
            return root.entry;
        }
        else if(match < 0)
        {
            return retrieve(root.getLeft(), toFind);
        }
        else {
            return retrieve(root.getRight(), toFind);
        }
    }

    // displays the passed title, will call compare functions
    private int display(Node root, String toShow)
    {
        if(root == null)
        {
            return 0;
        }
        int match = root.entry.compare(toShow);
        if(match == 0)
        {
            root.entry.display();
            return 1;
        }
        else if(match < 0)
        {
            return display(root.getLeft(), toShow);
        }
        else
        {
            return display(root.getRight(), toShow);
        }
    }

    // removes the passed title, also calls compare functions
    private Node remove(Node root, String toDel)
    {
        if(root == null)
        {
            return null;
        }
        int direction = root.entry.compare(toDel);
        if(direction < 0)
        {
            root.setLeft(remove(root.getLeft(), toDel));
        }
        else if(direction > 0)
        {
            root.setRight(remove(root.getRight(), toDel));
        }
        else // all different remove cases
        {
            if(root.getLeft() == null && root.getRight() == null)
            {
                return null;
            }
            else if(root.getLeft() != null && root.getRight() == null)
            {
                root = root.getLeft();
                return root;
            }
            else if(root.getLeft() == null && root.getRight() != null)
            {
                root = root.getRight();
                return root;
            }
            else if(root.getLeft() != null && root.getRight().getLeft() == null)
            {
                Node temp = root;
                root = root.getRight();
                root.setLeft(temp.getLeft());
                return root;
            }
            else if(root.getLeft() != null && root.getRight() != null)
            {
                Node temp = root;
                Node current = root.getRight();
                Node prev = current;
                while(current.getLeft() != null)
                {
                    prev = current;
                    current = current.getLeft();
                }
                root = current;
                root.setLeft(temp.getLeft());
                root.setRight(temp.getRight());
                prev.setLeft(current.getRight());
                return root;
            }
        }
        return root;
    }

    // displays all data in the tree
    private int displayAll(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        displayAll(root.getLeft());
        root.entry.display();
        displayAll(root.getRight());
        return 1;
    }

    // will remove all the data from the tree
    private Node removeAll(Node root)
    {
        if(root == null)
        {
            return null;
        }
        root.setLeft(removeAll(root.getLeft()));
        root.setRight(removeAll(root.getRight()));
        root.entry.remove();
        return null;
    }

    // traverses tree and appends file
    private void fileWrite(Node root)
    {
        if(root == null)
        {
            return;
        }
        fileWrite(root.getLeft());
        root.entry.fileWrite();
        fileWrite(root.getRight());
    }
}
