import java.text.Normalizer;
import java.util.*;

public class Principal {
    /**
     * Lista 02 Laboratorio de Computacao II
     *
     * @author Arthur Berbert; Guilherme Rocha; Matheus Muriel
     * @version 04/03/18
     */
    public static void main(String[] args){
        List<Integer> vals = Arrays.asList(3,3,7,5);
        //System.out.println(Principal.existeRecursivo(5, vals));
        //System.out.println(Principal.existeTailRecursivo(5, vals, 0));
        int[] vetor = new int[]{5, 8, 7, 3, 9, 9};
        System.out.println(recursiveMinimum(vetor, vetor.length));
    }

    /*  1.a)
        Implemente uma versão de existe que seja puramente recursiva.
     */
    public static boolean existeRecursivo(int chave, List<Integer> vals) {
        if (chave == vals.get(0)) { return true; }
        if (vals.size() == 1) { return false; }

        if (existeRecursivo(chave, vals.subList(1, vals.size()))) {return true; }
        else {return false; }
    }

    /*  1.b)
        Implemente uma versão de existe que seja tail recursiva.
     */
    public static boolean existeTailRecursivo(
            int chave, List<Integer> vals, int tail){
        assert vals != null: "Listas nulas não são aceitas.";

        if (vals.size() == tail) {return false; }

        if (chave == vals.get(tail)) {return true; }
            return existeTailRecursivo(chave, vals, tail + 1);
    }

    /*  18.7
        O que seguinte código faz?
     */
    public static int mystery(int a, int b) {
        if (b ==  1)
            return a;
        else
            return a + mystery(a, b - 1);
    }
    // Resposta: Chega ao produto de a por b através de adições e subtrações.

    /*  18.8
        Localize o(s) erro(s) no seguinte método recursivo e explique como
        corrigi-lo(s). Esse método deve encontrar a soma dos valores de 0 a n.
     */
    public static int sum(int n) {
        if (n == 0)
            return 0;
        else
            return n + sum(n);
    }
    // Resposta: foi necessário acrescentar ( - 1) a “n” na sexta linha dentro de sum(n).
    // Assim ficando: return n + sum(n -1);

    /*  18.9
        Escreva uma método recursivo power(base, exponent) que, quando chamado, retorna
        base exponente
    */
    public static int recursivo(int numero, int expo){
        if(expo == 0){
            return 1;
        }
        if(expo == 1){
            return numero;
        }else{
            return numero * recursivo(numero, expo - 1);

        }
    }

    /*  18.14
        Escreva um método recursivo testPalindrome que retorna o valor boolean true,
        se a string armazenada no array for um palíndromo, e false, caso contrário.
        O método deve ignorar espaços e pontuação na string
     */
    public static boolean testPalindrome(String[] str){
        String palavraPura = str[0];
        palavraPura = palavraPura.replaceAll(" ", "");
        palavraPura = Normalizer.normalize(palavraPura,
                Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        //As linhas acima estão transformando o array em String,
        // removendo espaços e tirando os acentos

        return testPalindrome(palavraPura, 0, palavraPura.length()-1);
    }

    /**
     *  Metodo private que recebe uma palavra e verifica recursivamente se ela é um palindromo.
     *  Esse metodo é chamado pelo metodo com o mesmo nome.
     * @param palavraPura   String a ser verificada
     * @param i     int com uma pocição de um caracter de inicio
     * @param f     int com uma pocição de um caracter de final
     * @return
     */
    private static boolean testPalindrome(String palavraPura, int i, int f){
        boolean retorno;

        if(palavraPura.charAt(i) != palavraPura.charAt(f)){
            return retorno = false;
        }else {
            if( i >= (palavraPura.length()-1) ) { return retorno = true; }
            retorno = testPalindrome(palavraPura,i+1,f-1);
        }

        return retorno;
    }

    /*  18.18
        Escreva um método recursivo recursiveMinimum que determina o menor elemento em
        um array de inteiros. O método deve retornar quando ele receber um array de um elemento.
     */
    public static int recursiveMinimum(int[] vetor ,int fim){
        --fim;
        if (fim == 0){
            return vetor[fim];
        }
        int ultimo = vetor[fim];
        int proximo = recursiveMinimum(vetor,(fim));
        return (ultimo < proximo) ? ultimo : proximo;
    }
}
