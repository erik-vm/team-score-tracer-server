package com.team5.teamscoretrackerserver.controller;

import com.team5.teamscoretrackerserver.exeptions.TeamNotFoundException;
import com.team5.teamscoretrackerserver.model.Activity;
import com.team5.teamscoretrackerserver.model.Team;
import com.team5.teamscoretrackerserver.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @PutMapping("teamId={teamId}&activityId={activityId}&score={score}")
    public void editActivityScore(@PathVariable("teamId") BigInteger teamId,
                                  @PathVariable("activityId") BigInteger activityId,
                                  @PathVariable("score") Integer score) throws TeamNotFoundException {
         activityService.editActivityScore(teamId,activityId,score);
    }
}
