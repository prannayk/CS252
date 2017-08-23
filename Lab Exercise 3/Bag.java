import java.util.*
import java.lang.*

public class Bag<Item> extends Object implements Iterator<Item> {
	int size;
	public Bag(){
		this.size = 0;
		this.head = NULL;
	}
	static private class Node {
		Node next;
		Item content;
		Node(Object content, Node next){
			this.content = content;
			this.next = next;
		}
		public Node next(){
			return this.next;
		}
		public Object getElement(){
			return this.content;
		}
	}
	Node tail;
	public boolean isEmpty(){
		return this.size == 0;
	}
	public void add(Item o){
		Node n = new Node(o, this.tail);
		this.tail = n;
	}
	public int size(){
		return this.size;
	}
};