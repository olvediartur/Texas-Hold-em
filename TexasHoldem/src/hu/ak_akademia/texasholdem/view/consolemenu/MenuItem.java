/**
 * 
 */
package hu.ak_akademia.texasholdem.view.consolemenu;

import hu.ak_akademia.texasholdem.exception.CantSelectExeption;

/**
 * @author bnagy
 *
 */
public abstract class MenuItem {
	private int index;
	private String title;
	
	/**
	 * @param index
	 * @param title
	 */
	public MenuItem(int index, String title) {
		this.index = index;
		this.title = title;
	}
	
	/**
	 * @param title
	 */
	public MenuItem(String title) {
		this.title = title;
	}

	/**
	 * @return
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	

	/**
	 *
	 */
	@Override
	public String toString() {
		return index + " - " + title;
	}
	
	/**
	 * @throws CantSelectExeption
	 */
	public void select() throws CantSelectExeption {
		throw new CantSelectExeption();
	}
}