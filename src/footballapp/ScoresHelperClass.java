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
public class ScoresHelperClass {
    String hteam, ateam;
    int hscore,ascore;
    
    public ScoresHelperClass(){
        
    }
    public ScoresHelperClass(String home_team, String away_team,int home_score,int away_score){
        this.hteam = home_team;
        this.ateam = away_team;
        this.hscore = home_score;
        this.ascore = away_score;
    }
    public void setHteam(String home_team){
        this.hteam = home_team;
    }
    public String getHteam(){
        return hteam;
    }
    public void setAteam(String away_team){
        this.ateam = away_team;
    }
    public String getAteam(){
        return ateam;
    }
    public void setHscore(int home_score){
        this.hscore = home_score;
    }
    public int getHscore(){
        return hscore;
    }
    public void setAscore(int away_score){
        this.ascore = away_score;
    }
    public int getAscore(){
        return ascore;
    }
    public String toString(){
        return "\t"+hteam +"\t"+hscore +"-" +ascore +"\t" +ateam +"\n";
    }
    
}
