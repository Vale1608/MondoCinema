package cinema.model;

public class Sale {
	
	private int codSala;
	private int posti;
	private String nome;
	private String Citta;
	
	public Sale() {
		
	}
	
	public Sale(int codSala) {
		this.codSala = codSala;
	}
	
	public Sale(int posti, String nome, String Citta) {
		this.posti= posti;
		this.nome = nome;
		this.Citta = Citta;
	}
	

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Sale))return false;
		if(this == obj)return true;
		
		Sale sala = (Sale)obj;
		return this.codSala == sala.codSala;
	}
	
	@Override
	public String toString() {
		String s = ""+this.nome+" "+this.posti+" "+this.Citta;
		return s;
	}

	public int getCodSala() {
		return codSala;
	}

	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}

	public int getPostiASedere() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return Citta;
	}

	public void setCitta(String Citta) {
		this.Citta = Citta;
	}
	
	
}
