package Chapter1;
import java.util.*;
import java.util.stream.Collectors;
class CountingDuplicateCharacters{

    public static void main(String[] args){
        String sample_str = "dfasdf3#afsdfa32R@12(*Jdads";
        Map<Character, Integer> result = countDuplicateCharacters(sample_str);
        for( Character charKey : result.keySet() ){
	        Integer integerValue = result.get(charKey);
	        System.out.println( charKey +":"+ integerValue );
        }
        System.out.println("\n");
        Map<Character, Long> result2 = countDuplicateCharacters2(sample_str);
        for( Character charKey : result2.keySet() ){
	        Long integerValue = result2.get(charKey);
	        System.out.println( charKey +":"+ integerValue );
        }
    }
    // Solution 1
    public static Map<Character, Integer> countDuplicateCharacters(String str){
        Map<Character, Integer> result = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            result.compute(ch, (k,v) -> (v==null)? 1 : ++v);
        }
        return result;
    }
    // Solution 2
    public static Map <Character, Long>  countDuplicateCharacters2(String str){
        Map<Character, Long> result  = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;
    }
}