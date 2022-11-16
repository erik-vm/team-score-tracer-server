package com.team5.teamscoretrackerserver.exeptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NumberOfPointsBellowZeroException extends RuntimeException {
    String message = "Can't have negative points. Minimum is 0";
    public NumberOfPointsBellowZeroException(String message) {
        this.message = message;
    }
}


