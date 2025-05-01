import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;

public class FunctionPlotter {


    //using x^2 + x = y as my function to solve
    public double functionSolver(int num){
        //used formula to get my result
        double result = Math.pow(num,2) + num;

        return result;
    }
    XYSeries data = new XYSeries("Data");// used xy series to take in two data points:  https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm

    // Generate points and plot them also returns data
    public XYSeries plotPoints() {
        for (int x = 0; x <= 1000; x++) {
            double y = functionSolver(x);
            data.add(x, y);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(data);//set it series to a dataset

        // Create a xy line chart this helped: https://www.jfree.org/jfreechart/javadoc/org/jfree/chart/ChartFactory.html
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Data", // Chart title
                "X",                      // X-axis label
                "y",                   // Y-axis label
                dataset                   // The dataset containing the points to plot
        );


        ChartPanel chartPanel = new ChartPanel(chart);//Creates chart panel used this
        JFrame frame = new JFrame("Function Plotter");// Creates a window for the chart
        frame.add(chartPanel);// Adds chart panel to the window
        frame.setSize(800, 600);// Set window size
        frame.setVisible(true);// Makes window visible

        return data;
    }
}
