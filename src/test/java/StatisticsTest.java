import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {
    private String filePath = "tdffinishers2024.csv";
    @Test
    void testGetTeam() throws FileNotFoundException {
        //Arrange
        Statistics list = new Statistics(filePath);
        Set<String> expectedList = new HashSet<>();
        expectedList.add("TEAM VISMA | LEASE A BIKE");
        expectedList.add("ISRAEL - PREMIER TECH");
        expectedList.add("LIDL-TREK");

        //Act
        Set<String> actualList = list.getTeam();
        int actualSize = actualList.size();

        //Assert
        int expectSize = 22;

        Assertions.assertEquals(expectSize, actualSize);
        Assertions.assertTrue(actualList.containsAll(expectedList));
    }

    @Test
    void testGetTeamWithMembers()throws FileNotFoundException{
        //Arrange
        Statistics list = new Statistics(filePath);
        Map<String, Set<String>> expectedMap = new HashMap<>();
        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("JONAS VINGEGAARD HANSEN");
        expectedSet.add("JAN TRATNIK, BART LEMMEN");
        expectedSet.add("MATTEO JORGENSON");
        expectedSet.add("CHRISTOPHE LAPORTE");
        expectedSet.add("WILCO KELDERMAN");
        expectedSet.add("TIESJ BENOOT");
        expectedSet.add("WOUT VAN AERT");

        expectedMap.put("TEAM VISMA | LEASE A BIKE", expectedSet);

        //Act
        Map<String, Set<String>> actualMap = list.getTeamsWithMembers();
        int actualSize = actualMap.get("TEAM VISMA | LEASE A BIKE").size();

        Map<String, Set<String>> actualMapToUse = new HashMap<>();
        for(Map.Entry<String, Set<String>> entry : actualMap.entrySet()){
            if(entry.getKey().equals("TEAM VISMA | LEASE A BIKE")){
                actualMapToUse.put(entry.getKey(), entry.getValue());
            }
        }

        //Assert
        int expectedSize = 8;

        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedMap.toString(), actualMapToUse.toString());
    }

    @Test
    void testGetTeamMembers()throws FileNotFoundException{
        //Arrange
        Statistics list = new Statistics(filePath);
        Set<String> expectedTeam = new HashSet<>();
        expectedTeam.add("MIKEL LANDA MEANA");
        expectedTeam.add("ILAN VAN WILDER");
        expectedTeam.add("YVES LAMPAERT");
        expectedTeam.add("JAN HIRT");
        expectedTeam.add("GIANNI MOSCON");
        expectedTeam.add("REMCO EVENEPOEL");

        list.getTeamMembers("SOUDAL QUICK-STEP");

        //Act
        Set<String> actualTeam = list.getTeamMembers("SOUDAL QUICK-STEP");

        //Assert
        int expectedValue = 6;

        Assertions.assertEquals(expectedValue, actualTeam.size());
        Assertions.assertEquals(expectedTeam.toString(), actualTeam.toString());
    }
}