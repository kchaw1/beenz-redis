package com.example.beenzredis.template;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * template 방식 테스트
 */
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    StringRedisTemplate redisTemplate;

    private final String key = "testKey";

    @AfterEach
    void 키삭제() {
        redisTemplate.delete(key);
    }

    @Test
    void 키밸류를넣는다() {

        final String value = "testValue";

        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();

        valueOps.set(key, value);

        assertThat(valueOps.get(key)).isEqualTo(value);
    }

    /**
     * LinkedList와 비슷한 자료구조
     * 처음과 마지막에 element 를 추가할 수 있다.
     */
    @Test
    void 리스트테스트() {
        ListOperations<String, String> listOps = redisTemplate.opsForList();

        listOps.rightPush(key, "H");
        listOps.rightPush(key, "e");
        listOps.rightPush(key, "l");
        listOps.rightPush(key, "l");
        listOps.rightPush(key, "o");

        assertThat(listOps.leftPop(key)).isEqualTo("H");
        assertThat(listOps.rightPop(key)).isEqualTo("o");
    }

    /**
     * 자바의 Set과 비슷 순서가 X, 중복X 인 자료구조
     */
    @Test
    void 셋테스트() {
        SetOperations<String, String> setOps = redisTemplate.opsForSet();

        setOps.add(key, "H", "e", "l" , "l", "o");

        assertThat(setOps.members(key).contains("H")).isTrue();
        assertThat(setOps.size(key)).isEqualTo(4);
    }

    /**
     * Set 자료구조에 Score가 추가로 등록되는 구조
     * score가 낮은순에서 높은순으로 정렬된다.
     * 키에 대한중복은 허용되지 않으나, 동일 스코어는 존재가능
     * 랭킹시스템에 활용된다고 한다.
     */
    @Test
    void 정렬된셋테스트() {
        ZSetOperations<String, String> zsetOps = redisTemplate.opsForZSet();

        zsetOps.add(key,"H", 1);
        zsetOps.add(key,"e", 2);
        zsetOps.add(key,"b", 2);
        zsetOps.add(key,"l", 4);
        zsetOps.add(key,"o", 5);

        System.out.println(zsetOps.rangeByScore(key,0, 999));

        assertThat(zsetOps.score(key, "H")).isEqualTo(1);
    }

    /**
     * 키 안에 키밸류가 들어있는 자료구조
     */
    @Test
    void 해시테스트() {
        HashOperations<String, Object, Object> hashOps = redisTemplate.opsForHash();

        String hashKey1 = "hashKey1";
        String hashValue1 = "hashValue1";
        String hashKey2 = "hashKey2";
        String hashValue2 = "hashValue2";

        hashOps.put(key, hashKey1, hashValue1);
        hashOps.put(key, hashKey2, hashValue2);

        assertThat(hashOps.get(key, hashKey1)).isEqualTo("hashValue1");
    }
}
