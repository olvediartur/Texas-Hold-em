package hu.ak_akademia.texasholdem.model;

/**
 * @author Artúr Ölvedi
 *
 */
public class Node<T> {

	T data;

	Node<T> next;

	public Node(T data) {
		this.data = data;
	}

}
