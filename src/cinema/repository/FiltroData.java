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

public class FiltroData  {

	
	

	
	public List<FiltroClasseData> fcd(String mese) {
	
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement preparedStatement = null;
		List<FiltroClasseData> arrayFiltrato = new ArrayList<>();
		//Step tokenizzare la query
	    Statement statement = null;
	    ResultSet resultSet = null;
	   
	        try {
	        	
	            preparedStatement = conn.prepareStatement("SELECT Titolo.film,dataProiezione.proiezioni,nome.sala FROM film proiezioni sale Where f.codfilm=p.codfilm and p.codSala=s,codSala and dataProiezione REGEXP ?");
	            preparedStatement.setString(1, mese);
	            
	            
	            while(resultSet.next()) {
	                FiltroClasseData fcd = new FiltroClasseData();
	                
	                fcd.setTitolo(resultSet.getString("Titolo"));
	                fcd.setData(resultSet.getString("DataProiezione"));
	                fcd.setTitolo(resultSet.getString("Nome"));
	               

	                arrayFiltrato.add(fcd);
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

	        return arrayFiltrato;

		
		
	}

	

	

	

}

