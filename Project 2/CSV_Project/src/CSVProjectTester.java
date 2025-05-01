public class CSVProjectTester {
    public static void main(String[] args){
        FunctionPlotter Test = new FunctionPlotter();
        SaltData saltTester = new SaltData();
        SmoothData smoothTester = new SmoothData();

        Test.plotPoints();
        saltTester.salting();
        smoothTester.smoothing();

    }
}
