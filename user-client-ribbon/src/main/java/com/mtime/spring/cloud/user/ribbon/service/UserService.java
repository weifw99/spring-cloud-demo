package com.mtime.spring.cloud.user.ribbon.service;

import com.mtime.spring.cloud.user.ribbon.domain.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mtime on 2016/10/26.
 */
@Service
public class UserService {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    RestTemplate restTemplate;

    public String addService() {
        return restTemplate.getForEntity("http://USER-SERVICE/add?a=10&b=20", String.class).getBody();
    }
    public User getUser(Long id){

        logger.info("UserService.getUser");
        User user = restTemplate.getForEntity("http://USER-SERVICE/getUser?id=10", User.class).getBody();
        return user;
    }
    public void saveUser(User user){
        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("name", user.getName());
        String s = restTemplate.postForObject("http://USER-SERVICE/saveUser", null, String.class, map);
        //HttpStatus statusCode = restTemplate.postForEntity("http://USER-SERVICE/saveUser", null, String.class, map).getStatusCode();
        logger.info("UserService.saveUser");
    }
    public User editUser(User user){
        logger.info("UserService.editUser" + user);
        return user;
    }
    public void deleteUser(Long id){
        logger.info("UserService.deleteUser");
    }

}
