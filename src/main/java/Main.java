import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "tdffinishers2024.csv";
        TDFFileReader reader = new TDFFileReader(fileName);
        Statistics readList = new Statistics(fileName);

        System.out.println(reader.readFile());
        System.out.println(readList.getTeam());
        System.out.println(readList.getTeamsWithMembers());
        System.out.println(readList.getTeamMembers("BAHRAIN VICTORIOUS"));
    }
}
