import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TDFFileReaderTest {
    String filePath = "tdffinishers2024.csv";
    @Test
    void readFile() throws FileNotFoundException {
        //Arrange
        TDFFileReader read = new TDFFileReader(filePath);
        List<Cyclist> actualList = read.readFile();


        //Act
        Cyclist actualValue = actualList.get(0);

        //Assert
        Cyclist expectedValue = new Cyclist("TADEJ POGAČAR", "UAE TEAM EMIRATES");
        Assertions.assertEquals(expectedValue.toString(), actualValue.toString());
    }
}