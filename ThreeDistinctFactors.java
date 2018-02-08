/*
Given a positive integer n (1 <= n <= 10^18).
Check whether a number has exactly three distinct factors,
return true if it has exactly three distinct factors, otherwise false.

Given n = 9, return true
Number 9 has exactly three factors: 1, 3, 9, so return true.
*/
public class ThreeDistinctFactors {
    /*
     * @param n: the given number
     * @return: true if it has exactly three distinct factors, otherwise false
     */
     // hint: has to be a proper square and that sqrt has to be prime.
    public boolean isThreeDisctFactors(long n) {
        if(n == 1) return false;

        double sqrt = Math.sqrt(n);
        long sqrtLong = (long)sqrt;

        return (Math.pow(sqrtLong, 2) == n && isPrime(sqrtLong));
    }

    boolean isPrime(long n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(long i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
