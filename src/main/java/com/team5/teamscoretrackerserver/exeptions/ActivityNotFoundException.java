package com.team5.teamscoretrackerserver.exeptions;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ActivityNotFoundException extends RuntimeException{
    String message = "This activity doesn't exist. Try selecting a different activity from the board.";
    
    public ActivityNotFoundException(String message) {
       this.message = message;
    }
}
   
    

