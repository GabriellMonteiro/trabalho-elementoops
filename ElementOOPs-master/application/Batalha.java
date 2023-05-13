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

import java.util.Random;
import java.util.Scanner;

public class Batalha {
    Scanner sc;

    private static Criatura[] criaturas = new Criatura[4];
    public Batalha() {
        this.sc = new Scanner(System.in);
    }

    public void escolhaCriatura() {
        System.out.println("Informe qual criatura deseja inicar o jogo: \n" +
                "1. StoneDev \n" +
                "2. WaveNerd \n" +
                "3. BurnCoder \n" +
                "4. BreezeHacker \n" +
                "5. (sair) ");
        int escolha = this.sc.nextInt();
        sc.nextLine();
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

            this.iniciaABatalha();
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
            this.escolhaCriatura();
        }
    }

    public void iniciaABatalha() {
        System.out.println("1. iniciar o torneio \n" +
                "2. Sair do programa");
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
            this.iniciaABatalha();
        }
    }

    public void batalha() {
        System.out.println(criaturas[0].getNOME());
        System.out.println(criaturas[0].getELEMENTO());
        System.out.println(criaturas[0].getPONTOS_DE_VIDA());


        // verifica se a criatura escolhida é mais veloz que o adversario
        if (criaturas[0].getVELOCIDADE() >= criaturas[1].getVELOCIDADE()) {
            escolhido(criaturas[0], criaturas[1] );
            inimigo(criaturas[1], criaturas[0] );

            if(statusDaBatalha() == false) {
                this.batalha();

            }else{
                resetarPontoDeVida();
                System.out.println("SUA VIDA FOI REGENERADA " + criaturas[0].getPONTOS_DE_VIDA());
                System.out.println("LUTA ENCERRADA");
            }

        } else if (criaturas[1].getVELOCIDADE() > criaturas[0].getVELOCIDADE()) {
            inimigo(criaturas[1], criaturas[0]);
            escolhido(criaturas[0], criaturas[1]);

            if(statusDaBatalha() == false) {
                this.batalha();

            }else{
                resetarPontoDeVida();
                System.out.println("LUTA ENCERRADA");
                System.out.println("SUA VIDA FOI REGENERADA " + criaturas[0].getPONTOS_DE_VIDA());
            }

            }
        }

    public void escolhido(Criatura atacante, Criatura defensor){
        System.out.println("1. Realizar ataque físico \n" +
                "2. Realizar ataque elemental \n" +
                "3. Sair do programa");
        int escolha = this.sc.nextInt();
        sc.nextLine();
        switch (escolha) {
            case 1:
                atacante.ataqueFisico(atacante, defensor);
                break;
            case 2:
                atacante.ataqueElemental(atacante, defensor);
                break;
            case 3:
                System.out.println("Processando..");
                System.out.println("Jogo finalizado!");
                return;
        }
    }

    public void inimigo(Criatura defensor, Criatura atacante){
        Random rand = new Random();
        int escolha = rand.nextInt(2) + 1;
        switch (escolha) {
            case 1:
                defensor.ataqueFisico(defensor, atacante);
                break;
            case 2:
                defensor.ataqueElemental(defensor, atacante);
                break;
        }
    }

    public boolean statusDaBatalha() {
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
    public static void resetarPontoDeVida(){
        criaturas[0].setPONTOS_DE_VIDA(criaturas[0].getPONTOS_DE_VIDA());
    }
}
