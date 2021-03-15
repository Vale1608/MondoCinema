package cinema.model;

public class Proiezioni {
	
	private int codProiezione;
	private int codFilm;
	private int codSala;
	private int incasso;
	private String dataProiezione;
	
	public Proiezioni() {
		
	}
	
	public Proiezioni(int codProiezione) {
		this.codProiezione = codProiezione;
	}
	
	public Proiezioni(int codFilm, int codSala, int incasso, String dataProiezione) {
		this.codFilm = codFilm;
		this.codSala = codSala;
		this.incasso = incasso;
		this.dataProiezione = dataProiezione;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Proiezioni))return false;
		if(this == obj)return true;
		Proiezioni proiezione = (Proiezioni)obj;
		return this.codProiezione == proiezione.codProiezione;
	}
	
	@Override
	public String toString() {
		String s = ""+this.codFilm+" "+this.codSala+" "+this.incasso+" "+this.dataProiezione;
		return s;
	}

	public int getCodProiezione() {
		return codProiezione;
	}

	public void setCodProiezione(int codProiezione) {
		this.codProiezione = codProiezione;
	}

	public int getCodFilm() {
		return codFilm;
	}

	public void setCodFilm(int codFilm) {
		this.codFilm = codFilm;
	}

	public int getCodSala() {
		return codSala;
	}

	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}

	public int getIncasso() {
		return incasso;
	}

	public void setIncasso(int incasso) {
		this.incasso = incasso;
	}

	public String getDataProiezione() {
		return dataProiezione;
	}

	public void setDataProiezione(String dataProiezione) {
		this.dataProiezione = dataProiezione;
	} 

}

	
