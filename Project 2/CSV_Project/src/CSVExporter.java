import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    // Method to write data to a text file in CSV format googled https://www.w3schools.com/java/java_files_create.asp
    public void exportDataToCSV(String fileName, List<DataPoint> data) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Write the header
            writer.write("x,y");
            writer.write(System.getProperty("line.separator"));//separates line googled https://stackoverflow.com/questions/18549704/create-a-new-line-in-javas-filewriter

            // Write the data points
            for (DataPoint point : data) {
                writer.write(String.format("%.1f,%.5f", point.x, point.y));
                writer.write(System.getProperty("line.separator"));
            }

            System.out.println("Data written to " + fileName);
        } catch (IOException e) {
            System.out.println("Unable to export data to file:");
            e.printStackTrace();
        }
    }
}
