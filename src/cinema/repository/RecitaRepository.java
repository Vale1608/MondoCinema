package cinema.repository;
import java.util.List;

import cinema.model.Recita;

public interface RecitaRepository {
	
	boolean aggiungi(Recita recita);
	boolean update(Recita recita);
	boolean delete(Integer codAttore, Integer codFilm);
	List<Recita> recita();
	Recita getRecita(int codAttore,int codFilm);
	
}

