package com.team5.teamscoretrackerserver.exeptions;

public class TeamNotFoundException extends Exception{

    public  TeamNotFoundException(){
        super( "Team was not found!");
    }

    public TeamNotFoundException(String name){
        super( String.format("Team with name = %s was not found!", name));
    }
}
