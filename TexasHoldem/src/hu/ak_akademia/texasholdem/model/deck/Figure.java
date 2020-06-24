/**
 * 
 */
package hu.ak_akademia.texasholdem.model.deck;

/**
 * @author Artúr Ölvedi
 *
 */
public enum Figure {
	ACE("A", 1), KING("K", 2), QUEEN("Q", 3), JACK("J", 4), TEN("T", 5), NINE("9", 6), EIGHT("8", 7),
	SEVEN("7", 8),	SIX("6", 9), FIVE("5", 10), FOUR("4", 11), THREE("3", 12), TWO("2", 13);

	private String symbol;
	private int value;

	/**
	 * @param symbol
	 * @param value
	 */
	private Figure(String symbol, int value) {
		this.symbol = symbol;
		this.value = value;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
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
	 * @return A bemenetként kapott szöveg alapján visszatér a szövegnek megfelelő
	 *         Figure objektummal
	 */
	public static Figure getFigureEnum(String figure) {
		for (Figure f : Figure.values()) {
			if (("" + f.getSymbol()).equals(figure)) {
				return f;
			}
		}
		return null;
	}
	
	/**
	 * @param figure
	 * @return A bemenetként kapott szám alapján visszatér a számnak megfelelő
	 *         Figure objektummal
	 */
	public static Figure getFigureEnum(int figure) {
		for (Figure f : Figure.values()) {
			if (f.getValue() == figure) {
				return f;
			}
		}
		return null;
	}
}
