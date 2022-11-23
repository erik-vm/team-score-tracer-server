package com.team5.teamscoretrackerserver.exeptions;

public class TeamWithThatNameAlreadyExists extends Exception{

    public TeamWithThatNameAlreadyExists(String name){
        super( String.format("Team with name = %s already exists!", name));
    }


}
