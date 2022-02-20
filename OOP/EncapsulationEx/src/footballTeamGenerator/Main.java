package footballTeamGenerator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        Map<String,Team> teams=new LinkedHashMap<>();


        String line = scann.nextLine();
        while(!line.equals("END")){

            String[] input=line.split(";");
            String command=input[0];
            String teamName=input[1];

            try {


                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.putIfAbsent(teamName, team);
                        break;
                    case "Add":



                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            String playerName = input[2];
                            int endurance = Integer.parseInt(input[3]);
                            int sprint = Integer.parseInt(input[4]);
                            int dribble = Integer.parseInt(input[5]);
                            int passing = Integer.parseInt(input[6]);
                            int shooting = Integer.parseInt(input[7]);
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teams.get(teamName).addPlayer(player);
                        }


                        break;
                    case "Remove":
                        String playerToRemove = input[2];
                        teams.get(teamName).removePlayer(playerToRemove);
                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            System.out.printf("%s - %d%n", teamName, Math.round(teams.get(teamName).getRating()));
                        }
                        break;
                }
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }


            line = scann.nextLine();
        }
    }
}
