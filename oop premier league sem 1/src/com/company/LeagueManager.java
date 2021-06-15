package com.company;

import java.io.IOException;
import java.util.ArrayList;

public interface LeagueManager {
    public void addSportsClub();

    public void removeSportsClub();

    public void displayStatistics();

    public void premierLeagueTable();

    public void startOfMatch();

    public ArrayList<MatchPremier> dateSearchMatch(String matchYear, String matchMonth, String matchDay);

    public void premierLeagueFW() throws IOException;

    public void premierLeagueFR() throws IOException;

    public void premierLeagueFW1() throws IOException;

    public void premierLeagueFR1() throws IOException;




}
