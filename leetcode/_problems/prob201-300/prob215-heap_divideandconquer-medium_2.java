/*
    - Runtime : 2ms, Memory : 39.3MB 
*/
class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        int[] maxHeap = new int[nums.length+2];    
        
        for (int i = 0; i < nums.length; i++) {
            insertElement(maxHeap, i, nums[i]);
        }
            
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = removeElement(maxHeap, nums.length-i);
        }
        
        return result;
    }
    
    private void insertElement(int[] maxHeap, int currentSize, int element) {
        if (currentSize == 0) {
            maxHeap[1] = element;
            return;
        }
        
        int index = currentSize + 1;
        maxHeap[index] = element;
        
        while (index > 1) {
            int parentIndex = index / 2;
        
            if (maxHeap[index] > maxHeap[parentIndex]) {
                swap(maxHeap, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }
    
    private int removeElement(int[] maxHeap, int currentSize) {
        int result = maxHeap[1];
        
        int index = 1;
        maxHeap[index] = maxHeap[currentSize];
        
        while (true) {
            int leftIndex = index * 2;
            int rightIndex = index * 2 + 1;
            
            if (rightIndex < currentSize) {
                if (maxHeap[leftIndex] > maxHeap[rightIndex]) {
                    if (maxHeap[leftIndex] > maxHeap[index]) {
                        swap(maxHeap, leftIndex, index);
                        index = leftIndex;
                    } else {
                        break;
                    }
                } else {
                    if (maxHeap[rightIndex] > maxHeap[index]) {
                        swap(maxHeap, rightIndex, index);
                        index = rightIndex;
                    } else {
                        break;
                    }
                }
            } else if (leftIndex < currentSize) {
                if (maxHeap[leftIndex] > maxHeap[index]) {
                    swap(maxHeap, leftIndex, index);
                    index = leftIndex;
                } else {
                    break;
                }
            } else {
                break;
            }
            
        }
        
        return result;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}