import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

class FindingFirstNonRepeatedCharacter{

    private static final int EXTENDED_ASCII_CODES = 256;
    public static void main(String[] args){
        String test_str = "asdGfagsdfasdf2";
        char ans = firstNonRepeatedCharacter(test_str);
        System.out.println(ans);
        String ans1 = firstNonRepeatedCharacter_16bit(test_str);
        System.out.println(ans1);
        char ans2 = firstNonRepeatedCharacter2(test_str);
        System.out.println(ans2);
    }
    // Solution 1
    public static char firstNonRepeatedCharacter(String str){
        int[] flags = new int[EXTENDED_ASCII_CODES];
        for (int i=0; i< flags.length; i++){
            flags[i] = -1;
        }
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(flags[ch] == -1){
                flags[ch] = i;
            }else{
                flags[ch] = -2;
            }
        }
        int position = Integer.MAX_VALUE;
        for(int i =0; i< EXTENDED_ASCII_CODES; i++){
            if(flags[i] >=0){
                position = Math.min(position, flags[i]);
            }
        }
        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }
    // Solution 1-1 Functional Style 16 bit 

    public static String firstNonRepeatedCharacter_16bit(String str){
      Map<Integer, Long> chs = str.codePoints()
        .mapToObj(cp -> cp)
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
      int cp = chs.entrySet().stream()
        .filter(e -> e.getValue() == 1L)
        .findFirst()
        .map(Map.Entry::getKey)
        .orElse(Integer.valueOf(Character.MIN_VALUE));
      return String.valueOf(Character.toChars(cp));
    }

    // Solution 2
    // LinkedHashMap is insertion-order map(it maintains the order in which the keys were inserted into the map)
    static public char firstNonRepeatedCharacter2(String str){
        Map<Character, Integer> chars = new LinkedHashMap<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            chars.compute(ch, (k,v) -> (v == null)?1 : ++v);
        }
        for (Map.Entry<Character, Integer> entry: chars.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }
}