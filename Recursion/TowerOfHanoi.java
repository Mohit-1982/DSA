Tower Of Hanoi 

intution : Moving first n - 1 disks from source to helepr such that we will move the biggest disk to the destination
toh(n-1,src,dest,hel);
now if we somehow move the n - 1 disks to the destination we will solve this problem so for that 
we will move n - 1 disks to the destination
toh(n-1,hel,src,dest);

GFG TC : O(2^n)
class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        return toh(n,from,to,aux);
    }
    public int toh(int n,int src,int hel,int dest) {
        if(n == 0) return 0;
        int left = toh(n-1,src,dest,hel);
        int current = 1;
        int right = toh(n-1,hel,src,dest);
        return left + current + right;
    }
}

static void toh(int n, int src, int hlp, int dest) {
        if(n == 1) {
            count++;
            System.out.println("Move Disk " + n + " From " + src + " --> " + dest);
            return;
        }
        toh(n - 1,src,dest,hlp);
        System.out.println("Move Disk " + n + " From " + src + " --> " + dest);
        count++;
        toh(n - 1,hlp,src,dest);
    }
