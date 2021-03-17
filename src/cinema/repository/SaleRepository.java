package cinema.repository;

import java.util.List;
import cinema.model.Sale;

public interface SaleRepository {
	
	List<Sale> filtraPerCitta(String citta);

}
