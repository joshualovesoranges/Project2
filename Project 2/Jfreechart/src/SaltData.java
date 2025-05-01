import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.util.Random;


public class SaltData {
    XYSeries saltData = new XYSeries("Salt Data");// used xy series to take in two data points:  https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm
    Random rand = new Random();//using the random class

    //the salting method
    public XYSeries salting(XYSeries data){
        for (int i = 0; i < data.getItemCount(); i++) {
            double x = data.getX(i).doubleValue();//gets the x values from the data
            double y = data.getY(i).doubleValue();//gets the y values from the data
            double salt = rand.nextDouble(-100000, 100000);//salting between the range -100000 to 100000
            saltData.add(x, y + salt);//adding random salt to the original y value and adding the new y to saltData
        }

        XYSeriesCollection dataset = new XYSeriesCollection(saltData);//set it series to a dataset

        // Create a xy line chart this helped: https://www.jfree.org/jfreechart/javadoc/org/jfree/chart/ChartFactory.html
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Salt Data", // Chart title
                "X",                      // X-axis label
                "y",                   // Y-axis label
                dataset                   // The dataset containing the points to plot
        );


        ChartPanel chartPanel = new ChartPanel(chart);//Creates chart panel used this
        JFrame frame = new JFrame("Salting");// Creates a window for the chart
        frame.add(chartPanel);// Adds chart panel to the window
        frame.setSize(800, 600);// Set window size
        frame.setVisible(true);// Makes window visible

        return saltData;
    }
}
