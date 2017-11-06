/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicebtrie;

import java.util.Scanner;

/**
 *
 * @author Dayane
 */
public class NICEBTRIE {
    public static int i;
   public static char[]s = new char[1001];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int qtd = entrada.nextInt();
        while(qtd>0){
            String palavra = entrada.next();
            s= palavra.toCharArray();
            i=0;
            System.out.println(lenght()-1);
            qtd--;
        }
    }
    
    public static int lenght(){
         if(s[i++]=='l'){
             return 1;
         }
         else{
             return max(lenght(),lenght())+1;
         }
    }
    public static int max(int p,int q){
        if(p>q){
            return p;
        }
        else{
            return q;
        }
    }
}
