package com.company;

import java.util.Objects;

public class UniversityFootballClub extends FootballClub {
    private String universityName;
    private String universityCoachName;




    public UniversityFootballClub(String clubName,String location,String sportManagerName, int wins, int defeats, int draws, int noOfGoalsReceived, int noOfGoalsScored, int noOfPoints, int noOfMatches,String universityName, String coachName) {
        super(clubName,location,sportManagerName,wins,defeats, draws, noOfGoalsReceived, noOfGoalsScored, noOfPoints, noOfMatches);
        this.universityName = universityName;
        this.universityCoachName = coachName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCoachName() {
        return universityCoachName;
    }

    public void setCoachName(String coachName) {
        this.universityCoachName = coachName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return Objects.equals(universityName, that.universityName) &&
                Objects.equals(universityCoachName, that.universityCoachName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), universityName, universityCoachName);
    }

}
