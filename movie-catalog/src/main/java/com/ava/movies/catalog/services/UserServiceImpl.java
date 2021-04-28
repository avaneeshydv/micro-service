package com.ava.movies.catalog.services;

import com.ava.movies.catalog.entity.Users;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
    @Value("${user.url}")
    private String userUrl;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackUser",
    //hystrix 
    commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000"),
        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") }, 

//Bulkhead properties
threadPoolProperties = {
        @HystrixProperty(name = "coreSize", value = "30"),
        @HystrixProperty(name = "maxQueueSize", value = "50")

})
    public Users getUser(int id) {
        LOGGER.info("calling api to extract user info ofr id {} ", id);
        String url = userUrl + "getinfo?id=" + id;
        return restTemplate.getForObject(url, Users.class);
    }

    // falback method to be return response while error
    private Users getFallbackUser(int id) {
        LOGGER.info("Executing fallback method as due to error while getting actual user for id {}", id);
        Users users = new Users();
        users.setUserId(id);
        users.setFirstName("not able to get firstName");
        users.setLastName("not able to get lastName");
        users.setEmail("not able to get email");
        return users;
    }
}
