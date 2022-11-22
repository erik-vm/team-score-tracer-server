package com.team5.teamscoretrackerserver.exeptions;

public class TeamSavingFailedException extends Exception{

    public TeamSavingFailedException(){
        super("Team name must not be empty!");
    }

}
