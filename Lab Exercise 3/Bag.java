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
		Item content;
		Node(Object content, Node next){
			this.content = content;
			this.next = next;
		}
		public Node next(){
			return this.next;
		}
		public Item getElement(){
			return this.content;
		}
	}
	public boolean isEmpty(){
		return this.size == 0;
	}
	public Item returnLast(){
		Item i = this.tail.getElement;
		this.tail = this.tail.next();
	}
	public void add(Item o){
		Node n = new Node(o, this.tail);
		this.tail = n;
	}
	public int size(){
		return this.size;
	}
	public Iterator<Item> iterator(){
		Iterator<Item> iter = new BagIterator(this.tail);
		return iter;
	}
	public Node tail(){
		return this.tail;
	}
	private class BagIterator implements Iterator<Item>{
		private Bag<Item> copy;
		public BagIterator(Node tail, int size){
			copy = new Bag<Item>();
			Node n = tail;
			for(int i=0; i< size; i++){
				copy.add(n.getElement());
				n = n.next();
			}
		}
		public boolean hasNext(){return !copy.isEmpty();}
		public Item next(){return (Item )copy.returnLast();}
	}
};
