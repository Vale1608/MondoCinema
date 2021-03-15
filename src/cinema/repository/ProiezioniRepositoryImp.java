package cinema.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cinema.model.Proiezioni;

public class ProiezioniRepositoryImp implements ProiezioniRepository {

	@Override
	public boolean aggiungi(Proiezioni proiezione) {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		int cercato=0;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO proiezioni VALUES(?,?,?,?,?)");
			//public Proiezioni(int codFilm, int codSala,int proiezione, int incasso, String dataproiezione)
			//controllare se set int o Integer
	        preparedStatement.setInt(1, proiezione.getCodFilm());
	        preparedStatement.setInt(2, proiezione.getCodSala());
			preparedStatement.setInt(3, proiezione.getCodProiezione());
	        preparedStatement.setInt(4, proiezione.getIncasso());
	        preparedStatement.setString(5, proiezione.getDataProiezione());
	        
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
	public boolean update(Proiezioni proiezione) {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		int modificato=0;
		try {
			//controllare scritte stringa 
			preparedStatement = conn.prepareStatement("UPDATE proiezioni  codFilm = ?, codSala = ?, incasso = ?, DataProiezione = ?, WHERE CodProiezione = ?");
			
	        preparedStatement.setInt(1, proiezione.getCodFilm());
	        preparedStatement.setInt(2, proiezione.getCodSala());
			
	        preparedStatement.setInt(4, proiezione.getIncasso());
	        preparedStatement.setString(5, proiezione.getDataProiezione());
			preparedStatement.setInt(3, proiezione.getCodProiezione());
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
	public boolean delete(Integer CodProiezione) {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		int isDeleted = 0;
        try {
            preparedStatement = conn.prepareStatement("DELETE FROM Film WHERE CodProiezione = ?");

            preparedStatement.setInt(3, CodProiezione);

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
//public Proiezioni(int codFilm, int codSala,int proiezione, int incasso, String DataProiezione)
	@Override
	public Proiezioni cerca(String dataProiezione, int codFilm) {
		
		Connection conn = ConnectionDatabase.getConnection();
		Proiezioni p=null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement=conn.prepareStatement("SELECT * FROM proiezioni WHERE DataProiezione=? and codFilm=?");
			preparedStatement.setString(5, dataProiezione);
			preparedStatement.setInt(1, codFilm);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				 p=new Proiezioni();
				
				 p.setCodFilm(resultSet.getInt("codFilm"));
				 p.setCodSala(resultSet.getInt("codSala"));
	             p.setCodProiezione(resultSet.getInt("codProiezione"));
	             p.setIncasso( resultSet.getInt("incasso") );
	             p.setDataProiezione( resultSet.getString("DataProiezione") );
	             
				
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
		return p;
		
		
		
		
		
	}

	@Override
	public List<Proiezioni> proiezioni() {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		List<Proiezioni> proiezioni = new ArrayList<>();
	    Statement statement = null;
	    ResultSet resultSet = null;
	        try {
	            statement = conn.createStatement();

	            resultSet = statement.executeQuery("SELECT * FROM proiezioni");
	            while(resultSet.next()) {
	                Proiezioni p = new Proiezioni();
	                
	                p.setCodFilm(resultSet.getInt("codFilm"));
	                p.setCodSala(resultSet.getInt("codSala"));
	                p.setCodProiezione(resultSet.getInt("codProiezione"));
	                p.setIncasso( resultSet.getInt("incasso") );
	                p.setDataProiezione( resultSet.getString("DataProiezione") );
	               

	                proiezioni.add(p);
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

	        return proiezioni;

		
		
	}

	

	@Override
	public Proiezioni getProiezioni(int codFilm, String dataProiezione) {
		
		Connection conn = ConnectionDatabase.getConnection();
		Proiezioni p=null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM film WHERE codFilm=? and dataProiezione=?");
			preparedStatement.setInt(1,codFilm );
			preparedStatement.setString(2,dataProiezione);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				p=new Proiezioni();
				
				p.setCodFilm(resultSet.getInt("codFilm"));
				p.setCodSala(resultSet.getInt("codSala"));
	            p.setCodProiezione(resultSet.getInt("codProiezione"));
	            p.setIncasso( resultSet.getInt("incasso") );
	            p.setDataProiezione( resultSet.getString("DataProiezione") );
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
		return p;
			
	}
	
	@Override
	public Proiezioni getProiezioni(int codFilm, int codSala) {
		
		Connection conn = ConnectionDatabase.getConnection();
		Proiezioni p=null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM film WHERE codFilm=? and codSala=?");
			preparedStatement.setInt(1,codFilm);
			preparedStatement.setInt(2,codSala);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				p=new Proiezioni();
				
				p.setCodFilm(resultSet.getInt("codFilm"));
				p.setCodSala(resultSet.getInt("codSala"));
	            p.setCodProiezione(resultSet.getInt("codProiezione"));
	            p.setIncasso( resultSet.getInt("incasso") );
	            p.setDataProiezione( resultSet.getString("dataProiezione") );
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
		return p;
			
	}
}

