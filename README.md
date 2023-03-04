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
