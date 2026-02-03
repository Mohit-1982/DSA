public class HowToPrintAbrrevations {
    public static void main(String[] args) {
        abbrevations("pep","",0);
    }
    static void abbrevations(String str,String p,int count) {
        if(str.isEmpty()) {
            //Check if count is zero or not
            if(count > 0) {
                p += count;
                System.out.print(p + " ");
                return;
            }else {
                System.out.print(p + " ");
                return;
            }
        }
        char ch = str.charAt(0);
        //pick calls
        if(count > 0) {
            abbrevations(str.substring(1),p + count + ch,0);
        }else {
            abbrevations(str.substring(1),p + ch,0);
        }
        //unpick call
        abbrevations(str.substring(1),p,count + 1);
    }
}
