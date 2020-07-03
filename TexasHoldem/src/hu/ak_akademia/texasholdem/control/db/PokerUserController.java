/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;

/**
 * @author bnagy
 *
 */
public class PokerUserController extends AbstractController<PokerUserEntity> {

	public PokerUserController() {
		super();
		dao = new PokerUserDao();
	}

	@Override
	public void setSelected(String[] dataFromUi) {
		selected = new PokerUserEntity();
		selected.setName(dataFromUi[0]);
		selected.setPassword(dataFromUi[1]);
		selected.setCredits(Integer.parseInt(dataFromUi[2]));
		selected.setIs_deleted(false);
	}
	
}
