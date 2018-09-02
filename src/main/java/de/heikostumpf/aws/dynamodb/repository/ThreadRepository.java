package de.heikostumpf.aws.dynamodb.repository;

import de.heikostumpf.aws.dynamodb.model.ThreadId;
import org.springframework.data.repository.CrudRepository;

public interface ThreadRepository extends CrudRepository<Thread, ThreadId> {
}
