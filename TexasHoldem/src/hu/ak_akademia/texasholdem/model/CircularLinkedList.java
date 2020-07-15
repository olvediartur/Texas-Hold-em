package hu.ak_akademia.texasholdem.model;

import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.texasholdem.control.game.Player;

/**
 * @author Artúr Ölvedi
 *
 */
public class CircularLinkedList<T>  {
	private int size = 0;
	private Node<T> head;
	private Node<T> tail;
	private List<Player> listOfPlayers = new ArrayList<Player>();
	
	
	public Node<T> getDealer() {
		return tail;
	}

	public void add(T player) {
		Node<T> newNode = new Node<T>(player);
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = head;
		} else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}
		listOfPlayers.add((Player) player);
		size++;
	}

	public void delete(T player) {
		Node<T> currentNode = head;
		if (head != null) {
			if (currentNode.data.equals(player)) {
				head = head.next;
				tail.next = head;
			} else {
				do {
					Node<T> nextNode = currentNode.next;
					if (nextNode.data.equals(player)) {
						currentNode.next = nextNode.next;
						break;
					}
					currentNode = currentNode.next;
				} while (currentNode != head);
			}
		}
		size--;
	}

	public boolean contains(T searchPlayer) {
		Node<T> currentNode = head;
		if (head == null) {
			return false;
		} else {
			do {
				if (currentNode.data == searchPlayer) {
					return true;
				}
				currentNode = currentNode.next;
			} while (currentNode != head);
			return false;
		}
	}

	public T getNext(T player) {
		Node<T> currentNode = head;
		if (head == null) {
			return null;
		} else {
			do {
				if (currentNode.data == player) {
					return currentNode.next.data;
				}
				currentNode = currentNode.next;
			} while (currentNode != head);
		}
		return null;
	}

	public T getPrevious(T player) {
		Node<T> curr = head;
		int counter = 0;
		if (curr == null) {
			return null;
		} else {
			Node<T> temp = curr;
			for (int i = 0; i < getSize(); i++) {
				if (!(temp.next.data == player)) {
					temp = temp.next;
				} else {
					counter++;
				}
			}
			return counter == 0 ? null : temp.data;
		}
	}

	public int getSize() {
		return size;
	}

	public List<Player> getListOfPlayers() {
		return listOfPlayers;
	}
	
}
