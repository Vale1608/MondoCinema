package cinema.GUI;

import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cinema.model.FiltroClasseData;
import cinema.repository.FiltroDataImp;


public class PannelloMesi extends PannelloTabella implements FiltroInterfaccia{
	
	private JScrollPane sp;
	private JTable filtroClasseData;
	private String colonna[]={"Titolo","Sala","DataProiezione"};
	private FiltroDataImp filtroData = new FiltroDataImp();
	protected Object[][] data = new Object[0][0];
	private String meseRic=null;
	
	
	
	public PannelloMesi(PanelSwitcher panelSwitcher) {
        
		this.panelSwitcher = panelSwitcher;

		this.filtroClasseData=new JTable(data,colonna);
	    this.sp=new JScrollPane(this.filtroClasseData);
	    this.add(sp);
    }
	
	
	public void cercaTable() {
		// TODO Auto-generated method stub
		String input = JOptionPane.showInputDialog("Inserire numero mese");
		String mesi= "-"+input+"-";
        //potevamo mettere un menu a tendina da far selezionare
        
		List<FiltroClasseData> filtroClasseData= filtroData.fcd(mesi);

        this.data = new Object[filtroClasseData.size()][3];
        Iterator<FiltroClasseData> ia = filtroClasseData.iterator();
        int i = 0;
        while(ia.hasNext()) {
        	FiltroClasseData a = ia.next();
            
            if(a != null) {
               this.data[i][0] = a.getTitolo();
               this.data[i][1] = a.getSala();
               this.data[i][2] = a.getData();
              
            }

            i++;
        }
	
	this.remove(this.sp);

    this.filtroClasseData = new JTable(data, colonna);
    this.sp = new JScrollPane(this.filtroClasseData);
    this.add(this.sp);
	





	
	
		
	
	
	}
	
}
