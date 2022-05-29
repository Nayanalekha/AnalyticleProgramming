import java.util.Arrays;

/**
 * This class is responsible to return the minimum number of filters that a factory can use to
 * reduce the current pollution by half
 */
public class PolutionFilterCountSolution {
    public static int solution(int[] A) {
        int tagetpolu = Arrays.stream(A).sum() / 2;
        int result = 0;
        if (tagetpolu == 0) {
            return result;
        }
        reverseSortedInt(A);

        for (int i = 0; ; i++) {
            A[0] = A[0] / 2;
            int currentpolution = Arrays.stream(A).sum();
            if (currentpolution <= tagetpolu) {
                result = i + 1;
                break;
            }

            reverseSortedInt(A);
        }
        return result;
    }

    /**
     * Responsible to sort the given array in decending order
     *
     * @param array
     */
    public static void reverseSortedInt(int[] array) {
        Arrays.sort(array);
        int ono = array.length;
        for (int i = 0; i < ono / 2; i++) {
            int temp = array[i];
            array[i] = array[ono - i - 1];
            array[ono - i - 1] = temp;
        }
    }

    public static void main(String args[]) {
        int[] p = new int[]{0, 0, 0};

        System.out.println(solution(p));

    }

}
