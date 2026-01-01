public class RemoveChFromString {
    public static void main(String[] args) {
        String ans = remove("baccad","",'a');
        System.out.println(ans);
    }
    static String remove(String p,String up,char remove){
        if(p.isEmpty()) return up;
        char ch = p.charAt(0);
        if(ch == remove) return remove(p.substring(1),up,remove);
        else return remove(p.substring(1),up+ch,remove); //if we do something like ch + up then it will add opposite directions we can check pallindrome via this
        //if we have given only the p string then we have to do ch + remove(p.substring(1));
        // and return "" if(p.isEmpty());
     }
}
