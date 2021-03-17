package cinema.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cinema.model.Recita;

	public class RecitaRepositoryImp implements RecitaRepository {
		
		@Override
		public boolean aggiungi(Recita recita) {
			Connection conn=ConnectionDatabase.getConnection();
			PreparedStatement preparedStatement = null;
			int cercato=0;
			try {
				preparedStatement=conn.prepareStatement("INSERT INTO recita VALUES(?,?)");
				preparedStatement.setInt(1, recita.getCodAttore());
				preparedStatement.setInt(2, recita.getCodFilm());
				
				cercato=preparedStatement.executeUpdate();
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
		public boolean update(Recita recita) {
			Connection conn=ConnectionDatabase.getConnection();
			PreparedStatement preparedStatement = null;
			
			int cercato=0;
			try {
				preparedStatement = conn.prepareStatement("UPDATE recita SET CodAttore=?,CodFilm=?");
				preparedStatement.setInt(1, recita.getCodAttore());
				preparedStatement.setInt(2, recita.getCodFilm());
				
				cercato=preparedStatement.executeUpdate();
			}catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
			return cercato!=0;
		}

		@Override
		public boolean delete(Integer codAttore, Integer codFilm) {
			Connection conn=ConnectionDatabase.getConnection();
			PreparedStatement preparedStatement = null;
			
			int isDeleted = 0;
			try {
				preparedStatement=conn.prepareStatement("DELETE FROM recita WHERE CodAttore=? AND CodFilm=?");
				preparedStatement.setInt(1, codAttore);
				preparedStatement.setInt(2, codFilm);
				
				
				isDeleted=preparedStatement.executeUpdate();
			}catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
			
			return false;
		}

		@Override
		public List<Recita> recita(){
			Connection conn = ConnectionDatabase.getConnection();

	        List<Recita> recita = new ArrayList<>();
	        Statement statement = null;
	        ResultSet resultSet = null;
	        try {
	            statement = conn.createStatement();

	            resultSet = statement.executeQuery("SELECT * FROM recita");
	            while(resultSet.next()) {
	                Recita recitas = new Recita();

	                recitas.setCodAttore(resultSet.getInt("CodAttore"));
	                recitas.setCodFilm(resultSet.getInt("CodFilm"));
	               
	                recita.add(recitas);
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

	        return recita;
	    }

		@Override
		public Recita getRecita(int codAttore,int codFilm) {
			Connection conn = ConnectionDatabase.getConnection();
			
			Recita recita=null;
			PreparedStatement preparedStatement = null;
			
			try {
				preparedStatement = conn.prepareStatement("SELECT * FROM recita WHERE CodAttore = ? and CodFilm = ?");
				
				preparedStatement.setInt(1, codAttore);
	            preparedStatement.setInt(2, codFilm);
	            
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if(resultSet.next()) {
	            	recita.setCodAttore(resultSet.getInt(codAttore));
	            	recita.setCodFilm(resultSet.getInt(codFilm));
	            }
				
			}catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                preparedStatement.close();
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
			return recita;
		}

	}

