
package guessanimals;

public class BinaryTree {
    
    private Node root;
    

    public BinaryTree(){
        
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
        Node newRoot = new Node("vive na água");
        this.root = newRoot;
        insertNodeLeft(root, "Macaco");
        insertNodeRight(root, "Peixe");
        startGame(root);
    }
}