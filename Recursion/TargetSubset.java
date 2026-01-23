import java.util.ArrayList;

public class TargetSubset {
    public static void main(String[] args) {
        int[] arr = {10,20,30};
        System.out.println(targetSub(arr,0,60,0));
    }
    static ArrayList<String> targetSub(int[] arr,int idx,int target,int sum) {
        if(idx == arr.length) {
            if(sum == target) {
                ArrayList<String> list = new ArrayList<>();
                list.add("");
                return list;
            }else {
                return new ArrayList<>();
            }
        }
        //pick skip method
        ArrayList<String> pick = targetSub(arr,idx + 1,target,sum + arr[idx]);
        ArrayList<String> skip = targetSub(arr,idx + 1,target,sum);
        ArrayList<String> ans = new ArrayList<>();

        for(String ele : pick) {
            ans.add(arr[idx] + " " + ele);
        }
        for(String ele : skip) {
            ans.add(ele);
        }
        return ans;
    }
}
