package cinema.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cinema.model.Attori;

public class AttoriRepositoryImp implements AttoriRepository 
{
	@Override
	public boolean aggiungi(Attori attori) {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		int cercato=0;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO attori VALUES(null,?,?,?,?)");
			
	        preparedStatement.setInt(1, attori.getCodAttore());
	        preparedStatement.setString(2, attori.getNome());
	        preparedStatement.setInt(3, attori.getAnnoNascita());
	        preparedStatement.setString(4, attori.getNazionalita());
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
	public boolean update(Attori attori) {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		int modificato=0;
		try {
			//controllare scritte stringa 
			preparedStatement = conn.prepareStatement("UPDATE attori  CodAttore = ?, Nome = ?, AnnoNascita = ? Nazionalita = ?, WHERE CodAttore = ?");
			
	        preparedStatement.setInt(1, attori.getCodAttore());
	        preparedStatement.setString(2, attori.getNome());
	        preparedStatement.setInt(3, attori.getAnnoNascita());
	        preparedStatement.setString(4, attori.getNazionalita());
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
	public boolean delete(Integer CodAttore) {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		int isDeleted = 0;
        try {
            preparedStatement = conn.prepareStatement("DELETE FROM Attori WHERE CodAttore = ?");

            preparedStatement.setInt(1, CodAttore);

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
	public Attori cerca(String nome, int codAttore) {
		
		Connection conn = ConnectionDatabase.getConnection();
		Attori attori=null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement=conn.prepareStatement("SELECT * FROM attori WHERE Nome=? and CodAttore=?");
			preparedStatement.setString(1, nome);
			preparedStatement.setInt(2, codAttore);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				attori=new Attori();
				
				 attori.setCodAttore(resultSet.getInt("CodAttore"));
				 attori.setNome( resultSet.getString("Nome"));
				 attori.setAnnoNascita( resultSet.getInt("AnnoNascita"));
				 attori.setNazionalita( resultSet.getString("Nazionalita") );
				
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
		return attori;
		
		
		
		
		
	}

	@Override
	public List<Attori> attori() {
		
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		List<Attori> attori = new ArrayList<>();
	    Statement statement = null;
	    ResultSet resultSet = null;
	        try {
	            statement = conn.createStatement();

	            resultSet = statement.executeQuery("SELECT * FROM attori");
	            while(resultSet.next()) {
	                Attori a = new Attori();
	                
	                a.setCodAttore(resultSet.getInt("CodAttore"));
	                a.setNome( resultSet.getString("Nome"));
	                a.setAnnoNascita( resultSet.getInt("AnnoNascita"));
	                a.setNazionalita( resultSet.getString("Nazionalita") );
	             
	                attori.add(a);
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

	        return attori;

		
		
	}

	@Override
	public Attori getAttori(Integer CodAttore) {
		
		Connection conn = ConnectionDatabase.getConnection();
		Attori attori=null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Attori WHERE CodAttore = ? ");
			preparedStatement.setInt(1, CodAttore);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				attori=new Attori();
				
				attori.setCodAttore(CodAttore);
				attori.setNome(resultSet.getString("Nome"));
				attori.setAnnoNascita(resultSet.getInt("AnnoNascita"));
				attori.setNazionalita(resultSet.getString("Nazionalita"));
			
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
		return attori;
	}

	@Override
	public Attori getAttori(String nome, int annoNascita) {
		
		Connection conn = ConnectionDatabase.getConnection();
		Attori attori=null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM attori WHERE nome=? and AnnoNascita=?");
			preparedStatement.setString(1,nome );
			preparedStatement.setInt(2,annoNascita);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				attori=new Attori();
				
				attori.setCodAttore(resultSet.getInt("CodAttore"));
				attori.setNome(resultSet.getString("Nome"));
				attori.setAnnoNascita(resultSet.getInt("AnnoNascita"));
				attori.setNazionalita(resultSet.getString("Nazionalita"));
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
		return attori;
			
	}	
	
}