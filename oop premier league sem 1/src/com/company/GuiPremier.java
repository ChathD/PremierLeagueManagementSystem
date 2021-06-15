package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;

public class GuiPremier extends Application {
    public static PremierLeagueManager manageLeagueTop = new PremierLeagueManager();

    public static Comparator Goal_Sort(){
        Comparator<FootballClub> gList = new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub o1, FootballClub o2) {
                return o2.getNoOfGoalsScored()-o1.getNoOfGoalsScored();
            }
        };
        return gList;
    }

    public static Comparator Wins_Sort(){
        Comparator<FootballClub> wList = new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub o1, FootballClub o2) {
                return o2.getWins()-o1.getWins();
            }
        };
        return wList;
    }

    UserMain UM_mainUse = new UserMain();



    public static void main(String[] args) throws IOException {
        launch(args);

    }



    @Override
    public void start(Stage primaryStage) throws Exception {


        UM_mainUse.ReadPremier();

    }

    public void Secret_MinionGui() throws FileNotFoundException {
        Stage show_stage = new Stage();
        Scene scene1, scene2,scene3,scene4,scene5,scene6;



        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  scene 1

        //scene_List {


        Pane Pane__01 = new Pane();
        scene1 = new Scene(Pane__01, 650, 525);


        Pane pane__02 = new Pane();
        scene2 = new Scene(pane__02,650,650);

        Pane pane__03 = new Pane();
        scene3 = new Scene(pane__03,650,650);

        Pane pane__04 = new Pane();
        scene4 = new Scene(pane__04,650,650);

        Pane pane__05 = new Pane();
        scene5 = new Scene(pane__05,650,650);






        //            }
        Label lb_1 = new Label("Premier League");
        lb_1.setLayoutX(225);
        lb_1.setLayoutY(45);
        lb_1.setStyle("-fx-font-size:30px");


        Image Main_art = new Image("image/live.png");
        ImageView MAIN_ONE = new ImageView(Main_art);
        MAIN_ONE.setFitWidth(650);
        MAIN_ONE.setFitHeight(600);


        Button bt_1 = new Button("View Table");
        bt_1.setLayoutX(130);
        bt_1.setLayoutY(170);
        bt_1.setPrefSize(180,50);
        bt_1.setStyle("-fx-font-size:20px");


        Button bt_2 = new Button("Match Start");
        bt_2.setLayoutX(355);
        bt_2.setLayoutY(170);
        bt_2.setPrefSize(180,50);
        bt_2.setStyle("-fx-font-size:20px");
       

        Button bt_3 = new Button("previous match");
        bt_3.setLayoutX(130);
        bt_3.setLayoutY(300);
        bt_3.setPrefSize(180,50);
        bt_3.setStyle("-fx-font-size:20px");


        Button bt_4 = new Button("Quit");
        bt_4.setLayoutX(355);
        bt_4.setLayoutY(300);
        bt_4.setPrefSize(180,50);
        bt_4.setStyle("-fx-font-size:20px");
        bt_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) bt_4.getScene().getWindow();
                stage.close();
            }
        });



        Pane__01.getChildren().addAll(MAIN_ONE,bt_1,bt_2,bt_3,bt_4,lb_1);



        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  scene2

        //table

        TableView<FootballClub> tblResults = new TableView();
        tblResults.setPrefSize(510,450);
        tblResults.setLayoutX(65);
        tblResults.setLayoutY(40);
        TableColumn<FootballClub,String> tblCol = new TableColumn();
        tblCol.setMaxWidth(120);
        tblCol.setMinWidth(120);
        PropertyValueFactory colName = new PropertyValueFactory("clubName");
        tblCol.setCellValueFactory(colName);

        tblResults.getColumns().addAll(
                columnNumberString("Club Name ","clubName",150),
                columnNumberInt("MP","noOfMatches",45),
                columnNumberInt("W","wins",45),
                columnNumberInt("D","draws",45),
                columnNumberInt("L","defeats",45),
                columnNumberInt("GS","noOfGoalsScored",45),
                columnNumberInt("GA","noOfGoalsReceived",45),
                columnNumberInt("GD","goalDifference",45),
                columnNumberInt("Pts","noOfPoints",45)

        );

        for(FootballClub Iterate:manageLeagueTop.premierleagueArray){      //arraylist
            tblResults.getItems().addAll(Iterate);
        }

        Image Main_art1 = new Image("image/e3.jpg");
        ImageView MAIN_ONE1 = new ImageView(Main_art1);
        MAIN_ONE1.setFitWidth(650);
        MAIN_ONE1.setFitHeight(650);







        Button  bt_5= new Button("back");
        bt_5.setLayoutX(60);
        bt_5.setLayoutY(530);
        bt_5.setStyle("-fx-font-size:20px");
        bt_5.setPrefSize(110,50);
        bt_5.setOnAction(event -> show_stage.setScene(scene1));

        Button  bt_6= new Button("Goal");
        bt_6.setLayoutX(200);
        bt_6.setLayoutY(530);
        bt_6.setStyle("-fx-font-size:20px");
        bt_6.setPrefSize(110,50);
        bt_6.setOnAction(e -> {
            tblResults.getItems().clear();
            manageLeagueTop.premierleagueArray.sort(Goal_Sort());
            for(FootballClub Iterate:manageLeagueTop.premierleagueArray){      //arraylist
                tblResults.getItems().addAll(Iterate);
            }


        });

        Button  bt_7= new Button("Statistics");
        bt_7.setLayoutX(340);
        bt_7.setLayoutY(530);
        bt_7.setStyle("-fx-font-size:20px");
        bt_7.setPrefSize(110,50);
        bt_7.setOnAction(e -> {
            tblResults.getItems().clear();;
            manageLeagueTop.premierleagueArray.sort(FootballClub::compareTo);
            for(FootballClub Iterate:manageLeagueTop.premierleagueArray){      //arraylist
                tblResults.getItems().addAll(Iterate);
            }


        });

        Button  bt_8= new Button("Wins");
        bt_8.setLayoutX(480);
        bt_8.setLayoutY(530);
        bt_8.setStyle("-fx-font-size:20px");
        bt_8.setPrefSize(110,50);
        bt_8.setOnAction(e -> {
            tblResults.getItems().clear();
            manageLeagueTop.premierleagueArray.sort(Wins_Sort());
            for (FootballClub Iterate : manageLeagueTop.premierleagueArray) {      //arraylist
                tblResults.getItems().addAll(Iterate);
            }

        });


        pane__02.getChildren().addAll(MAIN_ONE1,bt_5,bt_6,bt_7,bt_8,tblResults);




        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>







        Pane randomMatch = new Pane();
        randomMatch.setPrefSize(300,220);
        randomMatch.setLayoutX(85);
        randomMatch.setLayoutY(165);
        randomMatch.setStyle("-fx-background-color: aqua");

        Image Main_art2 = new Image("image/maradona.png");
        ImageView MAIN_ONE2 = new ImageView(Main_art2);
        MAIN_ONE2.setFitWidth(650);
        MAIN_ONE2.setFitHeight(650);



        Label lb_2 = new Label();
        lb_2.setLayoutX(95);
        lb_2.setLayoutY(60);
        lb_2.setPrefSize(280,60);



        Label lb_3 = new Label();
        lb_3.setLayoutX(120);
        lb_3.setLayoutY(125);
        lb_3.setPrefSize(280,60);

        randomMatch.getChildren().addAll(lb_2,lb_3);

        Button bt_9 = new Button("back");
        bt_9.setLayoutX(60);
        bt_9.setLayoutY(530);
        bt_9.setStyle("-fx-font-size:20px");
        bt_9.setPrefSize(110,50);
        bt_9.setOnAction(event -> show_stage.setScene(scene1));


        Button bt_11 = new Button("Generate");
        bt_11.setLayoutX(180);
        bt_11.setLayoutY(530);
        bt_11.setStyle("-fx-font-size:20px");
        bt_11.setPrefSize(110,50);
        bt_11.setOnAction(e ->{
            MatchPremier newMatchclub = manageLeagueTop.Mgenerate();
            lb_2.setText(""+newMatchclub.getMatch_day()+"/"+newMatchclub.getMatch_month()+"/"+newMatchclub.getMatch_year());
            lb_3.setText(""+newMatchclub.getFirst_club()+"\t"+newMatchclub.first_score+"\t"+"VS"+"\t"+newMatchclub.getSecond_club()+"\t"+newMatchclub.second_score);
        } );








        pane__03.getChildren().addAll(MAIN_ONE2,bt_9,randomMatch,bt_11);

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Button bt_10 = new Button("back");
        bt_10.setLayoutX(60);
        bt_10.setLayoutY(570);
        bt_10.setStyle("-fx-font-size:20px");
        bt_10.setPrefSize(110,50);
        bt_10.setOnAction(event -> show_stage.setScene(scene1));

        Image Main_art3 = new Image("image/mosala.png");
        ImageView MAIN_ONE3 = new ImageView(Main_art3);
        MAIN_ONE3.setFitWidth(650);
        MAIN_ONE3.setFitHeight(650);



        TextField tfd_1 = new TextField();
        tfd_1.setLayoutX(300);
        tfd_1.setLayoutY(30);
        tfd_1.setPrefSize(120,15);
        tfd_1.setStyle("-fx-font-size:20px");

        TextField tfd_2 = new TextField();
        tfd_2.setLayoutX(200);
        tfd_2.setLayoutY(30);
        tfd_2.setPrefSize(80,15);
        tfd_2.setStyle("-fx-font-size:20px");

        TextField tfd_3 = new TextField();
        tfd_3.setLayoutX(100);
        tfd_3.setLayoutY(30);
        tfd_3.setPrefSize(80,15);
        tfd_3.setStyle("-fx-font-size:20px");

        Button bt_12 = new Button("search");
        bt_12.setLayoutX(440);
        bt_12.setLayoutY(30);
        bt_12.setStyle("-fx-font-size:20px");
        bt_12.setPrefSize(110,40);





        TableView<MatchPremier> tblMatch = new TableView();
        tblMatch.setPrefSize(600,450);
        tblMatch.setLayoutX(30);
        tblMatch.setLayoutY(100);
        TableColumn<MatchPremier,String> tblCol_1 = new TableColumn();
        tblCol_1.setMaxWidth(120);
        tblCol_1.setMinWidth(120);
        PropertyValueFactory colName_1 = new PropertyValueFactory("HomeClub Name");
        tblCol_1.setCellValueFactory(colName_1);

        tblMatch.getColumns().addAll(
                columnMatchString("HomeClub Name ","first_club",112),
                columnNumberString("AwayClub Name","second_club",112),
                columnNumberInt("HomeClub Goal","first_score",112),
                columnNumberInt("AwayClub Goal","second_score",112),
                columnNumberInt("Year","match_year",50),
                columnNumberInt("Month","match_month",50),
                columnNumberInt("Date","match_day",50)


        );

        for(MatchPremier Iterate_1:manageLeagueTop.leagueMatch){      //arraylist
            tblMatch.getItems().addAll(Iterate_1);
        }








        pane__04.getChildren().addAll(MAIN_ONE3,tblMatch,bt_10,tfd_1,bt_12,tfd_2,tfd_3);


        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


        Image Main_art4 = new Image("image/kevin.png");
        ImageView MAIN_ONE4 = new ImageView(Main_art4);
        MAIN_ONE4.setFitWidth(650);
        MAIN_ONE4.setFitHeight(650);

        Button bt_13 = new Button("back");
        bt_13.setLayoutX(60);
        bt_13.setLayoutY(570);
        bt_13.setStyle("-fx-font-size:20px");
        bt_13.setPrefSize(110,50);
        bt_13.setOnAction(event -> show_stage.setScene(scene1));

     //   TextArea ta_1 = new TextArea();
     //   ta_1.setLayoutX(60);
     //   ta_1.setLayoutY(50);
      //  ta_1.setPrefSize(525,400);
      //  ta_1.setStyle("-fx-font-size:20px;");

        VBox vb = new VBox();
        vb.setLayoutX(60);
        vb.setLayoutY(50);
        vb.setPrefSize(525,400);
        vb.setStyle("-fx-font-size:20px;");








        pane__05.getChildren().addAll(MAIN_ONE4,bt_13,vb);

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        bt_1.setOnAction(e->{
            show_stage.setScene(scene2);
            tblResults.getItems().clear();
            manageLeagueTop.premierleagueArray.sort(FootballClub::compareTo);

            for (FootballClub Iterate : manageLeagueTop.premierleagueArray) {      //arraylist
                tblResults.getItems().addAll(Iterate);
            }


        });

        ///////
        bt_2.setOnAction(event -> show_stage.setScene(scene3));

        //////


        bt_3.setOnAction(e->{
            show_stage.setScene(scene4);
            tblMatch.getItems().clear();
            manageLeagueTop.leagueMatch.sort(MatchPremier::compareTo);

            for(MatchPremier match:manageLeagueTop.leagueMatch){
                tblMatch.getItems().addAll(match);
            }
        });


        //////
        bt_12.setOnAction(event -> {
        vb.getChildren().clear();
                    show_stage.setScene(scene5);
                    for (MatchPremier findTheMatch : manageLeagueTop.dateSearchMatch(tfd_1.getText(), tfd_2.getText(), tfd_3.getText())) {
                        vb.getChildren().add(lblMethod(findTheMatch));
                    }


                });







        show_stage.setScene(scene1);
        show_stage.showAndWait();



    }
    public static  Label lblMethod(MatchPremier match_L){
        Label label_box = new Label(""+match_L.getFirst_club()+"\t"+match_L.getFirst_score()+"\t Vs"+"\t"+match_L.getSecond_club()+"\t"+match_L.getSecond_score());
        label_box.setPrefSize(525,60);
        return label_box;
    }
    //table 1
    public static TableColumn columnNumberString(String colTitle,String colValue,int colWidth){
        TableColumn<FootballClub,String> tblCol = new TableColumn(colTitle);
        tblCol.setMaxWidth(colWidth);
        tblCol.setMinWidth(colWidth);
        PropertyValueFactory colName = new PropertyValueFactory(colValue);
        tblCol.setCellValueFactory(colName);
        return tblCol;

    }
    public static TableColumn columnNumberInt (String colTitle,String colValue,int colWidth){
        TableColumn<FootballClub,Integer> tblCol = new TableColumn(colTitle);
        tblCol.setMaxWidth(colWidth);
        tblCol.setMinWidth(colWidth);
        PropertyValueFactory colName = new PropertyValueFactory(colValue);
        tblCol.setCellValueFactory(colName);
        return tblCol;

    }
    //table 2
    public static TableColumn columnMatchInt (String colTitle,String colValue,int colWidth){
        TableColumn<MatchPremier,Integer> tblCol = new TableColumn(colTitle);
        tblCol.setMaxWidth(colWidth);
        tblCol.setMinWidth(colWidth);
        PropertyValueFactory colName = new PropertyValueFactory(colValue);
        tblCol.setCellValueFactory(colName);
        return tblCol;

    }

    public static TableColumn columnMatchString(String colTitle,String colValue,int colWidth){
        TableColumn<MatchPremier,String> tblCol = new TableColumn(colTitle);
        tblCol.setMaxWidth(colWidth);
        tblCol.setMinWidth(colWidth);
        PropertyValueFactory colName = new PropertyValueFactory(colValue);
        tblCol.setCellValueFactory(colName);
        return tblCol;

    }
    public boolean dateValidation(int matchYear, int matchMonth, int matchDay){

        boolean leapyrs = false;
        //A leap year is exactly divisible by 4 except for century years (years ending with 00).
        // The century year is a leap year only if it is perfectly divisible by 400.
        if (matchYear % 4 == 0) {
            // if the year is century
            if (matchYear % 100 == 0) {
                leapyrs = matchYear % 400 == 0;
            }else{
                leapyrs = true;
            }
        }

        if
        (leapyrs && matchMonth==2 && matchDay<30){
            return true;
        }else if(!leapyrs && matchMonth==2 && matchDay<29){
            return true;
        }else if((matchMonth==1 ||matchMonth==3 || matchMonth==5 ||matchMonth==7 ||matchMonth==8 || matchMonth==10 ||matchMonth==12) && (matchDay<32)){
            return true;
        }else return (matchMonth == 4 || matchMonth == 6 || matchMonth == 9 || matchMonth == 11) && (matchDay < 31);

    }



}
