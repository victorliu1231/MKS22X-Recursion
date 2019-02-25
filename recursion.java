import java.util.ArrayList;

public class recursion{
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
     *fib(0) = 0; fib(1) = 1; fib(5) = 5
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
        if (index == 1){
            return fibHelp(n, 1, index+1, 1);
        }
        if (index == 0){
            return fibHelp(n, 1, index+1, 0);
        }
        return fibHelp(n, sum+last, index+1, sum); //the "sum" before this function call is now the last element of the new function call
    }


    public static ArrayList<Integer> makeAllSums(int n){
        ArrayList<Integer> L = new ArrayList<>();
        return msHelp(n, L);
    }
    public static ArrayList<Integer> msHelp(int n, ArrayList<Integer> L){
        if (n == 0){
            L.add(0);
            return L;
        } else {
            int size = L.size(); //outside variable so that the loop does NOT update L.size() while parsing
            //adds "n" to the elements in L as existed before the loop runs
            for (int i = 0; i < size; i++){
                L.add(L.get(i)+n);
            }
            L.add(n);
            return msHelp(n-1, L);
        }
    }

}
