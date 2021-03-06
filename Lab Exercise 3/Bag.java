import java.util.*;
import java.lang.*;

public class Bag<Item> extends Object implements Iterator<Item> {
	int size;
	Node tail;
    Iterator<Item> iter;
	public Bag(){
		this.size = 0;
		this.tail = null;
        this.iter = null;
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
        this.size = this.size - 1;
		Item i = (Item) this.tail.getElement();
		this.tail = this.tail.next();
		return i;
	}
	public void add(Item o){
		Node n = new Node((Object) o, this.tail);
		this.tail = n;
        this.size++;
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
    public boolean hasNext(){
        return !this.isEmpty();
    }
    public Item next(){
        if (!this.hasNext()) return null;
        if (this.iter == null) {
            this.iter = new BagIterator(this.tail, this.size());
        } else if (!this.iter.hasNext()) {
            this.iter = new BagIterator(this.tail, this.size());
        }
        return this.iter.next();
    }
	private class BagIterator implements Iterator<Item> {
		Bag<Item> copy;
		public BagIterator(Node tail, int size){
			copy = new Bag<Item>();
			Node n = tail;
			for (int i=0;i<size;i++)
				copy.add((Item)n.getElement());
                n = n.next();
		}
		public boolean hasNext(){return !copy.isEmpty();}
		public Item next(){
            if (this.hasNext()) return (Item)copy.returnLast();
            else {return null;}}	
	};
    public static void main(String[] args){
        Bag<Integer> bag = new Bag<Integer>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        System.out.println(bag.returnLast());
        System.out.println(bag.next());
    }
};
