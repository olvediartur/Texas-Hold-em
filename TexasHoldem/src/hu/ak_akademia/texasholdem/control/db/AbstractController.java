/**
 * 
 */
package hu.ak_akademia.texasholdem.control.db;

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
		String feedBackMsg = "Ezt még ki kell találni, hogy hogyan állítsuk";
		selected = dao.read(id);
		return feedBackMsg;
	}
	
	public String setAll() {
		String feedBackMsg = "Ezt még ki kell találni, hogy hogyan állítsuk";
		List<T> items = dao.getAll();
		for(T t : items) {
			if(!all.contains(t)) {
				all.add(t);
			}		
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
	
}
