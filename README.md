# Spring-common-auth

### TodoList

- AdminUser CRUD API
- Admonrole CRUD API
- ResourceApi CRUD API
- Swagger
- 도커로 빌드
- 라이트 세일에 배포(도커허브 사용)

# 관리문서

## Api

모든 api는 /api/v1 으로 시작한다.


| 카테고리 | 이름               | Http method | Http URL          |
| -------- | ------------------ | ----------- | ----------------- |
| Admin    | AdminUser 단건생성 | post        | /admin-user       |
|          | AdminUser 단건조회 | get         | /admin-users/{id} |
|          | AdminUser 복수조회 | get         | /admin-users      |
|          | AdminUser 단건삭제 | delete      | /admin-users/{id} |
|          | AdminUser 단건수정 | put         | /admin-users/{id} |

# 메모

## docker로 redis 설치하기

- reids 이미지 pull

```shell

docker pull redis:alpine
```

- redis-cli로 redis에 접속하기 위해서는 redis에 접속을 위한 network를 만들어 줘야 한다.

```shell
docker network create redis-net
```

- redis 컨테이너 생성

```shell
docker run --name my-redis \
             -p 6379:6379 \
             --network redis-net \
             -v my/folder:/data \
             -d redis:alpine redis-server --appendonly yes
```

- redis cli 로 접근해보기

```shell
 docker run -it --network redis-net --rm redis:alpine redis-cli -h my-redis
```




### 참고자료

- spring service test

https://velog.io/@hellonayeon/spring-boot-service-layer-unit-testcode

- docker redis

https://emflant.tistory.com/235
