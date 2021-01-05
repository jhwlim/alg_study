# 1주차. 알고리즘 스터디
- 시간/공간 복잡도 (Time and Space Complexity)
- 스택과 큐 (Stack and Queue)

## 1. 시간/공간 복잡도
### (1) 알고리즘
- 컴퓨터 프로그램의 수학적 추상화, 문제해결을 위한 계산과정  
- 프로그램의 실행속도는 프로그램이 동작하는 하드웨어나 컴파일러 등의 조건에 따라 결정되며,  
- <u>입력의 수/단위가 커질수록 알고리즘의 성능과 효율성은 중요해진다.</u>  

### (2) 복잡도
- <u>알고리즘의 성능을 객관적으로 평가하는 기준.</u>   
① 시간복잡도 : 실행에 필요한 시간을 평가  
② 공간복잡도 : 메모리영역이 얼마나 필요한가를 평가  

### (2-1) 시간복잡도 
실행에 필요한 시간은 각 연산에 얼만큼의 시간이 소요되는지에 따라 결정되며,  
알고리즘을 구성하는 각 연산의 실행시간의 총합 = 알고리즘의 실행시간 이다.  
(2개 이상의 복잡도로 구성된 알고리즘의 전체 복잡도는 차원이 더 높은 쪽의 복잡도를 우선한다.)

<u>자료구조에 따라 시간복잡도는 달라지기 때문에</u>, 알고리즘 문제풀이시 어떤 자료구조를 사용할지 고민이 필요하다.  
배열과 중첩 for문을 통해서 쉽게 접근하면, 시간 복잡도는 n의 중첩된 for문의 횟수 승이 되기 때문에 시간초과와 맞닥뜨리게 된다.

이외에도 시간/공간 복잡도 관점에서 좀 더 효율이 좋은 방법으로 문제에 접근하면 좋을 결과가 있을 것이다.  
(예. String → StringBuilder or StringBuffer)

## 2. 스택
### (1) 스택
- 데이터를 일시적으로 저장하기 위해 사용하는 자료구조
- 가장 나중에 넣은 데이터를 가장 먼저 꺼낸다. (후입선출, LIFO, Last In First Out)

### (2) 주요 용어
- push : 스택에 데이터를 넣는 작업
- pop : 스택에서 데이터를 꺼내는 작업
- top : push와 pop을 하는 위치
- bottom : 스택의 가장 아랫부분

### (3) 스택 구현 - int형
```java
public class IntStack {
	int ptr; // 스택에 쌓여 있는 데이터 수
	int max; // 스택에 쌓을 수 있는 최대 데이터 수
	int[] stackArr; // 스택 본체용 배열
	
	// 스택이 비어있을 경우 실행시 예외
	public class EmptyIntStackException extends RuntimeException {
	  public EmptyIntStackException() {};
	}
  
	// 스택이 비어있을 경우 실행시 예외
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {};
	}
	
	// 생성자
	public IntStack(int max) {
		this.max = max;
		this.ptr = 0;
		this.stackArr = new int[max];
	}
	
	public void push (int inputData) throws OverflowIntStackException {
		if (ptr >= max) throw new OverflowIntStackException();
		stackArr[ptr++] = inputData;
	}
	
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0) throw new EmptyIntStackException();
		return stackArr[--ptr];
	}
	
	// 스택 꼭대기에 있는 데이터를 '몰래 엿보는' 메서드
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0) throw new EmptyIntStackException();
		return stackArr[ptr - 1];
	}
}
```
### (4) 스택의 시간복잡도
- InsertIon, Deletion : O(1) ; 데이터 삽입과 삭제는 맨 위의 데이터를 대상으로 한다.
- Search : O(n)

## 3. 큐
### (1) 큐
- 스택과 마찬가지로 데이터를 일시적으로 쌓아두기 위한 자료구조
- 가장 먼저 넣은 데이터를 가장 먼저 꺼낸다. (선입선출, FIFO, First In First out)

### (2) 주요 용어
- enqueue (인큐) : 큐에 데이터를 넣는 작업
- dequeue (디큐) : 큐에서 데이터를 꺼내는 작업
- front : 데이터를 꺼내는 위치
- rear : 데이터를 넣는 위치

### (3) 인큐와 디큐의 복잡도
- 인큐의 복잡도 : O(1)
- 디큐의 복잡도 : O(n) ; 디큐를 하고 모든 요소를 앞으로 한칸씩 이동해야한다.

### (4) 링버퍼
- 디큐시 배열요소를 앞으로 옮기지 않는 큐를 구현하기 위해 사용하는 자료구조
- 큐 배열의 처음이 끝과 연결되었다고 보는 구조
- 논리적으로 어떤 요소가 첫번째 요소이고, 마지막 요소인지 식별하기 위하여  
변수 front와 rear를 사용한다.
- 인큐와 디큐 수행시, front와 rear 변수를 업데이트를 해주므로  
요소 이동으로 인한 복잡도를 개선할 수 있다. (복잡도 : O(1))

### (5) 링(버퍼) 구현 - int형
```java
public class IntQueue {

	private int max; 
	private int num;
	private int[] que;
	
	private int front;
	private int rear;
	
	public IntQueue(int max) {
		this.max = max;
		this.num = 0;
		que = new int[max];
		front = 0;
		rear = 0;
	}
	
	public void enQueue(int data) {
		if (num == max) { // full
			return;
		}
		num++;
		que[rear++] = data;
		if (rear == max) {
			rear = 0;
		}
	}
	
	public int deQueue() {
		if (num < 1) { // empty
			return 0;
		}
		num--;
		int out = que[front++];
		if (front == max) {
			front = 0;
		}
		
		return out;
		
	}
}
  ```
