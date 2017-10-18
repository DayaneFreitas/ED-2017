/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaqueue;

import java.util.Scanner;

/**
 *
 * @author Dayane
 */
public class Adaqueue {

    private static int cabeça = -1;
    private static int calda = -1;
    private final static int primeiro_elemento = 1000010;
    private static boolean reverte;
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int tam = entrada.nextInt();
        int[] numeros = new int[4009099];
        reverte = false;
        for(int i = 0;i<=tam;i++){
            String entradas = entrada.nextLine();
            String []elementos = entradas.split(" ");
            if (elementos.length == 1){
                if("front".equals(elementos[0])) {
                    Front(numeros);
                } else if("back".equals(elementos[0])) {
                    back(numeros);
                } else {

                    int temp = cabeça;
                    cabeça = calda;
                    calda = temp;
                    reverte = !reverte;
               
                }
            }else{
                int valor = Integer.valueOf(elementos[1]);
                // possibilities.
                if("toFront".equals(elementos[0])) {
                    ToFront(numeros, valor);
                }else if("push_back".equals(elementos[0])) {
                   Push_Back(numeros, valor);
                }

            }
        }
    }
    //Imprimi o ultimo elemento e depois apaga ele
    public static void back(int [] numeros){
        if((reverte && calda > cabeça) || (!reverte && cabeça > calda) || cabeça == -1) {
            System.out.println("No job for Ada?");
            return;
        }

        System.out.println(numeros[calda]);
        if(reverte) {
            calda++;
        } else {
            calda--;
        }    
    }
    //Adiciona o numero dado na frente da fila
    public static void ToFront(int [] numeros, int valor) {
        if(calda == -1) {
            calda = primeiro_elemento;
            cabeça = primeiro_elemento;
        } else {
            if(reverte) {
                cabeça++;
            } else {
                cabeça--;
            }
        }
        numeros[cabeça] = valor;
    }
    //Adiciona o elemento atrás da fila
    public static void Push_Back(int []numeros, int valor) {

        if(cabeça == -1) {
            calda = primeiro_elemento;
            cabeça = primeiro_elemento;
        } else {
            if(reverte) {
                calda--;
            } else {
                calda++;
            }
        }

        numeros[calda] = valor;

    }
    //printa o ultimo elemento na fila e depois apaga
    public static void Front(int [] numero) {

        if((reverte && calda > cabeça) || (!reverte && cabeça > calda) || cabeça == -1) {
            System.out.println("No job for Ada?");
            return;
        }
        //Imprimi o elemento na frente da fila
        System.out.println(numero[cabeça]);
        if(reverte) {
            cabeça--;
        } else {
            cabeça++;
        }


    }
}
