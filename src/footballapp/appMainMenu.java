

package footballapp;

import static footballapp.JavaFxHelperClass.aascore;
import static footballapp.JavaFxHelperClass.away_team;
import static footballapp.JavaFxHelperClass.home_team;
import static footballapp.JavaFxHelperClass.hhscore;
import static footballapp.JavaFxHelperClass.team_captain;
import static footballapp.JavaFxHelperClass.team_city;
import static footballapp.JavaFxHelperClass.team_coach;
import static footballapp.JavaFxHelperClass.team_name;
import static footballapp.JavaFxHelperClass.team_stadium;
import static footballapp.JavaFxHelperClass.view;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

interface Function{
    String content(int position, String team, int points);
}

public class appMainMenu {

    //Variables
    private static Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    private static Hashtable<String, String> stan = new Hashtable<String, String>();
    private static Hashtable<String, String> tble = new Hashtable<String, String>();
    static String strng;
    static int integer1, hscore, ascore;
    static boolean checkTeam;
    //Arraylist to hold contents read
    static ArrayList<String> contents = new ArrayList<>();
    
    
    public static void main(String[] args) throws IOException {
        //Main method
        //System.out.println("    FOOTBALL APPLICATION  \n\n");
        //System Menu
        //menu();
        JavaFxHelperClass.main(args);
        
    }
    public static void menu() throws IOException {
        
        System.out.println("        MENU        ");
        System.out.println("1. Register Teams");
        System.out.println("2. List league teams");
        System.out.println("3. Record games' scores");
        System.out.println("4. List game results");
        System.out.println("5. Display standings' table");
        System.out.println("6. Quit\n");
        //select menu using switch
        menuSwitch();
       
    }
    public static void menuSwitch() throws IOException {
        //check value integer
        checker();
     
        //switch integer
        switch(integer1){
            case 1: 
                //Register teams
                System.out.println("    REGISTER TEAMS");
                System.out.println();
                regTeams();
                //Change menu / exit
                menuExitContinue();
                break;   
            case 2:
                //List league teams
                System.out.println("    LEAGUE TEAMS");
                System.out.println();
                leagueTeams();
                //Change menu / exit
                menuExitContinue();
                break;
            case 3:
                //Record scores
                System.out.println("    RECORD SCORES");
                System.out.println();
                recScores();
                //Change menu / exit
                menuExitContinue();
                break;
            case 4:
                //List game results
                System.out.println("    GAMES' RESULTS");
                System.out.println();
                gamResults();
                //Change menu / exit
                menuExitContinue();
                break;
            case 5:
                //Display Standings' table
                System.out.println("    STANDINGS' TABLE");
                System.out.println();
                standTable();
                //Change menu / exit
                menuExitContinue();
                
                break;
            case 6:
                //End program
                System.out.println("    FOOTBALL APPLICATION EXITED");
                System.out.println();
                break;
            default:
                //Throw error
                System.out.println("Select correct menu");
                System.out.println();
                //return to main menu
                menu();
        }
     
    }    
        
    public static void leagueTeams() {
        helperMethod("Teams & Details.txt");
        view.clear();
        view.setText("              LEAGUE TEAMS\n\nName\tCouch\tCaptain\tStadium\tCity\n"+strng);
        //System.out.println("Name\tCouch\tCaptain\tStadium\tCity");
        //System.out.println(strng);
      
    }
     
    public static void gamResults() {
   
        helperMethod("Games Results.txt");
        view.clear();
        view.setText("              GAMES' RESULTS\n\n"+strng);
        //System.out.println(strng);
    
    }

    public static void standTable() throws IOException {
   
            //STANDINGS' TABLE
                    
        standTableHashing();
        sortValue(table,table.size());
    
    }
    public static void checker()throws IOException{
        try {
            Scanner scn = new Scanner(System.in);    
            integer1 = scn.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid integer. Enter again.");
            checker();
        }
    }
    public static void helperMethod(String file_name){
        try(
                FileReader file = new FileReader(file_name);
                BufferedReader stream = new BufferedReader(file);){
            strng = new String();
                
            //Declare variables
            int chara; // variable to hold unicode int of character
            char cast; // variable to hold casted character      
            //Initialize the variables
            chara = stream.read(); // reading first character
            cast = (char) chara; // type cast from integer to character
            
            while( chara != -1)//The file is not empty
            {
                strng = strng + cast;
                chara = stream.read(); // read next char
                cast = (char) chara;
            }
            strng = strng + "\n";
        }
        catch(Exception e)//Nothing read
        {
            
        }
        
    }

    private static void standTableHashing() {
    
         try{
             //read the records initially stored
            helperMethod("Standings.txt");
            String tableString = strng.replace("{", "");
            tableString = tableString.replace("}", "");
            table.clear();
            //string to hashtable
            String [] hashString = tableString.trim().split(",");
             for (String hashString1 : hashString) {
                 String [] key_value = hashString1.trim().split("=");
                 table.putIfAbsent(key_value[0], Integer.parseInt(key_value[1]));
             }
        }
        catch(Exception e){
            
        }
        
    
    }
    
        
    public static void sortValue(Hashtable <String, Integer> t, int count){
        //Variables
        int values[] = new int[count];
        int i=0,pos=1;
        
        
        for (String ss: t.keySet()){
            values[i]=t.get(ss);
            i++;
        }
        ArrayList<String> list = new ArrayList<>();
        //view.clear();
        Arrays.sort(values);
        outer:for (int j=values.length-1;j>=0;j--){
        while(pos<table.size()+1){
            for(String ss: t.keySet()){
                if(t.get(ss)==values[j]){
                    
                    Function info = (posi, team, points)->{
                     
                        String full_cont = posi+"\t"+team+ "\t\t\t" +points+"\n";
                        return full_cont;
                    };
                    String row = info.content(pos, ss.trim(), values[j]);
                    
                    list.add(row);
                    //System.out.println(pos+"\t"+ss.trim()+ "\t\t\t" +values[j]);
                    pos++;
                    values[j]=-1;
                    t.put(ss, -1);
                    continue outer;
                }
            }
        }
            
                
        }
        view.clear();
        String displayPoints = list.toString().replace("[", "").replace("]", "").replace(",","");
        view.setText("              STANDINGS' TABLE\n\n"+displayPoints);
        
    }
    public static void regTeams() {
    /*
        //Scanner object to collect details of the teams
        Scanner scn = new Scanner(System.in);
        //Prompt for the name of the team
        System.out.println("Team's name: ");
        String team_name = scn.nextLine();
        //name of the couch
        System.out.println("Team's couch: ");
        String team_couch = scn.nextLine();
        //name of the captain
        System.out.println("Team's captain: ");
        String tema_captain = scn.nextLine();
        //name of the stadium
        System.out.println("Team's stadium: ");   
        String team_stadium = scn.nextLine();
        //diagnosis
        System.out.println("Team's city: ");   
        String team_city = scn.nextLine();
    */
        //regTeamsHelperClass object to hold team registration data
        RegTeamsHelperClass regTeams = new RegTeamsHelperClass();
        //add the details into the RegTeamsHelperClass object
        regTeams.setName(team_name);//name of the team
        regTeams.setCouch(team_coach);//name of the couch
        regTeams.setCaptain(team_captain);//name of the captain
        regTeams.setStadium(team_stadium);//team's stadium
        regTeams.setCity(team_city);//team's city
        
        //Create variables for both FileWriter and PrintWriter
        FileWriter file;
        FileWriter file2;
        PrintWriter file_writer=null;//Initialize variable to null
        PrintWriter file_writer2=null;//Initialize variable to null
        try{
            //open files
            file = new FileWriter("regTeams.txt", true);//this stores names
            file2 = new FileWriter("Teams & Details.txt", true);//this stores all details
            //convert files to enable writing methods
            file_writer = new PrintWriter(file);
            file_writer2 = new PrintWriter(file2);
            
            file_writer.print(regTeams.getName()+"\n");//store only names of the teams
            file_writer2.print(regTeams.toString());//store all details of the teams
            
        }
        catch(Exception e){
            //if the files fail to open/write, display failure message
            view.clear();
            view.setText("There was a problem while writing into the file.");
            //System.out.println("There was a problem while writing into the file.");
            //System.out.println();
        }
        finally{
            //Close files to flush contents
            file_writer.close();
            file_writer2.close();
            //System.out.println();
            
        }
        //Print success message
        view.clear();
        view.setText("Successfully registered " +regTeams.getName().toUpperCase() +" into the League");
        //System.out.println("Successfully registered " +regTeams.getName().toUpperCase() +" into the League");
        //System.out.println();
    }
    
     public static void recScores() throws IOException {
        
        //Scanner object to collect scores
        //Scanner scn = new Scanner(System.in);
        //Prompt for the home team
        //System.out.println("Home team:");
        //String home_team = scn.nextLine();
        team_name=home_team;
        checkString();
        if (checkTeam != false){
            //away team
        //System.out.print(" vs ");
        //String away_team = scn.nextLine();
        team_name=away_team;
        checkString();
        if (checkTeam != false){
            //final scores
        //System.out.println("Final scores");
        //home
        //System.out.print("(H)");
        //checker();
        //int hscore = integer1;
        //System.out.println();
        //away
        //System.out.print("(A)");
        //();
        //int ascore = integer1;
        
        try{
            hscore = Integer.parseInt(hhscore);
            ascore = Integer.parseInt(aascore);
        }
        catch (Exception e){
            view.clear();
            view.setText("Score must be an integer!!");
        }
        
        if (hscore!=0 && ascore != 0 && hhscore!= null && aascore!= null){
            
        try{
            helperMethod("Standings.txt");//retrieve already stored data
            String tableString = strng.trim();//remove side spaces and tabs on the string
            String replace = tableString.replace("{", "").replace("}", "");//remove curly brackets
            table.clear();//clear the hashtable
            String [] hashString = replace.trim().split(",");//split string data
            //create a hashtable
            for (String hashString1 : hashString) {
                String hashTable = hashString1.trim();
                String [] key_value = hashTable.trim().split("=");
                tble.putIfAbsent(key_value[0], key_value[1]);
                stan = tble;
            }
        }
        catch(Exception e){
            stan = stan;
        }
        stan.putIfAbsent(home_team.trim(), "0");
        stan.putIfAbsent(away_team.trim(), "0");
        
        
         if (hscore > ascore){
            view.clear();
            view.setText(home_team +" WON\n");
            //System.out.println();
            //System.out.println(home_team +" WON\n");
            
            int hpoints = Integer.valueOf(stan.get(home_team))+3;
            stan.replace(home_team.trim(), String.valueOf(hpoints).trim());
             
        }
        else if(hscore < ascore){
            view.clear();
            view.setText(away_team +" WON\n");
            //System.out.println();
            //System.out.println(away_team +" WON\n");
            int apoints = Integer.valueOf(stan.get(away_team))+3;
            stan.replace(away_team.trim(), String.valueOf(apoints).trim());
        }
        else{
            view.clear();
            view.setText("The game ended with a DRAW\n");
            
            //System.out.println();
            //System.out.println("The game ended with a DRAW\n");
            int hpoints = Integer.valueOf(stan.get(home_team))+1;
            int apoints = Integer.valueOf(stan.get(away_team))+1;
            stan.replace(home_team.trim(), String.valueOf(hpoints).trim());
            stan.replace(away_team.trim(), String.valueOf(apoints).trim());
        }
        
       
        ScoresHelperClass scores = new ScoresHelperClass();
        StandingsHelperClass standings = new StandingsHelperClass();
        scores.setHteam(home_team);
        scores.setAteam(away_team);
        scores.setHscore(hscore);
        scores.setAscore(ascore);
        
        FileWriter file;
        FileWriter file2;
        PrintWriter file_writer=null;//Initialize variable to null
        PrintWriter file_writer2=null;//Initialize variable to null
        try{
            //open files
            file = new FileWriter("Games Results.txt", true);//this stores final results of the games
            file2 = new FileWriter("Standings.txt");//this stores standings
            //convert files to enable writing methods
            file_writer = new PrintWriter(file);
            file_writer2 = new PrintWriter(file2);
            
            file_writer.print(scores.toString());//store reults
            file_writer2.print(stan.toString());//store with standings
            
        }
        catch(Exception e){
            //if the files fail to open/write, display failure message
            
            view.clear();
            view.setText("There was a problem while writing into the file.");
            //System.out.println("There was a problem while writing into the file.");
            //System.out.println();
        }
        finally{
            //Close files to flush contents
            file_writer.close();
            file_writer2.close();
            //System.out.println();
        }
        
        }
        else{
            view.clear();
            view.setText("Score must be an integer!!");
        }
        
        
        try{
            helperMethod("Standings.txt");//retrieve already stored data
            String tableString = strng.trim();//remove side spaces and tabs on the string
            String replace = tableString.replace("{", "").replace("}", "");//remove curly brackets
            table.clear();//clear the hashtable
            String [] hashString = replace.trim().split(",");//split string data
            //create a hashtable
            for (String hashString1 : hashString) {
                String hashTable = hashString1.trim();
                String [] key_value = hashTable.trim().split("=");
                tble.putIfAbsent(key_value[0], key_value[1]);
                stan = tble;
            }
        }
        catch(Exception e){
            stan = stan;
        }
        stan.putIfAbsent(home_team.trim(), "0");
        stan.putIfAbsent(away_team.trim(), "0");
        
        
         if (hscore > ascore){
            view.clear();
            view.setText(home_team +" WON\n");
            //System.out.println();
            //System.out.println(home_team +" WON\n");
            
            int hpoints = Integer.valueOf(stan.get(home_team))+3;
            stan.replace(home_team.trim(), String.valueOf(hpoints).trim());
             
        }
        else if(hscore < ascore){
            view.clear();
            view.setText(away_team +" WON\n");
            //System.out.println();
            //System.out.println(away_team +" WON\n");
            int apoints = Integer.valueOf(stan.get(away_team))+3;
            stan.replace(away_team.trim(), String.valueOf(apoints).trim());
        }
        else{
            view.clear();
            view.setText("The game ended with a DRAW\n");
            
            //System.out.println();
            //System.out.println("The game ended with a DRAW\n");
            int hpoints = Integer.valueOf(stan.get(home_team))+1;
            int apoints = Integer.valueOf(stan.get(away_team))+1;
            stan.replace(home_team.trim(), String.valueOf(hpoints).trim());
            stan.replace(away_team.trim(), String.valueOf(apoints).trim());
        }
        
       
        ScoresHelperClass scores = new ScoresHelperClass();
        StandingsHelperClass standings = new StandingsHelperClass();
        scores.setHteam(home_team);
        scores.setAteam(away_team);
        scores.setHscore(hscore);
        scores.setAscore(ascore);
        
        FileWriter file;
        FileWriter file2;
        PrintWriter file_writer=null;//Initialize variable to null
        PrintWriter file_writer2=null;//Initialize variable to null
        try{
            //open files
            file = new FileWriter("Games Results.txt", true);//this stores final results of the games
            file2 = new FileWriter("Standings.txt");//this stores standings
            //convert files to enable writing methods
            file_writer = new PrintWriter(file);
            file_writer2 = new PrintWriter(file2);
            
            file_writer.print(scores.toString());//store reults
            file_writer2.print(stan.toString());//store with standings
            
        }
        catch(Exception e){
            //if the files fail to open/write, display failure message
            
            view.clear();
            view.setText("There was a problem while writing into the file.");
            //System.out.println("There was a problem while writing into the file.");
            //System.out.println();
        }
        finally{
            //Close files to flush contents
            file_writer.close();
            file_writer2.close();
            //System.out.println();
            
        }
        
        //recursiveMethod();
        }
        else{
            view.clear();
            view.setText("The team is not registered.");
            //System.out.println("The team is not registered.");
        }
        
        }
        else{
            view.clear();
            view.setText("The team is not registered.");
            //System.out.println("The team is not registered.");
        }
        
    }

    public static void recursiveMethod() throws IOException {
   
        System.out.println("1. Record more scores");
        System.out.println("2. Main nenu");
        System.out.println("3. Done");
        
        checker();
        switch(integer1){
            case 1:
                recScores();
                break;
            case 2:
                menu();
                break;
            case 3:
                System.out.println("FOOTBALL APPLICATION EXITED");
                break;
            default:
                System.out.println("Select correct menu");
                
        }
    
    }

    private static void menuExitContinue() throws IOException {
    
        System.out.println("1. Main nenu");
        System.out.println("2. Done");
        
        checker();
        switch(integer1){
            case 1:
                menu();
                break;
            case 2:
                System.out.println("FOOTBALL APPLICATION EXITED");
                break;
            default:
                System.out.println("Select correct menu");
                
        }
    }
    
    private static void checkString() {
     
            
        String line = null;
        try{
            FileReader patientFile = new FileReader("regTeams.txt");//Open file in a reading mode
            BufferedReader patientStream = new BufferedReader(patientFile);//Bufffer the file
                    
            while((line = patientStream.readLine())!=null){
                contents.add(line);
            }
            patientStream.close();
            
            
        }
        catch(Exception e){
        }
        checkTeam = contents.contains(team_name);
        
    }

    
}
