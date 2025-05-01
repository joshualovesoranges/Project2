import java.math.BigInteger;

public class StatsLibrary {

    // method to get the factorial of any number using big integer because long does not work https://www.geeksforgeeks.org/biginteger-class-in-java/
    public BigInteger getFactorial(int num){
        if (num == 0 || num == 1) {
            return BigInteger.ONE; // 0! and 1! are 1
        }

        BigInteger result = BigInteger.valueOf(num);// needs big integer value of num

        //for loop used to get the factorial
        for(int i = 2; i < num; i++){
            result = result.multiply(BigInteger.valueOf(i));//multiplies num with numbers less than itself

        }
        return result;
    }

    public double getPoissonDistribution(int lambda, int y){
        BigInteger yFactorial = getFactorial(y);//we store y factorial for later use in the formula
        double top = (Math.pow(Math.E, -lambda)) * (Math.pow(lambda, y));//the top half of the formula
        double result = top / yFactorial.doubleValue();//divide the top by the bottom

        return result;
    }

    public double getTchebysheffsThm(double k){
        //Tchebysheffs formula used
        double result = 1 - (1/Math.pow(k, 2));
        return result;
    }
}
