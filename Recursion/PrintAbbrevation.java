public class PrintAbbrevation {
    public static void main(String[] args) {
        abbreVations("pep","",0);
    }
    static void abbreVations(String str,String p,int count) {
        if(str.isEmpty()) {
            if(count == 0)
                System.out.print(p + " ");
            else
                System.out.print(p + count + " ");
            return;
        }
        //pick
        if(count > 0)
            abbreVations(str.substring(1),p + count + str.charAt(0),0);//make the count zero as we added it in the processed string
        else
            abbreVations(str.substring(1),p + str.charAt(0),0);
        //skip
        abbreVations(str.substring(1),p,count + 1);
    }
}
