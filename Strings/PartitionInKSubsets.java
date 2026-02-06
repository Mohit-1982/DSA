package BackTracking;

import java.util.ArrayList;

public class PartitionInKSubsets {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int i = 1;
        int n = 4;
        int k = 3;
        int nos = 0;//number of sets
        for(int j = 0;j < k;j++) {//first fill the lists otherwise it won't print anything
            ans.add(new ArrayList<>());
        }
        print(i,n,k,nos,ans);
    }
    static void print(int i,int n,int k,int nos,ArrayList<ArrayList<Integer>> ans) {
        if(i > n) {
            if(nos == k) {
                for(ArrayList<Integer> set : ans) {
                    System.out.print(set + " ");
                }
                System.out.println();
            }
            return;
        }
        for(int j = 0; j < ans.size(); j++) {
            if(ans.get(j).size() > 0) {
                //we are adding value in existing set
                ans.get(j).add(i);//i is the number here we are adding
                print(i + 1,n,k,nos,ans);
                ans.get(j).remove(ans.get(j).size() - 1);//backtrack
            }else {
                //we are adding value in new set
                ans.get(j).add(i);
                print(i + 1,n,k,nos + 1,ans);
                ans.get(j).remove(ans.get(j).size() - 1);//backtrack
                break;//why break here because we dont have to add on next empty sets. otherwise it will create permutations
            }
        }
    }
}
