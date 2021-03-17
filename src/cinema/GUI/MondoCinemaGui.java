package cinema.GUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

import cinema.model.Film;
import cinema.model.Sale;
import cinema.repository.FilmRepository;
import cinema.repository.FilmRepositoryImp;



public class MondoCinemaGui implements PanelSwitcher{
	
	private final int WIDTH = 800;
    private final int HEIGTH = 600;
    private JFrame frame;
   
    
    private PannelloTabellaAttori pannelloTabella2;
    private PannelloTabella pannelloTabella;
    private PannelloAddFilm pannelloAddFilm;
    private PannelloFiltraPerCitta pannelloFiltraPerCitta;
    private PannelloTabellaFiltraPerCitta pannelloTabellaFiltraPerCitta;
    private FilmRepository filmRepository = new FilmRepositoryImp();
    
    private Sale sale;
    private String citta;
    
    public MondoCinemaGui(String title) {
    	this.frame = new JFrame();
    	this.frame.setTitle(title);
    	this.frame.setSize(WIDTH, HEIGTH);
    	this.frame.setLocation(new Point(50,200));
    	this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();

        JMenu comandi = new JMenu("Comandi");
        JMenu attori=new JMenu("Attori");
        JMenuItem caricaAttori=new JMenuItem("Carica");
        JMenu film=new JMenu("Film");
        JMenuItem caricaFilm=new JMenuItem("Carica");
       // JMenu recita=new JMenu("Recita");
       // JMenuItem caricaRecita=new JMenuItem("Carica");
        JMenu proiezioni=new JMenu("Proiezioni");
        JMenuItem caricaProiezioni=new JMenuItem("Carica");
       // JMenu sale=new JMenu("Sale");
       // JMenuItem caricaSale=new JMenuItem("Carica");
        film.add(caricaFilm);
       // sale.add(caricaSale);
       // recita.add(caricaRecita);
        proiezioni.add(caricaProiezioni);
        attori.add(caricaAttori);

        
        JMenuItem addFilm = new JMenuItem("AddFilm");
        JMenuItem update = new JMenuItem("Update");
        JMenuItem delete = new JMenuItem("Delete");
        JMenuItem close = new JMenuItem("Close");


      
        JMenu filtraper= new JMenu("Filtra per");
        JMenuItem titoloeCod = new JMenuItem("Titolo e CodFilm");
        JMenuItem listafilm = new JMenuItem("ListaFilm");
        JMenuItem codFilm=new JMenuItem("CodFilm");
        JMenuItem titoloeanno=new JMenuItem("Titolo e Anno");
        JMenuItem salePerCitta = new JMenuItem("Sale per Città");
        
        filtraper.add(titoloeCod);
        filtraper.add(listafilm);
        filtraper.add(codFilm);
        filtraper.add(titoloeanno);
        
        filtraper.add(salePerCitta);
        pannelloFiltraPerCitta = new PannelloFiltraPerCitta(this);
        salePerCitta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pannelloFiltraPerCitta();
			}
		});
        
        
        comandi.add(filtraper);
        
        
        
        close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(-1);
			}
        	
         });
        
        
        comandi.add(addFilm);
        comandi.add(update);
        comandi.add(delete);
        comandi.add(close);
        menuBar.add(comandi);
        menuBar.add(attori);
        menuBar.add(film);
       // menuBar.add(recita);
        menuBar.add(proiezioni);
        //menuBar.add(sale);
        
        addFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                pannelloAddFilm();

            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Dammi il codice del film da aggiornare");
                Integer CodFilm = Integer.parseInt(input);

                Film film = filmRepository.getFilm(CodFilm);
                pannelloAddFilm.setFilm(film);

                switchTo(pannelloAddFilm);
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Dammi il CodFilm del film da eliminare");
                Integer CodFilm = Integer.parseInt(input);

                filmRepository.delete(CodFilm);
            }
        });

        this.frame.setJMenuBar(menuBar);
   
        
//        pannelloTabella = new PannelloTabella1(this);
//        pannelloTabella =new PannelloTabella2(this);
//        pannelloTabella=new PannelloTabella3(this);
  
        
        pannelloAddFilm = new PannelloAddFilm(this);
       
     
        caricaAttori.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pannelloTabella =new PannelloTabellaAttori(MondoCinemaGui.this);
				pannelloTabella.cercaTable();
				switchTo(pannelloTabella);
			}
        
        });
        caricaFilm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pannelloTabella = new PannelloTabellaFilm(MondoCinemaGui.this);
				pannelloTabella.cercaTable();
				switchTo(pannelloTabella);
				
			}
		});              
        caricaProiezioni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pannelloTabella=new PannelloTabellaProiezioni(MondoCinemaGui.this);
				pannelloTabella.cercaTable();
				switchTo(pannelloTabella);
			}
        	
        });
       // this.frame.add(this.pannelloTabella, BorderLayout.CENTER);
       // this.pannelloTabella();
        this.frame.setVisible(true);
       
     
    }
 
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() { //classe interna anonima
            @Override
            public void run() {
                PanelSwitcher mondoCinema = new MondoCinemaGui("MondoCinema");
            }
        });
    }

	@Override
	public void pannelloTabella() {
		
		// TODO Auto-generated method stub
		switchTo(pannelloTabella);
	}
	
	@Override
	public void pannelloAddFilm() {
	     switchTo(pannelloAddFilm);
	}
	
//	private void switchTo(PannelloAddFilm pannelloFilm) {
//		// TODO Auto-generated method stub
//		this.frame.setContentPane(pannelloAddFilm);
//        this.frame.pack();
//	}
//	
//	
//	 
//	private void switchTo(PannelloTabella pannelloTabella) {
//		// TODO Auto-generated method stub
//		this.frame.setContentPane(pannelloTabella);
//        this.frame.pack();
//	}
	
	private void switchTo(JComponent component) {
		// TODO Auto-generated method stub
		this.frame.setContentPane(component);
        this.frame.pack();
	}
	 private class CercaTable implements ActionListener {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	           MondoCinemaGui.this.pannelloTabella.cercaTable();
	            switchTo(MondoCinemaGui.this.pannelloTabella);

	        }
	    }
	@Override
	public void pannelloFiltraPerCitta() {
		switchTo(pannelloFiltraPerCitta);
		
	} 
	
	public void setCitta(String citta) {
		this.citta = citta;
	}


	@Override
	public void pannelloTabellaFiltraPerCitta(String citta) {
		this.pannelloTabellaFiltraPerCitta = new PannelloTabellaFiltraPerCitta(this);
		this.pannelloTabellaFiltraPerCitta.setCitta(citta);
		this.pannelloTabellaFiltraPerCitta.cercaTable();
		switchTo(pannelloTabellaFiltraPerCitta);
		
	}

}
