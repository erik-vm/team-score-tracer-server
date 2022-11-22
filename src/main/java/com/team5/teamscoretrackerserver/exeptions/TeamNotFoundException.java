package com.team5.teamscoretrackerserver.exeptions;

public class TeamNotFoundException extends Exception{

    public  TeamNotFoundException(){
        super( "Teams where not found!");
    }

    public TeamNotFoundException(String nameOrId){
        super( String.format("Team with name or id = %s was not found!", nameOrId));
    }


}
