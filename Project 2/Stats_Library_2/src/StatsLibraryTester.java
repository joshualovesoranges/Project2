public class StatsLibraryTester {
    public static void main (String[] args){
        int lambda = 1;
        int y = 0;
        double k = 2;

        StatsLibrary test = new StatsLibrary();

        System.out.println("The result of the poisson distribution is: " + test.getPoissonDistribution(lambda, y));
        System.out.println("The result of the Tchebysheff's theorem  is: " + test.getTchebysheffsThm(k));
    }
}
