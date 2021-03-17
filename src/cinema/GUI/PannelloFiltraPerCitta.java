package cinema.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cinema.model.Sale;
import cinema.repository.SaleRepository;
import cinema.repository.SaleRepositoryImpl;

public class PannelloFiltraPerCitta extends JPanel{
	
	private JLabel citta = new JLabel("Città: ");
	private JTextField cittaTxt = new JTextField(24);
	
	private JLabel field = new JLabel("Cerca Sale per citta");
	private JButton cerca = new JButton("Cerca");
	private JButton esci = new JButton("Esci");
	
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	
	private SaleRepository saleRepository = new SaleRepositoryImpl();
	private PanelSwitcher panelSwitcher;
	private PannelloTabellaFiltraPerCitta pannelloTabellaFiltraPerCitta;
	private String c;
	
	public PannelloFiltraPerCitta(PanelSwitcher panelSwitcher) {
		this.panelSwitcher = panelSwitcher;
		
		northPanel = new JPanel();
		northPanel.add(field);
		
		centerPanel = new JPanel();
		centerPanel.add(citta);
		centerPanel.add(cittaTxt);
		
		southPanel = new JPanel();
		southPanel.add(cerca);
		southPanel.add(esci);
		
		this.setLayout(new BorderLayout());
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.esci.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
			}
		});
        
        this.cerca.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String c = cittaTxt.getText();
				
				if(c == null) {
					field.setText("Nessuna corrispondenza trovata!");
				}
				
				panelSwitcher.pannelloTabellaFiltraPerCitta(c);
			}
		});
	}

}
