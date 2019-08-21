class BST
{
    private BSTNode root;

    public void put( int key, String value )
    {
        if ( root == null )
        {
            root = new BSTNode( key, value );
        }
        else
        {
            root.put( key, value );
        }
    }

    public String get( int key )
    {
        return root == null ? null : root.get( key );
    }
}


class BSTNode
{
    private int key;
    private String value;
    private BSTNode left, right;

    public BSTNode( int key, String value )
    {
        this.key = key;
        this.value = value;
    }

    //if key not found in BST then it is added. If jey already exists then that node's value
    //is updated.
    public void put( int key, String value )
    {
        if (  key < this.key )         
        {             
            if ( left != null )             
            {                 
                left.put( key, value );             
            }             
            else             
            {                 
                left = new BSTNode( key, value );             
            }         
        }         
        else if ( key > this.key)
        {
            if ( right != null )
            {
                right.put( key, value );
            }
            else
            {
                right = new BSTNode( key, value );
            }
        }
        else
        {
            //update this one
            this.value = value;
        }
    }

    //find Node with given key and return it's value
    public String get( int key )
    {
        if (  key == this.key )
        {
            return value;
        }

        if (  key < this.key )
        {
            return left == null ? null : left.get( key );
        }
        else
        {
            return right == null ? null : right.get( key );
        }
    }
}

public class BinarySerachTree {

    public static void main(String ... args){

        BST tree = new BST();
        tree.put( 2, "eff" );
        tree.put( 4, "sea" );
        tree.put( 8, "aye" );
        tree.put( 1, "eee" );
        tree.put( 3, "eye" );
        tree.put( 5, "aitch" );
        tree.put( 6, "zed" );
        
        System.out.println("Original node wiht key 2: " + tree.get(2));
        
        tree.put(2, "eye updated" );

        System.out.println("Modified node wiht key 2: " + tree.get(2));
    }

}
