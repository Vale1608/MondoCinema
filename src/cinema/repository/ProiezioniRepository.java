package cinema.repository;
import java.util.List;

import cinema.model.Proiezioni;

public interface ProiezioniRepository {


	
		



	    boolean aggiungi(Proiezioni proiezione);
	    boolean update(Proiezioni proiezione);
	    boolean delete(Integer CodProiezione);
	    Proiezioni cerca(String dataProiezione,int codFilm);
	    List<Proiezioni> proiezioni();
	    //get qualcosa in base ai paramentri film
	    
	    Proiezioni getProiezioni(int codFilm, String dataProiezione);
		Proiezioni getProiezioni(int codFilm, int codSala);
		



	}

