
import java.util.ArrayList;


public class FunctionPlotter {

    ArrayList<DataPoint> Data = new ArrayList<>();
    CSVExporter exporter = new CSVExporter();

    //using x^2 + x = y as my function to solve
    public double functionSolver(int num){
        //used formula to get my result
        double result = Math.pow(num,2) + num;

        return result;
    }

    public void plotPoints(){
        //for loop to decide how many points I want
        for(int x = 0; x <= 1000; x++){
            //calls function solver to get the point
            double y = functionSolver(x);
            //x and y are added to the data
            Data.add(new DataPoint(x,y));
        }
        //printing my points for testing purposes
        for(DataPoint xy: Data){
            System.out.println(xy);
        }
        // exports data points into csv file
        exporter.exportDataToCSV("data.csv", Data);
    }

}

