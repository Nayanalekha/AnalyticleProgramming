import java.util.Arrays;

public class MinimumCarsToTrip {
    public static int solution(int[] P, int[] S) {
        int result = 0;
        int noOfCars = P.length;
        int totalPeople = Arrays.stream(P).sum();
        Arrays.sort(S);
        reverseInt(S);

        int totalSeatcount = 0;
        for (int i = 0; i < noOfCars + 1; i++) {
            int currentCarseatSize = S[i];
            int tempSeatCount = totalSeatcount + currentCarseatSize;
            if (totalPeople <= tempSeatCount) {
                result = i + 1;
                break;
            } else {
                totalSeatcount = tempSeatCount;
            }
        }
        return result;


    }

    public static void reverseInt(int[] array) {
        int ono = array.length;
        for (int i = 0; i < ono / 2; i++) {
            int temp = array[i];
            array[i] = array[ono - i - 1];
            array[ono - i - 1] = temp;
        }
    }

    public static void main(String args[]) {
        int[] p = new int[]{1, 4, 1};
        int[] s = new int[]{1, 5, 1};
        System.out.println(solution(p, s));

    }

}
