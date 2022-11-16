package com.team5.teamscoretrackerserver.repository;

import com.team5.teamscoretrackerserver.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface TeamRepository extends MongoRepository<Team, BigInteger> {

    Optional<Team> findTeamByTeamName(String name);
}
