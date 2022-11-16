package com.team5.teamscoretrackerserver.service;

import com.team5.teamscoretrackerserver.model.Activity;
import com.team5.teamscoretrackerserver.model.Team;
import com.team5.teamscoretrackerserver.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ActivityService {

    @Autowired
    private TeamRepository teamRepository;

    public void editActivityScore(Activity activity) {


        //We are given an activity from the frontend and searching in all teams to find out which team has this activity.
        // I know it's bullshit but i ll find a better way

        List<Team> teams = teamRepository.findAll();


        if (teams != null) {
            //searching in the team's activities to find and edit the activity
        teams.forEach(team -> {
            List<Activity> activityList = team.getActivityList();
            activityList.forEach(activity1 -> {
                if (activity1.getActivityId() == activity.getActivityId()) {

                    activity1.setScore(activity.getScore());
                    team.setActivityList(activityList);
                }
        });

                //finally saving the team along with the activity update in the repository
                teamRepository.save(team);
            });


        }
    }


}
