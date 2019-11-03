
package guessanimals;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        
        JFrame frame = new JFrame ("Jogo dos Animais");
        Scanner scanner = new Scanner(System.in);
        int ans;
        String[] opcoes = {"Ok, entendi!"};
        String[] opcoes2 = {"Sim"};
        String[] opcoes3 = {"Não", "Sim"};
        Node father = null;
        
        if (JOptionPane.showOptionDialog(frame, "Eu prometo a você que posso adivinhar QUALQUER animal que você pensar!",
                "Jogo dos Animais", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, opcoes, 0) == JOptionPane.CLOSED_OPTION){
            
            System.exit(0);
        };
        
        if (JOptionPane.showOptionDialog(frame, "Pronto? Já pensou?",
                "Jogo dos Animais", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, opcoes2, 0) == JOptionPane.CLOSED_OPTION){
            
            System.exit(0);
        };
        
        /* Inicia a busca na árvore: enquanto o nó possuir algum filho.
        o nó é uma característica (já que não é folha da árvore),
        portanto, deve-se perguntar ao jogador se o animal possui tal característica.
         */
        
        while (node.getLeft() != null || node.getRight() != null){
            
            ans = JOptionPane.showOptionDialog(frame, "Este animal " + node.getInfo() + "?",
                  "Jogo dos Animais", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                   null, opcoes3, 0);
            // Se possui a característica, busca na direita.
            if (ans == 1){
                father = node;
                node = node.getRight();
            }
            // Se não possui a característica, busca na esquerda.
            else if (ans == 0){
                father = node;
                node = node.getLeft();
            }
            else{
                System.exit(1);
            }
        }
        ans = JOptionPane.showOptionDialog(frame, "O animal pensado foi " + node.getInfo() + "\n\nAcertei?",
              "Jogo dos Animais", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
              null, opcoes3, 0);
        
        if (ans == 1){
            ans = JOptionPane.showOptionDialog(frame, "Haha, eu sabia! Quer jogar novamente?",
            "Jogo dos Animais", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, opcoes3, 0);
            
            if (ans == 1){
                startGame(root);
            }
            
            else if (ans == 0){
                JOptionPane.showMessageDialog(frame, "Tchauzinho! <3");
            }
            else{
                System.exit(0);
            }
        }
        
        /* Caso o animal que está na folha não seja o que o jogador pensou,
        deve-se perguntar qual é este animal e sua característica que o difere
        do animal da folha. Assim, o nó atual vira esta característica e os filhos
        são os dois animais.
        */
        else if (ans == 0){ 
            String animal = JOptionPane.showInputDialog(frame, "Aff... que chato :(\n\nEm qual animal você pensou?", "Jogo dos Animais", JOptionPane.QUESTION_MESSAGE);
            
            if (animal == null){
                System.exit(0);
            }
            String feature = JOptionPane.showInputDialog(frame, "O que um(a) " + animal + " faz que o difere de um(a)" + node.getInfo() + "?", "Jogo dos Animais", JOptionPane.QUESTION_MESSAGE);
            if (feature == null){
                System.exit(0);
            }
            
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
            ans = JOptionPane.showOptionDialog(frame, "Beleza! Agora sabemos tudo sobre um(a) " + newAnimal.getInfo() + "\n\nDeseja jogar novamente?",
            "Jogo dos Animais", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, opcoes3, 0);
            
            if (ans == 1){
                startGame(root);
            }
            else if (ans == 0){
                JOptionPane.showMessageDialog(frame, "Tchauzinho! <3");
            }
            else{
                System.exit(0);
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