
import java.util.LinkedList;

public class JoshuaSimpleHashmap {
    static LinkedList<String>[] data;
    int size = 7; // Initial array size
    int elementCount = 0; // Tracks the number of stored elements
    static final double maxInput = 0.75; // Resize when 75% full
    int resizeCount = 0;

    // Initialize the array with LinkedLists
    public void initialize() {
        data = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            data[i] = new LinkedList<>();
        }
    }

    //takes a string and maps it to the number of letters in the string
    public int simpleHash(String str){
        // Computes the hash of the string and maps it to the range [0, size-1].
        return Math.abs(str.hashCode()) % size;
    }



    //adds a string to the data structure
    public void add(String str){
        //check if the there no more room in the array if so resizes the array
        if ((double) elementCount / size > maxInput) {
            resize();  //resize the array to handle more elements
            elementCount = 0;  //reset element count after resize
        }

        //calculate the index for the string using a hash function
        int index = simpleHash(str);
        data[index].add(str);  //add the string to the corresponding LinkedList
        elementCount++;  //increment the element count
    }

    //resizes the array
    public void resize(){
        // Double the size of the array
        int newSize = size * 2;
        LinkedList<String>[] newData = new LinkedList[newSize];

        // Initialize the new array with empty LinkedLists
        for(int i = 0; i < newSize; i++){
            newData[i] = new LinkedList<String>();
        }

        //Transfer elements from the old array to the new array
        for(int i = 0; i < size; i++) {
            //Iterate through each LinkedList in the old array
            for (String str : data[i]) {
                //Calculate the new index for each element in the resized array
                int newIndex = Math.abs(str.hashCode()) % newSize;

                //Add the element to the appropriate LinkedList in the new array
                newData[newIndex].add(str);
            }
        }
        //updates the data,size of the array and resizeCounter
        data = newData;
        size = newSize;
        resizeCount++;
    }
}
