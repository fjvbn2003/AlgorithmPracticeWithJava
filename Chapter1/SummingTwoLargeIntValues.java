import java.util.*;

class SummingTwoLargeIntValues { 
    public static void main(String[] args){
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int z = x+y;
        System.out.println(z); // -2 ??
    }
}