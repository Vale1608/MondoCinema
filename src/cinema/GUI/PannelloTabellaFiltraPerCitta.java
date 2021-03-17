package cinema.GUI;

import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cinema.model.Sale;
import cinema.repository.SaleRepository;
import cinema.repository.SaleRepositoryImpl;

public class PannelloTabellaFiltraPerCitta extends PannelloTabella {
	
	private JTable sala;
	private JScrollPane sp;
	private String column[] = {"Nome","Posti"};
	private Object[][] data = new Object[0][0];
	
	private SaleRepository saleRepository = new SaleRepositoryImpl();
	
	private PanelSwitcher panelSwitcher;
	
	private String citta; 
	
	public PannelloTabellaFiltraPerCitta() {}
	
	public PannelloTabellaFiltraPerCitta(PanelSwitcher panelSwitcher) {
		
		this.panelSwitcher = panelSwitcher;
		this.sala = new JTable(data,column);
		this.sp= new JScrollPane(this.sala);
		this.add(sp);		
	}	

	@Override
	public void cercaTable() {
		List<Sale> sale;
		sale = saleRepository.filtraPerCitta(citta);

		this.data = new Object[sale.size()][2];
		Iterator<Sale> ia = sale.iterator();
		int i = 0;
		while(ia.hasNext()) {
			Sale sl = ia.next();
			System.out.println(sl);
			if(sl != null) {
				this.data[i][0] = sl.getNome();
				this.data[i][1] = sl.getPostiASedere();
			}
			
			i++;
		}
		
		this.remove(this.sp);

        this.sala = new JTable(data, column);
        this.sp = new JScrollPane(this.sala);
        this.add(this.sp);		
	}

	public void setCitta(String citta) {
		this.citta = citta;
		
	}


}
