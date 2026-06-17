package TP04;

public class Exercicio2 {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("TESTANDO CONSTRUTOR COM PARÂMETROS");
        System.out.println("=========================================");
        // Cria uma data não bissexta
        Data data1 = new Data(15, 8, 2023);
        System.out.println("Formato 1 (mostra1): " + data1.mostra1());
        System.out.println("Formato 2 (mostra2): " + data1.mostra2());
        System.out.println("É ano bissexto? " + data1.bissexto());
        System.out.println("Dias transcorridos no ano: " + data1.diasTranscorridos());

        System.out.println("\n=========================================");
        System.out.println("TESTANDO MÉTODOS DE ENTRADA INTERATIVOS");
        System.out.println("=========================================");
        System.out.println("Vamos alterar o ano da data acima para 2024.");
        data1.entraAno(); // O console vai pedir para você digitar o ano, digite 2024
        
        System.out.println("\nData após a alteração:");
        System.out.println("Formato 1: " + data1.mostra1());
        System.out.println("É ano bissexto agora? " + data1.bissexto());
        System.out.println("Dias transcorridos em 2024 (bissexto): " + data1.diasTranscorridos());

        System.out.println("\n=========================================");
        System.out.println("TESTANDO CONSTRUTOR VAZIO (INPUT DO USUÁRIO)");
        System.out.println("=========================================");
        Data data2 = new Data(); // Vai pedir dia, mês e ano e tratar erros
        System.out.println("\nData inserida por você: " + data2.mostra2());

        System.out.println("\n=========================================");
        System.out.println("TESTANDO APRESENTAÇÃO DA DATA ATUAL (JAVA API)");
        System.out.println("=========================================");
        data1.apresentaDataAtual();
    }
}
