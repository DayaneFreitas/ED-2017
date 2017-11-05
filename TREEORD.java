/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeord;

import java.util.Scanner;

/**
 *
 * @author Dayane
 */
public class TREEORD {
     //O objetivo deste exercicio é verificar:
    // 1.Se o primeiro nó da primeira árvore é igual o utlimo nó da segunda árvore;
    // 2.Se o ultimo nó da primeira árvore é igual o ultimo da ultima árvore;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int no,cont= 0;
        int qtd = entrada.nextInt();
        int[] aux = new int[2];
        for(int i=0;i<3;i++)//Pega cada linha 
        {
        for (int j=0;j<qtd;j++){
            //Esse for vai verificando cada nó da arvore
            no = entrada.nextInt();
            if(i==0 && j==0){ 
                //Preenche o array com o primeiro elemento da arvore
                aux[0] = no;
            }

            if(i==0 && j==qtd-1) {
                //primeira árvore,ultimo elemento
                aux[1] = no;
            }

            if((i==1 && j==qtd-1) && aux[0]==no) {
                //Segunda árvore,ultimo elemento,verifica se o primeiro elemento do array aux é igual o nó que esta sendo informado.
                cont++;
            }

            if(i==2 && j==qtd-1 && aux[1]==no) {
                //terceira árvore,verifica se um ultimo elemento de aux é igual o nó fornecido;
                cont++;
            }
        }
    }
        if(cont==2){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
    
}
