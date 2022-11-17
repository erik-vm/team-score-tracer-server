package com.team5.teamscoretrackerserver.controller;

import com.team5.teamscoretrackerserver.exeptions.TeamNotFoundException;
import com.team5.teamscoretrackerserver.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @PutMapping("teamId={teamId}&activityId={activityId}&score={score}")
    public void editActivityScore(@PathVariable("teamId") String teamId,
                                  @PathVariable("activityId") String activityId,
                                  @PathVariable("score") Integer score) throws TeamNotFoundException {
         activityService.editActivityScore(teamId,activityId,score);
    }
}
