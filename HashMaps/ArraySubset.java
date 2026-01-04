
class Solution {
    public boolean isSubset(int a[], int b[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<a.length;i++) {
            if(map.containsKey(a[i])) {
                int freq = map.get(a[i]);
                map.put(a[i],freq+1);
            }else map.put(a[i],1);
        }
        
        for(int i = 0;i<b.length;i++) {
            if(map.containsKey(b[i])) {
                int freq = map.get(b[i]);
                if(freq <= 0) return false;
                map.put(b[i],freq-1);
            }else return false;
        }
        return true;
    }
}
