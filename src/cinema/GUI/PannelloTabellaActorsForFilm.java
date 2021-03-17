package cinema.GUI;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.Iterator;
import java.util.List;

import cinema.model.AttoriPerFilm;
import cinema.repository.SelectActorsForFilm;
import cinema.repository.SelectActorsForFilmImpl;

import java.sql.*;

public class PannelloTabellaActorsForFilm extends PannelloTabella {
	private JScrollPane sp;
	private JTable actorsforfilm;
	
	private String colonna[]= {"nome", "titolo"};
	private SelectActorsForFilm SelectActors=new SelectActorsForFilmImpl();
	
	
	private int numero;
	
	public PannelloTabellaActorsForFilm() {}
	
	public PannelloTabellaActorsForFilm(PanelSwitcher panelSwitcher) {
		this.panelSwitcher=panelSwitcher;
		
		this.actorsforfilm=new JTable(data,colonna);
		
		this.sp=new JScrollPane(this.actorsforfilm);
		
		this.add(sp);
		
	}
	
	public void setNumero(int n) {
		this.numero=n;
	}
	
	
	@Override
	public void cercaTable() {
		List<AttoriPerFilm> aflista=SelectActors.joinactors(this.numero);
		this.data = new Object[aflista.size()][2];
		Iterator<AttoriPerFilm> ia=aflista.iterator();
		int i=0;
		while(ia.hasNext()) {
			AttoriPerFilm af=ia.next();
			System.out.println(af);
			if (af!=null) {
				this.data[i][0]=af.getNomeA();
				this.data[i][1]=af.getNomeF();
			}
			i++;
		}
		
		this.remove(this.sp);
		
		this.actorsforfilm=new JTable(data,colonna);
		this.sp = new JScrollPane(this.actorsforfilm);
		this.add(this.sp);
	}
	
	
}
