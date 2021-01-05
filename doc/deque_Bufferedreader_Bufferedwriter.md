# 2주차 알고리즘 스터디
- 문제풀이 하면서 공부한 내용 정리하기

## 1. BufferedReader 
### (1) 개요
- 콘솔 또는 파일로 부터 텍스트를 읽을 때 사용하는 클래스
- Scanner 클래스와 비교하여 효율적으로 데이터를 입력 받을 수 있다. 

### (2) Method
- readLine()   
  - Enter를 기준으로 한줄씩 입력하고, String 타입을 반환한다.
  - String 이외의 데이터 타입으로 받기위해서는 parsing 필요
  
```java
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  String str = br.readline(); 
```

### (3) 사용시 주의사항
- 예외처리 필요 ; throws IOException or try ~ catch문

## 2. BufferedWriter
### (1) 개요
- 텍스트를 출력할 때 사용하는 클래스
- System.out 과 비교하여 효율적으로 데이터를 출력할 수 있다.

### (2) Method
- write()
  - Input Parameter를 String 형식으로 출력 (개행문자 작성 필요)
  
```java
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  
  bw.write("ABC\n"); // "ABC" + Enter
  
  bw.flush(); // flush buffer
  bw.close(); // close buffer
```

### (3) 사용시 주의사항
- 예외처리 필요 ; throws IOException or try ~ catch문
- 클래스 사용이 끝나면 flush 및 close 필요

## 3. Deque (덱)
### (1) 개요
- 시작과 끝 지점에서 양쪽 모두에서 데이터를 넣거나 뺄 수 있는 자료구조
- 스택과 큐의 특징을 모두 가지고 있다.  
  (스택 : front_push → front_pop, 큐 : back_push -> front_pop)

### (2) Java 에서의 사용법
- Java에서는 아래와 같은 방법으로 Deque 을 사용할 수 있다.

```java
  // 덱 선언
  Deque<Integer> deque = new ArrayDeque<Integer>();
```

```java
  // add() : 덱의 뒤에 추가
  deque.add(1); 
  deque.add(2);

  // addFirst() : 덱의 앞에 추가
  deque.addFirst(3);

  // addLast() : 덱의 뒤에 추가
  deque.addLast(3);
```

```java
  // remove() : 덱의 뒤에서 삭제
  deque.remove();

  // removeFirst() : 덱의 앞에서 삭제
  deque.removeFirst(); 

  // removeFirst() : 덱의 뒤에서 삭제
  deque.removeLast();
```

```java
  int n = deque.size(); // 덱의 요소의 개수를 반환
  boolean isEmpty = deque.isEmpty(); // 덱이 비어있으면 true
```

### (3) Deque 구현하기
- LinkedList 개념을 활용하여 Deque 
```java
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
```
