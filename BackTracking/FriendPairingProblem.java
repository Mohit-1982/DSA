GFG
class Solution {
    public long countFriendsPairings(int n) {
        boolean[] used = new boolean[n + 1];
        String p = "";
        int[] count = new int[1];
        frnd(used,p,1,count,n);
        return (long)count[0];
        //No need of string in this question just doing so that i can do the print ans also
    }
    public void frnd(boolean[] used,String p,int i,int[] count,int n) {
        if(i > n) {
            count[0]++;
            return;
        }
        if(used[i] == true) {
            frnd(used,p,i + 1,count,n);
        }else {
            used[i] = true;
            frnd(used,p + i,i + 1,count,n);
            for(int j = i + 1;j <=n;j++) {//start form next number of i because we have used i earlier
                if(used[j] == false) {
                used[j] = true;
                frnd(used,p + i + "," + j,i + 1,count,n);
                used[j] = false;
                }
            }
            used[i] = false;
        }
    }
}
