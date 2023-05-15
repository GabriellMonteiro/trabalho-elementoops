package entites;

import java.util.Random;

public class BreezeHacker extends Criatura {
	private String NOME;
	private String ELEMENTO;
	private int PODER;
	private int ATAQUE;
	private int DEFESA;
	private int VELOCIDADE;
	private int PONTOS_DE_VIDA;
<<<<<<< HEAD
	private int pontosDeVidaInilcial;
=======
	private int PONTOS_DE_VIDA_INICIAL;
>>>>>>> origin/master

	public BreezeHacker() {
		Random rand = new Random();
		setNOME("BreezeHacker");
		setELEMENTO("Ar");
		setPODER(rand.nextInt(21) + 10);
		setATAQUE(rand.nextInt(11) + 5);
		setDEFESA(rand.nextInt(11) + 5);
		setVELOCIDADE(rand.nextInt(10) + 1);
		setPONTOS_DE_VIDA(rand.nextInt(201) + 200);
<<<<<<< HEAD
		setPontosDeVidaInilcial(getPONTOS_DE_VIDA());
=======
		setPONTOS_DE_VIDA_INICIAL(getPONTOS_DE_VIDA());
>>>>>>> origin/master
	}

	@Override
	public double fatorCriatura(Criatura atacante, Criatura defesor) {
		if (atacante.getELEMENTO().equals("Ar") && defesor.getELEMENTO().equals(("Agua"))) {
			double fator = atacante.getPODER() * atacante.getATAQUE() / defesor.getDEFESA() * 1;
			return fator;
		} else if (atacante.getELEMENTO().equals("Ar") && defesor.getELEMENTO().equals(("Fogo"))) {
			double fator = atacante.getPODER() * atacante.getATAQUE() / defesor.getDEFESA() * 1;
			return fator;

		} else if (atacante.getELEMENTO().equals("Ar") && defesor.getELEMENTO().equals(("Ar"))) {
			double fator = atacante.getPODER() * atacante.getATAQUE() / defesor.getDEFESA() * 0.5;
			return fator;

		} else if (atacante.getELEMENTO().equals("Ar") && defesor.getELEMENTO().equals(("Terra"))) {
			double fator = atacante.getPODER() * atacante.getATAQUE() / defesor.getDEFESA() * 2;
			return fator;
		}
		return 0;
	}
	@Override
	public String fraseDeEfeito(Criatura criatura) {
		String frase = "LEVE COMO O VENTO, ÁGIL COMO UMA PLUMA, EU SOU A CRIATURA DAS ALTURAS";
		return frase;
	}
}