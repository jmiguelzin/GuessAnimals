
package guessanimals;

import java.util.Scanner;

public class BinaryTree {
    
    private Node root;
    
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    public Node insertNodeLeft(Node node, String info){
        // esta função adiciona um filho a esquerda de um nó.
        if (node.getLeft() == null){
            Node newNode = new Node(info);
            node.setLeft(newNode);
            return newNode;
        }
        
        return null;    
    }   
    
    public Node insertNodeRight(Node node, String info){
        
        // esta função adiciona um filho a direita de um nó.
        if (node.getRight() == null){
            Node newNode = new Node(info);
            node.setRight(newNode);
            return newNode;
        }
        
        return null;
    }    
    
    public void startGame(Node node){
        
        Scanner scanner = new Scanner(System.in);
        String ans;
        Node father = null;
        System.out.println("Eu prometo a você que posso adivinhar QUALQUER animal que você pensar!");
        System.out.println("Pronto? Já pensou?");
        
        /* Inicia a busca na árvore: enquanto o nó possuir algum filho.
        o nó é uma característica (já que não é folha da árvore),
        portanto, deve-se perguntar ao jogador se o animal possui tal característica.
         */
        
        while (node.getLeft() != null || node.getRight() != null){
            
            System.out.println("Este animal " + node.getInfo() + " (s/n)?");
            ans = scanner.next();
            // Se possui a característica, busca na direita.
            if (ans.equals("s")){
                father = node;
                node = node.getRight();
            }
            // Se não possui a característica, busca na esquerda.
            else if (ans.equals("n")){
                father = node;
                node = node.getLeft();
            }
        }
        
        System.out.println("O animal pensado foi: " + node.getInfo());
        System.out.println("Acertei (s/n)?");
        ans = scanner.next();
        
        if (ans.equals("s")){
            System.out.println("Haha, eu sabia! Quer jogar novamente (s/n)?");
            ans = scanner.next();
            
            if (ans.equals("s")){
                startGame(root);
            }
        }
        
        /* Caso o animal que está na folha não seja o que o jogador pensou,
        deve-se perguntar qual é este animal e sua característica que o difere
        do animal da folha. Assim, o nó atual vira esta característica e os filhos
        são os dois animais.
        */
        else if (ans.equals("n")){ 
            String animal;
            String feature;
            
            System.out.println("Aff.. que chato :(");
            
            System.out.println("Em qual animal você pensou?");
            scanner.nextLine();
            animal = scanner.nextLine();
            
            System.out.println("Qual a característica que difere um(a) " + animal + " de um " + node.getInfo() + "?");
            feature = scanner.nextLine();
            
            Node newAnimal = new Node(animal);
            Node newFeature = new Node(feature);
            newFeature.setLeft(node);
            newFeature.setRight(newAnimal);
            
            if (father.getLeft() == node){
                father.setLeft(newFeature);
            }
            else{
                father.setRight(newFeature);
            }
            
            System.out.println("Animal adicionado! Deseja jogar novamente (s/n)?");
            ans = scanner.next();
            
            if (ans.equals("s")){
                startGame(root);
            }
        }  
    }
   
    public void loadGame(){
        
        // Esta função inicia a árvore colocando uma característica e dois animais.
        Node newRoot = new Node("vive na água");
        this.root = newRoot;
        insertNodeLeft(root, "Macaco");
        insertNodeRight(root, "Peixe");
        
        startGame(root);
        
    }
}