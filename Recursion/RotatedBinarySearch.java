Using Recursion.

  public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        int ans = rotatedBS(0,arr.length-1,2,arr);
        System.out.println(ans);
    }
    static int rotatedBS(int s,int e,int key,int[] arr){
        if(s>e){
            return -1;
        }
        int m = s+(e-s)/2;
        if(arr[m] == key) return m;
        //this condition is used to check the first half is sorted or not 
        if(arr[s] <= arr[m]){
            if(key >= arr[s] && key <= arr[m]) return rotatedBS(s,m-1,key,arr);
            else return rotatedBS(m+1,e,key,arr);
        }
        if(key>=arr[m] && key <= arr[e]) return rotatedBS(m+1,e,key,arr);
        else return rotatedBS(s,m-1,key,arr);
    }
}
