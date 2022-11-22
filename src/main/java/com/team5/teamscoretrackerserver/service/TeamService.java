package com.team5.teamscoretrackerserver.service;

import com.team5.teamscoretrackerserver.exeptions.TeamNotFoundException;
import com.team5.teamscoretrackerserver.exeptions.TeamSavingFailedException;
import com.team5.teamscoretrackerserver.model.Team;
import com.team5.teamscoretrackerserver.repository.TeamRepository;
import dtos.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public TeamDTO addTeam(Team team) throws TeamSavingFailedException {
        if (team.getTeamName() == null || team.getTeamName().equals("")){
            throw new TeamSavingFailedException();
        }
        teamRepository.save(team);
        return convertEntityToDTO(team);
    }
    public List<TeamDTO> getAllTeams() throws TeamNotFoundException {
        return getTeamDTO();
    }

    //DTO related
    public List<TeamDTO> getTeamDTO() throws TeamNotFoundException {
        if (teamRepository.findAll().isEmpty()){
            throw new TeamNotFoundException();
        }
        return teamRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
    public TeamDTO convertEntityToDTO(Team team){

        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getTeamId());
        teamDTO.setName(team.getTeamName());
        teamDTO.setScore(team.getTeamScore());
        return teamDTO;
    }

    public Team findTeamByName(String name) throws TeamNotFoundException {
        Optional<Team> teamOptional = teamRepository.findTeamByTeamName(name);
        if (teamOptional.isEmpty()){
            throw new TeamNotFoundException(name);
        }
        return teamOptional.get();
    }

    public Team findTeamById(String teamId) throws TeamNotFoundException {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (teamOptional.isEmpty()){
            throw new TeamNotFoundException(teamId);
        }
        return teamOptional.get();
    }


}
