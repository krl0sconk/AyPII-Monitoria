/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author sdariana
 */
public class FuncRec {

    int V[] = new int[100];
    //int T;
    int S;
    Scanner sc = new Scanner(System.in);

    public void leer(int T, int i) {
        if (i < T) {
            System.out.print("Digite el número " + (i + 1) + ": ");
            this.V[i] = sc.nextInt();
            i++;
            leer(T, i);
        }
    }

    public void sub_sumar(int s, int i) {
        //this.S=0;
        if (i < 10) {
            S += this.V[i];
            i++;
            sub_sumar(S, i);
        } else {
            System.out.println("El resultado es: " + S);
        }
    }

    public int func_sumar(int s, int i) {
        if (i < 10) {
            s += this.V[i];
            i++;
            func_sumar(s, i);
        }else{
        //System.out.println("S= " + s);
        this.S = s;
        }
        return S;
    }
}
