#스프링 레디스 연동 연습

## 1. 연결하기
- application.yml 에 레디스 서버 정보(spring.redis.host, spring.redis.port) 설정
- RedisConfig.java 파일에서 서버정보 주입받고 연동

## 2. 스프링 소스
- @RedisHash("key") 활용하여 엔티티 생성 (Person.java)
- 레파지토리 생성 (PersonRedisRepository.java)
- 컨트롤러 생성 (RedisController.java) 후 save 로직 작성

## 3. 그 외 (aws 배포)
- aws 에 redis 설치
- ./redis-server 로 서버 실행 (기본포트 6379)
- 프로젝트에서 gradlew bootjar 명령어로 jar 파일 생성
- scp 로 aws에 jar파일 업로드
- jar 실행 후 브라우저에서 8080 포트 접속 후 /save 호출
- ./redis-cli 에서 저장된 키확인

## 4. 참고
1. https://docs.spring.io/spring-data/redis/docs/2.5.5/reference/html/#redis:connectors:lettuce
2. https://docs.spring.io/spring-data/redis/docs/2.5.5/reference/html/#redis.repositories.usage
3. https://sabarada.tistory.com/106?category=856943
4. https://techsoda.net/windows10-pem-file-permission-settings/
