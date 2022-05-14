import java.util.Arrays;

public class IntArrayContainer {
    public static int aa(int[] A) {
        int result= 0;
        for(int i=1 ; i< 100000; i++)
            if(!contains(A,i)){
                result = i;
                break;
            }

        return result;

    }

    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public static void main(String args[]){
        int[] intArray1 = new int[] {4,5,6,7,8};
        int[] intArray2 = new int[] {1,2,3,4,5,6,7,8};
        System.out.println( aa(intArray2));
    }
}
