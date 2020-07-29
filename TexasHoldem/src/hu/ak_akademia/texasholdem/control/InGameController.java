/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.ak_akademia.texasholdem.control.bl.BestFive;
import hu.ak_akademia.texasholdem.control.bl.BestFiveComparator;
import hu.ak_akademia.texasholdem.control.bl.WinnerPokerHand;
import hu.ak_akademia.texasholdem.control.game.Bid;
import hu.ak_akademia.texasholdem.control.game.Hand;
import hu.ak_akademia.texasholdem.control.game.InGameAction;
import hu.ak_akademia.texasholdem.control.game.Player;
import hu.ak_akademia.texasholdem.control.game.Round;
import hu.ak_akademia.texasholdem.control.game.Session;
import hu.ak_akademia.texasholdem.model.db.GameEntity;
import hu.ak_akademia.texasholdem.model.db.HandEntity;
import hu.ak_akademia.texasholdem.model.deck.Card;
import hu.ak_akademia.texasholdem.view.UI;
import hu.ak_akademia.texasholdem.view.consolemenu.Menu;
import hu.ak_akademia.texasholdem.view.consolemenu.MenuItem;
import hu.ak_akademia.texasholdem.view.consolemenu.Option;

/**
 * @author bnagy
 *
 */
public class InGameController extends ApplicationController {

	private Session session;

	public InGameController() {
		super();
		menu = new Menu(UI.bundle.getString("ingamemenu"));
		initialiseInGameMenu();
	}

	public InGameController(Session session) {
		super();
		menu = new Menu(UI.bundle.getString("ingamemenu"));
		initialiseInGameMenu();
		this.session = session;
	}

	/**
	 * 
	 */
	private void initialiseInGameMenu() {
		MenuItem call = new Option(1, UI.bundle.getString("ingamemenu_call")) {
			@Override
			public void select() {
				Hand hand = session.getCurrentHand();
				Bid bid = hand.getCurrentBid();
				Player actor = bid.getCurrentPlayer();
				int amountToCall = bid.getLastRaiser().getChipsInPot() - actor.getChipsInPot();
				if (!actor.canPay(amountToCall)) {
					// Ezt máshogy kell majd lekezelni.
					// Ugye ez egy All-In :)
					System.out.println("NOT VALID CALL!");
					System.out.println("YOU FOLD!");
					foldPlayer(actor, hand);
					return;
				}
				actor.call(amountToCall);
				hand.addToPot(amountToCall);
				actor.setLastAction(InGameAction.CALL);
			}
		};
		MenuItem check = new Option(2, UI.bundle.getString("ingamemenu_check")) {
			@Override
			public void select() {
				Hand hand = session.getCurrentHand();
				Bid bid = hand.getCurrentBid();
				Player actor = bid.getCurrentPlayer();
				if (bid.wasBet()) {
					ui.showMessage("cant_check");
					useMenu(menu);
					return;
				}
				actor.setLastAction(InGameAction.CHECK);
			}
		};
		MenuItem raise = new Option(3, UI.bundle.getString("ingamemenu_raise")) {
			@Override
			public void select() {
				Hand hand = session.getCurrentHand();
				Bid bid = hand.getCurrentBid();
				Player actor = bid.getCurrentPlayer();
				int raiseChips = 0;
				String raiseMsg = "ui_void_msg";
				do {
					ui.showMessage(raiseMsg);
					raiseChips = ui.getIntFromUser("how_much_raise");
					raiseMsg = "not_valid_raise";
				} while (!actor.canPay(raiseChips));
				actor.raise(raiseChips);
				hand.addToPot(raiseChips);
				actor.setLastAction(InGameAction.RAISE);
			}
		};
		MenuItem fold = new Option(4, UI.bundle.getString("ingamemenu_fold")) {
			@Override
			public void select() {
				Hand hand = session.getCurrentHand();
				Bid bid = hand.getCurrentBid();
				Player actor = bid.getCurrentPlayer();
				foldPlayer(actor, hand);
			}
		};
		MenuItem sitOut = new Option(5, UI.bundle.getString("ingamemenu_sitout")) {
			@Override
			public void select() {
				// TODO write game methods
				Hand hand = session.getCurrentHand();
				Bid bid = hand.getCurrentBid();
				Player actor = bid.getCurrentPlayer();
				bid.getPlayersInHand().delete(actor);
				hand.getPlayers().delete(actor);
				session.getPlayers().delete(actor);
				foldPlayer(actor, hand);
				actor.setLastAction(InGameAction.SITOUT);
				actor.sitOut();
			}
		};
		menu.getOptions().add(call);
		menu.getOptions().add(check);
		menu.getOptions().add(raise);
		menu.getOptions().add(fold);
		menu.getOptions().add(sitOut);
	}

	/**
	 * 
	 */
	@Override
	public void start() {
		while (!session.isOver()) {
			// Hand hand = session.newHand();
			// dbc.getGameController()
			// .setSelected(new GameEntity(hand.getDateOfGame(),hand.getPot()));
			dbc.getGameController().setSelected(new GameEntity(LocalDate.now(), 0));
			dbc.getGameController().create();
			dbc.getGameController().getLast();
			Hand hand = new Hand(session.getPlayers(), dbc.getGameController().getSelected());
			session.setCurrentHand(hand);
			runHand(hand);
		}
	}

	private void runHand(Hand hand) {
		Bid bid;
		Round round;
		hand.shuffleDeck();
		hand.deal();
		round = Round.PREFLOP;
		bid = hand.newBid(round);
		// System.out.println(bid.getCurrentPlayer().getName());
		runBid(bid, hand);
		if (!hand.isOver()) {
			round = Round.FLOP;
			nextRound(hand, round);
			if (!hand.isOver()) {
				round = Round.TURN;
				nextRound(hand, round);
				if (!hand.isOver()) {
					round = Round.RIVER;
					nextRound(hand, round);
				}
			}
		}
		showDown(hand);
	}

	private void runBid(Bid bid, Hand hand) {
		for (Player p : bid.getPlayersInHand().getListOfPlayers()) {
			p.setLastAction(InGameAction.RAISE);
		}
		Player lastRaiser = bid.getBigBlind();
		Player currentPlayer;
		bid.setLastRaiser(lastRaiser);
		if (bid.getRound().getValue() == 0) {
			currentPlayer = bid.getPlayersInHand().getNext(bid.getLastRaiser());
		} else {
			currentPlayer = bid.getPlayersInHand().getNext(bid.getDealer());
		}
		bid.setCurrentPlayer(currentPlayer);
		while (!bid.isEndOfBid(currentPlayer, lastRaiser)) {
			ui.clearConsole();
			ui.print(bid.getCurrentPlayer().getName());
			ui.showMessage("is_your_turn");
			ui.showBoard(hand.getBoard());
			ui.print(UI.bundle.getString("pot") + hand.getPot() + "\n");
			ui.showPlayerCards(bid.getCurrentPlayer().getCards());
			ui.print(UI.bundle.getString("chips_in_pot") + bid.getCurrentPlayer().getChipsInPot() + "\n");
			ui.print(UI.bundle.getString("free_chips") + bid.getCurrentPlayer().getChips() + "\n");
			useMenu(menu);
			if (!bid.wasBet() && bid.getCurrentPlayer().getLastAction() == InGameAction.RAISE) {
				bid.setWasBet(true);
			}
			currentPlayer = nextPlayer(currentPlayer, bid);
		}
	}

	/**
	 * 
	 */
	private void showDown(Hand hand) {
		int counter = 0;
		for (Player p : hand.getPlayers()) {
			if (p.isInHand()) {
				counter++;
			}
		}
		List<WinnerPokerHand> wphList = new ArrayList<>();
		if (counter == 1) {
			Player player = hand.getCurrentBid().getCurrentPlayer();
			HandEntity entity = new HandEntity();
			entity.setPokerUserId(player.getId());
			entity.setGameId(hand.getId());
			entity.setCard1(player.getCard1());
			entity.setCard2(player.getCard2());
			entity.setWon(true);
			dbc.getHandController().setSelected(entity);
			ui.showMessage(dbc.getHandController().create());
		} else {
			for (Player p : hand.getPlayers()) {
				if (p.isInHand()) {
					wphList.add(getBestPokerHand(p, hand));
				}
			}
			Collections.sort(wphList);
			WinnerPokerHand winner = wphList.get(0);
			for (Player p : hand.getPlayers()) {
				if (p.getId() == winner.getUser().getId()) {
					p.setChips(p.getChips() + hand.getPot());
				}
			}

			// győztes a db-be
			dbc.getPlayerInGameController().setSelected(winner.getEntity());
			ui.showMessage(dbc.getPlayerInGameController().create());

			// a játék a db-be
			dbc.getGameController().setSelected(new GameEntity(hand.getDateOfGame(), hand.getPot()));
			dbc.getGameController().update();
		}
	}

	/**
	 * @param p
	 * @param hand
	 * @return
	 */
	private WinnerPokerHand getBestPokerHand(Player p, Hand hand) {
		// ki kell próbálni még :)
		// lehet rosszul számol
		List<Card> cards = new ArrayList<>();
		cards.add(p.getCard1());
		cards.add(p.getCard2());
		for (Card c : hand.getBoard()) {
			cards.add(c);
		}
		List<BestFive> bestFives = new ArrayList<>();
		for (int i = 0; i < cards.size() - 1; i++) {
			for (int j = i + 1; j < cards.size(); j++) {
				int index = 0;
				Card[] cardArr = new Card[5];
				for (int k = 0; k < cards.size(); k++) {
					if (k == i || k == j) {
						continue;
					}
					cardArr[index] = cards.get(k);
					index++;
				}
				bestFives.add(new BestFive(cardArr[0], cardArr[1], cardArr[2], cardArr[3], cardArr[4]));
			}
		}
		Collections.sort(bestFives, new BestFiveComparator());
		return new WinnerPokerHand(p, hand, bestFives.get(0));
	}

	private void foldPlayer(Player player, Hand hand) {
		player.setLastAction(InGameAction.FOLD);
		player.fold();
		HandEntity entity = new HandEntity();
		entity.setPokerUserId(player.getId());
		entity.setGameId(hand.getId());
		entity.setCard1(player.getCard1());
		entity.setCard2(player.getCard2());
		entity.setWon(false);
		dbc.getHandController().setSelected(entity);
		ui.showMessage(dbc.getHandController().create());
	}

	private void nextRound(Hand hand, Round round) {
		hand.dealOnStreet(round);
		Bid bid = hand.newBid(round);
		runBid(bid, hand);
	}

	private Player nextPlayer(Player player, Bid bid) {
		ui.clearConsole();
		Player nextPlayer = bid.getPlayersInHand().getNext(player);
		bid.setCurrentPlayer(nextPlayer);
		ui.getStringFromUser("press_enter_to_continue");
		return nextPlayer;
	}

}
