import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    private List<Cyclist> list;

    public Statistics(String fileName) throws FileNotFoundException {
        this.list = new TDFFileReader(fileName).readFile();
    }

    public Set<String> getTeam(){
        Set<String> team = new HashSet<>();
        for(Cyclist info : list){
            team.addAll(Set.of(info.getTeam()));
        }
        return team;
    }

    public Map<String, Set<String>> getTeamsWithMembers(){
        Map<String, Set<String>> namesAndTeamMap = new HashMap<>();

        for(String teams : getTeam()){
            namesAndTeamMap.put(teams, new HashSet<String>());
        }

        for(Cyclist info : list){
            namesAndTeamMap.get(info.getTeam()).add(info.getName());
        }

        return namesAndTeamMap;
    }

    public Set<String> getTeamMembers(String team){
        Map<String, Set<String>> teamMem = getTeamsWithMembers();
        return teamMem.get(team);
    }
}
