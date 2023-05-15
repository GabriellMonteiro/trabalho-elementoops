package criatura;

import java.util.Random;

public class StoneDev extends Criatura{
	private String nome;
	private String elemento;
	private int poder;
	private int ataque;
	private int defesa;
	private int velocidade;
	private int pontosDeVida;
	private int pontosDeVidaInilcial;

	public StoneDev() {
		Random rand = new Random();
		setNome("StoneDev");
		setElemento("Terra");
		setPoder(rand.nextInt(21) + 10);
		setAtaque(rand.nextInt(11) + 5);
		setDefesa(rand.nextInt(11) + 5);
		setVelocidade(rand.nextInt(10) + 1);
		setPontosDeVida(rand.nextInt(201) + 200);
		setPontosDeVidaInilcial(getPontosDeVida());
	}
	@Override
	public double fatorCriatura(Criatura atacante, Criatura defesor) {
		if (atacante.getElemento().equals("Terra") && defesor.getElemento().equals(("Ar"))) {
			double fator = atacante.getPoder() * atacante.getAtaque() / defesor.getDefesa() * 1;
			return fator;
		} else if (atacante.getElemento().equals("Terra") && defesor.getElemento().equals(("Fogo"))){
			double fator = atacante.getPoder() * atacante.getAtaque() / defesor.getDefesa() * 1;
			return fator;

		} else if(atacante.getElemento().equals("Terra") && defesor.getElemento().equals(("Terra"))) {
			double fator = atacante.getPoder() * atacante.getAtaque() / defesor.getDefesa() * 0.5;
			return fator;

		} else if (atacante.getElemento().equals("Terra") && defesor.getElemento().equals(("Agua"))){
			double fator = atacante.getPoder() * atacante.getAtaque() / defesor.getDefesa() * 2;
			return fator;
		}
		return 0;
	}
	@Override
	public String fraseDeEfeito(Criatura criatura) {
		String frase = "MINHA FORÇA É A SOLIDEZ DA TERRA SOB MEUS PÉS.";
		return frase;
	}
	@Override
	public String fraseDeAtaque(Criatura criatura) {
		String frase = "ATAQUE DESLIZAMENTO DE PEDRA";
		return frase;
	}
}

