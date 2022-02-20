package footballTeamGenerator;

public class Player {
    private String name;
   private int endurance;
   private int sprint;
   private int dribble;
   private int passing;
   private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
       setName(name);
       setEndurance(endurance);
       setSprint(sprint);
       setDribble(dribble);
       setPassing(passing);
       setShooting(shooting);

    }

    private void setName(String name) {
        if(name==null||name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
checkAbilityRange(endurance,"Endurance");
this.endurance=endurance;
    }

    private void setSprint(int sprint) {
        checkAbilityRange(sprint,"Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        checkAbilityRange(dribble,"Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        checkAbilityRange(passing,"Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        checkAbilityRange(shooting,"Shooting");
        this.shooting = shooting;
    }

    private void checkAbilityRange(int parameter, String ability ){
        if(parameter<0||parameter>100){
            throw new IllegalArgumentException(String.format(
                    "%s should be between 0 and 100.",ability));
        }
    }

    public String getName() {
        return name;
    }

    public double overallSkillLevel(){
        return (this.sprint+this.endurance+this.dribble+this.passing+this.shooting)/5.00;
    }
}
