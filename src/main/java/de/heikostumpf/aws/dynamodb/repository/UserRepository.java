package de.heikostumpf.aws.dynamodb.repository;

import de.heikostumpf.aws.dynamodb.model.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface UserRepository extends CrudRepository<User, String> {

}
