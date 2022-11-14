package com.team5.teamscoretrackerserver.Repository;

import com.team5.teamscoretrackerserver.Model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {
}
