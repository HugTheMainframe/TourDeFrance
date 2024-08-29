import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TDFFileReader {
    private Scanner read;
    public TDFFileReader(String fileName) throws FileNotFoundException {
        this.read = new Scanner(new File(fileName));
    }

    public List<Cyclist> readFile(){
        ArrayList<Cyclist> listOfTour = new ArrayList<>();

        Cyclist cyclerCreation;
        while(read.hasNextLine()){
            String line = read.nextLine();
            String[] cyclerInfo = line.split(";");
            cyclerCreation = new Cyclist(cyclerInfo[1], cyclerInfo[2]);
            listOfTour.add(cyclerCreation);
        }
        read.close();
        return listOfTour;
    }
}
