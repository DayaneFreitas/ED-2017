/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaindex;

import java.util.Scanner;

/**
 *
 * @author Dayane
 */
public class Adaindex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int tamanho1 = 0;
        tamanho1 = entrada.nextInt();
        int tamanho2 = 0;
        tamanho2 = entrada.nextInt();
        String [] lista = new String [tamanho1];
        for (int i=0;i<tamanho1;i++){
            //captura os elementos do array
            lista[i] = entrada.next();
            
        }
        
        //int tamanho2 = 0;
        //tamanho2 = entrada.nextInt();
        String [] compara = new String[tamanho2];
        for (int i=0;i<tamanho2;i++){
            compara[i] = entrada.next();
            
        }
        for (int i=0;i<tamanho2;i++){
            String nome;
            nome=compara[i];
            Prefixo(nome,lista);
        }
    }
    public static void Prefixo(String n,String ar[]){
        int cont = 0;
        for (int i=0;i<ar.length;i++){
            if(ar[i].startsWith(n)){
                cont++;
            }
        }
        System.out.println(cont);
    }
    
}
