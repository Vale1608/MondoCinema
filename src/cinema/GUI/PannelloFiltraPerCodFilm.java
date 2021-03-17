package cinema.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PannelloFiltraPerCodFilm extends PannelloTabella {
	private JLabel labelCodFilm = new JLabel("CodFilm");
	
	private JTextField textCodFilm = new JTextField(8);
	
	private JPanel jPanelNorth = new JPanel();
    private JPanel jPanelSouth = new JPanel();
    
    
    
    public PannelloFiltraPerCodFilm(PanelSwitcher panelSwitcher) {
    	
    	this.panelSwitcher = panelSwitcher;
    	
    	jPanelNorth.add(labelCodFilm);
        jPanelNorth.add(textCodFilm);
        jPanelNorth.setLayout(new GridLayout(1,1));
        
        JButton vai = new JButton("Vai");
        jPanelSouth.add(vai);
        
        vai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n=Integer.parseInt(textCodFilm.getText());
				panelSwitcher.pannelloTabellaCodFilm(n);
				
			}
        });
        
        this.setLayout(new BorderLayout());
        this.add(jPanelNorth, BorderLayout.NORTH);
        this.add(jPanelSouth, BorderLayout.SOUTH);
    }



	@Override
	public void cercaTable() {
		// TODO Auto-generated method stub
		
	}
}
