package RavenPrograms;

public class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
	
	public boolean isEmpty(Node n) {
		return (n.next == null);
	}
}




