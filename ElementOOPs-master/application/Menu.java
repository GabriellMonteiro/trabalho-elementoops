package application;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Batalha batalha = new Batalha();

    public void iniciarJogo() {
        System.out.println("" + "1. iniciar um novo jogo \n" + "2. Sair do programa");
        int escolha = sc.nextInt();
        if (escolha >= 1 && escolha <= 2) {
            switch (escolha) {
                case 1 -> {
                    batalha.escolhaCriatura();
                }
                case 2 -> {
                    System.out.println("Processando..");
                    System.out.println("Jogo finalizado!");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
            iniciarJogo();
        }

    }
}
