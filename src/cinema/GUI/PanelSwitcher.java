package cinema.GUI;

import java.awt.Panel;

import cinema.model.Sale;

public interface PanelSwitcher {

	void pannelloTabella();
    void pannelloAddFilm();
    void pannelloFiltraPerCitta();
    void pannelloTabellaFiltraPerCitta(String citta);
    void setCitta(String citta);
}
