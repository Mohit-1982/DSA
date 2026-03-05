Leetcode - 93
  class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        genIp(s, res, 0, 0, "");
        return res;
    }
    public void genIp(String str, List<String> res, int idx, int parts, String p) {
        if(idx == str.length() && parts == 4) {
            res.add(p.substring(0, p.length() - 1));
            return;
        }
        if(parts > 4) return;
        if(idx + 1 <= str.length()) genIp(str, res, idx + 1, parts + 1, p + str.substring(idx, idx + 1) + ".");
        if(idx + 2 <= str.length() && isValid(str, idx, 2)) genIp(str, res, idx + 2, parts + 1, p + str.substring(idx, idx + 2) + ".");
        if(idx + 3 <= str.length() && isValid(str, idx, 3)) genIp(str, res, idx + 3, parts + 1, p + str.substring(idx, idx + 3) + ".");
    }
    public boolean isValid(String str, int idx, int till) {
        //Trial Zero
        if(str.charAt(idx) == '0') {
            return false;
        }
        //Number in Range or not
        String checkRange = "";
        if(idx + till <= str.length()) {
            checkRange = str.substring(idx, idx + till);
            int stringToInt = 0;
            for(int i = 0; i < checkRange.length(); i++) {
                char ch = checkRange.charAt(i);
                stringToInt = stringToInt * 10 + (ch - '0');
            }
            if(stringToInt < 0 || stringToInt > 255) return false;
        }
        return true;
    }
}
