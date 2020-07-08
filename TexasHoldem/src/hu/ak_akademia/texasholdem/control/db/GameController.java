/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.time.LocalDate;

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
	 * Valószínűleg nem kell.
	 */
	@Override
	public void setSelected(String[] dataFromUi) {
		selected = new GameEntity();
		selected.setId(Integer.parseInt(dataFromUi[0]));
		selected.setDateOfGame();
		selected.setPot(Integer.parseInt(dataFromUi[2]));
	}
	
}
