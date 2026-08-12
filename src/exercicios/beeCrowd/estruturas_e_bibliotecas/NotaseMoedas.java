package exercicios.beeCrowd.estruturas_e_bibliotecas;

import java.util.Scanner;

public class NotaseMoedas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double input = sc.nextDouble();

        int valor = (int) Math.round(input * 100);

        System.out.println("NOTAS:");

        int notas = valor / 10000;
        valor %= 10000;
        System.out.println(notas + " nota(s) de R$ 100.00");

        notas = valor / 5000;
        valor %= 5000;
        System.out.println(notas + " nota(s) de R$ 50.00");

        notas = valor / 2000;
        valor %= 2000;
        System.out.println(notas + " nota(s) de R$ 20.00");

        notas = valor / 1000;
        valor %= 1000;
        System.out.println(notas + " nota(s) de R$ 10.00");

        notas = valor / 500;
        valor %= 500;
        System.out.println(notas + " nota(s) de R$ 5.00");

        notas = valor / 200;
        valor %= 200;
        System.out.println(notas + " nota(s) de R$ 2.00");

        System.out.println("MOEDAS:");

        notas = valor / 100;
        valor %= 100;
        System.out.println(notas + " moeda(s) de R$ 1.00");

        notas = valor / 50;
        valor %= 50;
        System.out.println(notas + " moeda(s) de R$ 0.50");

        notas = valor / 25;
        valor %= 25;
        System.out.println(notas + " moeda(s) de R$ 0.25");

        notas = valor / 10;
        valor %= 10;
        System.out.println(notas + " moeda(s) de R$ 0.10");

        notas = valor / 5;
        valor %= 5;
        System.out.println(notas + " moeda(s) de R$ 0.05");

        notas = valor / 1;
        System.out.println(notas + " moeda(s) de R$ 0.01");
    }
}