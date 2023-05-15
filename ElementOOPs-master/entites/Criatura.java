package entites;

public abstract class Criatura {

	private String NOME;
	private String ELEMENTO;
	private int PODER;
	private int ATAQUE;
	private int DEFESA;
	private int VELOCIDADE;
	private int PONTOS_DE_VIDA;
	private int pontosDeVidaInilcial;

	public Criatura() {
		setNOME(this.NOME);
		setELEMENTO(this.ELEMENTO);
		setPODER(this.PODER);
		setATAQUE(this.ATAQUE);
		setDEFESA(this.DEFESA);
		setVELOCIDADE(this.VELOCIDADE);
		setPONTOS_DE_VIDA(this.PONTOS_DE_VIDA);
		setPontosDeVidaInilcial(this.PONTOS_DE_VIDA);
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String NOME) {
		this.NOME = NOME;
	}

	public String getELEMENTO() {
		return ELEMENTO;
	}

	public void setELEMENTO(String ELEMENTO) {
		this.ELEMENTO = ELEMENTO;
	}

	public int getPODER() {
		return PODER;
	}

	public void setPODER(int PODER) {
		this.PODER = PODER;
	}

	public int getATAQUE() {
		return ATAQUE;
	}

	public void setATAQUE(int ATAQUE) {
		this.ATAQUE = ATAQUE;
	}

	public int getDEFESA() {
		return DEFESA;
	}

	public void setDEFESA(int DEFESA) {
		this.DEFESA = DEFESA;
	}

	public int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public void setVELOCIDADE(int VELOCIDADE) {
		this.VELOCIDADE = VELOCIDADE;
	}

	public int getPONTOS_DE_VIDA() {
		return PONTOS_DE_VIDA;
	}

	public void setPONTOS_DE_VIDA(int PONTOS_DE_VIDA) {
		this.PONTOS_DE_VIDA = PONTOS_DE_VIDA;
	}

	public int getPontosDeVidaInilcial() {return pontosDeVidaInilcial;}

	public void setPontosDeVidaInilcial(int pontosDeVidaInilcial) {this.pontosDeVidaInilcial = pontosDeVidaInilcial;}

	public void receberDano(Criatura atacante, Criatura defensor, double fator){
		if(fator == 0){
			int DANO = (atacante.getPODER() * atacante.getATAQUE())
					/ defensor.getDEFESA();
			defensor.setPONTOS_DE_VIDA(defensor.getPONTOS_DE_VIDA() - DANO);
		} else {
			double DANO = fator;
			defensor.setPONTOS_DE_VIDA((int) (defensor.getPONTOS_DE_VIDA() - DANO));
		}
	} // Define o dano e subtrai dos pontos de vida

	public void ataqueFisico(Criatura atacante, Criatura defensor) {
		int DANO = (atacante.getPODER() * atacante.getATAQUE())
				/ defensor.getDEFESA();
		System.out.println(atacante.getNOME().toUpperCase() + " EFETUOU UM ATAQUE FÍSICO");
		receberDano(atacante, defensor, 0);
		System.out.println("DANO: -" + DANO);
		System.out.println("PONTOS DE VIDA RESTANTE: " + defensor.getPONTOS_DE_VIDA());
		System.out.println();
	} // ataque fisico

	public void ataqueElemental(Criatura atacante, Criatura defensor) {
		double fator = fatorCriatura(atacante, defensor);
		System.out.println(atacante.getNOME().toUpperCase() + " EFETUOU UM ATAQUE ELEMENTAL");
		receberDano(atacante, defensor, fator);
		System.out.println("DANO: -" + fator);
		System.out.println("PONTOS DE VIDA RESTANTE: " + defensor.getPONTOS_DE_VIDA());
		System.out.println();
		//mexi no ataque elemental, o fator está dando 0.0, ms só do inimigo
	}
	public String caracteristicas(Criatura criatura) {
		return String.format("" +
						"CRIATURA: %s\n" +
						"ELEMENTO: %s\n" +
						"PODER: %d\n" +
						"ATAQUE: %d\n" +
						"DEFESA: %d\n" +
						"VELOCIDADE: %d\n" +
						"PONTOS DE VIDA: %d\n" +
						"_________________________________", criatura.getNOME(), criatura.getELEMENTO(),
				criatura.getPODER(), criatura.getATAQUE(),
				criatura.getDEFESA(), criatura.getVELOCIDADE(),
				criatura.getPONTOS_DE_VIDA());
	}

	public abstract double fatorCriatura(Criatura atacante, Criatura defesor);
	public abstract String fraseDeEfeito(Criatura criatura);

} // FIM DA CLASSE CRIATURAS