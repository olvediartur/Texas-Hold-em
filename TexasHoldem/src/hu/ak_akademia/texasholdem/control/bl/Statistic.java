/**
 * 
 */
package hu.ak_akademia.texasholdem.control.bl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.ak_akademia.texasholdem.model.db.PlayerInGameEntity;

/**
 * @author bnagy
 *
 */
public class Statistic {
	private List<WinnerPokerHand> winners = new ArrayList<>();

	public Statistic(List<PlayerInGameEntity> entities) {
		if (!entities.isEmpty()) {
			for (PlayerInGameEntity e : entities) {
				winners.add(new WinnerPokerHand(e));
			}
		}
	}

	public List<WinnerPokerHand> getTopTenEver() {
		List<WinnerPokerHand> result = new ArrayList<>();
		if (!winners.isEmpty()) {
			Collections.sort(winners);
			for (int i = 0; i < Math.min(10, winners.size()); i++) {
				result.add(winners.get(i));
			}
		}
		return result;
	}

	public List<WinnerPokerHand> getTopTenInThisMonth() {
		List<WinnerPokerHand> result = new ArrayList<>();
		int month = LocalDate.now().getMonthValue();
		List<WinnerPokerHand> winnersInMonth = new ArrayList<>();
		for (WinnerPokerHand w : winners) {
			if (w.getGame().getDateOfGame().getMonthValue() == month) {
				winnersInMonth.add(w);
			}
		}
		Collections.sort(winnersInMonth);
		for (int i = 0; i < Math.min(10, winnersInMonth.size()); i++) {
			result.add(winnersInMonth.get(i));
		}
		return result;
	}

	public List<WinnerPokerHand> getLogedUserTopTenEver(int userId) {
		List<WinnerPokerHand> result = new ArrayList<>();
		List<WinnerPokerHand> usersWins = new ArrayList<>();
		for (WinnerPokerHand w : winners) {
			if (w.getUser().getId() == userId) {
				usersWins.add(w);
			}
		}
		Collections.sort(usersWins);
		for (int i = 0; i < Math.min(10, usersWins.size()); i++) {
			result.add(usersWins.get(i));
		}
		return result;
	}

}
