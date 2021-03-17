package cinema.model;

public class Attori {
	
	private int CodAttore;
	private String Nome;
	private int AnnoNascita;
	private String Nazionalita;
	
	public Attori() {
		
	}
	
	public Attori(int CodAttore,String Nome,int AnnoNscita,String Nazionalita) {
		this.CodAttore=CodAttore;
		this.Nome=Nome;
		this.AnnoNascita=AnnoNascita;
		this.Nazionalita=Nazionalita;
	}

	public int getCodAttore() {
		return CodAttore;
	}

	public void setCodAttore(int codAttore) {
		CodAttore = codAttore;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getAnnoNascita() {
		return AnnoNascita;
	}

	public void setAnnoNascita(int annoNascita) {
		AnnoNascita = annoNascita;
	}

	public String getNazionalita() {
		return Nazionalita;
	}

	public void setNazionalita(String Nazionalita) {
		this.Nazionalita = Nazionalita;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Attori)) return false;
		if(this==o) return true;
		Attori a=(Attori) o;
		return this.CodAttore == a.CodAttore;
	}
	
	@Override
	public String toString() {
		
		String s = ""+this.Nome+" "+this.AnnoNascita+" "+this.Nazionalita;
		return s;
		
	}
}
