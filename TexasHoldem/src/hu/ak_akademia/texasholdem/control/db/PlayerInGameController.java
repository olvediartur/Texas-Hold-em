/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import hu.ak_akademia.texasholdem.control.bl.BestFive;
import hu.ak_akademia.texasholdem.model.db.PlayerInGameEntity;

/**
 * @author bnagy
 *
 */
public class PlayerInGameController extends AbstractController<PlayerInGameEntity> {

	public PlayerInGameController() {
		super();
		dao = new PlayerInGameDao();
	}

	@Override
	public void setSelected(String[] dataFromUi) {
		selected = new PlayerInGameEntity();
		selected.setPokerUserId(Integer.parseInt(dataFromUi[0]));
		selected.setGameId(Integer.parseInt(dataFromUi[1]));
		selected.setBestCombination(BestFive.getBestFive(dataFromUi[2]));
	}
	
}
