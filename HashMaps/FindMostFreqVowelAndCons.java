Leetcode - 3541
  Brute : 
    class Solution {
    public int maxFreqSum(String s) {
        int res = 0;
        int vowFreq = 0;
        int consFreq = 0;
        int n = s.length();
        HashMap<Character, Integer> vow = new HashMap<>();
        HashMap<Character, Integer> con = new HashMap<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(isVowel(ch)) {
                if(vow.containsKey(ch)) {
                    int freq = vow.get(ch);
                    vow.put(ch, freq + 1);
                    vowFreq = Math.max(vowFreq, vow.get(ch));
                }else {
                    vow.put(ch, 1);
                    vowFreq = Math.max(vowFreq, vow.get(ch));
                }
            }else {
                if(con.containsKey(ch)) {
                    int freq = con.get(ch);
                    con.put(ch, freq + 1);
                    consFreq = Math.max(consFreq, con.get(ch));
                }else {
                    con.put(ch, 1);
                    consFreq = Math.max(consFreq, con.get(ch));
                }
            }
        }

        return vowFreq + consFreq;
    }

    public boolean isVowel(char ch) {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
            return false;
    }
}

Optimal : 
  class Solution {
    public int maxFreqSum(String s) {
        int n = s.length();
        int[] arr = new int[26];

        for(int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int vowFreq = 0;
        int consFreq = 0;

        for(int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if(isVowel(ch)) {
                vowFreq = Math.max(vowFreq, arr[i]);
            }else {
                consFreq = Math.max(consFreq, arr[i]);
            }
        }

        return vowFreq + consFreq;
    }

    public boolean isVowel(char ch) {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
            return false;
    }
}
