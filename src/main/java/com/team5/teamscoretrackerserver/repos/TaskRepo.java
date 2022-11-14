package com.team5.teamscoretrackerserver.repos;

import com.team5.teamscoretrackerserver.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepo extends MongoRepository<Task, String> {
}
