/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballapp;

/**
 *
 * @author user
 */
public class StandingsHelperClass {
    
    String team;
    int points;
    
    public StandingsHelperClass(){
        
    }
    public StandingsHelperClass(String team_name,int team_points){
        this.team = team_name;
        this.points = team_points;
    }
    public void setTeam(String team_name){
        this.team = team_name;
    }
    public String getTeam(){
        return team;
    }
    public void setPoints(int team_points){
        this.points = team_points;
    }
    public int getPoints(){
        return points;
    }
    
}
