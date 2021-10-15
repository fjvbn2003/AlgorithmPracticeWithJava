import java.util.*;
public class PrimitiveArray {
    // java는 무조건 call by value이다.
    // 그러나 포인터를 넘기기 때문에 call by reference가 가능한 것이다.
    static void multiply_two(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j]*=2;
            }
        }
        return;
    }
    static void clone_multiply_two(int[][] ar){
        int[][] arr = ar.clone();
        int row = arr.length;
        int col = arr[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j]*=2;
            }
        }
        return;
    }
    static void array_copy_multiply_two(int[][] ar){
        int row = ar.length;
        int col = ar[0].length;
        int[][] arr = new int[row][col];
        // 한 줄씩 copy해줘야함.
        // 이 부분은 확실히 c++이 편하다.


        // 이차원 배열을 복사하는 두가지 방법
        // 첫 번째 Array.copyOf
        for(int i=0; i<row; i++)
            arr[i]  = Arrays.copyOf(ar[i],col);
        // 두 번째 System.arraycopy
//        for(int i=0; i<row; i++){
//            System.arraycopy(ar[i],0, arr[i],0, col);
//        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j]*=2;
            }
        }
        System.out.println("in array_copy_multiply_two");
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        return;
    }
    public static void main(String[] args) {
        // 기본 array는 초깃값이 0으로 setting 된다.
        int[][] arr = new int[2][2];
        System.out.println("before function call");
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                arr[i][j] =1;
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        multiply_two(arr);
        System.out.println("After function call");
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        clone_multiply_two(arr);
        System.out.println("After clone function call");
        //  ? 클론함수가 안통한다. 1차원에서는 통하지만..
        // 주의 해야한다.
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        array_copy_multiply_two(arr);
        System.out.println("After arraycopy function call");
        //  ? 클론함수가 안통한다. 1차원에서는 통하지만..
        // 주의 해야한다.
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }



//        ArrayList<Integer> al = new ArrayList<>(10);
//        al.add(10);
//        al.add(2);
//
//        for(int i=0; i<al.size(); i++){
//            System.out.print(al.get(i)+" ");
//        }
        return;
    }

}
