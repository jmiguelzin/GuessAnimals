
package guessanimals;

public class BinaryTree {
    
    private Node root;
    
    
    public BinaryTree(String info){
        Node newRoot = new Node(info);
        this.root = newRoot;
        
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    public Node insertNodeLeft(Node node, String info){
        
        if (node.getLeft() == null){
            Node newNode = new Node(info);
            node.setLeft(newNode);
            return newNode;
        }
        
        return null;
        
    }   
    
    public Node insertNodeRight(Node node, String info){
        
        if (node.getRight() == null){
            Node newNode = new Node(info);
            node.setRight(newNode);
            return newNode;
        }
        
        return null;
        
    }    
    
    public void startGame(Node root){
        
    }
    
    public void loadGame(){
        BinaryTree tree = new BinaryTree("vive na água");
        insertNodeLeft(tree.getRoot(), "Macaco");
        insertNodeRight(tree.getRoot(), "Peixe");
        startGame(tree.root);
    }
}