package com.mtime.spring.cloud.user.ribbon.web;

import com.mtime.spring.cloud.user.ribbon.domain.User;
import com.mtime.spring.cloud.user.ribbon.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser" ,method = RequestMethod.GET)
    public User getUser(@RequestParam Long id) {
        ServiceInstance instance = client.getLocalServiceInstance();
        User user = userService.getUser(id);
        logger.info("/getUser, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + user);
        return user;
    }
    @RequestMapping(value = "/saveUser" ,method = RequestMethod.GET)
    public User saveUser(@RequestParam Long id) {
        ServiceInstance instance = client.getLocalServiceInstance();
        User user = new User();
        user.setId(id);
        userService.saveUser(user);
        logger.info("/saveUser, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() );
        return user;
    }

}