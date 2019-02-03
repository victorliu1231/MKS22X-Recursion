public class Recursion{
    /*   
    *@param n any non-negative value you want to take the sqrt of
    *@return the approximate sqrt of n within a tolerance of 0.001%
    */
    public static double sqrt(double n, double tolerance){
        if (n == 0){
            return 0;
        }
        double guess = n/2;
        return sqrtHelp(n, guess, tolerance);
    }

    public static double sqrtHelp(double n, double guess, double tolerance){
        if (n < 0){ 
            throw new IllegalArgumentException("Did you mean a positive number?");
        } else if (Math.abs((guess*guess - n) / n) <= tolerance){ //if the guess squared has a percent error of <= 0.001% from n
            return guess;
        } else {
            return sqrtHelp(n, (n / guess + guess) / 2, tolerance); //averaging out guess till it's a closer number to the actual sqrt
        }
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    public static int fib(int n){
        if (n < 0){
            throw new IllegalArgumentException("You put in a negative number!");
        }
        return fibHelp(n, 0, 0, 0);
    }

    public static int fibHelp(int n, int sum, int index, int last){
        if (n == index){ //terminates recursive loop
            return sum;
        }
        if (index == 0){
            return fibHelp(n, 0, index+1, 0);
        }
        if (index == 1){
            return fibHelp(n, 1, index+1, 1);
        }
        return fibHelp(n, sum+last, index+1, sum); //the "sum" before this function call is now the last element of the new function call
    }

    /*As Per classwork*/
    //public static ArrayList<Integer> makeAllSums(){
        
    //}

}