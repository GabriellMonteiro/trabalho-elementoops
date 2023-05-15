package criatura;

import application.Batalha;

public abstract class Criatura {
	private String nome;
	private String elemento;
	private int poder;
	private int ataque;
	private int defesa;
	private int velocidade;
	private int pontosDeVida;
	private int pontosDeVidaInilcial;


	public Criatura() {
		setNome(this.nome);
		setElemento(this.elemento);
		setPoder(this.poder);
		setAtaque(this.ataque);
		setDefesa(this.defesa);
		setVelocidade(this.velocidade);
		setPontosDeVida(this.pontosDeVida);
		setPontosDeVidaInilcial(this.pontosDeVida);
	}
	Batalha batalha = new Batalha();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public int getPontosDeVida() {
		return pontosDeVida;
	}

	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}

	public int getPontosDeVidaInilcial() {return pontosDeVidaInilcial;}

	public void setPontosDeVidaInilcial(int pontosDeVidaInilcial) {this.pontosDeVidaInilcial = pontosDeVidaInilcial;}

	public void receberDano(Criatura atacante, Criatura defensor, double fator){
		if(fator == 0){
			int DANO = (atacante.getPoder() * atacante.getAtaque())
					/ defensor.getDefesa();
			defensor.setPontosDeVida(defensor.getPontosDeVida() - DANO);
		} else {
			double DANO = fator;
			defensor.setPontosDeVida((int) (defensor.getPontosDeVida() - DANO));
		}
	}

	public void ataqueFisico(Criatura atacante, Criatura defensor) {
		int DANO = (atacante.getPoder() * atacante.getAtaque())
				/ defensor.getDefesa();
		System.out.println(atacante.getNome().toUpperCase() + " EFETUOU UM ATAQUE FÍSICO");
		receberDano(atacante, defensor, 0);
		System.out.println("DANO: -" + DANO);
		if (defensor.getPontosDeVida() < 0) {
			System.out.println("PONTOS DE VIDA RESTANTE DO " + defensor.getNome().toUpperCase() + ": 0");
		}else{
			System.out.println("PONTOS DE VIDA RESTANTE DO " + defensor.getNome().toUpperCase() + ": " + defensor.getPontosDeVida());
		}
		System.out.println();
		batalha.tempoDeEspera();
	}

	public void ataqueElemental(Criatura atacante, Criatura defensor) {
		double fator = fatorCriatura(atacante, defensor);
		System.out.println(atacante.getNome().toUpperCase() + " EFETUOU O " + fraseDeAtaque(atacante)) ;
		System.out.println("DANO: -" + fator);
		receberDano(atacante, defensor, fator);
			if (defensor.getPontosDeVida() < 0) {
				System.out.println("PONTOS DE VIDA RESTANTE DO " + defensor.getNome().toUpperCase() + ": 0");
			}else{
				System.out.println("PONTOS DE VIDA RESTANTE DO " + defensor.getNome().toUpperCase() + ": " + defensor.getPontosDeVida());
			}
		System.out.println();
		batalha.tempoDeEspera();
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
						"_________________________________", criatura.getNome(), criatura.getElemento(),
				criatura.getPoder(), criatura.getAtaque(),
				criatura.getDefesa(), criatura.getVelocidade(),
				criatura.getPontosDeVida());
	}

	public abstract double fatorCriatura(Criatura atacante, Criatura defesor);
	public abstract String fraseDeEfeito(Criatura criatura);
	public abstract String fraseDeAtaque(Criatura criatura);

}