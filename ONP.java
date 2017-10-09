/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onp;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Dayane
 */
public class ONP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
                //Quantidade de expressões
		int qtd = entrada.nextInt();
		while (qtd-- > 0) {
			String exp = entrada.next();
			int strLength = exp.length();
			int cont = -1;
                        //criando uma pilha com Stack
			Stack<Character> st = new Stack<Character>();
			String saida = "";
			while (cont++ < strLength - 1) {

				if (exp.charAt(cont) == '(')
					continue;
                                //varre o array pegando cada elemento
				char test = exp.charAt(cont);

				if (test == '+' || test == '-' || test == '*' || test == '/'
						|| test == '^') {
					st.add(test);
					continue;
				} else if (test == ')') {
					saida += st.pop();
					continue;
				} else {
					saida += String.valueOf(test);
					continue;
				}

			}
			System.out.println(saida.trim());

		}
    }
    
}
