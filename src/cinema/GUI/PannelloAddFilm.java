package cinema.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cinema.model.Film;
import cinema.repository.FilmRepository;
import cinema.repository.FilmRepositoryImp;

public class PannelloAddFilm extends JPanel implements PanelSwitcher {
	
	private JLabel labelCodFilm = new JLabel("CodFilm");
    private JLabel labelTitolo = new JLabel("Titolo");
    private JLabel labelAnnoProduzione = new JLabel("AnnoProduzione");
    private JLabel labelNazionalita= new JLabel("Nazionalita");
    private JLabel labelRegista = new JLabel("Regista");
    private JLabel labelGenere= new JLabel("Genere");

    private JTextField textCodFilm = new JTextField(8);
    private JTextField textTitolo = new JTextField(8);
    private JTextField textAnnoProduzione = new JTextField(8);
    private JTextField textNazionalita = new JTextField(8);
    private JTextField textRegista = new JTextField(8);
    private JTextField textGenere= new JTextField(8);

    private JPanel jPanelNorth = new JPanel();
    private JPanel jPanelSouth = new JPanel();

    private PanelSwitcher panelSwitcher;
    private PannelloTabellaFilm pannelloTabFilm;
    private Film film;

    private FilmRepository filmRepository = new FilmRepositoryImp();
    
public PannelloAddFilm(PanelSwitcher panelSwitcher) {
    	
    	this.panelSwitcher = panelSwitcher;

    	jPanelNorth.add(labelCodFilm);
        jPanelNorth.add(textCodFilm);
        jPanelNorth.add(labelTitolo);
        jPanelNorth.add(textTitolo);
        jPanelNorth.add(labelAnnoProduzione);
        jPanelNorth.add(textAnnoProduzione);
        jPanelNorth.add(labelRegista);
        jPanelNorth.add(textRegista);
        jPanelNorth.add(labelGenere);
        jPanelNorth.add(textGenere);

        jPanelNorth.setLayout(new GridLayout(1,2));

        JButton salva = new JButton("Salva");
        JButton indietro = new JButton("Indietro");
        jPanelSouth.add(salva);
        jPanelSouth.add(indietro);

        indietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
           	     
          
            
            //PannelloTabella pt= new PannelloTabellaFilm();
            panelSwitcher.pannelloTabella();
            
            
            }
        });
        /* indietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSwitcher.pannelloTabella();
            }
        });
*/

        salva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(film != null) {

                    film.setTitolo(textTitolo.getText());
                    film.setAnnoProduzione(textAnnoProduzione.getText());
                    film.setNazionalita(textNazionalita.getText());
                    film.setRegista(textRegista.getText());
                    film.setGenere(textGenere.getText());
                    String codiceFilm=textCodFilm.getText();
                    film.setCodFilm(Integer.parseInt(codiceFilm));


                    filmRepository.update(film);
                }

                else {

                    String titolo = textTitolo.getText();
                    String codiceFilm=textCodFilm.getText();
                    int codFilm = Integer.parseInt(codiceFilm);
                    String annoProduzione = textAnnoProduzione.getText();
                    String Nazionalita = textNazionalita.getText();
                    String regista = textRegista.getText();
                    String genere = textGenere.getText();

                    Film film = new Film(codFilm, annoProduzione, Nazionalita,regista,genere);
                    filmRepository.save(film);
                }


            }
        });

        this.setLayout(new BorderLayout());
        this.add(jPanelNorth, BorderLayout.NORTH);
        this.add(jPanelSouth, BorderLayout.SOUTH);
    }
    public Film getfilm() {
        return this.film;
    }

    public void setFilm(Film film) {
        if(film != null) {
            this.film = film;

           
            String codiceFilm=textCodFilm.getText();
            int codFilm = Integer.parseInt(codiceFilm);
            String titolo = textTitolo.getText();
            String annoProduzione = textAnnoProduzione.getText();
            String nazionalita = textNazionalita.getText();
            String regista = textRegista.getText();
            String genere = textGenere.getText();
        }
    }
	@Override
	public void pannelloTabella() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pannelloAddFilm() {
		// TODO Auto-generated method stub
		
	}

	
}
   

