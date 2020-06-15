/* Ez a legjobb 5 kártyát tároló osztály
 * 
 */
package hu.ak_akademia.texasholdem.control.bl;
/*
 * * meghívtam a deck packaget
 */
import hu.ak_akademia.texasholdem.model.deck.*;

/**
 * @author Lidia
 *
 */
public class BestFive { //osztály
	
	Card[]bestFiveCard;  // mező
	int cardValue1; //ebbe inicializálom a kártya értékét majd (1-13), pl. for ciklussal feltöltés?
	int cardValue2; 
	int cardValue3; 
	int cardValue4; 
	int cardValue5; 
	

	public Card card1;  //5 card objektum egységbe zárása
	public Card card2;
	public Card card3;
	public Card card4;
	public Card card5;
	
	public static void main (String[] args) { // ide kell majd belepakolni a függvényeket, amiket meg szeretnék hívni
		//toString();
		//BestFive(Card card1, Card card2, Card card3, Card card4, Card card5);
		//color.equals(card.getColor();
		//figure.equals(card.getFigure();
		//getBestFiveCards();
		
	}
	

	private BestFive(Card card1, Card card2, Card card3, Card card4, Card card5) { //konstruktorában 5 kártyát vár, amit eltárol magában
		this.card1 = card1;		//objektum card1 változója													//privát, így más osztályból nem lehet rajta módósítani, kell a privát???
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
		this.card5 = card5;
	}
	
	

	public Card[] getBestFiveCards() {  //visszatér a magában tárolt kártyák tömbjével
		Card[] card1 = new Card[3]; //minden kártya tároljon három tulajdonságot???(color,figure, cardValue) pl. piros szív 10???
		Card[] card2 = new Card[3];
		Card[] card3 = new Card[3];
		Card[] card4 = new Card[3];
		Card[] card5 = new Card[3];
		
	
		
		return this.card1, this.card2, this.card3, this.card4, this.card5;
		
	}
	
	public String toString() {
		String bestFive = " ";
		for(int i = 0; i <BestFive.size; i++ ) {
			bestFive = bestFive + BestFive.toString()+ " ";
		}
		//StringtoString - öt lap szöveges megjelenítése, debughoz, teszteléshez
		return bestFive;
	}
	
	
	 public boolean equals(Card card){
		 return (color.equals(card.getColor()) && figure.equals(card.getFigure())); // meg kell fogalmazni azt a logikát, hogy két kéz mikor egyenlő 
	} 
	 // wikipédia- sok sok kártyaérték: royal flush, straight flush, four of a kind, full house, flush, straight, three of kind, two pair, pair, high card
}
