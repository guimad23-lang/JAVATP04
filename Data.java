package TP04;

import java.text.DateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    // --- Métodos Auxiliares Internos ---
    private boolean verificaBissexto(int anoCheck) {
        return (anoCheck % 4 == 0 && anoCheck % 100 != 0) || (anoCheck % 400 == 0);
    }

    private boolean isDataValida(int d, int m, int a) {
        if (a < 1 || m < 1 || m > 12 || d < 1) return false;
        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (verificaBissexto(a)) diasPorMes[2] = 29; // Fevereiro em ano bissexto
        return d <= diasPorMes[m];
    }

    // --- Construtores ---
    public Data() {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        System.out.println("--- Inicializando nova Data ---");
        while (!valido) {
            try {
                System.out.print("Digite o dia: "); int d = sc.nextInt();
                System.out.print("Digite o mês: "); int m = sc.nextInt();
                System.out.print("Digite o ano: "); int a = sc.nextInt();
                
                if (isDataValida(d, m, a)) {
                    this.dia = d; this.mes = m; this.ano = a;
                    valido = true;
                } else {
                    System.out.println("Data inválida! Por favor, redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite apenas números inteiros.");
                sc.nextLine(); // Limpa o buffer
            }
        }
    }

    public Data(int d, int m, int a) {
        if (isDataValida(d, m, a)) {
            this.dia = d; this.mes = m; this.ano = a;
        } else {
            System.out.println("Valores inválidos no construtor. Setando data padrão: 01/01/1900");
            this.dia = 1; this.mes = 1; this.ano = 1900;
        }
    }

    // --- Setters (com parâmetros) ---
    public void entraDia(int d) { this.dia = d; }
    public void entraMes(int m) { this.mes = m; }
    public void entraAno(int a) { this.ano = a; }

    // --- Setters (sem parâmetros / Interativos) ---
    public void entraDia() {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite o novo dia: ");
                int d = sc.nextInt();
                if (isDataValida(d, this.mes, this.ano)) {
                    this.dia = d;
                    valido = true;
                } else {
                    System.out.println("Dia inválido para o mês/ano atual. Redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada."); sc.nextLine();
            }
        }
    }

    public void entraMes() {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite o novo mês: ");
                int m = sc.nextInt();
                if (isDataValida(this.dia, m, this.ano)) {
                    this.mes = m;
                    valido = true;
                } else {
                    System.out.println("Mês inválido para o dia/ano atual. Redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada."); sc.nextLine();
            }
        }
    }

    public void entraAno() {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite o novo ano: ");
                int a = sc.nextInt();
                if (isDataValida(this.dia, this.mes, a)) {
                    this.ano = a;
                    valido = true;
                } else {
                    System.out.println("Ano inválido para a data atual. Redigite.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada."); sc.nextLine();
            }
        }
    }

    // --- Getters ---
    public int retDia() { return this.dia; }
    public int retMes() { return this.mes; }
    public int retAno() { return this.ano; }

    // --- Métodos de Formatação ---
    public String mostra1() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    public String mostra2() {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                          "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return String.format("%02d/%s/%04d", this.dia, meses[this.mes - 1], this.ano);
    }

    // --- Lógicas de Negócio ---
    public boolean bissexto() {
        return verificaBissexto(this.ano);
    }

    public int diasTranscorridos() {
        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (bissexto()) diasPorMes[2] = 29;

        int dias = 0;
        for (int i = 1; i < this.mes; i++) {
            dias += diasPorMes[i];
        }
        dias += this.dia;
        return dias;
    }

    public void apresentaDataAtual() {
        Date hoje = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data Atual do Sistema: " + df.format(hoje));
    }
}
