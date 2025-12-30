GFG
  
class Solution {
    static ArrayList<Integer> snakePattern(int arr[][]) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            int m = arr[0].length-1;
            for(int j = 0;j<arr[0].length;j++){
                if(i%2==0){
                    list.add(arr[i][j]);
                }else{
                   if(m>=0) list.add(arr[i][m--]);
                }
            }
        }
        return list;
    }
}
