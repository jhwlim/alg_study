import java.util.*;

// 탐욕법 > 섬 연결하기
class Solution {
    public int solution(int n, int[][] costs) {
        
        // 1. 간선들의 가중치에 따라 오름차순으로 정렬하기
        Arrays.sort(costs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});        
        
        List<Set<Integer>> lands = new ArrayList<>(); 
        int sum = 0;
        
        // 2. 정렬된 간선들을 순서대로 사이클을 형성하지 않는 간선을 선택
        for(int i = 0; i < costs.length; i++) {
            int land1 = costs[i][0];
            int land2 = costs[i][1];
            int cost = costs[i][2];
            
            int j = 0;
            int idxOfSet = -1;
            
            // 사이클을 형성하는지 확인
            for (; j < lands.size(); j++) {
                Set<Integer> set = lands.get(j);
                boolean flag1 = set.contains(land1);
                boolean flag2 = set.contains(land2);
                
                if (flag1 && flag2) { // 하나의 집합에 모두 포함된 경우(사이클 형성)
                    break;
                } else if (!flag1 && !flag2) {
                    continue;
                } else {
                    if (idxOfSet == -1) {
                        idxOfSet = j;
                    } else { // 두 정점이 모두 다른 집합에 속해 있는 경우
                        sum += cost;
            
                        lands.get(idxOfSet).addAll(set);
                        lands.remove(j--);
                        break;
                    }
                }
            }
            
            if (j == lands.size()) {
                sum += cost;
    
                if (idxOfSet == -1) { // 두 정점이 어느 집합에도 속하지 않은 경우
                    Set<Integer> set = new HashSet<>();
                    set.add(land1);
                    set.add(land2);
                    lands.add(set);
                } else { // 하나의 정점이 집합에 속해 있는 경우
                    lands.get(idxOfSet).add(land1);
                    lands.get(idxOfSet).add(land2);
                }
            }
            
            if (lands.get(0).size() == n) { // 하나의 집합에 모든 정점이 포함되는 경우 종료
                break;
            }
        }
        
        return sum;
    }
    
    
}