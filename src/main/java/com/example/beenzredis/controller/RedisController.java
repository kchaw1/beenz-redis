package com.example.beenzredis.controller;

import com.example.beenzredis.repository.PersonRedisRepository;
import com.example.beenzredis.vo.Address;
import com.example.beenzredis.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    PersonRedisRepository redisRepository;

    @GetMapping("/save")
    public String save() {
        Address address = new Address("노원구 덕릉로");
        Person person = new Person(null, "kim", "chawon", address);

        Person save = redisRepository.save(person);

        return save.toString();
    }
}
