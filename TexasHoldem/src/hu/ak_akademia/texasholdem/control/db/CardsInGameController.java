/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import hu.ak_akademia.texasholdem.model.db.CardsInGameEntity;
import hu.ak_akademia.texasholdem.model.deck.Card;

/**
 * @author bnagy
 *
 */
public class CardsInGameController extends AbstractController<CardsInGameEntity> {

	public CardsInGameController() {
		super();
		dao = new CardsInGameDao();
	}

	@Override
	public void setSelected(String[] dataFromUi) {
		selected = new CardsInGameEntity();
		selected.setGameId(Integer.parseInt(dataFromUi[0]));
		selected.setFlop1(new Card(dataFromUi[1]));
		selected.setFlop2(new Card(dataFromUi[2]));
		selected.setFlop3(new Card(dataFromUi[3]));
		selected.setTurn(new Card(dataFromUi[4]));
		selected.setRiver(new Card(dataFromUi[5]));
	}
	
}
