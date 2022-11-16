package com.team5.teamscoretrackerserver.exeptions;

import java.math.BigInteger;

public class TeamNotFoundException extends Exception{

    public  TeamNotFoundException(){
        super( "Team was not found!");
    }

    public TeamNotFoundException(String name){
        super( String.format("Team with name = %s was not found!", name));
    }

    public TeamNotFoundException(BigInteger teamId){
        super( String.format("Team with id = %s was not found!", teamId));
    }
}
