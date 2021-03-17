package cinema.repository;
import cinema.model.AttoriPerFilm;
import java.util.List;

public interface SelectActorsForFilm {
	public List<AttoriPerFilm> joinactors(int codFilm);
}
