import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import java.util.regex.Pattern;
class ReversingLettersAndWords{
    private static final String WHITESPACE = " ";
    private static final Pattern PATTERN = Pattern.compile(" +");
    public static void main(String[] args){
        String test_str = "hi, my name is youngjukim!";
        String ans = reverseWords(test_str);
        System.out.println(ans);
        String ans2 = reverseWords_functional(test_str);
        System.out.println(ans2);
        return;
    }
    // Solution1 
    public static String reverseWords(String str){
        String [] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word : words){
            StringBuilder reversedWord = new StringBuilder();
            for(int i= word.length()-1; i>=0; i--){
                reversedWord.append(word.charAt(i));
            }
            reversedString.append(reversedWord).append(WHITESPACE);
        }
        return reversedString.toString();
    }
    // Solution2
    // JAVA 8 Functional Style
    public static String reverseWords_functional(String str){
        String [] words = str.split(WHITESPACE);
        return PATTERN.splitAsStream(str)
            .map(w -> new StringBuilder(w).reverse())
            .collect(Collectors.joining(" "));
    }
    
}