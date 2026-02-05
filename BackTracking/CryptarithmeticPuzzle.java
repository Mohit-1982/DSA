package BackTracking;

import java.util.HashMap;

public class CryptarithmeticPuzzle {
    public static void main(String[] args) {
        String unique = "";
        String s1 = "send";
        String s2 = "more";
        String s3 = "money";
        HashMap<Character,Integer> characterInMap = new HashMap<>();
        for(int i = 0;i < s1.length();i++) {
            char ch = s1.charAt(i);
            if(!characterInMap.containsKey(ch)) {
                characterInMap.put(ch,-1);
                unique += ch;
            }
        }
        for(int i = 0;i < s2.length();i++) {
            char ch = s2.charAt(i);
            if(!characterInMap.containsKey(ch)) {
                characterInMap.put(ch,-1);
                unique += ch;
            }
        }
        for(int i = 0;i < s3.length();i++) {
            char ch = s3.charAt(i);
            if(!characterInMap.containsKey(ch)) {
                characterInMap.put(ch,-1);
                unique += ch;
            }
        }
        boolean[] usedNumber = new boolean[10];
        cryPrint(unique,0,characterInMap,usedNumber,s1,s2,s3);
    }
    static void cryPrint(String unique, int idx, HashMap<Character,Integer> characterInMap,boolean[] usedNumber,String s1,String s2,String s3) {
        if(idx == unique.length()) {
            int num1 = getNum(s1,characterInMap);
            int num2 = getNum(s2,characterInMap);
            int num3 = getNum(s3,characterInMap);

            if(num1 + num2 == num3) { // We found a valid answer
                for(int i = 0;i < 26;i++) {
                    char ch = (char)('a' + i);
                    if(characterInMap.containsKey(ch)) {
                        System.out.print(ch + " --> " + characterInMap.get(ch) + " ");
                    }
                }
                System.out.println();
            }
            return;
        }
        for(int i = 0;i < 10;i++) {
            char ch = unique.charAt(idx);
            if(i == 0 && (ch == s1.charAt(0) || ch == s2.charAt(0) || ch == s3.charAt(0))) {
                continue; // this is the case of leading zeroes
            }
            if(!usedNumber[i]) {
                usedNumber[i] = true;
                characterInMap.put(ch,i); // i is the number here we are assigning with the value
                cryPrint(unique,idx + 1,characterInMap,usedNumber,s1,s2,s3);
                usedNumber[i] = false; // BackTrack --> remove all the changes we have made
                characterInMap.put(ch,-1);
            }
        }
    }
    static int getNum(String str,HashMap<Character,Integer> characterInMap) {
        int sum = 0;
        int idx = 0;
        for(int i = 0;i < str.length();i++) {
            if(characterInMap.containsKey(str.charAt(i))) {
                sum = sum * 10 + characterInMap.get(str.charAt(i));
            }
        }
        return sum;
    }
}
