import java.util.*;

// 힙 > 더 맵게
class Solution {
    public int solution(int[] scoville, int K) {
        int[] heap = new int[scoville.length + 2];
        for (int i = 0; i < scoville.length; i++) {
            insertElement(heap, i, scoville[i]);    
        }
        
        int count = 0;
        int currentSize = scoville.length;
        while (true) {
            int food1 = deleteElement(heap, currentSize--);
            if (food1 >= K) {
                return count; 
            }
            if (currentSize == 0) {
                break;
            }
            
            int food2 = deleteElement(heap, currentSize--);
            insertElement(heap, currentSize++, food1 + food2 * 2);
            
            count++;
        
        }
        
        return -1;
    }
    
    private void insertElement(int[] heap, int currentSize, int element) {
        if (currentSize == 0) {
            heap[1] = element;
            return;
        }
        
        int index = currentSize + 1;
        heap[index] = element;
        while (index > 1) {
            int parent = index / 2;
            
            if (heap[index] < heap[parent]) {
                swap(heap, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }
    
    private int deleteElement(int[] heap, int currentSize) {
        int result = heap[1];
        
        int index = 1;
        heap[index] = heap[currentSize];
        
        while (index < currentSize) {
            int leftChild = index * 2;
            int rightChild = index * 2 + 1;
            
            if (rightChild < currentSize) {
                if (heap[leftChild] < heap[rightChild]) {
                    if (heap[leftChild] < heap[index]) {
                        swap(heap, index, leftChild);
                        index = leftChild;
                        continue;
                    }    
                } else {
                    if (heap[rightChild] < heap[index]) {
                        swap(heap, index, rightChild);
                        index = rightChild;
                        continue;
                    }
                }
                
            } else if (leftChild < currentSize) {
                if (heap[leftChild] < heap[index]) {
                    swap(heap, index, leftChild);
                    index = leftChild;
                    continue;
                }
            }
            
            break;
        }
        
        return result;
    }
    
    private void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
}