/**
 * Comparator<BestFive> interface
 */
package hu.ak_akademia.texasholdem.control.bl;

import java.util.Comparator;

/**
 * @author bnagy
 * @author user
 *
 */
public class BestFiveComparator implements Comparator<BestFive> {

	@Override
	public int compare(BestFive o1, BestFive o2) {
		if (o1.getBestFiveValue().getValue() < o2.getBestFiveValue().getValue()) {
			return -1;
		} else if (o1.getBestFiveValue().getValue() > o2.getBestFiveValue().getValue()) {
			return 1;
		} else {
			return 0;
		}
	}

}
