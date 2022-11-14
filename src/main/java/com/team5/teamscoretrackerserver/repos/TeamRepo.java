package com.team5.teamscoretrackerserver.repos;

import com.team5.teamscoretrackerserver.models.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepo extends MongoRepository<Team, String> {
}
