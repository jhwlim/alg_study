import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		Deque d = new Deque();
		
		for (int i = 0; i < n; i++) {
			String[] s = sc.nextLine().split(" ");
			
			switch (s[0]) {
			case "push_back" :
				d.push_back(Integer.parseInt(s[1]));
				break;
			case "push_front" :
				d.push_front(Integer.parseInt(s[1]));
				break;
			case "pop_front" :
				d.pop_front();
				break;
			case "pop_back" :
				d.pop_back();
				break;
			case "size" :
				d.size();
				break;
			case "empty" :
				d.empty();
				break;
			case "front" :
				d.front();
				break;
			case "back" :
				d.back();
				break;
			}
		}
		sc.close();
		
	}
	
	static class Node {	
		int data;
		Node next;
		Node prev;
		
		public Node(int data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}
	
	static class Deque {
		int size;
		Node head;
		Node tail;
		
		public Deque() {
			head = null;
			tail = null;
			size = 0;
		}
		
		// 정수 x를 덱의 맨 앞에 넣는다.
		public void push_front (int x) {
			Node newNode = new Node(x);
			if (size == 0) {
				head = newNode;
				tail = newNode;
			} else {
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			}
			size++;
		}
		
		// 정수 x를 덱의 맨 뒤에 넣는다.
		public void push_back (int x) {
			Node newNode = new Node(x);
			if (size == 0) {
				head = newNode;
				tail = newNode;
			} else {
				newNode.prev = tail;
				tail.next = newNode;
				tail = newNode;
			}
			size++;
		}
		
		// 덱의 맨 앞에 있는 수를 뺀다.
		public void pop_front() {
			front();
			
			if (size == 1) {
				head = null;
				tail = null;
				size--;
			} else if (size > 1) {
				head = head.next;
				head.prev = null;
				size--;
				if (size == 1) tail = head;
			}
			
		}
		
		// 덱의 맨 뒤에 있는 수를 뺀다.
		public void pop_back() {
			back();
			
			if (size == 1) {
				head = null;
				tail = null;
				size--;
			} else if (size > 1) {
				tail = tail.prev;
				tail.next = null;
				size--;
				if (size == 1) head = tail;
			}
		}
		
		// 덱의 맨 앞에 있는 수를 출력한다.
		public void front() {
			System.out.println(size > 0 ? head.data : -1);
		}
		
		// 덱의 맨 뒤에 있는 수를 출력한다.
		public void back() {
			System.out.println(size > 0 ? tail.data : -1);
		}
		
		// 덱에 들어있는 정수의 개수를 출력한다.
		public void size() {
			System.out.println(size);
		}
		
		// 덱이 비어있는지 확인한다.
		public void empty() {
			System.out.println(size == 0 ? 1 : 0);
		}
		
		// 덱을 출력한다.
		public void print() {
			if (size > 0) {
				Node node = head;
				while (true) {
					System.out.print(node.data);
					node = node.next;
					if (node != null) {
						System.out.print(" → ");
					} else {
						break;
					}
				}
				System.out.println();
			}
		}
	}
}
