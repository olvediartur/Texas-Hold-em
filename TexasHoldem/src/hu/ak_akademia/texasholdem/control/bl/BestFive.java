/* Ez a legjobb 5 kártyát tároló osztály
 * 
 */
package hu.ak_akademia.texasholdem.control.bl;
import java.util.Arrays;

/*
 * * meghívtam a deck packaget
 */
import hu.ak_akademia.texasholdem.model.deck.*;

/**
 * @author Lidia
 *
 */
public class BestFive { //osztály
	
	Card[] bestFiveCard = new Card[5];  // mező

	public Card card1;  //5 card objektum egységbe zárása
	public Card card2;
	public Card card3;
	public Card card4;
	public Card card5;
	
	public static void main (String[] args) { 
		Card c1 = new Card(CardColor.DIAMOND, Figure.FIVE);
		Card c2 = new Card(CardColor.DIAMOND, Figure.SEVEN);
		Card c3 = new Card(CardColor.DIAMOND, Figure.KING);
		Card c4 = new Card(CardColor.DIAMOND, Figure.ACE);
		Card c5 = new Card(CardColor.HEARTS, Figure.FIVE);
		
		int cardValue = c1.getFigure().getValue();
		int cardValue0 = c1.getColor().getValue();
		
		BestFive bf = new BestFive(c1, c2, c3, c4, c5);
		System.out.println(bf.toString());
		
	}
	

	public BestFive(Card card1, Card card2, Card card3, Card card4, Card card5) { //konstruktorában 5 kártyát vár, amit eltárol magában
													
		bestFiveCard[0] = card1;														
		bestFiveCard[1] = card2;
		bestFiveCard[2] = card3;
		bestFiveCard[3] = card4;
		bestFiveCard[4] = card5;
		
	}
	
	

	public Card[] getBestFiveCards() {  //visszatér a magában tárolt kártyák tömbjével
		Card[] card1 = new Card[3]; 
		Card[] card2 = new Card[3];
		Card[] card3 = new Card[3];
		Card[] card4 = new Card[3];
		Card[] card5 = new Card[3];
		
	
		return bestFiveCard;
		
	}
	
	public String toString() {
		String result = "";
		String separator = "";
		for(Card card : bestFiveCard) {
			result = result + separator + card.toString();
			separator = " - ";
		}
		return result;
	}
	
	
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(bestFiveCard);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BestFive other = (BestFive) obj;
		if (!Arrays.equals(bestFiveCard, other.bestFiveCard)) {
			return false;
		}
		return true;
	}


//	public boolean equals(Card card){
//		 return (color.equals(card.getColor()) && figure.equals(card.getFigure())); // meg kell fogalmazni azt a logikát, hogy két kéz mikor egyenlő 
//	} 
	 // wikipédia- sok sok kártyaérték: royal flush, straight flush, four of a kind, full house, flush, straight, three of kind, two pair, pair, high card
}
