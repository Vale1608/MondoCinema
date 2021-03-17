package cinema.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cinema.GUI.PannelloTabellaFiltraPerCitta;
import cinema.model.Sale;

public class SaleRepositoryImpl implements SaleRepository{

	@Override
	public List<Sale> filtraPerCitta(String citta) {
		Connection conn = ConnectionDatabase.getConnection(); 
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Sale> sale =new ArrayList<>();
		
		try {
			preparedStatement = conn.prepareStatement("SELECT nome, posti FROM sale WHERE citta=?");
			preparedStatement.setString(1,citta);
			resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Sale s = new Sale();
				
				s.setNome(resultSet.getString("Nome"));
				s.setPosti(resultSet.getInt("Posti"));
				
				sale.add(s);
				
			}
			
			preparedStatement.close();
			resultSet.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return sale;
	}

}
