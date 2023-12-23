# Github Actions를 활용한 CI/CD 파이프라인 구축 예제

# 개발 환경

- Language: JAVA 11
- Framework: Springboot 2.7.9
- DB: MySQL 8.0
- Build: Gradle 7.6.1
- Server: AWS EC2
- CI/CD: Github Actions, Docker

## 결과

- [http://ec2-52-79-213-143.ap-northeast-2.compute.amazonaws.com:8082](http://ec2-52-79-213-143.ap-northeast-2.compute.amazonaws.com:8082)

## CI/CD 파이프라인 구축 순서

- .github/workflows/gradle-build.yml 작성을 통해 설정
- DB 정보 등의 환경변수는 Github Actions secrets 설정을 통해 설정

1. Github Actions를 통해 main 브랜치에 merge 혹은 push 여부를 감지
2. 프로젝트 Gradle Build
3. Docker Hub에 Docker Image Build 후 Push
4. EC2 Instance에 접속 후 기존에 실행중인 컨테이너 삭제 후 프로젝트 재실행

