package cinema.GUI;

import java.util.Iterator;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import cinema.model.Attori;
import cinema.model.Film;
import cinema.repository.AttoriRepository;
import cinema.repository.AttoriRepositoryImp;
import cinema.repository.FilmRepository;
import cinema.repository.FilmRepositoryImp;

public class PannelloTabellaAttori extends PannelloTabella {

	private JScrollPane sp;
	private JTable attori ;
	private String colonna[]={"CodAttore","Nome","AnnoNascita", "Nazionalita"};
	private AttoriRepository attoriRepository = new AttoriRepositoryImp();
	
	public PannelloTabellaAttori() {}
	
	public PannelloTabellaAttori(PanelSwitcher panelSwitcher) {
        
		this.panelSwitcher = panelSwitcher;

		this.attori=new JTable(data,colonna);
	    this.sp=new JScrollPane(this.attori);
	    this.add(sp);
    }
	
	@Override
	public void cercaTable() {
		// TODO Auto-generated method stub
		List<Attori> attori= attoriRepository.attori();

        this.data = new Object[attori.size()][4];
        Iterator<Attori> ia = attori.iterator();
        int i = 0;
        while(ia.hasNext()) {
           Attori a = ia.next();
            System.out.println(a);
            if(a != null) {
                this.data[i][0] = a.getCodAttore();
                this.data[i][1] = a.getNome();
                this.data[i][2] = a.getAnnoNascita();
                this.data[i][3] = a.getNazionalita();
              
            }

            i++;
        }
	
	this.remove(this.sp);

    this.attori = new JTable(data, colonna);
    this.sp = new JScrollPane(this.attori);
    this.add(this.sp);
	}
}


	
	
	
	

