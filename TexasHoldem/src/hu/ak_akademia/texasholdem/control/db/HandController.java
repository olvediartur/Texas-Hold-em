/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import hu.ak_akademia.texasholdem.model.db.HandEntity;
import hu.ak_akademia.texasholdem.model.deck.Card;

/**
 * @author bnagy
 *
 */
public class HandController extends AbstractController<HandEntity> {

	public HandController() {
		super();
		dao = new HandDao();
	}

	@Override
	public void setSelected(String[] dataFromUi) {
		selected = new HandEntity();
		selected.setId(Integer.parseInt(dataFromUi[0]));
		selected.setPokerUserId(Integer.parseInt(dataFromUi[1]));
		selected.setGameId(Integer.parseInt(dataFromUi[2]));
		selected.setCard1(new Card(dataFromUi[3]));
		selected.setCard2(new Card(dataFromUi[4]));
		selected.setWon(false);
	}
	
}
