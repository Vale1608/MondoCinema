package cinema.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cinema.repository.FilmRepository;
import cinema.repository.FilmRepositoryImp;

public abstract class PannelloTabella extends JPanel {
	
	protected Object[][] data = new Object[0][0];
	
	
	protected PanelSwitcher panelSwitcher;
	
	
	public abstract void cercaTable() ;
	
}
