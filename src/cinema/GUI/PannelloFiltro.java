package cinema.GUI;

import java.util.Iterator;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import cinema.model.FiltroClasseData;
import cinema.model.Proiezioni;
import cinema.repository.FilmRepository;
import cinema.repository.FiltroData;
import cinema.repository.ProiezioniRepository;
import cinema.repository.ProiezioniRepositoryImp;

public class PannelloFiltro extends PannelloTabella {
	
	private JScrollPane sp;
	private JTable filtroClasseData;
	private String colonna[]={"Titolo","Sala","DataProiezione"};
	private FiltroData filtroData = new FiltroData();
	private String mese=null;
	
	
	
	public PannelloFiltro(PanelSwitcher panelSwitcher) {
        
		this.panelSwitcher = panelSwitcher;

		this.filtroClasseData=new JTable(data,colonna);
	    this.sp=new JScrollPane(this.filtroClasseData);
	    this.add(sp);
    }
	
	@Override
	public void cercaTable() {
		// TODO Auto-generated method stub
		List<FiltroClasseData> filtroClasseData= filtroData.fcd(mese);

        this.data = new Object[filtroClasseData.size()][3];
        Iterator<FiltroClasseData> ia = filtroClasseData.iterator();
        int i = 0;
        while(ia.hasNext()) {
        	FiltroClasseData a = ia.next();
            System.out.println(a);
            if(a != null) {
               this.data[i][1] = a.getTitolo();
                this.data[i][2] = a.getSala();
                this.data[i][3] = a.getData();
              
            }

            i++;
        }
	
	this.remove(this.sp);

    this.filtroClasseData = new JTable(data, colonna);
    this.sp = new JScrollPane(this.filtroClasseData);
    this.add(this.sp);
	}
}
