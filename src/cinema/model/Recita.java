package cinema.model;

public class Recita {
	
	private int codAttore;
	private int codFilm;
	
	public Recita() {
		
	}
	
	public Recita(int codAttore,int codFilm) {
		this.codAttore = codAttore;
		this.codFilm = codFilm;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Recita))return true;
		if(this == obj)return true;
		Recita recita = (Recita)obj;
		return this.codAttore == recita.codAttore && this.codFilm==recita.codFilm;
	}
	
	@Override
	public String toString() {
		String s = ""+this.codAttore+" "+this.codFilm;
		return s;
	}

	public int getCodAttore() {
		return codAttore;
	}

	public void setCodAttore(int codAttore) {
		this.codAttore = codAttore;
	}

	public int getCodFilm() {
		return codFilm;
	}

	public void setCodFilm(int codFilm) {
		this.codFilm = codFilm;
	}
	
}

