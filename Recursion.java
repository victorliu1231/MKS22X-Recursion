public class Recursion{
    /*   
    *@param n any non-negative value you want to take the sqrt of
    *@return the approximate sqrt of n within a tolerance of 0.001%
    */
    public static double sqrt(double n){
        if (n == 0){
            return 0;
        }
        double guess = n/2;
        return sqrtHelp(n, guess);
    }

    public static double sqrtHelp(double n, double guess){
        if (n < 0){ 
            throw new IllegalArgumentException("Did you mean a positive number?");
        } else if (Math.abs((guess*guess - n) / n) <= 0.00001){ //if the guess squared has a percent error of <= 0.001% from n
            return guess;
        } else {
            return sqrtHelp(n, (n / guess + guess) / 2); //averaging out guess till it's a closer number to the actual sqrt
        }
    }

    public static void main(String[]args){
        System.out.println("sqrt(100): "+sqrt(100));
        System.out.println("sqrt(2): "+sqrt(2));
        System.out.println("sqrt(0): "+sqrt(0));
        System.out.println("sqrt(1): "+sqrt(1));
        System.out.println("sqrt(-1): "+sqrt(-1));
    }
}