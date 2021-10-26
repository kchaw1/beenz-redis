스프링 레디스 연동 연습

## 1. 연결하기
- application.yml 에 레디스 서버 정보(spring.redis.host, spring.redis.port) 설정
- RedisConfig.java 파일에서 서버정보 주입받고 연동

## 2. 스프링 소스
- @RedisHash("key") 활용하여 엔티티 생성 (Person.java)
- 레파지토리 생성 (PersonRedisRepository.java)
- 테스트생성 (redisTemplate, repository) 2가지 방식으로 진행

## 3. 참고
1. https://docs.spring.io/spring-data/redis/docs/2.5.5/reference/html/#redis:connectors:lettuce
2. https://docs.spring.io/spring-data/redis/docs/2.5.5/reference/html/#redis.repositories.usage
3. https://sabarada.tistory.com/106?category=856943
4. https://techsoda.net/windows10-pem-file-permission-settings/
