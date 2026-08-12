package exercicios.beeCrowd.estruturas_e_bibliotecas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Media3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        double n3 = sc.nextDouble();
        double n4 = sc.nextDouble();

        BigDecimal media = new BigDecimal(String.valueOf(mediaPonderada(n1, n2, n3, n4)));


        if(media.compareTo(new BigDecimal("7")) >= 0){
            System.out.printf("Media: %.1f\n", media);
            System.out.println("Aluno aprovado.");
        }else if (media.compareTo(new BigDecimal("5")) < 0){
            System.out.printf("Media: %.1f\n", media);
            System.out.println("Aluno reprovado.");
        }else {
            double nota = sc.nextDouble();

            System.out.printf("Media: %.1f\n", media);
            System.out.println("Aluno em exame.");

            System.out.printf("Nota do exame: %.1f\n", nota);

            BigDecimal bdNota = new BigDecimal(String.valueOf(nota));
            BigDecimal mediaFinal = media.add(bdNota).divide(new BigDecimal("2"), 1, RoundingMode.CEILING);

            if (mediaFinal.compareTo(new BigDecimal("5")) >= 0) {
                System.out.println("Aluno aprovado.");
            } else {
                System.out.println("Aluno reprovado.");
            }

            System.out.printf("Media final: %.1f\n", mediaFinal);
        }
        sc.close();
    }

    static BigDecimal mediaPonderada(double n1, double n2, double n3, double n4){

        BigDecimal soma = new BigDecimal(String.valueOf(n1)).multiply(new BigDecimal("2"))
                .add(new BigDecimal(String.valueOf(n2)).multiply(new BigDecimal("3")))
                .add(new BigDecimal(String.valueOf(n3)).multiply(new BigDecimal("4")))
                .add(new BigDecimal(String.valueOf(n4)));

        return soma.divide(new BigDecimal("10"),1, RoundingMode.DOWN);
    }
}
