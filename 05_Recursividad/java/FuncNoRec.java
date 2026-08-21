/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author sdariana
 */
public class FuncNoRec {
    int V[] = new int[100];
    //int T;
    int S;
    Scanner sc = new Scanner(System.in);
    public void leer(int T){
        for (int i = 0; i < T; i++) {
            System.out.print("Digite el número "+(i+1)+": ");
            this.V[i]=sc.nextInt();
        }
    }
    public void sub_sumar(){
        this.S=0;
        for (int i = 0; i < 10; i++) {
            S+=this.V[i];
        }
        System.out.println("El resultado es: "+S);
    }
    public int func_sumar(){
        this.S=0;
        for (int i = 0; i < 10; i++) {
            S+=V[i];
        }
        return S;
    }
}
