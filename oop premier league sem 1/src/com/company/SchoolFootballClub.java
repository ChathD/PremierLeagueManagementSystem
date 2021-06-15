package com.company;

import java.util.Objects;

public class SchoolFootballClub extends FootballClub {
    private String schoolName;
    private String schoolCoachName;




    public SchoolFootballClub(String clubName,String location,String sportManagerName, int wins, int defeats, int draws, int noOfGoalsReceived, int noOfGoalsScored, int noOfPoints, int noOfMatches,String schoolName, String coachName ) {
        super(clubName,location,sportManagerName,wins,defeats, draws, noOfGoalsReceived, noOfGoalsScored, noOfPoints, noOfMatches);
        this.schoolName = schoolName;
        this.schoolCoachName = coachName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCoachName() {
        return schoolCoachName;
    }

    public void setCoachName(String coachName) {
        this.schoolCoachName = coachName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchoolFootballClub that = (SchoolFootballClub) o;
        return Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(schoolCoachName, that.schoolCoachName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolName, schoolCoachName);
    }
}
