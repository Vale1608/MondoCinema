package cinema.repository;

import java.util.ArrayList;
import java.util.List;

import cinema.model.Film;

import java.sql.*;

public class FilmRepositoryImp implements FilmRepository {
	
	@Override
	public boolean save(Film film) {
		 Connection conn = ConnectionDatabase.getConnection();

	        PreparedStatement preparedStatement = null;

	        int isSaved = 0;
	        try {
	            preparedStatement = conn.prepareStatement("INSERT INTO contact VALUES(null,?,?,?,?,?)");

	            preparedStatement.setInt(1, film.getCodFilm());
	            preparedStatement.setString(2, film.getTitolo());
	            preparedStatement.setString(3, film.getAnnoProduzione());
	            preparedStatement.setString(4, film.getRegista());
	            preparedStatement.setString(5, film.getGenere());

	            isSaved = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                preparedStatement.close();
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return isSaved != 0;
	    }
	
	@Override
	public boolean aggiungi(Film film) {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		int cercato=0;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO film VALUES(null,?,?,?,?,?,?)");
			
	        preparedStatement.setString(1, film.getTitolo());
	        preparedStatement.setString(2, film.getAnnoProduzione());
	        preparedStatement.setString(4, film.getNazionalita());
	        preparedStatement.setString(3, film.getRegista());
	        preparedStatement.setString(5, film.getGenere());
		} catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return cercato!=0;
	}

	@Override
	public boolean update(Film film) {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		int modificato=0;
		try {
			//controllare scritte stringa 
			preparedStatement = conn.prepareStatement("UPDATE film  Titolo = ?, AnnoProduzione = ?, Nazionalita = ?, Regista = ?, Genere=?, WHERE CodFilm = ?");
			
	        preparedStatement.setString(1, film.getTitolo());
	        preparedStatement.setString(2, film.getAnnoProduzione());
	        preparedStatement.setString(3, film.getNazionalita());
	        preparedStatement.setString(4, film.getRegista());
	        preparedStatement.setString(5, film.getGenere());
	        preparedStatement.setInt(6, film.getCodFilm());
		} catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
		
		
		return modificato!=0;
	}

	@Override
	public boolean delete(Integer CodFilm) {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		int isDeleted = 0;
        try {
            preparedStatement = conn.prepareStatement("DELETE FROM Film WHERE CodFilm = ?");

            preparedStatement.setInt(1, CodFilm);

            isDeleted = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isDeleted != 0;
	}

	@Override
	public Film cerca(String titolo, int codFilm) {
		
		Connection conn = ConnectionDatabase.getConnection();
		Film film=null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement=conn.prepareStatement("SELECT * FROM film WHERE titolo=? and codFilm=?");
			preparedStatement.setString(1, titolo);
			preparedStatement.setInt(2, codFilm);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				film=new Film();
				
				 film.setCodFilm(resultSet.getInt("CodFilm"));
				 film.setTitolo( resultSet.getString("Titolo"));
	             film.setAnnoProduzione( resultSet.getString("AnnoProduzione"));
	             film.setNazionalita( resultSet.getString("Nazionalita") );
	             film.setRegista( resultSet.getString("regista") );
	             film.setGenere( resultSet.getString("genere") );
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return film;
		
		
		
		
		
	}

	@Override
	public List<Film> film() {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		List<Film> film = new ArrayList<>();
	    Statement statement = null;
	    ResultSet resultSet = null;
	        try {
	            statement = conn.createStatement();

	            resultSet = statement.executeQuery("SELECT * FROM film");
	            while(resultSet.next()) {
	                Film f = new Film();
	                
	                f.setCodFilm(resultSet.getInt("CodFilm"));
	                f.setTitolo( resultSet.getString("Titolo"));
	                f.setAnnoProduzione( resultSet.getString("AnnoProduzione"));
	                f.setNazionalita( resultSet.getString("Nazionalita") );
	                f.setRegista( resultSet.getString("regista") );
	                f.setGenere( resultSet.getString("genere") );
	             
	               

	                film.add(f);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                statement.close();
	                resultSet.close();
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return film;

		
		
	}

	@Override
	public Film getFilm(Integer CodFilm) {
		
		Connection conn = ConnectionDatabase.getConnection();
		Film film=null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Film WHERE CodFilm = ? ");
			preparedStatement.setInt(1, CodFilm);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				film=new Film();
				
				film.setCodFilm(CodFilm);
				film.setTitolo(resultSet.getString("Titolo"));
				film.setAnnoProduzione(resultSet.getString("AnnoProduzione"));
				film.setNazionalita(resultSet.getString("Nazionalita"));
				film.setRegista(resultSet.getString("Regista"));
				film.setGenere(resultSet.getString("Genere"));
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				preparedStatement.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return film;
	}

	@Override
	public Film getFilm(String titolo, String annoProduzione) {
		
		Connection conn = ConnectionDatabase.getConnection();
		Film film=null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM film WHERE titolo=? and annoProduzione=?");
			preparedStatement.setString(1,titolo );
			preparedStatement.setString(2,annoProduzione);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				film=new Film();
				
				film.setCodFilm(resultSet.getInt("CodFilm"));
				film.setTitolo(resultSet.getString("Titolo"));
				film.setAnnoProduzione(resultSet.getString("AnnoProduzione"));
				film.setNazionalita(resultSet.getString("Nazionalita"));
				film.setRegista(resultSet.getString("Regista"));
				film.setGenere(resultSet.getString("Genere"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try{
				preparedStatement.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return film;
			
	}	
}
