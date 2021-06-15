package com.company;

import java.io.IOException;
import java.util.Scanner;

public class UserMain {
    public static PremierLeagueManager manageLeagueTop = new PremierLeagueManager();

    public void ReadPremier() {

        GuiPremier gui_rr= new GuiPremier();
        try {
            manageLeagueTop.premierLeagueFR();
        } catch (IOException var) {
            var.printStackTrace();
        }

        try {

            manageLeagueTop.premierLeagueFR1();
        } catch (IOException var1) {
            var1.printStackTrace();
        }


        int input;

        while (true) {

            try {


                Scanner sc = new Scanner(System.in);

                System.out.println("\n");
                System.out.println("  <<<Premier league>>>\n");


                System.out.println(" 1 - add  club:\n");
                System.out.println(" 2 - remove club: \n");
                System.out.println(" 3 - display a club: \n");
                System.out.println(" 4 - view premier league table: \n");
                System.out.println(" 5 - start match: \n");
                System.out.println(" 6 - Enter to open user interface : \n");
                System.out.println(" 7 - Write in file: \n");

                System.out.print("Enter a number : ");

                input = sc.nextInt();


                if (input == 1) {
                    manageLeagueTop.addSportsClub();
                } else if (input == 2) {
                    manageLeagueTop.removeSportsClub();

                } else if (input == 3) {
                    manageLeagueTop.displayStatistics();
                } else if (input == 4) {
                    manageLeagueTop.premierLeagueTable();
                } else if (input == 5) {
                    manageLeagueTop.startOfMatch();

                }else if (input == 6) {
                    gui_rr.Secret_MinionGui();
                }

                else if (input == 7) {
                    manageLeagueTop.premierLeagueFW();
                    manageLeagueTop.premierLeagueFW1();
                    System.exit(0);
                } else {
                    System.out.println("invalid input range");
                }
            }
            catch (Exception var2){
                System.out.println("invalid input");
            }


        }

    }
}
