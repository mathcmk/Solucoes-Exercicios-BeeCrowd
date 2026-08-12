import java.util.HashMap;
import java.util.Map;

public class Exercicio2 {
    public static void main(String[] args) {
        String texto = "abkacabad";

        Character resultado  = primeiroNaoRepetido(texto);
        System.out.println(resultado);
    }

    private static Character primeiroNaoRepetido(String texto) {
        Map<Character, Integer> mapa = new HashMap<>();

        //Contar quantas vezes cada palavra aparece
        for (char c : texto.toCharArray()){
            mapa.put(c, mapa.getOrDefault(c, 0) + 1);
        }

        //Encontrar o primeiro que aparecer só uma vez

        for(char c : texto.toCharArray()){
            if(mapa.get(c) == 1){
                return c;
            }
        }
        return null;

    }
}
