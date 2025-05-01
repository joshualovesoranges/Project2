import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SmoothData {
    ArrayList<DataPoint> smoothData = new ArrayList<>();//stores smoothed data
    ArrayList<Double> xValues = new ArrayList<>();
    ArrayList<Double> yValues = new ArrayList<>();
    Random rand = new Random();
    CSVExporter exporter = new CSVExporter();
    int windowValue = 50;

    public void smoothing(){
        //https://www.w3schools.com/java/java_files_read.asp
        try{
            File saltData = new File("salt_data2.csv");
            Scanner reader = new Scanner(saltData);
            //skips first line because it is just x and y and we only want the data.
            if(reader.hasNextLine()){
                reader.nextLine();
            }
            while(reader.hasNextLine()){
                //reads each line and splits the line into 2 parts
                String line = reader.nextLine();
                String[] myData = line.split(",");

                if(myData.length == 2){
                    //stores my data into x and y values
                    xValues.add(Double.parseDouble(myData[0]));
                    yValues.add(Double.parseDouble(myData[1]));

                }
            }

            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("The file could not be read:");
            e.printStackTrace();
        }

        //this is where the smoothing starts
        for(int i = 0; i < yValues.size(); i++){
            int preCounter = 0;//counter for previous values
            int nextCounter = 0;//counter for next values
            double preValues = 0;//Holds the sum of all previous values for a given y
            double nextValues = 0;// holds the sum of all the next values for a given y
            double y = yValues.get(i);

            //gets all the previous values based on window size
            for(int j = i-1; preCounter < windowValue && j >= 0; j--){
                preValues += yValues.get(j);
                preCounter++;

            }

            for(int t = i+1; nextCounter < windowValue && t < yValues.size(); t++){
                nextValues += yValues.get(t);
                nextCounter++;

            }

            double smoothedY = (nextValues + preValues) / (nextCounter + preCounter); //averages the values to get smoothed value
            smoothData.add(new DataPoint(xValues.get(i), smoothedY));//adds smoothed y value to my data set

        }

        // exports data points into csv file
        exporter.exportDataToCSV("smooth_data2.csv", smoothData);
    }
}
