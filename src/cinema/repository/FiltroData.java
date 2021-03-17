package cinema.repository;

import java.util.List;

import cinema.model.FiltroClasseData;

public interface FiltroData {
	List<FiltroClasseData> fcd(String mese);
}
