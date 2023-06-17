import java.util.ArrayList;
import java.util.List;

public class SportsTeam {

    private String teamName;
    private List<Player> teamMembers = new ArrayList<>();
    private int totalWins =0 ;
    private int totalLosses =0 ;
    private int totalTies =0 ;

    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }

    public void AddTeamMember(Player player){
        if(!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }

    public void ListTeamMembers(){
       System.out.println(teamName);
       System.out.println(teamMembers);
    }

    public int Ranking(){
        return (totalLosses * 2) + totalTies + 1;
    }

    public String SetScore(int ourScore,int theirScore){
        String message = "Lost to";
        if(ourScore>theirScore){
            totalWins++;
            message = "beat";
        } else if (ourScore==theirScore) {
            totalTies++;
            message="tied";
        }else{
            totalLosses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName +  "(Ranked " + Ranking() + ")";
    }
}
