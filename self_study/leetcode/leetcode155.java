class MinStack {

    List<Integer> sList = null;
    int len;
    
    public MinStack() {
        sList = new ArrayList<>();    
        len = 0;
    }
    
    public void push(int x) {
        sList.add(x);
        len++;
    }
    
    public void pop() {
        sList.remove(--len);   
    }
    
    public int top() {
        return sList.get(len-1);
    }
    
    public int getMin() {
        int min = sList.get(0);
        
        for (int i = 1; i < len; i++) {
                if (sList.get(i) < min) min = sList.get(i);
        }
        return min;
    }
}
