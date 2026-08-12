package exercicios.beeCrowd.estruturas_e_bibliotecas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OndeEstaOMarmore {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int caso = 1;

        while (true) {

            List<Integer> marmores = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            int n = sc.nextInt();
            int q = sc.nextInt();

            if (n == 0 && q == 0) {
                break;
            }

            for (int j = 0; j < n; j++) {
                marmores.add(sc.nextInt());
            }

            Collections.sort(marmores);

            sb.append("CASE# ").append(caso).append(":\n");

            for (int k = 0; k < q; k++) {

                int buscar = sc.nextInt();

                int esquerda = 0;
                int direita = marmores.size() - 1;
                int resposta = -1;

                while (esquerda <= direita) {

                    int meio = (esquerda + direita) / 2;

                    if (marmores.get(meio) == buscar) {
                        resposta = meio;
                        direita = meio - 1; // continua procurando à esquerda
                    } else if (marmores.get(meio) < buscar) {
                        esquerda = meio + 1;
                    } else {
                        direita = meio - 1;
                    }
                }

                if (resposta != -1) {
                    sb.append(buscar)
                            .append(" found at ")
                            .append(resposta + 1)
                            .append("\n");
                } else {
                    sb.append(buscar)
                            .append(" not found\n");
                }
            }

            System.out.print(sb);

            caso++;
        }

        sc.close();
    }
}