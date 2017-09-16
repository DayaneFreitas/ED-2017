/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequencias;

import java.util.Scanner;
import static javax.swing.JOptionPane.showInputDialog;

/**
 *
 * @author Dayane
 */
public class Sequencias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int tamanhoS = 0;
        tamanhoS = entrada.nextInt();
        int[] S = new int [tamanhoS];
        //String elementos;
        //System.out.println("Valores:");
        //elementos = entrada.next();
        
        //char [] valores =  elementos.toCharArray();
        for (int i=0;i<tamanhoS;i++){
            //S[i] = Integer.parseInt(String.valueOf(valores[i]));
            //System.out.println(S[i]);
            S[i] = entrada.nextInt();
        }
        
        int tamanhoQ = 0;
        //System.out.println("tamanho2:");
        tamanhoQ = entrada.nextInt();
        //String elementosQ;
        //System.out.println("Valores:");
        //elementosQ =  entrada.next();
        //char [] valQ = elementosQ.toCharArray();
        int [] Q = new int[tamanhoQ];
        for (int i=0;i<tamanhoQ;i++){
            Q[i] = entrada.nextInt();
            //System.out.println(Q[i]);
            
        }
        for (int i=0;i<tamanhoS;i++){
             if (!procura(S[i],Q)){
                String cout = (i!=(S.length-1))? S[i] + " ": S[i] +"";
                
                System.out.print(cout);
             }
        }
    }
    public static boolean procura(int dado,int ar[]){
        int cont = 0;
        for(int i = 0;i< (ar.length);i++)  {
          
         if(ar[i]== dado)
          return true;   
         
         
    }
    
        return false;
 }
}
    
    
