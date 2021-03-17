package cinema.repository;

import java.util.List;

import cinema.model.Film;

public interface FilmRepository {
	


    boolean save(Film film);
    boolean aggiungi(Film film);
    boolean update(Film film);
    boolean delete(Integer CodFilm);
    Film cerca(String titolo,int codFilm);
    List<Film> film();
    //get qualcosa in base ai paramentri film
    
    Film getFilm(Integer id);
    Film getFilm(String titolo, String annoProduzione);
	



}

