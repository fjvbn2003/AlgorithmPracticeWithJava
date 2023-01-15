package Chapter1;
import java.util.*;


class CheckingContainesOnlyDigits{

    public static void main(String[] args){

        boolean ans = containsOnlyDigits("3123213");
        System.out.println(ans);
        boolean ans2 = containsOnlyDigits("31afsd23213");
        System.out.println(ans2);
        boolean ans3 = containsOnlyDigits_functional("3123213");
        System.out.println(ans);
        boolean ans4 = containsOnlyDigits_functional("31afsd23213");
        System.out.println(ans2);
        boolean ans5 = containsOnlyDigits_regular_expression("3123213");
        System.out.println(ans);
        boolean ans6 = containsOnlyDigits_regular_expression("31afsd23213");
        System.out.println(ans2);
        return;
    }
    // Solution 1
    // if speed is a requirement, below is better then Solution 2.
    public static boolean containsOnlyDigits(String str){
        for (int i=0; i<str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    // Solution 2
    // JAVA 8 functional
    public static boolean containsOnlyDigits_functional(String str){
        return !str.chars()
            .anyMatch(n-> !Character.isDigit(n));
    }
    // Solution 3
    // Using string match (regular expression)
    public static boolean containsOnlyDigits_regular_expression(String str){
       return str.matches("[0-9]+");
    }
}