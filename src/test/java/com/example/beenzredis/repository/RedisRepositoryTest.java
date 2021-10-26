package com.example.beenzredis.repository;

import com.example.beenzredis.vo.Address;
import com.example.beenzredis.vo.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * repository 방식 테스트
 */
@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    PersonRedisRepository redisRepository;

    @AfterEach
    void deleteAllKey() {
        redisRepository.deleteAll();
    }

    @Test
    void 객체세이브테스트() {

        Address address = new Address("노원구");

        String firstName = "kim";
        String lastName = "chawon";

        Person person = new Person(null, firstName, lastName, address);

        Person save = redisRepository.save(person);

        assertThat(save.getAddress().getAddress()).isEqualTo(person.getAddress().getAddress());
        assertThat(save.getFirstName()).isEqualTo(firstName);
        assertThat(save.getLastName()).isEqualTo(lastName);
    }
}
