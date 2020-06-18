/**
 * 
 */
package hu.ak_akademia.texasholdem.view.consolemenu;

import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.texasholdem.exception.CantSelectExeption;

/**
 * @author bnagy
 *
 */
public class Menu extends MenuItem {
	private List<MenuItem> options = new ArrayList<>();
	/**
	 * @param index
	 * @param title
	 */
	public Menu(String title) {
		super(title);
	}
	
	/**
	 * @param index
	 * @param title
	 */
	public Menu(int index, String title) {
		super(index, title);
	}

	/**
	 * @param index
	 * @throws CantSelectExeption
	 */
	public void selectOption(int index) throws CantSelectExeption {
		options.get(index - 1).select();
	}
	
	/**
	 * @return
	 */
	public List<MenuItem> getOptions() {
		return options;
	}

	/**
	 * @return
	 */
	public String show() {
		StringBuilder sb = new StringBuilder();
		sb.append( "[" + getTitle() + "]\n");
		for(int i = 0; i < options.size(); i++) {
			sb.append(options.get(i).toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public void select() throws CantSelectExeption {
		super.select();
	}
	
}
