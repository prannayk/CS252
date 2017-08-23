class Node {
	int key;
	String value;

	Node leftChild;
	Node rightChild;

	Node(int key, String val){
		this.key = key;
		this.val = val;
	}

	public String toString(){
		return "" + key;
	}
}