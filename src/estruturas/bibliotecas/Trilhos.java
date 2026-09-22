package estruturas.bibliotecas;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Trilhos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){

            int n = sc.nextInt();

            if (n == 0){
                break;
            }

            while(true){

                int primeiro = sc.nextInt();

                if (primeiro == 0)
                    break;

                int[] ordem = new int[n];

                ordem[0] = primeiro;

                for (int i = 1; i < n; i++){
                    ordem[i] = sc.nextInt();
                }

                Stack<Integer> pilha = new Stack<>();
                int proximo = 1;
            }
        }
    }
}
