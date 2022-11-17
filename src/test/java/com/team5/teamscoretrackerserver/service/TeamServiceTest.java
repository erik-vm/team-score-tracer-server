package com.team5.teamscoretrackerserver.service;

import com.team5.teamscoretrackerserver.model.Team;
import com.team5.teamscoretrackerserver.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class TeamServiceTest {

    @Autowired
    TeamService teamService;
    @MockBean
    TeamRepository teamRepository;

    Team team;

    @BeforeEach
    public void beforeEach(){
        team = new Team("A-Team", 69);
    }



    @Test
    void addTeam(){
        when(teamRepository.save(team)).thenReturn(team);
        assertEquals(teamService.convertEntityToDTO(team), teamService.addTeam(team));

    }

    @Test
    void getAllTeams() {
        when(teamRepository.findAll()).thenReturn(Stream.of(
                new Team("A-Team", 69), new Team("Fantastic Five", 5))
                .collect(Collectors.toList()));
        assertEquals(2, teamService.getAllTeams().size());
    }

    @Test
    void getTeamDTO() {
    }

    @Test
    void findTeamByName() {
    }

    @Test
    void findTeamById() {
    }
}