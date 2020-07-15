package hu.ak_akademia.texasholdem.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Artúr Ölvedi
 *
 */
//public class CircularLinkedList<T>  implements Iterator<T>,Iterable<T> {
public class CircularLinkedList<T>  implements Iterable<T> {
	private int size = 0;
	private Node<T> head = new Node(null);
	private Node<T> tail = new Node(null);
	
	//private Node<T> actualNode;
	private List<T> listOfPlayers = new ArrayList<>();

	public CircularLinkedList() {
		super();
		head.next = tail;
		tail.next = head;
		//actualNode = head;
	}

	public Node<T> getDealer() {
		return tail;
	}

	public void add(T element) {
		Node<T> newNode = new Node<T>(element);
		if (head.data == null) {
			head = newNode;
			tail = newNode;
			newNode.next = head;
		} else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}
		listOfPlayers.add(element);
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
		if (head.data == null) {
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
		if (curr.data == null) {
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

	public List<T> getListOfPlayers() {
		return listOfPlayers;
	}

	/*
	 * @Override public boolean hasNext() { if(actualNode.data == null) { actualNode
	 * = head; } if(!actualNode.equals(tail)) { return true; } return false; }
	 * 
	 * @Override public T next() { actualNode = actualNode.next; return
	 * actualNode.data; }
	 */

	@Override
	public Iterator<T> iterator() {
		return listOfPlayers.iterator();
	}
	
}
