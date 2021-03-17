package cinema.repository;

import java.util.List;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cinema.model.*;

public class SelectActorsForFilmImpl implements SelectActorsForFilm {

	@Override
	public List<AttoriPerFilm> joinactors(int codFilm) {
		Connection conn=ConnectionDatabase.getConnection();
		List<AttoriPerFilm> aflista=new ArrayList<>();
		
		PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    
	    try {
	    	preparedStatement=conn.prepareStatement("select a.nome,f.titolo from attori a,film f,recita r where f.codFilm=? AND r.codAttore=a.CodAttore AND f.codFilm=r.codFilm");
	    	preparedStatement.setInt(1, codFilm);
	    	
	    	resultSet=preparedStatement.executeQuery();
	    	while(resultSet.next()) {
	    		AttoriPerFilm af=new AttoriPerFilm();
	    		
	    		af.setNomeA(resultSet.getString("nome"));
	    		af.setNomeF(resultSet.getString("titolo"));
	    		
	    		aflista.add(af);
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
	
		return aflista;
	}

}
