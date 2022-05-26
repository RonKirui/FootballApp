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
public class RegTeamsHelperClass {
    
    String name, couch, captain, stadium, city;
    
    RegTeamsHelperClass() {}
    
    public RegTeamsHelperClass(String team_name, String team_couch, String team_captain, String team_stadium, String team_city){
        this.name = team_name;
        this.couch = team_couch;
        this.captain = team_captain;
        this.stadium = team_stadium;
        this.city = team_city;
        
    }

    
    
    public void setName(String team_name){
        this.name = team_name;
    }
    public String getName(){
        return name;
    }
    public void setCouch(String team_couch){
        this.couch = team_couch;
    }
    public String getCouch(){
        return couch;
    }
    public void setCaptain(String team_captain){
        this.captain = team_captain;
    }
    public String getCaptain(){
        return captain;
    }
    public void setStadium(String team_stadium){
        this.stadium = team_stadium;
    }
    public String getStadium(){
        return stadium;
    }
    public void setCity(String team_city){
        this.city = team_city;
    }
    public String getCity(){
        return city;
    }
    public String toString(){
        return name +"\t" +couch +"\t" +captain +"\t" +stadium +"\t" +city +"\n";
    }
}
