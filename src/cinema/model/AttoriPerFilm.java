package cinema.model;

public class AttoriPerFilm {
	private String nomeattore;
	private String nomefilm;
	
	public AttoriPerFilm() {}
	
	public AttoriPerFilm(String nomeattore, String nomefilm) {
		this.nomeattore=nomeattore;
		this.nomefilm=nomefilm;
	}
	
	public String getNomeA() {
		return this.nomeattore;
	}
	
	public String getNomeF() {
		return this.nomefilm;
	}
	
	public void setNomeA(String nome) {
		this.nomeattore=nome;
	}
	
	public void setNomeF(String nome) {
		this.nomefilm=nome;
	}
}
