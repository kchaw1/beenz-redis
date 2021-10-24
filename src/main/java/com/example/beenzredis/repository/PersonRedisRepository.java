package com.example.beenzredis.repository;

import com.example.beenzredis.vo.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<Person,String> {

}
