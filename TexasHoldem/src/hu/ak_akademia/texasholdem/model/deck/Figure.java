/**
 * 
 */
package hu.ak_akademia.texasholdem.model.deck;

/**
 * @author Art�r �lvedi
 *
 */
public enum Figure {
	ACE('A', 1), KING('K', 2), QUEEN('Q', 3), JACK('J', 4), TEN('T', 5), NINE('9', 6), EIGHT('8', 7), SEVEN('7', 8),
	SIX('6', 9), FIVE('5', 10), FOUR('4', 11), THREE('3', 12), TWO('2', 13);

	private char symbol;
	private int value;

	/**
	 * @param symbol
	 * @param value
	 */
	private Figure(char symbol, int value) {
		this.symbol = symbol;
		this.value = value;
	}

	/**
	 * @return the symbol
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param figure
	 * @return
	 * A bemenetként kapott szöveg alapján
	 * visszatér a szövegnek megfelelő Figure objektummal
	 */
	public static Figure getFigureEnum(String figure) {
		for(Figure f : Figure.values()) {
			if(("" + f.getSymbol()).equals(figure)) {
				return f;
			}
		}
		return null;
	}
}
