package exercicios.beeCrowd.estruturas_e_bibliotecas;

import java.util.Scanner;

public class TADRacional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testes = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < testes; i++) {
            String valor = sc.nextLine();

            String[] valoresFiltrados = valor.split(" ");

            // Cria as variaveis de calculo
            double n1 = Double.parseDouble(valoresFiltrados[0]);
            double d1 = Double.parseDouble(valoresFiltrados[1]);
            String operador = valoresFiltrados[2];
            double n2 = Double.parseDouble(valoresFiltrados[3]);
            double d2 = Double.parseDouble(valoresFiltrados[4]);



        }
    }
}
