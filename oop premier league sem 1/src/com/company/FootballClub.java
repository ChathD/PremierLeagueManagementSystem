package com.company;

import java.util.Objects;

public class FootballClub extends SportsClub implements Comparable <FootballClub>{
   private static final long seralVersionUID = 6433858223774886977L;

    private int wins;
    private int defeats;
    private int draws;
    private int noOfGoalsReceived;
    private int noOfGoalsScored;
    private int noOfPoints;
    private int noOfMatches;
    private int goalDifference;

    public int getGoalDifference(){
        return goalDifference=noOfGoalsScored-noOfGoalsReceived;
    }






    public FootballClub(String clubName,String location,String sportManagerName, int wins, int defeats, int draws, int noOfGoalsReceived, int noOfGoalsScored, int noOfPoints, int noOfMatches) {
        super(clubName, location, sportManagerName);
        this.wins = wins;
        this.defeats = defeats;
        this.draws = draws;
        this.noOfGoalsReceived = noOfGoalsReceived;
        this.noOfGoalsScored = noOfGoalsScored;
        this.noOfPoints = noOfPoints;
        this.noOfMatches = noOfMatches;
    }



    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getNoOfGoalsReceived() {
        return noOfGoalsReceived;
    }

    public void setNoOfGoalsReceived(int noOfGoalsReceived) {
        this.noOfGoalsReceived = noOfGoalsReceived;
    }

    public int getNoOfGoalsScored() {
        return noOfGoalsScored;
    }

    public void setNoOfGoalsScored(int noOfGoalsScored) {
        this.noOfGoalsScored = noOfGoalsScored;
    }

    public int getNoOfPoints() {
        return noOfPoints;
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    public int getNoOfMatches() {
        return noOfMatches;
    }

    public void setNoOfMatches(int noOfMatches) {
        this.noOfMatches = noOfMatches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return wins == that.wins &&
                defeats == that.defeats &&
                draws == that.draws &&
                noOfGoalsReceived == that.noOfGoalsReceived &&
                noOfGoalsScored == that.noOfGoalsScored &&
                noOfPoints == that.noOfPoints &&
                noOfMatches == that.noOfMatches;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wins, defeats, draws, noOfGoalsReceived, noOfGoalsScored, noOfPoints, noOfMatches);
    }

    @Override
    public int compareTo(FootballClub clubF){
        if(noOfPoints==clubF.noOfPoints){
            int clubGD_1=noOfGoalsScored-getDefeats();
            int clubGD_2=clubF.noOfGoalsScored-clubF.getDefeats();
            return clubGD_2-clubGD_1;
        }
        return clubF.noOfPoints-noOfPoints;

    }


}
