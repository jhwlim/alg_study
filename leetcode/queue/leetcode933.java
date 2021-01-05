// Difficulty : easy
class RecentCounter {
    
    int now;
    int startRange;
    Queue<Integer> q = null;
    
    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        q.add(t);
        
        now = t;
        startRange = now - 3000;
        
        while(q.peek() < startRange) {
            q.poll();
        }
        
        return q.size();
    }
}