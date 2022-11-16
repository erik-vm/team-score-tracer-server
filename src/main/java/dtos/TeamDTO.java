package dtos;

import lombok.Data;

import java.math.BigInteger;

@Data
public class TeamDTO {
    private BigInteger Id;
    private String Name;
    private Integer Score;
}
