package guessanimals;

class Node {
    
    private String info;
    private Node left;
    private Node right;

    public Node(String info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    
}
