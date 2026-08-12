package exercicios.beeCrowd.estruturas_e_bibliotecas;

import java.util.Scanner;

public class ProcessadorAmigavelDeInteiros {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {

            String entrada = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            boolean erro = false;

            if (entrada.isEmpty()) {
                System.out.println("error");
                continue;
            }

            for (int i = 0; i < entrada.length(); i++) {

                char c = entrada.charAt(i);

                if (c == 'l') {
                    sb.append('1');

                } else if (c == 'o' || c == 'O') {
                    sb.append('0');

                } else if (c == ' ' || c == ',') {
                    // Ignora

                } else if (Character.isDigit(c)) {
                    sb.append(c);

                } else {
                    erro = true;
                    break;
                }
            }

            if (erro || sb.length() == 0) {
                System.out.println("error");
                continue;
            }

            try {

                long valor = Long.parseLong(sb.toString());

                if (valor > Integer.MAX_VALUE) {
                    System.out.println("error");
                } else {
                    System.out.println(valor);
                }

            } catch (NumberFormatException e) {
                // Número maior que um long
                System.out.println("error");
            }
        }

        sc.close();
    }
}