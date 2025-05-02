import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SaltData {
    ArrayList<DataPoint> saltData = new ArrayList<>();
    Random rand = new Random();
    CSVExporter exporter = new CSVExporter();

    public void salting(){
        https://www.w3schools.com/java/java_files_read.asp
        try{
            File geometricData = new File("data.csv");
            Scanner reader = new Scanner(geometricData);
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
                    double x = Double.parseDouble(myData[0]);
                    double y = Double.parseDouble(myData[1]);

                    //randomly selects number between -1.00 and 1.00
                    double salt = rand.nextDouble(-100000,100000);
                    double saltedY = y + salt;//original y value plus the randomly selected number used to salt it
                    saltData.add(new DataPoint(x, saltedY));
                }
            }

            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("The file could not be read:");
            e.printStackTrace();
        }
        // exports data points into csv file
        exporter.exportDataToCSV("salt_data2.csv", saltData);
    }
}
