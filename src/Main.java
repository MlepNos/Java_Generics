
interface Editor{
    String name();
}
interface Player{}
record BaseballPlayer(String name,String position)implements Player{}
record FootballPlayer(String name,String position)implements Player{}
record VolleyballPlayer(String name,String position)implements Editor{}
public class Main {


    public static void main(String[] args) {
       BaseballTeam philles1 = new BaseballTeam("Philles");
       BaseballTeam astros1 = new BaseballTeam("Astros");
       ScoreResult(philles1,2,astros1,1);

       SportsTeam philles2 = new SportsTeam("Philles");
       SportsTeam astros2 = new SportsTeam("Astros");
       ScoreResult(philles2,2,astros2,1);

       var james = new BaseballPlayer("James","Right Fielder");
       var harden = new BaseballPlayer("Harden","Left Fielder");
       philles1.AddTeamMember(james);
       philles1.AddTeamMember(harden);
       philles1.ListTeamMembers();

       SportsTeam Milan1 = new SportsTeam("Milan");
       var Ibrahimovic1 = new FootballPlayer("Ibra","Striker");
       var Ronaldinho1 = new FootballPlayer("Ronaldinho","\tAttacking midfielder, winger");
       Milan1.AddTeamMember(Ibrahimovic1);
       Milan1.AddTeamMember(Ronaldinho1);


       var guthrie1 = new BaseballPlayer("Guthrie","Center");
       Milan1.AddTeamMember(guthrie1);

       Milan1.ListTeamMembers();
       System.out.println("-".repeat(35));
       //We have a problem here
       //We can add a Baseball player to a football team

        Team<BaseballPlayer> philles = new Team<>("Philles");
        Team<BaseballPlayer> astros = new Team<>("Astros");
        ScoreResult(philles,2,astros,1);
        var guthrie = new BaseballPlayer("Guthrie","Center");
        philles.AddTeamMember(guthrie);
        philles.ListTeamMembers();
        System.out.println("-".repeat(35));


        Team<FootballPlayer> Milan = new Team<>("Milan");
        var Ibrahimovic = new FootballPlayer("Ibra","Striker");
        var Ronaldinho = new FootballPlayer("Ronaldinho","\tAttacking midfielder, winger");
        Milan.AddTeamMember(Ibrahimovic);
        Milan.AddTeamMember(Ronaldinho);
//      Milan.AddTeamMember(guthrie);
        Milan.ListTeamMembers();

        System.out.println("-".repeat(35));

        Team<String> adelaide = new Team<>("Adelaide");
        adelaide.AddTeamMember("Roberts");
        adelaide.ListTeamMembers();

        Team<String> canberra = new Team<>("Canberra");
        canberra.AddTeamMember("Barton");
        canberra.ListTeamMembers();
        ScoreResult(adelaide,0,canberra,3);
        System.out.println("-".repeat(35));
//      Team<int> melbourne = new Team<>("Melbourne");  Generics cant use Primitive data types as arguments

        //we set an upper bound to the member generic with <T extentds Member>.it will only work with Editor types
        //Member<Integer> melbourne = new Member<>("Melbourne");
        //VolleyballPlayer is a Editor type
        Member<VolleyballPlayer> melbourne = new Member<>("Melbourne");
        var Arnold = new VolleyballPlayer("Arnold","A");
        var Buttosi = new VolleyballPlayer("Buttosi","B");
        melbourne.AddTeamMember(Arnold);
        melbourne.AddTeamMember(Buttosi);
        melbourne.ListTeamMembers();

        System.out.println("-".repeat(35));

        var Philly = new Affiliation("City","Philadelphia","US");
        Part<VolleyballPlayer,Affiliation> PP = new Part<>("Philadelphia Phillies",Philly);
        var Arnold2 = new VolleyballPlayer("Arnold","A");
        var Buttosi2 = new VolleyballPlayer("Buttosi","B");
        PP.AddTeamMember(Arnold2);
        PP.AddTeamMember(Buttosi2);
        PP.ListTeamMembers();
        //We can pass also other types to the second parameter like Strings , <first,second> because we did not set any boundries
    }

    public static void ScoreResult(BaseballTeam team1, int t1_score,BaseballTeam team2, int t2_score){
        String message = team1.SetScore(t1_score,t2_score);
        team2.SetScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }

    public static void ScoreResult(SportsTeam team1, int t1_score,SportsTeam team2, int t2_score){
        String message = team1.SetScore(t1_score,t2_score);
        team2.SetScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }

    public static void ScoreResult(Team team1, int t1_score,Team team2, int t2_score){
        String message = team1.SetScore(t1_score,t2_score);
        team2.SetScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }
}