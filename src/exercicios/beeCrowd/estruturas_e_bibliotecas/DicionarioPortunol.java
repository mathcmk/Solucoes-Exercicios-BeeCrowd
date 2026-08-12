package exercicios.beeCrowd.estruturas_e_bibliotecas;/*package exercicios.beeCrowd.estruturas_e_bibliotecas*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class DicionarioPortunol {

    static class Node {
        int[] next = new int[26];
        boolean end;

        Node() {
            Arrays.fill(next, -1);
            end = false;
        }
    }

    static ArrayList<Node> triePt = new ArrayList<>();
    static ArrayList<Node> trieEsp = new ArrayList<>();

    static void inicializeTrie() {
        triePt.clear();
        trieEsp.clear();
        triePt.add(new Node());
        trieEsp.add(new Node());
    }

    static void insertTriePt(String word) {

        int atual = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            int indice = c - 'a';

            if (triePt.get(atual).next[indice] == -1) {
                triePt.get(atual).next[indice] = triePt.size();
                triePt.add(new Node());
            }

            atual = triePt.get(atual).next[indice];
        }
        triePt.get(atual).end = true;
    }

    static void insertTrieEsp(String word) {
        int atual = 0;

        for (int i = word.length() - 1; i >= 0; i--) {

            char c = word.charAt(i);
            int indice = c - 'a';

            if (trieEsp.get(atual).next[indice] == -1) {
                trieEsp.get(atual).next[indice] = trieEsp.size();
                trieEsp.add(new Node());
            }

            atual = trieEsp.get(atual).next[indice];
        }

        trieEsp.get(atual).end = true;
    }

    static boolean buscar(String word) {

        int atual = 0;

        for (char c : word.toCharArray()) {

            int letra = c - 'a';

            if (triePt.get(atual).next[letra] == -1)
                return false;

            atual = triePt.get(atual).next[letra];
        }
        return triePt.get(atual).end;
    }

    static boolean buscaEsp(String palavra) {
        int atual = 0;

        for (char c : palavra.toCharArray()) {

            int letra = c - 'a';

            if (trieEsp.get(atual).next[letra] == -1)
                return false;

            atual = trieEsp.get(atual).next[letra];
        }
        return trieEsp.get(atual).end;
    }

    static boolean startsWith(String prefix) {

        int atual = 0;

        for (char c : prefix.toCharArray()) {

            int letra = c - 'a';

            if (triePt.get(atual).next[letra] == -1)
                return false;

            atual = triePt.get(atual).next[letra];
        }
        return true;
    }

    static void dfs(int atual, StringBuilder palavra) {

        for (int i = 0; i < 26; i++) {

            if (triePt.get(atual).next[i] != -1) {
                int filho = triePt.get(atual).next[i];

                char letra = (char) ('a' + i);

                palavra.append(letra);

                if (triePt.get(filho).end)
                    System.out.println(palavra);

                dfs(filho, palavra);

                palavra.deleteCharAt(palavra.length() - 1);

            }
        }
    }

    static int contarNosPt(int atual) {

        int quantidade = 1;

        for (int i = 0; i < 26; i++) {

            if (triePt.get(atual).next[i] != -1) {

                int filho = triePt.get(atual).next[i];

                quantidade += contarNosPt(filho);
            }
        }
        return quantidade;
    }

    static int contarNosEsp(int atual) {

        int quantidade = 1;

        for (int i = 0; i < 26; i++) {

            if (trieEsp.get(atual).next[i] != -1) {

                int filho = trieEsp.get(atual).next[i];


                quantidade += contarNosEsp(filho);
            }
        }
        return quantidade;
    }

    static int contarPalavrasCompletasPt(int atual) {

        int quantidade = 0;

        if (triePt.get(atual).end) {

            quantidade++;
        }

        for (int i = 0; i < 26; i++) {

            if (triePt.get(atual).next[i] != -1) {

                int filho = triePt.get(atual).next[i];

                quantidade += contarPalavrasCompletasPt(filho);
            }
        }
        return quantidade;
    }

    static int contarpalavrasCompletasEsp(int atual) {

        int quantidade = 0;

        if (trieEsp.get(atual).end) {
            quantidade++;
        }

        for (int i = 0; i < 26; i++) {

            if (trieEsp.get(atual).next[i] != -1) {

                int filho = triePt.get(atual).next[i];

                quantidade += contarpalavrasCompletasEsp(filho);
            }
        }

        return quantidade;
    }


    static long[][] contarSufixosPorPrimeiraLetra() {

        long[][] resultado = new long[2][26];

        contarSufixo(0, 0, resultado);

        return resultado;
    }

    static long contarCombinacoes(int atual, long[][] sufixos) {

        long quantidade = 0;

        for (int i = 0; i < 26; i++) {

            // aqui você já pode somar os sufixos de tamanho 1

            quantidade += sufixos[0][i];

            // depois precisa verificar:
            // "o nó atual possui um filho com a letra i?"

            if (triePt.get(atual).next[i] == -1) {
                quantidade += sufixos[1][i];
            } else {

                int filho = triePt.get(atual).next[i];

                quantidade += contarCombinacoes(filho, sufixos);
            }
        }
        return quantidade;
    }

    static void contarSufixo(int atual, int profundidade, long[][] resultado) {

        for (int i = 0; i < 26; i++) {

            if (trieEsp.get(atual).next[i] != -1) {

                int filho = trieEsp.get(atual).next[i];

                int novaProfundidade = profundidade + 1;

                if (novaProfundidade == 1) {
                    resultado[0][i]++;
                } else {
                    resultado[1][i]++;
                }

                contarSufixo(filho, novaProfundidade, resultado);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if (p == 0 && s == 0) {
                break;
            }

            inicializeTrie();

            // Inserindo palavras portuguesas
            for (int i = 0; i < p; i++) {

                String palavra = br.readLine();

                insertTriePt(palavra);
            }

            // Inserindo palavras espanholas
            for (int i = 0; i < s; i++) {

                String palavra = br.readLine();

                insertTrieEsp(palavra);
            }

            // Conta os sufixos distintos
            long[][] sufixos =
                    contarSufixosPorPrimeiraLetra();

            long total = 0;

            // Começa pelos prefixos de tamanho 1
            for (int i = 0; i < 26; i++) {

                if (triePt.get(0).next[i] != -1) {

                    int filho =
                            triePt.get(0).next[i];

                    total +=
                            contarCombinacoes(filho, sufixos);
                }
            }

            System.out.println(total);
        }
    }
}