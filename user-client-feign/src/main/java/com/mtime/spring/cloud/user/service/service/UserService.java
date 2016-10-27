package com.mtime.spring.cloud.user.service.service;

import com.mtime.spring.cloud.user.service.domain.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Mtime on 2016/10/26.
 */
@Service
public class UserService {
    private final Logger logger = Logger.getLogger(getClass());

    public User getUser(Long id){
        logger.info("UserService.getUser");
        User user = new User();
        user.setId(id);
        user.setName("userName"+id);
        user.setAge(new Random().nextInt(60));
        user.setSex(1);
        return user;
    }
    public void saveUser(User user){
        logger.info("UserService.saveUser" + user);
    }
    public User editUser(User user){
        logger.info("UserService.editUser" + user);
        return user;
    }
    public void deleteUser(Long id){
        logger.info("UserService.deleteUser");
    }

}
