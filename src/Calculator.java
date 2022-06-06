public class Calculator {
    public static void main(String[] args) {
        Calculater sum = (a,b) -> a + b;
        Calculater multiply = (a,b) -> a * b;
        calculate(5,7, sum);
        calculate(5,7, multiply);
        returnSum(10,20);
    }
    public static void calculate(int a,int b, Calculater format) {
        int result = format.run(a,b);
        System.out.println(result);
    }

    public static void returnSum(int c,int d){
        Calculater cal = (a,b) -> {
            return a+b;
        };
        System.out.println(cal.run(c,d));
    }
}

interface Calculater {
    int run(int a, int b);
}


