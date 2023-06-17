import java.util.ArrayList;
import java.util.List;

record Affiliation(String name,String type, String countryCode){

    @Override
    public String toString() {
        return name + "( " + type + " in "+ countryCode + " )";
    }
}

public class Part<T extends Editor,S>{
    private String memberName;
    private List<T> Members = new ArrayList<>();
    private int totalWins =0 ;
    private int totalLosses =0 ;
    private int totalTies =0 ;

    private S affilation;

    public Part(String teamName) {
        this.memberName = teamName;
    }

    public Part(String memberName, S affilation) {
        this.memberName = memberName;
        this.affilation = affilation;
    }

    public void AddTeamMember(T t){
        if(!Members.contains(t)){
            Members.add(t);
        }
    }

    public void ListTeamMembers(){
        System.out.print(memberName);
        System.out.println((affilation==null)? "" : ": AFFILIATION: " + affilation);
        for (T t: Members){
            System.out.println(t.name());
        }

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
        return memberName +  "(Ranked " + Ranking() + ")";
    }


}
