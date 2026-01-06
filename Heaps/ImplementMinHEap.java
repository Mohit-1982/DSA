package Heaps;

import java.util.Arrays;

class Heap{
    int[] arr;
    int idx = 1;
    Heap(int capacity) {
        arr = new int[capacity+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
    }
    int remove() {
        if(idx == 1) {
            System.out.println("heap is empty");
            return -1;
        }
        int min = arr[1];
        arr[1] = arr[idx-1];
        idx--;
        int root = 1;
        while(root <= size()) {
            int left = 2*root , right = 2*root + 1;
            int leftVal = (left<=size()) ? arr[left] : Integer.MAX_VALUE;
            int rightVal = (right<=size()) ? arr[right] : Integer.MAX_VALUE;
            if(arr[root] < leftVal && arr[root] < rightVal) break;
            else {
                if(leftVal < rightVal) { //left child ko swap karna h
                    int temp = arr[root];
                    arr[root] = arr[left];
                    arr[left] = temp;
                    root = left;
                }else { //right child ko swap krna h
                    int temp = arr[root];
                    arr[root] = arr[right];
                    arr[right] = temp;
                    root = right;
                }
            }
        }
        return min;
    }
    void add(int val) {
        if(size()==arr.length) {
            System.out.println("Head is full");
            return;
        }
        arr[idx++] = val;
        int root = idx-1;
        while(root != 1) {
            if(arr[root] > arr[root/2]) break;
            else {
                int temp = arr[root];
                arr[root] = arr[root/2];
                arr[root/2] = temp;
                root /= 2;
            }
        }
    }
    void display() {
        if(size() == 0) {
            System.out.println("Heap is Empty");
            return;
        }
        for(int i = 1;i<idx;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    void peek() {
        if(size() == 0) {
            System.out.println("Heap is Empty!");
            return;
        }
        System.out.println(arr[1]);
    }
    int size() {
        return idx-1;
    }
}
public class ImplementHeap {
    public static void main(String[] args) {
        Heap h = new Heap(10);
        h.add(10); h.add(20); h.size(); h.peek(); h.add(2);
        h.display(); h.remove(); h.remove();
        h.display();
    }
}
