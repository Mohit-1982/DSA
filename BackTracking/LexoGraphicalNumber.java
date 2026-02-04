Leetcode - 386
class Solution {
    public List<Integer> lexicalOrder(int n) {
        //both loops will run till 9 because we can't create any digit other than 1 to 9
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i <= 9;i++) {
            addList(i,n,list);//this will print the whole family of 1 till n
        }
        return list;
    }
    public void addList(int n,int ori,List<Integer> list) {
        if(n > ori) {//check the number we have created is it bigger then the range
            return;
        }
        list.add(n);//first add then print family of this number 
        for(int i = 0;i <= 9;i++) {
            addList(n * 10 + i,ori,list);
        }
    }
}
