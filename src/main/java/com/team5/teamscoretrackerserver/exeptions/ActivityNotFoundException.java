package com.team5.teamscoretrackerserver.exeptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ActivityNotFoundException extends RuntimeException{
    String message = "This activity doesn't exist. Try selecting a different activity from the board.";
    
    public ActivityNotFoundException(String message) {
       this.message = message;
    }
}
   
    

