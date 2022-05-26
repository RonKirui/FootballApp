/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballapp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ron TheChosen
 */
public class JavaFxHelperClass extends Application {
    
    public static String team_name, team_coach, team_captain, team_stadium, 
            team_city, home_team, away_team, hhscore,aascore;
    public static TextArea view;
    @Override
    public void start(Stage primaryStage) {
        Text title = new Text();
        title.setText("Football Application");
        title.setFill(Color.RED);
        title.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, FontPosture.REGULAR, 40));
        title.setX(200);
        title.setY(30);
        
        Text textName = new Text();
        textName.setText("Team's Name");
        textName.setFill(Color.RED);
        textName.setX(30);
        textName.setY(70);
        
        TextField fieldName = new TextField();
        fieldName.setLayoutX(30);
        fieldName.setLayoutY(75);
        fieldName.setFocusTraversable(false);
        
        Text textCouch = new Text();
        textCouch.setText("Coach's Name");
        textCouch.setFill(Color.RED);
        textCouch.setX(30);
        textCouch.setY(110);
        
        TextField fieldCouch = new TextField();
        fieldCouch.setLayoutX(30);
        fieldCouch.setLayoutY(115);
        fieldCouch.setFocusTraversable(false);
        
        Text textCaptain = new Text();
        textCaptain.setText("Captain's Name");
        textCaptain.setFill(Color.RED);
        textCaptain.setX(30);
        textCaptain.setY(150);
        
        TextField fieldCaptain = new TextField();
        fieldCaptain.setLayoutX(30);
        fieldCaptain.setLayoutY(155);
        fieldCaptain.setFocusTraversable(false);
        
        Text textStadium = new Text();
        textStadium.setText("Team's Stadium");
        textStadium.setFill(Color.RED);
        textStadium.setX(30);
        textStadium.setY(190);
        
        TextField fieldStadium = new TextField();
        fieldStadium.setLayoutX(30);
        fieldStadium.setLayoutY(195);
        fieldStadium.setFocusTraversable(false);
        
        Text textCity = new Text();
        textCity.setText("Team's City");
        textCity.setFill(Color.RED);
        textCity.setX(30);
        textCity.setY(230);
        
        TextField fieldCity = new TextField();
        fieldCity.setLayoutX(30);
        fieldCity.setLayoutY(235);
        fieldCity.setFocusTraversable(false);
        
        view = new TextArea();
        view.setLayoutX(200);
        view.setLayoutY(80);
        view.setEditable(false);
        Button registerTeams = new Button();
        registerTeams.setLayoutX(60);
        registerTeams.setLayoutY(320);
        registerTeams.setText("Register Team"); 
        
        Button listTeams = new Button();
        listTeams.setLayoutX(230);
        listTeams.setLayoutY(320);
        listTeams.setText("League's Teams");
        
        Button gameResults = new Button();
        gameResults.setLayoutX(400);
        gameResults.setLayoutY(320);
        gameResults.setText("Game Results");
        
        Button leagueStandings = new Button();
        leagueStandings.setLayoutX(550);
        leagueStandings.setLayoutY(320);
        leagueStandings.setText("Table's Standings");
        
        Button recordScores = new Button();
        recordScores.setLayoutX(730);
        recordScores.setLayoutY(320);
        recordScores.setText("Record Scores");
        
        Button exit = new Button();
        exit.setLayoutX(780);
        exit.setLayoutY(380);
        exit.setText("Quit");
        
        //Record Scores
        Text textHome = new Text();
        textHome.setText("Home Team");
        textHome.setFill(Color.RED);
        textHome.setX(700);
        textHome.setY(70);
        
        TextField fieldHome = new TextField();
        fieldHome.setLayoutX(700);
        fieldHome.setLayoutY(75);
        fieldHome.setFocusTraversable(false);
        
        Text textAway = new Text();
        textAway.setText("VS");
        textAway.setFill(Color.RED);
        textAway.setX(700);
        textAway.setY(120);
        
        TextField fieldAway = new TextField();
        fieldAway.setLayoutX(700);
        fieldAway.setLayoutY(135);
        fieldAway.setFocusTraversable(false);
        
        Text textHscore = new Text();
        textHscore.setText("Home Score");
        textHscore.setFill(Color.RED);
        textHscore.setX(700);
        textHscore.setY(190);
        
        TextField fieldHscore = new TextField();
        fieldHscore.setLayoutX(700);
        fieldHscore.setLayoutY(195);
        fieldHscore.setFocusTraversable(false);
        
        Text textAscore = new Text();
        textAscore.setText("Away Score");
        textAscore.setFill(Color.RED);
        textAscore.setX(700);
        textAscore.setY(230);
        
        TextField fieldAscore = new TextField();
        fieldAscore.setLayoutX(700);
        fieldAscore.setLayoutY(235);
        fieldAscore.setFocusTraversable(false);
        
        
        registerTeams.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                team_name = fieldName.getText().trim();
                team_coach = fieldCouch.getText().trim();
                team_captain = fieldCaptain.getText().trim();
                team_stadium = fieldStadium.getText().trim();
                team_city = fieldCity.getText().trim();
                //Call register teams method
                appMainMenu.regTeams();
                
            }
        });
        listTeams.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                appMainMenu.leagueTeams();
            }
        });
        gameResults.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                appMainMenu.gamResults();
            }
        });
        leagueStandings.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    appMainMenu.standTable();
                } catch (IOException ex) {
                    Logger.getLogger(JavaFxHelperClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        recordScores.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                home_team = fieldHome.getText().trim();
                away_team = fieldAway.getText().trim();
                hhscore = fieldHscore.getText().trim();
                aascore = fieldAscore.getText().trim();
                try {
                    appMainMenu.recScores();
                } catch (IOException ex) {
                    Logger.getLogger(JavaFxHelperClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        
        Group root = new Group();
        //StackPane root = new StackPane();
        root.getChildren().add(title);
        root.getChildren().add(textName);
        root.getChildren().add(fieldName);
        root.getChildren().add(textCouch);
        root.getChildren().add(fieldCouch);
        root.getChildren().add(textCaptain);
        root.getChildren().add(fieldCaptain);
        root.getChildren().add(textStadium);
        root.getChildren().add(fieldStadium);
        root.getChildren().add(textCity);
        root.getChildren().add(fieldCity);
        root.getChildren().add(view);
        root.getChildren().add(listTeams);
        root.getChildren().add(registerTeams);
        root.getChildren().add(gameResults);
        root.getChildren().add(leagueStandings);
        root.getChildren().add(recordScores);
        root.getChildren().add(exit);
        
        root.getChildren().add(textHome);
        root.getChildren().add(fieldHome);
         root.getChildren().add(textAway);
        root.getChildren().add(fieldAway);
        root.getChildren().add(textHscore);
        root.getChildren().add(fieldHscore);
        root.getChildren().add(textAscore);
        root.getChildren().add(fieldAscore);
        Scene scene = new Scene(root, 880, 400,Color.WHITE);
        
        Stage stage = new Stage();
        
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Football App");
        stage.show();
        
        exit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
