package com.company;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    public static List<FootballClub> premierleagueArray = new ArrayList<FootballClub>();
    public static List<MatchPremier> leagueMatch = new ArrayList<MatchPremier>();

    //method to generate random match

    public static MatchPremier Mgenerate() {
        Random mRandom = new Random();
        int firstClubScore = mRandom.nextInt(10);
        int secondClubScore = mRandom.nextInt(10);
        int indexValueOfFirstClub = 0;
        int indexValueOfSecondClub = 0;

        while (true) {
            indexValueOfFirstClub = mRandom.nextInt(premierleagueArray.size());
            indexValueOfSecondClub = mRandom.nextInt(premierleagueArray.size());

            if (indexValueOfFirstClub != indexValueOfSecondClub) {
                break;
            }

        }
        String firstClubName = premierleagueArray.get(indexValueOfFirstClub).getClubName();
        String secondClubName = premierleagueArray.get(indexValueOfSecondClub).getClubName();
        LocalDate date = LocalDate.now();
        MatchPremier random_clubMatch = new MatchPremier(firstClubName, secondClubName, date.getYear(), date.getMonthValue(), date.getDayOfMonth(), firstClubScore, secondClubScore);
        leagueMatch.add(random_clubMatch);
        if (firstClubScore > secondClubScore) {
            for (int i = 0; i < premierleagueArray.size(); i++) {
                if (premierleagueArray.get(i).getClubName().equals(firstClubName)) {
                    premierleagueArray.get(i).setWins(premierleagueArray.get(i).getWins() + 1);
                    premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + firstClubScore);
                    premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + secondClubScore);
                    premierleagueArray.get(i).setNoOfPoints(premierleagueArray.get(i).getNoOfPoints() + 3);
                    premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);

                }


            }
        }
        if (firstClubScore == secondClubScore) {
            for (int i = 0; i < premierleagueArray.size(); i++) {
                if (premierleagueArray.get(i).getClubName().equals(firstClubName)) {
                    premierleagueArray.get(i).setDraws(premierleagueArray.get(i).getDraws() + 1);
                    premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + firstClubScore);
                    premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + secondClubScore);
                    premierleagueArray.get(i).setNoOfPoints(premierleagueArray.get(i).getNoOfPoints() + 1);
                    premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);

                }


            }


        }
        if (firstClubScore < secondClubScore) {
            for (int i = 0; i < premierleagueArray.size(); i++) {
                if (premierleagueArray.get(i).getClubName().equals(firstClubName)) {
                    premierleagueArray.get(i).setDefeats(premierleagueArray.get(i).getDefeats() + 1);
                    premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + firstClubScore);
                    premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + secondClubScore);
                    premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);
                }

            }


        }
        if (secondClubScore > firstClubScore) {
            for (int i = 0; i < premierleagueArray.size(); i++) {
                if (premierleagueArray.get(i).getClubName().equals(secondClubName)) {
                    premierleagueArray.get(i).setWins(premierleagueArray.get(i).getWins() + 1);
                    premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + secondClubScore);
                    premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + firstClubScore);
                    premierleagueArray.get(i).setNoOfPoints(premierleagueArray.get(i).getNoOfPoints() + 3);
                    premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);
                }
            }
        }
        if (secondClubScore == firstClubScore) {
            for (int i = 0; i < premierleagueArray.size(); i++) {
                if (premierleagueArray.get(i).getClubName().equals(secondClubName)) {
                    premierleagueArray.get(i).setDraws(premierleagueArray.get(i).getDraws() + 1);
                    premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + secondClubScore);
                    premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + firstClubScore);
                    premierleagueArray.get(i).setNoOfPoints(premierleagueArray.get(i).getNoOfPoints() + 1);
                    premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);
                }


            }

        }
        if (secondClubScore < firstClubScore) {
            for (int i = 0; i < premierleagueArray.size(); i++) {
                if (premierleagueArray.get(i).getClubName().equals(secondClubName)) {
                    premierleagueArray.get(i).setDefeats(premierleagueArray.get(i).getDefeats() + 1);
                    premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + secondClubScore);
                    premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + firstClubScore);
                    premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);
                }


            }

        }
        return random_clubMatch;

    }


    Scanner PL = new Scanner(System.in);



    @Override
    public void addSportsClub() {

        String clubName, clubLocation, sportManagerName;

        clubName=validStringInput("Name of club:");

        clubLocation=validStringInput("location of club:");

        sportManagerName=validStringInput("manager name:");


        FootballClub fb = new FootballClub(clubName, clubLocation, sportManagerName, 0, 0, 0, 0, 0, 0, 0);
        premierleagueArray.add(fb);
        System.out.println(premierleagueArray);


    }


    @Override
    public void removeSportsClub() {
        String removeClub=validStringInput("Enter the name of the Sports Club:");

        for (int i = 0; i < premierleagueArray.size(); i++) {
            if (premierleagueArray.get(i).getClubName().equals(removeClub)) {
                premierleagueArray.remove(i);
                System.out.println(premierleagueArray);

            }
        }

    }

    @Override
    public void displayStatistics() {
        String searchClub=validStringInput("Enter the name of the Sports Club:");




        for (int i = 0; i < premierleagueArray.size(); i++) {
            if (premierleagueArray.get(i).getClubName().equals(searchClub)) {
                System.out.println(premierleagueArray.get(i).getClubName());
                System.out.println("Wins-" + premierleagueArray.get(i).getWins());
                System.out.println("Defeats-" + premierleagueArray.get(i).getDefeats());
                System.out.println("Draws-" + premierleagueArray.get(i).getDraws());
                System.out.println("Goals Received-" + premierleagueArray.get(i).getNoOfGoalsReceived());
                System.out.println("Goals Scored-" + premierleagueArray.get(i).getNoOfGoalsScored());
                System.out.println("Number of points-" + premierleagueArray.get(i).getNoOfPoints());
                System.out.println("Number of Matches-" + premierleagueArray.get(i).getNoOfMatches());


            }


        }
    }

    @Override
    public void premierLeagueTable() {
        premierleagueArray.sort(FootballClub::compareTo);
        String leftAlignFormat = "|  %-15s  |  %-4d  | %-4d | %-4d| %-4d| %-4d | %-4d | %-4d|%-4d |%n";
        System.out.format("+-------------------+--------+------+-----+-----+------+------+-----+-----+%n");
        System.out.format("| football Club     |  M     |  W   |  D  |  L  |  GF  |  GA  | GD  | Pts |%n");
        System.out.format("+-------------------+--------+------+-----+-----+------+------+-----+-----+%n");
        for (int i = 0; i < premierleagueArray.size(); i++) {
            System.out.format(leftAlignFormat, premierleagueArray.get(i).getClubName(), premierleagueArray.get(i).getNoOfMatches(), premierleagueArray.get(i).getWins(), premierleagueArray.get(i).getDraws(), premierleagueArray.get(i).getDefeats(), premierleagueArray.get(i).getNoOfGoalsScored(), premierleagueArray.get(i).getNoOfGoalsReceived(), premierleagueArray.get(i).getNoOfGoalsScored() - premierleagueArray.get(i).getNoOfGoalsReceived(), premierleagueArray.get(i).getNoOfPoints());

        }
        System.out.format("+-------------------+--------+------+-----+-----+------+------+-----+-----+%n");


    }

    @Override
    public void startOfMatch() {
        String firstClub, secondClub, space;
        int year, month, day, firstFinal_score, secondFinal_score, c1, c2;

        c1 = 0;
        c2 = 0;

        firstClub =validStringInput("Name of first Club: \n");


        secondClub=validStringInput("Name of second Club:  \n");

        PL.nextLine();

        while (true) {

            year = validateUserInput("year of the Match:  \n");

            month = validateUserInput("month of the Match:  \n");

            day = validateUserInput("day of the Match:  \n");

            PL.nextLine();
            if (date_V(year, month, day)) {
                break;
            }
        }
        firstFinal_score=validateUserInput("Result of the first Final: \n");


        secondFinal_score=validateUserInput("Result of the second Final: \n");




        System.out.println("");
        space = PL.nextLine();


        MatchPremier shorted = new MatchPremier(firstClub, secondClub, year, month, day, firstFinal_score, secondFinal_score);
        leagueMatch.add(shorted);
        System.out.println(leagueMatch);


        for (int i = 0; i < premierleagueArray.size(); i++) {
            if (premierleagueArray.get(i).getClubName().equals(firstClub)) {
                c1 = 1;

            } else {
                System.out.println("this club is unavailable");
            }

        }
        for (int i = 0; i < premierleagueArray.size(); i++) {
            if (premierleagueArray.get(i).getClubName().equals(secondClub)) {
                c2 = 1;

            } else {
                System.out.println("this club is unavailable");
            }

        }
        if (c1 == 1 && c2 == 1) {
            if (firstFinal_score > secondFinal_score) {
                for (int i = 0; i < premierleagueArray.size(); i++) {
                    if (premierleagueArray.get(i).getClubName().equals(firstClub)) {
                        premierleagueArray.get(i).setWins(premierleagueArray.get(i).getWins() + 1);
                        premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + firstFinal_score);
                        premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + secondFinal_score);
                        premierleagueArray.get(i).setNoOfPoints(premierleagueArray.get(i).getNoOfPoints() + 3);
                        premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);

                    }


                }
            }
            if (firstFinal_score == secondFinal_score) {
                for (int i = 0; i < premierleagueArray.size(); i++) {
                    if (premierleagueArray.get(i).getClubName().equals(firstClub)) {
                        premierleagueArray.get(i).setDraws(premierleagueArray.get(i).getDraws() + 1);
                        premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + firstFinal_score);
                        premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + secondFinal_score);
                        premierleagueArray.get(i).setNoOfPoints(premierleagueArray.get(i).getNoOfPoints() + 1);
                        premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);

                    }


                }


            }
            if (firstFinal_score < secondFinal_score) {
                for (int i = 0; i < premierleagueArray.size(); i++) {
                    if (premierleagueArray.get(i).getClubName().equals(firstClub)) {
                        premierleagueArray.get(i).setDefeats(premierleagueArray.get(i).getDefeats() + 1);
                        premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + firstFinal_score);
                        premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + secondFinal_score);
                        premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);
                    }

                }


            }
            if (secondFinal_score > firstFinal_score) {
                for (int i = 0; i < premierleagueArray.size(); i++) {
                    if (premierleagueArray.get(i).getClubName().equals(secondClub)) {
                        premierleagueArray.get(i).setWins(premierleagueArray.get(i).getWins() + 1);
                        premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + secondFinal_score);
                        premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + firstFinal_score);
                        premierleagueArray.get(i).setNoOfPoints(premierleagueArray.get(i).getNoOfPoints() + 3);
                        premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);
                    }
                }
            }
            if (secondFinal_score == firstFinal_score) {
                for (int i = 0; i < premierleagueArray.size(); i++) {
                    if (premierleagueArray.get(i).getClubName().equals(secondClub)) {
                        premierleagueArray.get(i).setDraws(premierleagueArray.get(i).getDraws() + 1);
                        premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + secondFinal_score);
                        premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + firstFinal_score);
                        premierleagueArray.get(i).setNoOfPoints(premierleagueArray.get(i).getNoOfPoints() + 1);
                        premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);
                    }


                }

            }
            if (secondFinal_score < firstFinal_score) {
                for (int i = 0; i < premierleagueArray.size(); i++) {
                    if (premierleagueArray.get(i).getClubName().equals(secondClub)) {
                        premierleagueArray.get(i).setDefeats(premierleagueArray.get(i).getDefeats() + 1);
                        premierleagueArray.get(i).setNoOfGoalsScored(premierleagueArray.get(i).getNoOfGoalsScored() + secondFinal_score);
                        premierleagueArray.get(i).setNoOfGoalsReceived(premierleagueArray.get(i).getNoOfGoalsReceived() + firstFinal_score);
                        premierleagueArray.get(i).setNoOfMatches(premierleagueArray.get(i).getNoOfMatches() + 1);
                    }


                }

            }

        }

    }

    @Override
    public ArrayList<MatchPremier> dateSearchMatch(String matchYear, String matchMonth, String matchDay) {
        ArrayList<MatchPremier> findScores = new ArrayList<>();
        int matchYear_i = 0;
        int matchMonth_i = 0;
        int matchDay_i = 0;
        try {
            matchYear_i = Integer.parseInt(matchYear);
            matchMonth_i = Integer.parseInt(matchMonth);
            matchDay_i = Integer.parseInt(matchDay);
        } catch (Exception e) {
            return findScores;
        }


        for (MatchPremier match_football : leagueMatch) {
            if (match_football.getMatch_year() == (matchYear_i) && match_football.getMatch_month() == (matchMonth_i) && match_football.getMatch_day() == (matchDay_i)) {
                findScores.add(match_football);
            }
        }
        return findScores;

        // "team_1 :"+leagueMatch.get(i).getFirst_club()+"\n"+"team_1 score :"+leagueMatch.get(i).getFirst_score()+"\n"+
        //         "team_2 :"+leagueMatch.get(i).getSecond_club()+"\n"+"team_2 score :"+leagueMatch.get(i).getFirst_score();
    }


    @Override
    public void premierLeagueFW() throws IOException {
        File PL_file = new File("PL_record.txt");
        PrintWriter PL_print = new PrintWriter("PL_record.txt");
        PL_print.print("");
        FileOutputStream newPL = new FileOutputStream(PL_file, true);
        ObjectOutputStream FB_record = new ObjectOutputStream(newPL);
        Iterator iterator = premierleagueArray.iterator();
        while (iterator.hasNext()) {
            FootballClub fbObj = (FootballClub) iterator.next();
            FB_record.writeObject(fbObj);
            PL_print.close();


        }

    }


    @Override
    public void premierLeagueFR() throws IOException {
        FileInputStream plRead = new FileInputStream("PL_record.txt");
        ObjectInputStream plObj = new ObjectInputStream(plRead);
        ArrayList<FootballClub> readRecord = new ArrayList<FootballClub>();

        while (true) {
            try {
                FootballClub matchTest = (FootballClub) plObj.readObject();
                readRecord.add(matchTest);
            } catch (IOException | ClassNotFoundException e) {
                break;
            }
        }
        premierleagueArray.addAll(readRecord);

    }

    @Override
    public void premierLeagueFW1() throws IOException {
        File PL_file1 = new File("PL_record1.txt");
        PrintWriter PL_print = new PrintWriter("PL_record1.txt");
        PL_print.print("");
        FileOutputStream newPL1 = new FileOutputStream(PL_file1, true);
        ObjectOutputStream FB_record1 = new ObjectOutputStream(newPL1);
        Iterator iterator = leagueMatch.iterator();
        while (iterator.hasNext()) {
            MatchPremier matchObj = (MatchPremier) iterator.next();
            FB_record1.writeObject(matchObj);
            PL_print.close();

        }


    }

    @Override
    public void premierLeagueFR1() throws IOException {
        FileInputStream plRead1 = new FileInputStream("PL_record1.txt");
        ObjectInputStream plObj1 = new ObjectInputStream(plRead1);
        List<MatchPremier> readRecord1 = new ArrayList<MatchPremier>();

        while (true) {
            try {
                MatchPremier matchTest1 = (MatchPremier) plObj1.readObject();
                readRecord1.add(matchTest1);
            } catch (IOException | ClassNotFoundException e) {
                break;
            }
        }
        leagueMatch.addAll(readRecord1);

    }

    public boolean date_V(int matchYear, int matchMonth, int matchDay) {

        boolean leapyrs = false;

        if (matchYear % 4 == 0) {

            if (matchYear % 100 == 0) {
                leapyrs = matchYear % 400 == 0;
            } else {
                leapyrs = true;
            }
        }

        if
        (leapyrs && matchMonth == 2 && matchDay < 30) {
            return true;
        } else if (!leapyrs && matchMonth == 2 && matchDay < 29) {
            return true;
        } else if ((matchMonth == 1 || matchMonth == 3 || matchMonth == 5 || matchMonth == 7 || matchMonth == 8 || matchMonth == 10 || matchMonth == 12) && (matchDay < 32)) {
            return true;
        } else return (matchMonth == 4 || matchMonth == 6 || matchMonth == 9 || matchMonth == 11) && (matchDay < 31);

    }



    // method to validate integer input

    public int validateUserInput(String showLbl) {
        while (true) {
            System.out.print(showLbl);
            String checkInput = PL.nextLine();
            try {
                int inputValue = Integer.parseInt(checkInput);
                if (inputValue > 0) {

                    return inputValue;
                }
                System.out.println("Out of range");


            } catch (Exception e) {
                System.out.println("Invalid user input.Please Retry");
            }

        }
    }

    //method to validate string input

    public String validStringInput(String showString) {
        while (true) {
            String regex = "^[a-zA-Z]+$";
            System.out.println(showString);
            String checkString = PL.nextLine();
            if (checkString.matches(regex)) {
                return checkString;
            }
            System.out.println("Invalid String");

        }

    }

}

