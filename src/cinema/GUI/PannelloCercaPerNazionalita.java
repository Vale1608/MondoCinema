package cinema.GUI;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Iterator;

import cinema.model.Attori;
import cinema.repository.AttoriRepository;
import cinema.repository.AttoriRepositoryImp;

public class PannelloCercaPerNazionalita extends PannelloTabella {

	private JTable attori;
	private JScrollPane sp;
	private String column[] = {"CodAttore","Nome","AnnoNascita","Nazionalita"};
	private Object[][] data = new Object[0][0];
	
	private AttoriRepository attoriRepository = new AttoriRepositoryImp();
	
	private PanelSwitcher panelSwitcher;
	
	private String nazionalita; 
	
	
	public PannelloCercaPerNazionalita() {}
	
	public PannelloCercaPerNazionalita(PanelSwitcher panelSwitcher) {
		
		this.panelSwitcher = panelSwitcher;
		this.attori = new JTable(data,column);
		this.sp= new JScrollPane(this.attori);
		this.add(sp);		
	}	

	@Override
	public void cercaTable() {
		
		String nazionalita = JOptionPane.showInputDialog("Inserire Nazionalita ");
		List<Attori> attori= attoriRepository.getAttori(nazionalita);

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

        this.attori = new JTable(data, column);
        this.sp = new JScrollPane(this.attori);
        this.add(this.sp);		
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita= nazionalita;
		
	}

}
