// 시간 복잡도 개선
// 또 하나의 리스트를 생성하여, stack에 저장할 때의 최소값을 저장한다.
// 최소값을 찾을 때, 검색 시간을 줄일 수 있음.
class MinStack {

    List<Integer> sList = null;
    List<Integer> minList = null;
    
    public MinStack() {
        sList = new ArrayList<>();    
        minList = new ArrayList<>();
    }
    
    public void push(int x) {
        sList.add(x);
        
        int min;
        if (sList.size() == 1) min = x;
        else {
            min = minList.get(minList.size() - 1);
            if (x < min) min = x;
        }
        minList.add(min);
    }
    
    public void pop() {
        sList.remove(sList.size()-1);
        minList.remove(minList.size()-1);
    }
    
    public int top() {
        return sList.get(sList.size()-1);
    }
    
    public int getMin() {
        return minList.get(minList.size()-1);
    }
}

