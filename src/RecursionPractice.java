import java.util.*;
public class RecursionPractice {
    static int factorial(int n){
        if(n==0) return 1;
        return n*factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n 입력: ");
        int n = sc.nextInt();
        System.out.println(n+" 팩토리얼은 "+ factorial(n)+" 입니다.");
    }
}
