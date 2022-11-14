package com.team5.teamscoretrackerserver.Service;

import com.team5.teamscoretrackerserver.Model.Team;
import com.team5.teamscoretrackerserver.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public void addTeam(Team team){
        teamRepository.save(team);
    }
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }
}
