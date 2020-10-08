# Baisc Usage of Markdown

### new line : Enter 2회
### 수평선(hr) : -/ * 을 3회 이상

---

## 1. 제목

```
# 제목1
## 제목2 
### 제목3
#### 제목4
##### 제목5
###### 제목6
```

# 제목1
## 제목2
### 제목3
#### 제목4
##### 제목5
###### 제목6

---

## 2. 리스트
### (1) 번호없는 리스트 
-/ +/ * 중 하나를 연속적으로 사용

```
- 리스트1
- 리스트2
- 리스트3
```

- 리스트1
- 리스트2
- 리스트3

### (2) 번호 있는 리스트

```
1. 리스트1
2. 리스트2
3. 리스트3
```

1. 리스트1
2. 리스트2
3. 리스트3

---

## 3. 글씨체

### (1) 기울인 글씨

```
*기울인 글씨*
```

*기울인 글씨*

### (2) 굵은 글씨

```
**굵은 글씨**
```
**굵은 글씨**

---

## 4. 이미지 

```
![coding image](pic_coding.jpg)

![그림 파일이 없습니다.](pic_coding.png)
```

![coding image](pic_coding.jpg) <br>

![그림 파일이 없습니다.](pic_coding.png) <br>

---

## 5. 블럭
### (1) 인용

```
>인용1
>> 인용2
```

> 인용1
>> 인용2

### (2) inline Block

```
'inline block'
```
`inline block`

### (3) block (2lines ↑)
`/ ~을 시작과 끝 지점에 3회씩 삽입
~~~
```
block
```
~~~

```
block
```

### (3-1) code block
```
    ``` java
    System.out.println("Hello World!);
    ```
```

``` java
    System.out.println("Hello World!");
```

---

## 6. Table

dashes line(3↑, ---)으로 Table의 header와 body를 구분.

### (1) 테이블 정렬
- 가운데 정렬 :---:
- 오른쪽 정렬 ---:
- 왼쪽 정렬 :---

```
column1 |column2    |column3
---     |:---:      |---:
val1    |val2       |val3
val4    |val5       |val6
val7    |val8       |val9
```

column1 |column2    |column3
---     |:---:      |---:
val1    |val2       |val3
val4    |val5       |val6
val7    |val8       |val9

---

## 7. 링크

### (1) 인라인 링크
특정 웹사이트와 연결을 하고자 한다면, http:// 를 붙여줘야 한다.
```
[Google](http://www.google.co.kr "구글")
```

[Google](http://www.google.co.kr "구글")


### (2) 참조링크
자주 사용하는 링크를 번호 단위로 저장하고, [링크이름] 뒤에 연결할 링크의 번호를 붙여주면 해당 번호의 링크와 연결됨.

```
[Google][1]
[Naver][2]
[Google Home][1]

[1]: http://google.com/ "구글"
[2]: http://naver.com/ "네이버"
```

[Google][1]

[Naver][2]

[Google Home][1]

[1]:http://google.com/ "구글"
[2]:http://naver.com/ "네이버"

### (3) URL 링크

```
<http://google.com>
<http://naver.com>
```

<http://google.com>

<http://naver.com>