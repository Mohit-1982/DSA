public class Union {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2};
        List<Integer> list = unionArray(nums1,nums2);
        for(int ele : list) System.out.print(ele + " ");
    }
    static List<Integer> unionArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i != n && j != m) {
            if(nums1[i] < nums2[j]) {
                if(list.isEmpty() || list.get(list.size()-1) != nums1[i]) list.add(nums1[i]);
                i++;
            }else if (nums1[i] > nums2[j]) {
                if(list.isEmpty() || list.get(list.size()-1) != nums2[j]) list.add(nums2[j]);
                j++;
            }else {
                if(list.isEmpty() || list.get(list.size()-1) != nums1[i]) list.add(nums1[i]);
                i++;
                j++;
            }
        }
        if(i == n) {
            while(j != m) {
                if(list.isEmpty() || list.get(list.size()-1) != nums2[j]) list.add(nums2[j]);
                j++;
            }
        }else {
            while(i != n) {
                if(list.isEmpty() || list.get(list.size()-1) != nums1[i]) list.add(nums1[i]);
                i++;
            }
        }
        return list;
    }
}
