import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarParkFeeCalculator {
    public static long solution(String E, String L) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        int diffmin = 0;
        try {
            // Parsing the Time Period
            Date date1 = simpleDateFormat.parse(E);
            Date date2 = simpleDateFormat.parse(L);

            // Calculating the difference in milliseconds
            int differenceInMilliSeconds
                    = (int) Math.abs(date2.getTime() - date1.getTime());
            diffmin = differenceInMilliSeconds / 60000;
            System.out.println("diff in min" + diffmin);
            System.out.println("diff in hrs" + diffmin / 60);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return calculateFee(diffmin);
    }

    /**
     * Responsible to calculate the fee for the given time duration in mins
     *
     * @param diffmin
     * @return
     */
    private static long calculateFee(int diffmin) {
        long result = 2;
        if (diffmin < 60) {
            result = result + 3;
        } else {
            result = result + 3;
            int hrs = (diffmin - 60) / 60;
            int remainder = (diffmin - 60) % 60;
            if (remainder == 0) {
                result = result + (hrs * 4);
            } else {
                result = result + ((hrs + 1) * 4);
            }
        }
        System.out.println("Fee" + result);
        return result;
    }

    public static void main(String args[]) {

        solution("09:42", "11:42");

    }

}
