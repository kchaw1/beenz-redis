package com.example.beenzredis.vo;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * @RedisHash 의 value값으로 Set이 생성되고
 * 해당 Set에 Person 객체의 @Id 값이 Value로 들어간다.
 *
 * 동시에 people:@Id값 을 키로 가진 hash 가 생성되고 (null일경우 랜덤한 문자열 people:6e14bd74-ba4f-4f4b-acb8-6348be1757dd 등으로 생성됨)
 * hash 내부에 객체의 필드와 값이 key - value 형태로 들어간다
 */

@Getter
@RedisHash("people")
public class Person {
    @Id
    private final String id;
    private final String firstName;
    private final String lastName;
    private final Address address;

    @Builder
    public Person(String id, String firstName, String lastName, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}


