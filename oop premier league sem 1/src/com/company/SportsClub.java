package com.company;

import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {
    private static final long serialVersionUID = 6433858223774886977L;

    private String clubName;
    private String location;
    private String sportManagerName;
    SportsClub(){


    }

    @Override
    public String toString() {
        return "SportsClub{" +
                "clubName='" + clubName + '\'' +
                ", location='" + location + '\'' +
                ", sportManagerName='" + sportManagerName + '\'' +
                '}';
    }

    public SportsClub(String clubName, String location, String sportManagerName) {
        super();
        this.clubName = clubName;
        this.location = location;
        this.sportManagerName = sportManagerName;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getsportManagerName() {
        return sportManagerName;
    }

    public void setsportManagerName(String sportManagerName) {
        this.sportManagerName = sportManagerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return sportManagerName == that.sportManagerName &&
                Objects.equals(clubName, that.clubName) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, location, sportManagerName);
    }

}

