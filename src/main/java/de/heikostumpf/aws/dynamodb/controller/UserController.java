package de.heikostumpf.aws.dynamodb.controller;

import de.heikostumpf.aws.dynamodb.model.User;
import de.heikostumpf.aws.dynamodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
    public void saveUser(@RequestBody User user) {
        userRepository.save(user);
    }


    @RequestMapping(value = "/user/findbyid/{id}", method = RequestMethod.GET, produces = "application/json")
    public User findUserById(@PathVariable("id") String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> findUsers() {

        List<User> allUsers = new ArrayList<>();
        Iterator<User> userIterator = userRepository.findAll().iterator();

        while(userIterator.hasNext()) {
            allUsers.add(userIterator.next());
        }

        return  allUsers;

    }



}
