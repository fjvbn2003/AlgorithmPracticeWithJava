import java.util.*;
class CountingVowelsAndConsonant{
    public static void main(String[] args){

        Pair<Integer, Integer> ans = countVowelsAnsConsonants("asdfasdfbadfbasdfasdfbzlop");
        System.out.println(ans.vowels+" "+ans.consonants);
    }

    public static final Set<Character> allVowels = new HashSet(Arrays.asList('a','e','i','o','u'));
    public static Pair<Integer, Integer> countVowelsAnsConsonants(String str){
        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(allVowels.contains(ch)){
                vowels++;
            }else if((ch >='a' && ch <='z')){
                consonants++;
            }
        }
        return Pair.of(vowels, consonants);
    }
}