public class DataPoint {
    double x;
    double y;
    //constructor for my data points
    public DataPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    // have the out put not displayed as a String https://stackoverflow.com/questions/10734106/how-to-override-tostring-properly-in-java
    public String toString() {
        return "x: " + x + ", y: " + y;
    }
}
