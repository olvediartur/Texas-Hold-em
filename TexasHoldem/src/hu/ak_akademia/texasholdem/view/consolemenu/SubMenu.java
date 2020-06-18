/**
 * 
 */
package hu.ak_akademia.texasholdem.view.consolemenu;

/**
 * @author bnagy
 *
 */
public class SubMenu extends Menu {

	/**
	 * @param index
	 * @param title
	 */
	public SubMenu(int index, String title) {
		super(index, title);
	}

	/**
	 *
	 */
	@Override
	public void select() {
		// TODO Auto-generated method stub
	}
	
	/**
	 *
	 */
	@Override
	public String show() {
		StringBuilder sb = new StringBuilder();
		sb.append( "[" + getTitle() + "]\n");
		for(int i = 0; i < getOptions().size(); i++) {
			sb.append(getIndex() + "." + getOptions().get(i).toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
