package cinema.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import cinema.model.FiltroClasseData;
import cinema.model.Proiezioni;

public class FiltroDataImp implements FiltroData {

	
	

	
	public List<FiltroClasseData> fcd(String mese) {
	
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		
		List<FiltroClasseData> arrayFiltrato = new ArrayList<>();
		//Step tokenizzare la query
	    //Statement statement = null;
	    ResultSet resultSet = null;
	   
	        try {
	        	
	        	//preparedStatement = conn.prepareStatement("SELECT Titolo,dataProiezione,nome FROM film, proiezioni, sale Where film.codfilm=proiezioni.codfilm and proiezioni.codSala=sale.codSala and dataProiezione REGEXP ?");
	        	preparedStatement = conn.prepareStatement("SELECT film.titolo,proiezioni.dataProiezione,sale.nome FROM film, proiezioni, sale Where film.codfilm=proiezioni.codfilm and proiezioni.codSala=sale.codSala and proiezioni.dataProiezione REGEXP ?");
	            preparedStatement.setString(1, mese);
	             resultSet = preparedStatement.executeQuery();
	            
	            while(resultSet.next()) {
	                FiltroClasseData fcd = new FiltroClasseData();
	                
	                fcd.setTitolo(resultSet.getString("titolo"));
	                fcd.setData(resultSet.getString("dataProiezione"));
	                fcd.setSala(resultSet.getString("nome"));
	               

	                arrayFiltrato.add(fcd);
	            }
	            preparedStatement.close();
	            resultSet.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	               // statement.close();
	                
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return arrayFiltrato;

		
		
	}
	


	

	

	

}

