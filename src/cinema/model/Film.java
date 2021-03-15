package cinema.model;

import java.util.ArrayList;

public class Film {

	
	
	
	private int codFilm;
	private String titolo;
	private String annoProduzione;
	private	String Nazionalita;
	private	String regista;
	private String genere;
	
	public Film() {
		
	}
	
	public Film (int codFilm,String Titolo,String AnnoProduzione,String Regista,String Genere) {
		this.codFilm=codFilm;
		this.titolo=Titolo;
		this.annoProduzione=annoProduzione;
		this.regista=regista;
		this.genere=genere;
	
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Film))return false;
		if(this == obj)return true;
		
		Film film = (Film)obj;
		return this.codFilm == film.codFilm; 
	}
	@Override
	public String toString() {
		String s = ""+this.titolo+" "+this.annoProduzione+" "+this.Nazionalita+" "+this.regista+" "+this.genere;
		return s;
	}

	public void setCodFilm(int codFilm) {
		this.codFilm = codFilm;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getCodFilm() {
		return codFilm;
	}

	public String getTitolo() {
		return titolo;
	}

	

	public String getAnnoProduzione() {
		return annoProduzione;
	}

	public void setAnnoProduzione(String annoProduzione) {
		this.annoProduzione = annoProduzione;
	}

	public String getNazionalita() {
		return Nazionalita;
	}

	public void setNazionalita(String Nazionalita) {
		this.Nazionalita = Nazionalita;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	
	
}

