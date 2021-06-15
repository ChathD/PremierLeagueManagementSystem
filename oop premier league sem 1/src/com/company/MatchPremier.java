package com.company;

import java.io.Serializable;

public class MatchPremier implements Serializable,Comparable<MatchPremier> {
    private static final long seralVersionUID = 6433858223774886977L;
    String first_club;
    String second_club;
    int match_year;
    int match_month;
    int match_day;
    int first_score;
    int second_score;

    public MatchPremier(String first_club, String second_club, int match_year, int match_month, int match_day, int first_score, int second_score) {
        this.first_club = first_club;
        this.second_club = second_club;
        this.match_year = match_year;
        this.match_month = match_month;
        this.match_day = match_day;
        this.first_score = first_score;
        this.second_score = second_score;
    }

    public String getFirst_club() {
        return first_club;
    }

    public void setFirst_club(String first_club) {

        this.first_club = first_club;
    }

    public String getSecond_club() {
        return second_club;
    }

    public void setSecond_club(String second_club) {
        this.second_club = second_club;
    }

    public int getMatch_year() {
        return match_year;
    }

    public void setMatch_year(int match_year) {
        this.match_year = match_year;
    }

    public int getMatch_month() {
        return match_month;
    }

    public void setMatch_month(int match_month) {
        this.match_month = match_month;
    }

    public int getMatch_day() {
        return match_day;
    }

    public void setMatch_day(int match_day) {
        this.match_day = match_day;
    }

    public int getFirst_score() {
        return first_score;
    }

    public void setFirst_score(int first_score) {
        this.first_score = first_score;
    }

    public int getSecond_score() {
        return second_score;
    }

    public void setSecond_score(int second_score) {
        this.second_score = second_score;
    }

    @Override
    public int compareTo(MatchPremier o) {
        if(match_year==o.match_year){
            if(match_month==o.match_month){
                return match_day-o.match_day;
            }
            return match_month-o.match_month;
        }

        return match_year-o.match_year;

    }


}
