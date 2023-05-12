//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package application;

import entites.BreezeHacker;
import entites.BurnCoder;
import entites.Criatura;
import entites.StoneDev;
import entites.WaveNerd;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Batalha {
    Scanner sc;
    private static Criatura[] criaturas = new Criatura[4];

    public Batalha() {
        this.sc = new Scanner(System.in);
    }

    public void escolhaCriatura() {
        System.out.println("Informe qual criatura deseja inicar o jogo: \n1. StoneDev \n2. WaveNerd \n3. BurnCoder \n4. BreezeHacker \n5. (sair) ");
        int escolha = this.sc.nextInt();
        if (escolha >= 1 && escolha <= 5) {
            switch (escolha) {
                case 1:
                    System.out.println("Você escolheu o StoneDev");
                    criaturas[0] = new StoneDev();
                    criaturas[1] = new WaveNerd();
                    criaturas[2] = new BurnCoder();
                    criaturas[3] = new BreezeHacker();
                    break;
                case 2:
                    System.out.println("Você escolheu o WaveNerd");
                    criaturas[0] = new WaveNerd();
                    criaturas[1] = new StoneDev();
                    criaturas[2] = new BurnCoder();
                    criaturas[3] = new BreezeHacker();
                    break;
                case 3:
                    System.out.println("Você escolheu o BurnCoder");
                    criaturas[0] = new BurnCoder();
                    criaturas[1] = new WaveNerd();
                    criaturas[2] = new StoneDev();
                    criaturas[3] = new BreezeHacker();
                    break;
                case 4:
                    System.out.println("Você escolheu o BreezeHacker");
                    criaturas[0] = new BreezeHacker();
                    criaturas[1] = new WaveNerd();
                    criaturas[2] = new StoneDev();
                    criaturas[3] = new BurnCoder();
                    break;
                case 5:
                    System.out.println("Processando..");
                    System.out.println("Jogo finalizado!");
            }

            this.iniciaTorneio();
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
            this.escolhaCriatura();
        }

    }

    public void iniciaTorneio() {
        System.out.println("1. iniciar o torneio \n2. Sair do programa");
        int escolha = this.sc.nextInt();
        this.sc.nextLine();
        if (escolha >= 1 && escolha <= 2) {
            switch (escolha) {
                case 1:
                    this.batalha();
                    break;
                case 2:
                    System.out.println("Processando..");
                    System.out.println("Jogo finalizado!");
            }
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
            this.iniciaTorneio();
        }

    }

    public void batalha() {
        if (criaturas[0].getVELOCIDADE() > criaturas[1].getVELOCIDADE()) {
            System.out.println("1. Realizar ataque físico \n2. Realizar ataque elemental \n3. Sair do programa");
            int escolha = this.sc.nextInt();
            switch (escolha) {
                case 1:
                    criaturas[0].ataqueFisico(criaturas[0], criaturas[1]);
                    break;
                case 2:
                    criaturas[0].ataqueElemental(criaturas[0], criaturas[1]);
                    break;
                case 3:
                    System.out.println("Processando..");
                    System.out.println("Jogo finalizado!");
                    return;
            }

            if (!this.statusBatalha()) {
                this.batalha();
            }
        } else if (criaturas[1].getVELOCIDADE() > criaturas[0].getVELOCIDADE()) {
            Random rand = new Random();
            int escolha = rand.nextInt(2) + 1;
            if (escolha == 1) {
                criaturas[1].ataqueFisico(criaturas[1], criaturas[0]);
            } else if (escolha == 2) {
                criaturas[1].ataqueElemental(criaturas[1], criaturas[0]);
            }
        }

    }

    public boolean statusBatalha() {
        if (criaturas[0].getPONTOS_DE_VIDA() <= 0) {
            return true;
        } else if (criaturas[1].getPONTOS_DE_VIDA() <= 0) {
            System.out.println();
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
