import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.util.ArrayList;


public class SmoothData {
    XYSeries smoothData = new XYSeries("Smooth Data");
    ArrayList<Double> yValues = new ArrayList<>();
    int windowValue = 50;

    public XYSeries smoothing(XYSeries saltData){
        //get all the y values of salt data
        for (int i = 0; i < saltData.getItemCount(); i++) {
            yValues.add(saltData.getY(i).doubleValue());
        }

        for(int i = 0; i < yValues.size(); i++){
            int preCounter = 0;//counter for previous values
            int nextCounter = 0;//counter for next values
            // Using descriptive stats from apache
            DescriptiveStatistics stats = new DescriptiveStatistics(windowValue);

            //gets all the previous values based on window size
            for(int j = i-1; preCounter < windowValue && j >= 0; j--){
                stats.addValue(yValues.get(j));// Adding values using apache
                preCounter++;

            }
            //gets all the next values based on window size
            for(int t = i+1; nextCounter < windowValue && t < yValues.size(); t++){
                stats.addValue(yValues.get(t));// Adding values using apache
                nextCounter++;

            }

            double smoothedY = stats.getMean(); // Getting the mean using apache
            smoothData.add(i, smoothedY);//adds smoothed y value to my data set

        }
        XYSeriesCollection dataset = new XYSeriesCollection(smoothData);//set the series to a dataset

        // Create a xy line chart this helped: https://www.jfree.org/jfreechart/javadoc/org/jfree/chart/ChartFactory.html
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Smooth Data", // Chart title
                "X",                      // X-axis label
                "y",                   // Y-axis label
                dataset                   // The dataset containing the points to plot
        );


        ChartPanel chartPanel = new ChartPanel(chart);//Creates chart panel used this
        JFrame frame = new JFrame("Smoothing");// Creates a window for the chart
        frame.add(chartPanel);// Adds chart panel to the window
        frame.setSize(800, 600);// Set window size
        frame.setVisible(true);

        return smoothData;
    }
}




