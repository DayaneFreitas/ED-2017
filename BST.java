/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Dayane
 */
public class BST {
    //Array para guardar os elementos da árvore
    private static int [] tree;
    public static void main(String[] args) {
        // TODO code application logic here
                Scanner entrada = new Scanner(System.in);
                // é o numero de nó a ser adicionados á arvore
		int N = entrada.nextInt();
                //A função treeSet implementa uma árvore rubro-negra
		TreeSet <Integer> set = new TreeSet <Integer> ();
		long movimentos = 0;
		tree = new int [N + 1];
		for (int i = 0; i < N; i++) {
			int elemento = entrada.nextInt();
			Integer maior = set.higher (elemento);
			Integer menor = set.lower (elemento);
			if (maior == null) maior = N;//Retorna o menor elemento
			if (menor == null) menor = 1;//retorna o maior elemento
			movimentos += inserir (elemento);
			atualizar (maior + 1, -1);
			atualizar (menor, 1);
			set.add (elemento);
			System.out.println (movimentos);
		}
		
        
        
    }
    private static int inserir (int pos) {
		int soma = 0;
		for (int i = pos; i > 0; i -= (i & -i))
			soma += tree [i];
		return soma;
	}
	
	private static void atualizar (int pos, int val) {
		for (int i = pos; i < tree.length; i += (i & -i))
			tree [i] += val;
	}
	
}
