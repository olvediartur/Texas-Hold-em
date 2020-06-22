/**
 * Comperator interface
 */
package hu.ak_akademia.texasholdem.control.bl;

import java.util.Comparator;

import hu.ak_akademia.texasholdem.model.deck.Card;

/**
 * @author bnagy
 * @author Lidia
 *
 */
public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		if(o1.getFigure().getValue() < o2.getFigure().getValue()) {
			return -1;
		} else if(o1.getFigure().getValue() > o2.getFigure().getValue()) {
			return 1;
		} else if(o1.getColor().getValue() < o2.getColor().getValue()){
			return -1;
		} else if(o1.getColor().getValue() > o2.getColor().getValue()){
			return 1;
		} else {
			return 0;
		}
	}
	
}
