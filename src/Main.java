import java.sql.ClientInfoStatus;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> palavras = Arrays.asList("amor", "roma", "carro", "arom", "morro", "corar");
        Map<String, List<String>> mapa = new HashMap<>();

        for(String palavra : palavras){
            char[] letras = palavra.toCharArray();
            Arrays.sort(letras);
            String chave = new String(letras);

            if(!mapa.containsKey(chave)){
                mapa.put(chave, new ArrayList<>());
            }

            mapa.get(chave).add(palavra);
        }
        List<List<String>> resultado = new ArrayList<>(mapa.values());
        System.out.println(resultado);
    }
}
