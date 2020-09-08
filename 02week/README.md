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
