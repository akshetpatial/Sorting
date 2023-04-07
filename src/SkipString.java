import java.util.Scanner;

public class SkipString {

    public static String StringSkip(String st, String ch){
        int start=0;
       return helperFunction(st,ch,start);
    }

    public static String helperFunction(String st, String ch, int start){
        String newString="";
        if(start>=st.length())
            // Always remember this return is for the base condition where the recursion will terminate.
            return newString;

        if(st.substring(start).startsWith(ch)) {
            start += ch.length();
        }else {
            newString += st.charAt(start);
            start++;
        }
        String prevOutput=helperFunction(st,ch,start);
        newString+=prevOutput;
        // Always remember this return is for the returning the output that is ready for the main function means our actual answer.
        return newString;
    }


    public static void main(String[] args) {
        System.out.println("Enter a String: ");
        Scanner scan = new Scanner(System.in);
        // abcdappleeabc   abcappled
        String st = scan.nextLine();

        System.out.println("Enter a Sub String you want to skip: ");
        // a
        String ch = scan.nextLine();

        // First Approach : Iterative Approach
        String first= StringSkip(st,ch);
        System.out.println("Output after skipping the Sub String "+ch +" from String "+st+" is: "+first);

    }
}
