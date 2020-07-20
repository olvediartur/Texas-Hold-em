/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.texasholdem.model.db.DbEntity;

/**
 * @author bnagy
 *
 */
public abstract class AbstractController<T extends DbEntity> {
	
	AbstractDao<T> dao;
	
	protected T selected;
	List<T> all = new ArrayList<>();
	
	public AbstractController() {
	}
	
	public String create() {
		return dao.create(selected);
	}
	
	public String update() {
		return dao.update(selected);
	}
	
	public String getById(int id) {
		String feedBackMsg;
		try {
			selected = dao.read(id);
			feedBackMsg = "getting_succes";
		} catch (SQLException e) {
			feedBackMsg = "getting_failed";
			System.err.println("Cause: " + e.getMessage());
		}
		return feedBackMsg;
	}
	
	public String setAll() {
		String feedBackMsg;
		List<T> items;
		try {
			items = dao.getAll();
			for(T t : items) {
				if(!all.contains(t)) {
					all.add(t);
				}		
			}
			feedBackMsg = "all_user_setted";
		} catch (SQLException e) {
			feedBackMsg = "all_user_setting failed";
			System.err.println("Cause: " + e.getMessage());
		}		
		return feedBackMsg;
	}
	
	public abstract void setSelected(String[] dataFromUi);

	public T getSelected() {
		return selected;
	}

	public void setSelected(T selected) {
		this.selected = selected;
	}

	public List<T> getAll() {
		setAll();
		return all;
	}

	/**
	 * 
	 */
	public String getLast() {
		String feedBackMsg;
		try {
			selected = dao.getLast();
			feedBackMsg = "getting_succes";
		} catch (SQLException e) {
			feedBackMsg = "getting_failed";
			System.err.println("Cause: " + e.getMessage());
		}
		return feedBackMsg;
	};
	
}
