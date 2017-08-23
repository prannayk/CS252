import java.util.*;
import java.lang.*;

public class Bag<Item> extends Object implements Iterator<Item> {
	int size;
	Node tail;
	public Bag(){
		this.size = 0;
		this.tail = NULL;
	}
	static private class Node {
		Node next;
		Object content;
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
	public boolean isEmpty(){
		return this.size == 0;
	}
	public Item returnLast(){
		Item i = (Item) this.tail.getElement;
		this.tail = this.tail.next();
		return i;
	}
	public void add(Item o){
		Node n = new Node((Object) o, this.tail);
		this.tail = n;
	}
	public int size(){
		return this.size;
	}
	public Iterator<Item> iterator(){
		Iterator<Item> iter = new BagIterator(this.tail, this.size());
		return iter;
	}
	public Node tail(){
		return this.tail;
	}
	private class BagIterator implements Iterator<Item> {
		Bag<Item> copy;
		public BagIterator(Node tail, int size){
			copy = new Bag<Item>();
			Node n = tail;
			for (int i=0;i<size;i++)
				copy.add((Item)tail.getElement());
		}
		public boolean hasNext(){return !copy.isEmpty();}
		public Item next(){return (Item)copy.returnLast();}	
	};
	
};
