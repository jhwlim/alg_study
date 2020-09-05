import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		IntQueue q = new IntQueue(n);
		
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			switch (s) {
			case "push" :
				q.inqueue(sc.nextInt());
				break;
			case "pop" :
				q.dequeue();
				break;
			case "size" :
				q.size();
				break;
			case "empty" :
				q.empty();
				break;
			case "front" :
				q.printFront();
				break;
			case "back" :
				q.printRear();
				break;
			}
		}
		
		sc.close();
	}

	static class IntQueue {
		private int num;
		private int max;
		private int[] queArr;
		
		private int front;
		private int rear;
		
		public IntQueue(int max) {
			this.max = max;
			num = 0;
			queArr = new int[max];
			front = 0;
			rear = 0;
		}
		
		void inqueue(int data) {
			if (num < max) {
				queArr[rear++] = data;
				num++;
				if (rear >= max) rear = 0;		
			}
		}
		
		void dequeue() {
			int result = -1;
			if (num > 0) {
				result = queArr[front++];
				num--;
				if (front >= max) {
					front = 0;
				}
			} 
			System.out.println(result);
		}
		
		void size() {
			System.out.println(num);
		}
		
		void empty() {
			System.out.println((num == 0) ? 1 : 0);
		}
		
		public void printFront() {
			System.out.println((num > 0) ? queArr[front] : -1);
		}
		
		public void printRear() {
			System.out.println((num > 0) ? queArr[rear-1] : -1);			
		}
		
	}
}
