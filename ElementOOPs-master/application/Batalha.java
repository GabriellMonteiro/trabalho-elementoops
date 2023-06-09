//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package application;

import criatura.BreezeHacker;
import criatura.BurnCoder;
import criatura.Criatura;
import criatura.StoneDev;
import criatura.WaveNerd;

import java.util.Random;
import java.util.Scanner;

public class Batalha {
    Scanner sc;
    private static Criatura[] criaturas = new Criatura[4];
    public Batalha() {this.sc = new Scanner(System.in);}

    int criaturaInimiga = 1;

    public void escolhaCriatura() {
        System.out.println("Informe qual criatura deseja inicar o torneio: \n" +
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
                    criaturas[0] = new StoneDev();
                    criaturas[1] = new WaveNerd();
                    criaturas[2] = new BurnCoder();
                    criaturas[3] = new BreezeHacker();
                    break;
                case 2:
                    criaturas[0] = new WaveNerd();
                    criaturas[1] = new StoneDev();
                    criaturas[2] = new BurnCoder();
                    criaturas[3] = new BreezeHacker();
                    break;
                case 3:
                    criaturas[0] = new BurnCoder();
                    criaturas[1] = new WaveNerd();
                    criaturas[2] = new StoneDev();
                    criaturas[3] = new BreezeHacker();
                    break;
                case 4:
                    criaturas[0] = new BreezeHacker();
                    criaturas[1] = new WaveNerd();
                    criaturas[2] = new StoneDev();
                    criaturas[3] = new BurnCoder();
                    break;
                case 5:
                    System.out.println("Deseja realmente sair?\n" +
                            "1. Sim\n" +
                            "2. Não");

                    int confirmacao = sc.nextInt();
                    if (confirmacao == 1) {
                        System.out.println("Processando..");
                        tempoDeEspera();
                        System.out.println("Jogo finalizado!");
                        System.exit(0);
                    } else {
                        System.out.println("Continuando o programa..");
                        tempoDeEspera();
                        escolhaCriatura();
                        break;
                    }

            }
            this.iniciarBatalha();
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
            this.escolhaCriatura();
        }
    }

    public void iniciarBatalha() {
        System.out.println("CRIAUTURA ESCOLHIDA:");
        System.out.println(criaturas[0].fraseDeEfeito(criaturas[0]));
        tempoDeEspera();
        System.out.println(criaturas[0].caracteristicas(criaturas[0]));
        tempoDeEspera();
        System.out.println( criaturaInimiga + "º ADVERSÁRIO: ");
        System.out.println(criaturas[criaturaInimiga].fraseDeEfeito(criaturas[criaturaInimiga]));
        tempoDeEspera();
        System.out.println(criaturas[criaturaInimiga].caracteristicas(criaturas[criaturaInimiga]));
        System.out.println("1. iniciar a batalha? \n" +
                "2. Sair do programa");
        int escolha = this.sc.nextInt();
        this.sc.nextLine();
        if (escolha >= 1 && escolha <= 2) {
            switch (escolha) {
                case 1:
                    this.batalhar();
                    break;
                case 2:
                    System.out.println("Deseja realmente sair?\n" +
                            "1. Sim\n" +
                            "2. Não");

                    int confirmacao = sc.nextInt();
                    if (confirmacao == 1) {
                        System.out.println("Processando..");
                        tempoDeEspera();
                        System.out.println("Jogo finalizado!");
                        System.exit(0);
                    } else {
                        System.out.println("Continuando o programa.");
                        tempoDeEspera();
                        iniciarBatalha();
                        break;
                    }
            }
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
            this.iniciarBatalha();
        }

    }

    public void batalhar() {
        if (criaturas[0].getVelocidade() >= criaturas[criaturaInimiga].getVelocidade()) {
            personagemEscolhido(criaturas[0], criaturas[criaturaInimiga] );
            if(this.statusDaBatalha() == false){
                personagemInimigo(criaturas[criaturaInimiga], criaturas[0] );
            }
            this.continuarBatalha();

        } else {
            personagemInimigo(criaturas[criaturaInimiga], criaturas[0]);
            if(this.statusDaBatalha() == false){
                personagemEscolhido(criaturas[0], criaturas[criaturaInimiga]);
            }
            this.continuarBatalha();

        }
    }

    public void personagemEscolhido(Criatura atacante, Criatura defensor){
        System.out.println("1. Realizar ataque físico \n" +
                "2. Realizar ataque elemental \n" +
                "3. Sair do programa");
        int escolha = this.sc.nextInt();
        sc.nextLine();

        System.out.println();
        System.out.println("SEU ATAQUE: ");
        switch (escolha) {
            case 1:
                atacante.ataqueFisico(atacante, defensor);
                break;
            case 2:
                atacante.ataqueElemental(atacante, defensor);
                break;
            case 3:
                System.out.println("Deseja realmente sair?\n" +
                        "1. Sim\n" +
                        "2. Não");

                int confirmacao = sc.nextInt();
                if (confirmacao == 1) {
                    System.out.println("Processando..");
                    tempoDeEspera();
                    System.out.println("Jogo finalizado!");
                    System.exit(0);
                } else {
                    System.out.println("Continuando o programa.");
                    this.personagemEscolhido(atacante, defensor);
                    break;
                }
        }
    }

    public void personagemInimigo(Criatura atacante, Criatura defensor){
        System.out.println("ATAQUE INIMIGO: ");
        Random rand = new Random();
        int escolha = rand.nextInt(2) + 1;
        switch (escolha) {
            case 1:
                atacante.ataqueFisico(atacante,defensor);
                break;
            case 2:
                atacante.ataqueElemental(atacante,defensor);
                break;
        }
    }

    public boolean statusDaBatalha() {
        return criaturas[0].getPontosDeVida() <= 0 || criaturas[criaturaInimiga].getPontosDeVida() <= 0;
    }
    public static void resetarPontoDeVida(){
        criaturas[0].setPontosDeVida(criaturas[0].getPontosDeVidaInilcial());
    }
    public void continuarTorneio(){
        if (criaturas[0].getPontosDeVida() <= 0) {
            System.out.println("VOCÊ FOI ELIMINADO! ");

        } else if (criaturas[criaturaInimiga].getPontosDeVida() <= 0){
            System.out.println("LUTA ENCERRADA");
            System.out.println(criaturas[0].getNome().toUpperCase() + " VENCEU A " + criaturaInimiga + "ª RODADA!!!");
            resetarPontoDeVida();
            System.out.println();
            System.out.println("SUA VIDA FOI REGENERADA " + criaturas[0].getPontosDeVida() + "\n") ;
            ++criaturaInimiga;
            if (criaturaInimiga >= criaturas.length) {
                System.out.println( criaturas[0].getNome().toUpperCase() + " GANHOU  O TORNEIO!!!");
                System.out.println(criaturas[0].fraseDeEfeito(criaturas[0]));
                criaturaInimiga = 1;
                System.out.println("\n" + "VOCÊ VENCEU PARABÉNS!!!!");
                return;
            } else {
                this.iniciarBatalha();
            }
        }
    }
    public void continuarBatalha(){
        if(statusDaBatalha() == false) {
            this.batalhar();

        }else{
            this.continuarTorneio();
        }
    }
    public void tempoDeEspera(){
     try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
         System.out.println("Ocorreu um erro inesperado." +
                 "Reinicializando o programa...");
         tempoDeEspera();
         Menu menu = new Menu();
         menu.iniciarJogo();
     }
    }
}
