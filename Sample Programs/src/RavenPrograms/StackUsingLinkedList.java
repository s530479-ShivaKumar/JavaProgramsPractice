package RavenPrograms;

public class StackUsingLinkedList {
	int maxSize;
	int top =-1;
	LinkedList l;
	

	public StackUsingLinkedList(int maxSize) {
		this.maxSize = maxSize;
		l = new LinkedList();
		
	}

	public void push(Node n) {
		if(top<maxSize) {
			n.next = l.head;
			l.head = n;
			top++;
			System.out.println("Pushed element "+ n.data);
		}
		else {
			System.out.println("Cannot push as stack is full");
		}
	}
	public void pop() {
		if(top< 0) {
			System.out.println("Cannot pop as stack is empty");
		}
		else {
			Node temp = l.head;
			l.head = l.head.next;
			top--;
			System.out.println("Removed element "+ temp.data);
		}
	}
}
