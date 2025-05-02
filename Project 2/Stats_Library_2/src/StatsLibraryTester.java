public class StatsLibraryTester {
    public static void main (String[] args){
        //values for poisson and Tchebysheff's theorem
        int lambda = 1;
        int y = 0;
        double k = 2;
        //values for uniform distribution
        int a = 20;
        int b = 25;
        int c = 20;
        int d = 22;


        StatsLibrary test = new StatsLibrary();

        System.out.println("The result of the poisson distribution is: " + test.getPoissonDistribution(lambda, y));
        System.out.println("The result of the Tchebysheff's theorem  is: " + test.getTchebysheffsThm(k));
        System.out.println("The result of the uniform distribution is: " + test.getUniformDistribution(a,b,c,d));
    }
}
