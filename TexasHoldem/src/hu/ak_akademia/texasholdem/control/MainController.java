/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import java.util.List;

import hu.ak_akademia.texasholdem.control.bl.Statistic;
import hu.ak_akademia.texasholdem.control.db.AbstractController;
import hu.ak_akademia.texasholdem.model.db.PlayerInGameEntity;
import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;
import hu.ak_akademia.texasholdem.view.UI;
import hu.ak_akademia.texasholdem.view.consolemenu.Menu;
import hu.ak_akademia.texasholdem.view.consolemenu.MenuItem;
import hu.ak_akademia.texasholdem.view.consolemenu.Option;
import hu.ak_akademia.texasholdem.view.consolemenu.SubMenu;

/**
 * @author bnagy
 *
 */
public class MainController extends ApplicationController {

	public MainController() {
		super();
		menu = new Menu(UI.bundle.getString("mainmenu"));
		initialiseMainMenu();
	}

	/**
	 * 
	 */
	private void initialiseMainMenu() {
		MenuItem start = new Option(1, UI.bundle.getString("mainmenu_start")) {
			@Override
			public void select() {
				new NewGameController().start();
			}
		};
		MenuItem editProfile = new SubMenu(2, UI.bundle.getString("mainmenu_edit")) {
			@Override
			public void select() {
				useMenu(this);
			}
		};
		MenuItem payIn = new Option(1, UI.bundle.getString("mainmenu_edit_payin")) {
			@Override
			public void select() {
				int amountToPayIn = ui.getIntFromUser("mainmenu_edit_payin_msg");
				PokerUserEntity user = ui.getLogedUser();
				user.setCredits(user.getCredits() + amountToPayIn);
				dbc.getPokerUserController().setSelected(user);
				ui.showMessage(dbc.getPokerUserController().update());
				useMenu(menu);
			}
		};
		MenuItem payOff = new Option(2, UI.bundle.getString("mainmenu_edit_payoff")) {
			@Override
			public void select() {
				int amountToPayIn = ui.getIntFromUser("mainmenu_edit_payoff_msg");
				PokerUserEntity user = ui.getLogedUser();
				user.setCredits(user.getCredits() - amountToPayIn);
				dbc.getPokerUserController().setSelected(user);
				ui.showMessage(dbc.getPokerUserController().update());
				useMenu(menu);
			}
		};
		
		MenuItem stats = new SubMenu(3, UI.bundle.getString("mainmenu_edit_stats")) {
			@Override
			public void select() {
				useMenu(this);
			}
		};
		MenuItem top10Ever = new Option(1, UI.bundle.getString("statistic_top10_ever")) {
			@Override
			public void select() {
				//AbstractController<PlayerInGameEntity> pig = dbc.getPlayerInGameController();
				//List<PlayerInGameEntity> list = pig.getAll();
				//Statistic stat = new Statistic(list);
				Statistic stat = new Statistic(dbc.getPlayerInGameController().getAll());
				ui.showStatisticList(stat.getTopTenEver());
				useMenu(menu);
			}
		};
		MenuItem top10Month = new Option(2, UI.bundle.getString("statistic_top10_month")) {
			@Override
			public void select() {
				Statistic stat = new Statistic(dbc.getPlayerInGameController().getAll());
				ui.showStatisticList(stat.getTopTenInThisMonth());
				useMenu(menu);
			}
		};
		MenuItem myTop10ever = new Option(3, UI.bundle.getString("statistic_mytop10")) {
			@Override
			public void select() {
				Statistic stat = new Statistic(dbc.getPlayerInGameController().getAll());
				ui.showStatisticList(stat.getLogedUserTopTenEver(ui.getLogedUser().getId()));
				useMenu(menu);
			}
		};
		MenuItem back = new Option(4, UI.bundle.getString("mainmenu_edit_back")) {
			@Override
			public void select() {
				useMenu(menu);
			}
		};
		SubMenu subMenuStats = (SubMenu) stats;
		subMenuStats.getOptions().add(top10Ever);
		subMenuStats.getOptions().add(top10Month);
		subMenuStats.getOptions().add(myTop10ever);
		subMenuStats.getOptions().add(back);
		
		MenuItem changePW = new Option(4, UI.bundle.getString("mainmenu_edit_changepw")) {
			@Override
			public void select() {
				String newPw = ui.changePassword();
				PokerUserEntity user = ui.getLogedUser();
				user.setPassword(newPw);
				dbc.getPokerUserController().setSelected(user);
				ui.showMessage(dbc.getPokerUserController().update());
				useMenu(menu);
			}
		};
		MenuItem backToMain = new Option(5, UI.bundle.getString("mainmenu_edit_back")) {
			@Override
			public void select() {
				useMenu(menu);
			}
		};
		Menu subMenuEdit = (Menu) editProfile;
		subMenuEdit.getOptions().add(payIn);
		subMenuEdit.getOptions().add(payOff);
		subMenuEdit.getOptions().add(subMenuStats);
		subMenuEdit.getOptions().add(changePW);
		subMenuEdit.getOptions().add(backToMain);

		MenuItem quit = new Option(3, UI.bundle.getString("mainmenu_quit")) {
			@Override
			public void select() {
				ui.setLogedUser(null);
				new AdminController().start();
			}
		};

		menu.getOptions().add(start);
		menu.getOptions().add(subMenuEdit);
		menu.getOptions().add(quit);
	}
	
	@Override
	public void start() {
		super.start();
		//TODO Rita TEX02-74
	}
}