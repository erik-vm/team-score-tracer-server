package com.team5.teamscoretrackerserver.service;

import com.team5.teamscoretrackerserver.exeptions.TeamNotFoundException;
import com.team5.teamscoretrackerserver.model.Activity;
import com.team5.teamscoretrackerserver.model.Team;
import com.team5.teamscoretrackerserver.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ActivityService {

    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamRepository teamRepository;

    public void editActivityScore(String teamId, String activityId, Integer score) throws TeamNotFoundException {


        //We are given an activity from the frontend and searching in all teams to find out which team has this activity.
        // I know it's bullshit but i ll find a better way

        Team team = teamService.findTeamById(teamId);

            List<Activity> activityList = team.getActivityList();
            activityList.forEach(activity1 -> {
                if (activity1.getActivityId().equals(activityId)) {
                    activity1.setScore(score);
                    team.setActivityList(activityList);
                }
        });

                //finally saving the team along with the activity update in the repository
                teamRepository.save(team);
            }






}
