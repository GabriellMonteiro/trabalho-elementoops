package entites;

import java.util.Random;

public class BurnCoder extends Criatura{
	private String NOME;
	private String ELEMENTO;
	private int PODER;
	private int ATAQUE;
	private int DEFESA;
	private int VELOCIDADE;
	private int PONTOS_DE_VIDA;
	private int pontosDeVidaInilcial;

	public BurnCoder(){
		Random rand = new Random();
		setNOME("BurnCoder");
		setELEMENTO("Fogo");
		setPODER(rand.nextInt(21) + 10);
		setATAQUE(rand.nextInt(11) + 5);
		setDEFESA(rand.nextInt(11) + 5);
		setVELOCIDADE(rand.nextInt(10) + 1);
		setPONTOS_DE_VIDA(rand.nextInt(201) + 200);
		setPontosDeVidaInilcial(getPONTOS_DE_VIDA());

	}
	@Override
	public double fatorCriatura(Criatura atacante, Criatura defesor) {
		if (atacante.getELEMENTO().equals("Fogo") && defesor.getELEMENTO().equals(("Terra"))) {
			double fator = atacante.getPODER() * atacante.getATAQUE() / defesor.getDEFESA() * 1;
			return fator;
		} else if (atacante.getELEMENTO().equals("Fogo") && defesor.getELEMENTO().equals(("Agua"))){
			double fator = atacante.getPODER() * atacante.getATAQUE() / defesor.getDEFESA() * 1;
			return fator;

		} else if(atacante.getELEMENTO().equals("Fogo") && defesor.getELEMENTO().equals(("Fogo"))) {
			double fator = atacante.getPODER() * atacante.getATAQUE() / defesor.getDEFESA() * 0.5;
			return fator;

		} else if (atacante.getELEMENTO().equals("Fogo") && defesor.getELEMENTO().equals(("Ar"))){
			double fator = atacante.getPODER() * atacante.getATAQUE() / defesor.getDEFESA() * 2;
			return fator;
		}
		return 0;
	}
	@Override
	public String fraseDeEfeito(Criatura criatura) {
		String frase = "PRONTO PARA CONSUMIR TUDO EM MEU CAMINHO E DEIXAR APENAS CINZAS PARA TRÁS";
		return frase;
	}

}
