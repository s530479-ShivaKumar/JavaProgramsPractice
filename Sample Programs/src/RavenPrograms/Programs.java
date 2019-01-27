package RavenPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Programs {
	public static Object obj1 = new Object();
	public static Object obj2 = new Object();

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Programs p = new Programs();
		System.out.print("Name ");
		p.PrintName();
		System.out.println("Print Array ");
		p.PrintArray();
		System.out.println();
		System.out.println("Palindrome");
		System.out.println("Number Palindrome "+p.isPalindrome(1567651));
		
		System.out.println("String palindrome " + p.isPalindrome("ABCDCBA"));
		System.out.println("Reverse of a String");
		System.out.println(p.reverseString("shiva"));
		System.out.println("Fibonacci");
		p.fibonacci(9);
		System.out.println();
		System.out.println("Binary Search");
		int binary = p.binarySearch(new int[] { 1,2,3,5,8, 10,11}, 11);
		if (binary < 0) {
			System.out.println("not found");
		} else {
			System.out.println("found at index: " + binary);
		}
		System.out.println("bubble Sort");
		p.bubblesort(new int[] {5,6,3,5,6,9});
		System.out.println();
		
		System.out.println("Middle Linked List");
		LinkedList l= p.CreateLinkedList();
		Node first = l.head;
		Node second = l.head;
		Node head = l.head;
		while(head!=null) {
			while(first != null && first.next != null) {
				first = first.next.next;
				second = second.next;
			}
			head = head.next;
		}	
		System.out.println("Middle Node is " +second.data);
		p.isArmstrong(Integer.parseInt(args[0]));
//		Thread1 t1runnable = new Thread1();
//		Thread2 t2runnable = new Thread2();
//		
//		Thread t1 = new Thread(t1runnable);
//		Thread t2 = new Thread(t2runnable);
//		t1.start();
//		t2.start();
		Employee e1 = new Employee(1, 20, "shiva");
		Employee e2 = new Employee(3, 25, "shiva");
		Employee e3 = new Employee(2, 22, "shiva");
		Employee e4 = new Employee(4, 21, "shiva");
		ArrayList<Employee> arList = new ArrayList<>();
		arList.add(e1);
		arList.add(e2);
		arList.add(e3);
		arList.add(e4);
		arList.sort(null);
		System.out.println("sorting by id using Comparable");
		for (Employee e : arList)
			System.out.println(e.id + " " + e.age + " " + e.name);

		Comparator<Employee> c = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.age - o2.age;
			}
		};
		arList.sort(c);
		System.out.println("sorting by age using Comparator");
		for (Employee e : arList)
			System.out.println(e.id + " " + e.age + " " + e.name);

		System.out.println("sorting by age using Comparator and lambda expressions, streams");
		List<Employee> sortedList = arList.stream()
				.sorted((em1, em2) -> em1.getAge() < em2.getAge() ? -1 : em1.getAge() > em2.getAge() ? 1 : 0)
				.collect(Collectors.toList());
		for (Employee e : arList)
			System.out.println(e.id + " " + e.age + " " + e.name);
		
		p.PrintPascalsTriangle(6);
		
		StackUsingLinkedList st = new StackUsingLinkedList(10);
		st.push(new Node(5));
		st.push(new Node(54));
		st.push(new Node(55));
		
		while(st.l.head !=null) {
			st.pop();
		}
	}

	// Print Name
	public void PrintName() {
		System.out.println("Shiva");
	}

	// Print Array
	public void PrintArray() {
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i]+ " ");
		}
	}

	// Reverse a String
	public String reverseString(String s) {
		String revString = "";
		if (s == null) {
			return null;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			revString += s.charAt(i);
		}
		return revString;
	}

	// palindrome for a String
	public boolean isPalindrome(String s) {
		if (s == null) {
			return true;
		} else {
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {

				} else {
					return false;
				}
			}
			return true;

		}
	}

	// Palindrome for an integer
	public boolean isPalindrome(int n) {
		int temp = n;
		long rev = 0;

		while (n > 0) {
			int last = n % 10;
			rev = rev * 10 + last;
			n = n / 10;
		}
		if (temp == rev) {
			return true;
		} else {
			return false;
		}
	}

	// Fibonacci series

	public void fibonacci(int n) {
		int first = 0;
		int second = 1;
		int third = 0;
		if (n > 0) {
			System.out.print(0 + " ");
		}
		if (n > 1) {
			System.out.print(1 + " ");
		}

		for (int i = 2; i < n; i++) {
			third = first + second;
			first = second;
			second = third;
			System.out.print(third + " ");
		}
	}

	// binary search
	public int binarySearch(int[] array, int n) {
		int first = 0;
		int last = array.length;
		while (first <=last) {
			int middle = (first+last)/2;
			if (array[middle] == n) {
				return middle;
			} else if (array[middle] > n) {
				last = middle - 1;
			} else if (array[middle] < n) {
				first = middle + 1;
			}

		}
		return -1000;
	}
//Bubble sort
	public void bubblesort(int[] arr) {
		int iteration = arr.length - 1;
		int temp = 0;

		for (int i = 0; i < iteration; i++) {
			for (int j = 0; j < iteration; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public LinkedList CreateLinkedList() {
		LinkedList link = new LinkedList();
		link.head = new Node(1);
		link.head.next = new Node(2);
		link.head.next.next = new Node(3);
		link.head.next.next.next = new Node(4);
		link.head.next.next.next = new Node(5);
		return link;

	}
// Armstrong
	public void isArmstrong(int n) {
		int temp = n;
		int remainder = 0;
		int number = 0;
		while (n > 0) {
			remainder = n % 10;
			number = number + remainder * remainder * remainder;
			n = n / 10;
		}
		if (number == temp) {
			System.out.println(temp + " is an armstrong number");
		} else {
			System.out.println(temp + " is not an armstrong number");
		}
	}
	// Pascals triangle
	public void PrintPascalsTriangle(int n) {
		int[] currentRow = {1};
		int[] previousRow;
		printRow(currentRow,n-1);
		previousRow = currentRow;
		
		for (int i=2;i<=n;i++) {
			currentRow = new int[i];
			currentRow[0] =1;
			currentRow[i-1] = 1;
			for(int j =0;j<=i-3;j++) {
				currentRow[j+1] = previousRow[j]+ previousRow[j+1];
			}
			printRow(currentRow,n-i);
			previousRow = currentRow;
		}
		
	}
	public void printRow(int[] row, int spaces) {
		String spaceProvided = "";
		while(spaces>0) {
			spaceProvided+= " ";
			spaces-=1;
		}
		System.out.print(spaceProvided);
		for(int i : row) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}

class Thread1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (Programs.obj1) {
			System.out.println("holding obj 1");

			System.out.println("waiting for obj2 after obj1 not going to execute both locks accuried statement");

			synchronized (Programs.obj2) {
				System.out.println("Holding both 1 and 2");
			}
		}

	}

}

class Thread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (Programs.obj2) {
			System.out.println("holding obj 2");
			System.out.println("waiting for obj1 after obj2 not going to execute both locks accuried statement");
			synchronized (Programs.obj1) {
				System.out.println("Holding both 1 and 2");
			}
		}

	}

}


