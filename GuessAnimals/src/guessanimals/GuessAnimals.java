
package guessanimals;

/*
Autor: João Miguel

Objetivo: Criar um jogo que advinhe qual animal o jogador está pensando.

Método: Utilizar árvore binária para guardar as características e os animais
nas folhas. 

A ideia é fazer uma busca de acordo com as características:
se o animal não tem a característica, vá para esquerda;
se o animal tiver a característica, vá para direita.

Quando se chega na folha da árvore, pergunta-se se é aquele animal que está na folha: 
caso não seja, aquela folha vira uma característica que diferencia aquele animal
com o animal que o jogador pensou (passada pelo próprio jogador, assim como o animal que ele pensou).

*/
public class GuessAnimals {

    public static void main(String[] args) {
        
        // Inicializa o jogo.
        BinaryTree game = new BinaryTree();
        game.loadGame();
    }
    
}
