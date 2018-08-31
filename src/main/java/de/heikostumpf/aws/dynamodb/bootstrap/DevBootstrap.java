package de.heikostumpf.aws.dynamodb.bootstrap;

import de.heikostumpf.aws.dynamodb.model.User;
import de.heikostumpf.aws.dynamodb.repository.UserRepository;
import org.ajbrown.namemachine.Gender;
import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;
import org.apache.commons.collections.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Heiko Stumpf
 * @version 1.0
 *
 * Initialize the User table with a pre-defined set of {@link User} objects
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(DevBootstrap.class);

    private void initData() {
        NameGenerator generator = new NameGenerator();
        List<Name> femaleNames = generator.generateNames( 500, Gender.FEMALE );
        List<Name> maleNames = generator.generateNames(500, Gender.MALE);
        List<Name> names = ListUtils.union(femaleNames,maleNames);

        for (Name name : names) {
            User user = new User();

            BeanUtils.copyProperties(name, user);
            logger.info("User:" + user);
            userRepository.save(user);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }



}

