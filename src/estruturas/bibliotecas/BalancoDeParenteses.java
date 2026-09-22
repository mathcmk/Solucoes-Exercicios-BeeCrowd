package estruturas.bibliotecas;

import java.util.Scanner;
import java.util.Stack;




public class BalancoDeParenteses {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        while (sc.hasNextLine()){

            String expressao = sc.nextLine();

            validador(expressao);
        }

        sc.close();

    }

    public static void validador(String expressao) {

        Stack<Character> parenteses = new Stack<>();

        for (int j = 0; j < expressao.length(); j++) {

            char c = expressao.charAt(j);

            //Condição que observa o caractere '('.
            if (c == '(') {
                parenteses.push(c);
            } else if (c == ')' && !parenteses.empty()) {
                parenteses.pop();
            } else if (c == ')' && parenteses.empty()) {
                System.out.println("incorrect");
                return;
            }
        }

        if (!parenteses.empty()) {
            System.out.println("incorrect");
        }else if(parenteses.empty()){
            System.out.println("correct");
        }

    }
}



