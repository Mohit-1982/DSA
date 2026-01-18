GFG
  Brute : O(n)
    class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length;i++) {
            if(arr[i] == x) {
                list.add(i);
            }
        }
        if(list.size() == 0) {
            list.add(-1);
            list.add(-1);
            return list;
        }else {
            int a = list.get(0);
            int b = list.get(list.size() - 1);
            list.clear();
            list.add(a);
            list.add(b);
            return list;
        }
    }
}

Optimal : O(logn)
  class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        int s = 0;
        int e = arr.length - 1;
        int check1 = -1;
        //First Ocurrance
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] == x) {
                check1 = m;
                e = m - 1;
            }else if(arr[m] > x) {
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        //Last Occurance
        s = 0;
        e = arr.length - 1;
        int check2 = -1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(arr[m] == x) {
                check2 = m;
                s = m + 1;
            }else if(arr[m] > x) {
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return new ArrayList<>(Arrays.asList(check1,check2));
    }
}
