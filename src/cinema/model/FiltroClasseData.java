package cinema.model;

public class FiltroClasseData {
	private String titolo;
	private String data;
	private String sala;
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	@Override
	public String toString() {
		return "titolo=" + titolo + ", data=" + data + ", sala=" + sala ;
	}
	
}
