import java.util.ArrayList;

public class FindAllIndicesMySelf {
    public static void main(String[] args) {
    int[] arr = { 3, 5, 7, 9, 7, 2, 7};
    int target = 7;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> ans = find(0,list,arr,target);
    ArrayList<Integer> ans1 = findFirst(0,list1,arr,target);
    int ans2 = findLast(0,arr,target);
        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
    }
    static ArrayList<Integer> find(int i,ArrayList<Integer> list,int[] arr,int target) {
        if(i == arr.length) {
            if(list.isEmpty()) list.add(-1);
            return list;
        }
        if(arr[i] == target) {
            list.add(i);
        }
        return find(i+1,list,arr,target);
    }

    static ArrayList<Integer> findFirst(int i,ArrayList<Integer> list,int[] arr,int target) {
        if(i == arr.length) {
            list.add(-1);
            return list;
        }
        if(arr[i] == target) {
            list.add(i);
            return list;
        }
        return findFirst(i+1,list,arr,target);
    }

    static int findLast(int i,int[] arr,int target) {
        if(i == arr.length) {
            return -1;
        }
        int lastidx = findLast(i+1,arr,target);
        if(lastidx == -1) {
            if(arr[i] == target) {
                lastidx = i;
                return lastidx;
            }else {
                return lastidx;
            }
        }else {
            return lastidx;
        }
    }
}
