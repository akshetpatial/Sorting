import java.util.Scanner;

public class SkipCharacter {
    
    public static String SkipCharacter_1(String st, char ch){
        int start= 0;
        int end= st.length()-1;

        StringBuilder answer = new StringBuilder();

        while(start<=end){
            if(st.charAt(start)!=ch)
                answer.append(st.charAt(start));
            start++;
        }
        return answer.toString();
    }

    public static String SkipCharacter_2(String st, char ch) {
        int start= 0;
        int end= st.length()-1;
        return helperFunction(st,ch,start,end);
    }

    public static String helperFunction(String st, char ch, int start, int end) {

        StringBuilder answer = new StringBuilder();
        if(start>end)
            return answer.toString();

        if(st.charAt(start)!=ch)
            answer.append(st.charAt(start));

        String output= helperFunction(st,ch,start+1,end);
        // Here again we want to append the char after every recursive call as we are making a new object answer.
        answer.append(output);

        return answer.toString();
    }

    public static String SkipCharacter_3(String st, char ch) {
        int start= 0;
        int end= st.length()-1;
        StringBuilder string = new StringBuilder();
        string.append(st);
        return helperFunction_3(string,ch,start,end);
    }

    public static String helperFunction_3(StringBuilder st, char ch, int start, int end) {

        if(start>end)
            return st.toString();

        if(st.charAt(start)==ch) {
            st.deleteCharAt(start);
            end--;
        }

        return helperFunction_3(st,ch,start+1,end);
    }

    public static void main(String[] args) {
        System.out.println("Enter a String: ");
        Scanner scan = new Scanner(System.in);
        // abcdeabc
        String st = scan.nextLine();

        System.out.println("Enter a character you want to skip: ");
        // a
        char ch = scan.nextLine().charAt(0);

        // First Approach : Iterative Approach
        String first= SkipCharacter_1(st,ch);
        System.out.println("Output after skipping the character "+ch +" from String "+st+" is: "+first);

        // Second Approach : Recursive Approach
        String second= SkipCharacter_2(st,ch);
        System.out.println("Output after skipping the character "+ch +" from String "+st+" is: "+second);

        // Third Approach : Recursive Approach converting the String into String builder
        String third= SkipCharacter_3(st,ch);
        System.out.println("Output after skipping the character "+ch +" from String "+st+" is: "+third);

    }
}
