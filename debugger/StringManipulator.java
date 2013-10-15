import java.util.*;
/**
 * This program reads in an entire line from the user
 * Counts and displays the number of vowels
 * Prints the entire line backwards
 * Replaces every letter 's' with the character '5' and displays the new line
 * 
 * @author csc142
 */
public class StringManipulator
{

    /**
     * Constructor for objects of class StringManipulator
     */
    public static void main(String[] args) {
        String input;
        
        Scanner inStream = new Scanner(System.in);
        System.out.println("Enter a line of text");
        System.out.print("> ");
        input = inStream.nextLine();
        
        int count = countVowels(input);
        String reverse = reverseString(input);
        String replace = replaceString(input, "s", "5");
        
        System.out.println("The number of vowels = " + count);
        System.out.println("The line in reverse: " + reverse);
        System.out.println("Every s replaced by 5: " +  replace);
        System.out.println("Good-bye");
    }

    private static int countVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i)) )
                count++;
        }
        return count;
    }
    
    private static boolean isVowel(char ch) {
	  boolean result;
        switch (ch) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                result = true;
                
            default:
                result = false;
        }
	  return result;
    }
    
    private static String reverseString(String src){
        String dest = "";
        for (int i = src.length()-1; i >0 ; i--)
            dest = dest + src.charAt(i);
        return dest;
    }
    
    private static String replaceString(String src, String a, String b){
        String result = src.replace(b, a );
        return result;
    }
}
