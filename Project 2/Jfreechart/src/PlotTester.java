import org.jfree.data.xy.XYSeries;

public class PlotTester {
    public static void main(String[] args){
        FunctionPlotter dataTest = new FunctionPlotter();
        SaltData saltTester = new SaltData();
        SmoothData smoothTester = new SmoothData();

        XYSeries data = dataTest.plotPoints();
        XYSeries saltData = saltTester.salting(data);
        smoothTester.smoothing(saltData);
    }
}
