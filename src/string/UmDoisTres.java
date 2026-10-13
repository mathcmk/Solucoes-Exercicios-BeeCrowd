package string;

import java.util.Scanner;


public class UmDoisTres {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();


       String[] numeros = {"one", "two", "three"};

        for (int i = 0; i < n; i++) {
            int um = 0;
            int dois = 0;
            int tres = 0;

            String palavra = sc.nextLine().toLowerCase();

            for (int j = 0; j < palavra.length(); j++) {

                char c = palavra.charAt(j);

                if (palavra.length() == 3 && c == numeros[0].charAt(j)){
                    um++;
                }

                if (palavra.length() == 3 && c == numeros[1].charAt(j)) {
                    dois++;
                }

                if (palavra.length() == 5 && c == numeros[2].charAt(j)) {
                    tres++;
                }
            }

            if (um > 1 && um <= 3){
                System.out.println(1);
            } else if (dois > 1 && dois <=3) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}
