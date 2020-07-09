/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import hu.ak_akademia.texasholdem.model.db.GameEntity;

/**
 * @author bnagy
 *
 */
public class GameController extends AbstractController<GameEntity> {

	public GameController() {
		super();
		dao = new GameDao();
	}

	/**
	 * 
	 */
	@Override
	public void setSelected(String[] dataFromUi) {//Valószínűleg nem kell.
		selected = new GameEntity();
		selected.setId(Integer.parseInt(dataFromUi[0]));
		selected.setDateOfGame(LocalDate.parse(dataFromUi[1], DateTimeFormatter.ofPattern("yyyy MM dd")));
		selected.setPot(Integer.parseInt(dataFromUi[2]));
	}
	
}
