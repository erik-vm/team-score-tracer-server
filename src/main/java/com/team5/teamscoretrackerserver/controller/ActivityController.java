package com.team5.teamscoretrackerserver.controller;

import com.team5.teamscoretrackerserver.model.Activity;
import com.team5.teamscoretrackerserver.model.Team;
import com.team5.teamscoretrackerserver.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @PutMapping("/edit")
    public void editActivityScore(@RequestBody Activity activity){
         activityService.editActivityScore(activity);
    }
}
