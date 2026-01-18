GFG
  Brute : O(n * m) 
  intution {
    1.Generated the Hashcode of pattern string
      2.Run a loop from 0 to subtract of text string length to pattern string length
        3.In this loop i have calculated the hashcode till i to pattern length + i
          4.After that i check the hashcode of txt with this pattern hashcode
            5.If they are same go for verfication like check all characters are same or not
              6.If same add in the list Else check for next set of characters.
  }
class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = contains(txt,pat,26);
        return ans;
    }
    ArrayList<Integer> contains(String text,String pttrn,int times) {
        long code = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < pttrn.length(); i++) {
            code += ((long) pttrn.charAt(i)) * times;
        }
        long HashCode = 0;
        for(int i = 0; i < text.length() - pttrn.length() + 1;i++) {
            HashCode = 0;
            for(int j = i;j < pttrn.length() + i;j++) {
                HashCode += ((long) text.charAt(j)) * times;
            }
            if(HashCode == code) {
                int loopTill = pttrn.length() + i;
                int x = 0;
                for (int j = i; j < loopTill; j++) {
                    if (text.charAt(j) != pttrn.charAt(x++)) {
                        break;
                    }
                    if(j == loopTill - 1) {
                        list.add(i);
                    }
                }
            }
        }
        return list;
    }
}


Optimal : Karp Rabin Algorithm
  TC : 1.Average Case : O(N + M)
       2.Worst Case : O(N * M) Because of Collisions.
