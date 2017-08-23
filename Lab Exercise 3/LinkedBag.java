import java.util.*;
import java.lang.*;

public class LinkedBag<Item> extends Object implements Iterator<Item> {
	int size;
	Node tail;
    Iterator<Item> iter;
	public LinkedBag(){
		this.size = 0;
		this.tail = null;
        this.iter = null;
	}
	public class Node extends Object {
		Node next;
		Item content;
		Node(Item content, Node next){
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
        this.size = this.size - 1;
		Item i = (Item) this.tail.getElement();
		this.tail = this.tail.next();
		return i;
	}
	public void add(Item o){
		Node n = new Node(o, this.tail);
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
        if (this.iter == null){
            this.iter = new BagIterator(this.tail, this.size);
        } else if (!this.iter.hasNext()) {
            this.iter = new BagIterator(this.tail, this.size());
        }
        return this.iter.next();
    }
	private class BagIterator implements Iterator<Item> {
		LinkedBag<Item> copy;
		public BagIterator(Node tail, int size){
			copy = new LinkedBag<Item>();
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
    static public void main(String[] args){
        LinkedBag<Integer> lbag = new LinkedBag<Integer>();
        lbag.add(1);
        lbag.add(2);
        System.out.println(lbag.returnLast());
        System.out.println(lbag.next());
    }
};
