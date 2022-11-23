package com.team5.teamscoretrackerserver.service;

import com.team5.teamscoretrackerserver.exeptions.TeamNotFoundException;
import com.team5.teamscoretrackerserver.exeptions.TeamSavingFailedException;
import com.team5.teamscoretrackerserver.exeptions.TeamWithThatNameAlreadyExists;
import com.team5.teamscoretrackerserver.model.Team;
import com.team5.teamscoretrackerserver.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class TeamServiceTest {

    @Autowired
    TeamService teamService;
    @MockBean
    TeamRepository teamRepository;

    Team team;

    @BeforeEach
    public void beforeEach() {
        team = new Team("A-Team", 69);
    }


    @Test
    void whenAddingTeam_thenShouldReturnTeamTDO() throws TeamSavingFailedException, TeamWithThatNameAlreadyExists {
        when(teamRepository.save(team)).thenReturn(team);
        assertEquals(teamService.convertEntityToDTO(team), teamService.addTeam(team));
    }

    @Test
    void whenAddingTeamWithEmptyName_thenShouldThrowException() {
        assertThrows(TeamSavingFailedException.class, ()->{
            teamService.addTeam(new Team());
        } );
    }


    @Test
    void whenCallingGetAllTeamsSize_shouldReturnTwo() throws TeamNotFoundException {
        when(teamRepository.findAll()).thenReturn(Stream.of(team, team)
                .collect(Collectors.toList()));
        assertEquals(2, teamService.getAllTeams().size());
    }

    @Test
    void whenCallingGetAllTeamsSize_shouldReturnException() {
        assertThrows(TeamNotFoundException.class, ()->{
            teamService.getAllTeams();
        });
    }

    @Test
    void whenCallingGetTeamDTOSize_shouldReturnTwo() throws TeamNotFoundException {
        when(teamRepository.findAll()).thenReturn(Stream.of(team, team)
                .collect(Collectors.toList()));
        assertEquals(2,teamService.getTeamDTO().size());
    }

    @Test
    void whenCallingFindTeamByName_shouldReturnTeam() throws TeamNotFoundException {
        when(teamRepository.findTeamByTeamName(team.getTeamName())).thenReturn(Optional.ofNullable(team));
        assertEquals(team, teamService.findTeamByName(team.getTeamName()));
    }

    @Test
    void whenCallingFindTeamById_shouldReturnTeam() throws TeamNotFoundException {
        when(teamRepository.findById(team.getTeamId())).thenReturn(Optional.ofNullable(team));
        assertEquals(team, teamService.findTeamById(team.getTeamId()));
    }
}