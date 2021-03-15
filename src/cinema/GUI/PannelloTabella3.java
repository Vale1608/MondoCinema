package cinema.GUI;

import java.util.Iterator;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import cinema.model.Proiezioni;
import cinema.repository.ProiezioniRepository;
import cinema.repository.ProiezioniRepositoryImp;

public class PannelloTabella3 extends PannelloTabella {
	
	private JScrollPane sp;
	private JTable proiezioni;
	private String colonna[]={"CodProiezione","CodFilm","CodSala", "Incasso","DataProiezione"};
	private ProiezioniRepository proiezioniRepository = new ProiezioniRepositoryImp();
	
	public PannelloTabella3() {}
	
	public PannelloTabella3(PanelSwitcher panelSwitcher) {
        
		this.panelSwitcher = panelSwitcher;

		this.proiezioni=new JTable(data,colonna);
	    this.sp=new JScrollPane(this.proiezioni);
	    this.add(sp);
    }
	
	@Override
	public void cercaTable() {
		// TODO Auto-generated method stub
		List<Proiezioni> attori= proiezioniRepository.proiezioni();

        this.data = new Object[attori.size()][5];
        Iterator<Proiezioni> ia = attori.iterator();
        int i = 0;
        while(ia.hasNext()) {
           Proiezioni a = ia.next();
            System.out.println(a);
            if(a != null) {
                this.data[i][0] = a.getCodProiezione();
                this.data[i][1] = a.getCodFilm();
                this.data[i][2] = a.getCodSala();
                this.data[i][3] = a.getIncasso();
                this.data[i][4] = a.getDataProiezione();
              
            }

            i++;
        }
	
	this.remove(this.sp);

    this.proiezioni = new JTable(data, colonna);
    this.sp = new JScrollPane(this.proiezioni);
    this.add(this.sp);
	}
}
