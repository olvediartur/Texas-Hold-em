package hu.ak_akademia.texasholdem.model;

/**
 * @author Artúr Ölvedi
 *
 */
public class CircularLinkedList {

	private int size = 0;
	private Node head = null;
	private Node tail = null;

	public void add(String data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = head;
		} else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}
		size++;
	}

	public void delete(String data) {
		Node currentNode = head;
		if (head != null) {
			if (currentNode.data.equals(data)) {
				head = head.next;
				tail.next = head;
			} else {
				do {
					Node nextNode = currentNode.next;
					if (nextNode.data.equals(data)) {
						currentNode.next = nextNode.next;
						break;
					}
					currentNode = currentNode.next;
				} while (currentNode != head);
			}
		}
		size--;
	}

	public String getNext(String actual) {
		Node currentNode = head;
		if (head == null) {
			return "The list is Empty!";
		} else {
			do {
				if (currentNode.data.equals(actual)) {
					return currentNode.next.data;
				}
				currentNode = currentNode.next;
			} while (currentNode != head);
		}
		return "No such element in the list!";
	}

	public String getPrevious(String actual) {
		Node curr = head;
		int counter = 0;
		if (curr == null) {
			return "The list is Empty!";
		} else {
			Node temp = curr;

			for (int i = 0; i < getSize(); i++) {
				if (!temp.next.data.equals(actual)) {
					temp = temp.next;
				} else {
					counter++;
				}
			}
			return counter == 0 ? "No such element in the list!" : temp.data;
		}
	}

	public int getSize() {
		return size;
	}
}
