class Solution {
    static int setBit(int n) {
        return n | (n+1);
    }
    static int setBitApproach2(int n) {
        for(int i = 0;i<31;i++) {
            if((n>>i) % 2 == 0){//this bit is 0 we have to set it
                return n | (1 << i);
            }
        }
        return 403802;
    }
}
