![freeneeds](/exec/freeneeds.png)

<br />

프로젝트명 : FreeNeeds  
팀명 : 놀면모하니  
개발기간 : 2022.08.29 ~ 2022.10.06  
프로젝트 개요 : 블록체인 기반 IT프리랜서 계약 서비스 <br/>
[프리니즈의 Notion 바로가기](https://dynamic-lan-3fb.notion.site/749ba73d0de04b219cf2a8293bdbecfb)

---

<br />

# 목차

1. [**서비스 소개**](#서비스-소개)
2. [**기술 스택**](#기술-스택)
3. [**시스템 아키텍처**](#시스템-아키텍처)
4. [**주요 기능**](#주요-기능)
5. [**프로젝트 산출물**](#프로젝트-산출물)
6. [**팀원 소개**](#팀원-소개)
7. [**배포**](#배포)

<br />

# 💡 서비스 소개

## **문제 많은 프리랜서 계약서, 프리니즈로 문제 없이**

> 디지털 노마드 시대와 함께 커져가는 IT 프리랜서의 생태계,<br/>
> 일방적 계약 변경으로 인한 피해와 대금 지불의 지연 등을 해결하기 위해 프리니즈가 등장했습니다. <br/>
> 프리니즈는 `블록체인 기술`을 적용하여 신뢰할 수 있는 계약 서비스를 제공하고 <br/>
> 안전한 IT 프리랜서 계약 환경을 조성합니다.

<br />

#### 프리랜서 찾기, 프로젝트 찾기, 모두 프리니즈와 함께 하세요!

<br />

# 🛠️ 기술 스택

<img src="https://img.shields.io/badge/Ethereum-3C3C3D?style=for-the-badge&logo=Ethereum&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/Web3.js-F16822?style=for-the-badge&logo=Web3.js&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/><br/>
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=#007396" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/JSON Web Tokens-000000?style=for-the-badge&logo=JSON Web Tokens&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/>
<img src="https://img.shields.io/badge/Nginx-009639?style=for-the-badge&logo=NGINX&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <br>
<img src="https://img.shields.io/badge/Vue.js-4FC08D?style=for-the-badge&logo=Vue.js&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/Node.js-339939?style=for-the-badge&logo=Node.js&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <br>
<img src="https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=Jira&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/GitLab-FCA121?style=for-the-badge&logo=GitLab&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <br/>

## 상세 기술스택 및 버전 - 수정

| 구분     | 기술스택        | 상세내용           | 버전     |
| -------- | --------------- | ------------------ | -------- |
| 공통     | 형상관리        | Gitlab             | \-       |
|          | 이슈관리        | Jira               | \-       |
|          | 커뮤니케이션    | Mattermost         | \-       |
|          | 커뮤니케이션    | Notion             | \-       |
| Server   | 서버            | AWS EC2            | \-       |
|          | 플랫폼          | Ubuntu             | 20.04    |
|          | 배포            | Docker             | 20.10.17 |
|          | 배포            | Jenkins            | 2.346.2  |
|          | 배포            | Nginx              | 1.23.1   |
| BackEnd  | DB              | MySQL              | 8.0.29   |
|          |                 | JPA                | 5.0.0    |
|          |                 | QueryDSL           | 5.0.0    |
|          | Java            | Zulu               | 11       |
|          | Spring          | Spring             | 5.3.22   |
|          |                 | Spring Boot        | 2.5.2    |
|          |                 | swagger2           | 3.0.0    |
|          |                 | Spring Security    | 2.7.2    |
|          |                 | JWT                | 3.10.3   |
|          | IDE             | Intellij           | 2022.2   |
|          | Build           | Gradle             | 7.5      |
| FrontEnd | HTML5           |                    | \-       |
|          | CSS3            |                    | \-       |
|          | JavaScript(ES6) |                    | \-       |
|          | Vue             |                    | 2.7.10   |
|          | IDE             | Visual Studio Code | 1.70.0   |

# 🛠️ 시스템 아키텍처

![시스템아키텍처](/exec/시스템아키텍처.png)

# ✨ 주요 기능

## 메인 페이지

![메인페이지](/exec/메인페이지.gif)

- 서비스의 사용 플로우와 핵심 기능을 확인할 수 있습니다.
- 추천 프로젝트와 추천 프리랜서를 제공합니다.

## 프로젝트 찾기 페이지

### 프로젝트 목록

![프로젝트목록페이지](/exec/프로젝트목록페이지.gif)

- 등록된 프로젝트 list를 페이징 처리해 제공합니다.
- 프로젝트 카드 클릭 시 프로젝트의 상세 사항을 볼 수 있습니다.

### 필터를 통한 프로젝트 찾기

![프로젝트필터](/exec/프로젝트필터.gif)

- 분야, 형태, 기술, 지역을 파라미터로 필터링해 프로젝트를 찾아줍니다.

## 프리랜서 찾기 페이지

### 프리랜서 목록

![프리랜서목록](/exec/프리랜서목록.gif)

- 등록된 프리랜서 list를 페이징 처리해 제공합니다.
- 프리랜서 카드 클릭 시 프리랜서의 상세 사항을 볼 수 있습니다.

### 필터를 통한 프리랜서 찾기

![프리랜서필터](/exec/프리랜서필터.gif)

- 기술을 파라미터로 필터링해 프로젝트를 찾아줍니다.

## 마이페이지 (기업 관점)

- 프로젝트 현황
  - 구인중인 프로젝트, 진행중인 프로젝트, 완료된 프로젝트를 분류하여 기업이 등록한 프로젝트 현황을 제공합니다.

![프로젝트현황](/exec/마이페이지.png)

- 프로젝트 등록
  - 프로젝트 등록이 가능합니다.

![프로젝트등록](/exec/프로젝트등록.png)

- 기업 정보 관리
  - 기업 정보 등록이 가능합니다.

![기업정보관리](/exec/기업정보관리.png)

## 계약 과정 (기업 관점)

### 인터뷰 요청하기

- 프리랜서 상세 페이지에서 원하는 프리랜서에게 인터뷰를 요청할 수 있습니다.

![인터뷰요청](/exec/인터뷰요청.png)

### 지원자에게 계약서 보내기

- 지원자에게 계약서를 작성해서 서명 후 보냅니다.

![기업계약서작성](/exec/기업계약서작성.gif)

### 계약 완료 시 계약서에 적힌 수만큼 기업의 지갑에서 TC토큰이 동결됩니다.

### 계약서 확인하기

- 계약이 완료된 프로젝트의 계약서를 확인할 수 있습니다.

- 계약이 완료된 프로젝트의 계약서는 스마트 컨트랙트를 통해 블록체인에 올라가게 됩니다.

- 코인보기 버튼을 통해 블록체인 데이터 정보를 확인할 수 있습니다.

### 완료된 프로젝트 정산하기

- 지원자 카드의 정산하기 버튼을 눌러 컨트랙트에 설정된 수의 TC토큰을 정산합니다.

### 완료된 프로젝트 프리랜서 평가하기

## 마이페이지 (프리랜서 관점)

- 나의 지원현황
- 제의받은 프로젝트, 지원한 프로젝트, 계약중인 프로젝트, 체결된 프로젝트를 분류하여 프리랜서가 진행중인 프로젝트 현황을 제공합니다.

![마이페이지_프리랜서](/exec/마이페이지_프리랜서.png)

- 커리어 관리
  - 프리랜서의 프로젝트와 이력서 등록 및 수정이 가능합니다.

![커리어관리_1](/exec/커리어관리_1.png) ![커리어관리_2](/exec/커리어관리_2.png)

## 계약 과정 (프리랜서 관점)

### 프로젝트 지원하기

![프로젝트지원](/exec/프로젝트지원.png)

- 프로젝트 상세 페이지에서 원하는 프로젝트에 지원할 수 있습니다.

### 계약서 서명하기

- 계약 중인 프로젝트 탭에서 기업 측에서 작성한 계약서를 확인하고 서명합니다.

![프리랜서계약서작성](/exec/프리랜서계약서작성.gif)

### 계약서 확인하기

- 계약이 완료된 프로젝트의 계약서를 확인할 수 있습니다.

- 계약이 완료된 프로젝트의 계약서는 스마트 컨트랙트를 통해 블록체인에 올라가게 됩니다.

- 코인보기 버튼을 통해 블록체인 데이터 정보를 확인할 수 있습니다.

### 완료된 프로젝트 정산받기

- 메타마스크 지갑을 통해 동결되어 있던 TC토큰을 정산 받습니다.

# 📋 프로젝트 산출물

## erd 설계

[erd cloud 보러가기](https://www.erdcloud.com/d/j7nRd349XXnabbYwj)
![freeneeds_ERD](/exec/freeneeds_ERD.png)

## 와이어프레임

[figma 보러가기](https://www.figma.com/file/hbIltXjOidNACXJxHGKLE4/%EB%86%80%EB%A9%B4%EB%AD%90%ED%95%98%EB%8B%88?node-id=0%3A1)

# 🤗 팀원 소개

<table>
    <tr>
        <td height="140px" align="center">
            <br><br> 박재영(팀장😎) <br>(Front-End)  <br></td>
        <td height="140px" align="center"> 
            <br><br> 박수근 <br>(Front-End)  <br></td>
        <td height="140px" align="center"> 
            <br><br> 성문조 <br>(Front-End) <br></td>
        <td height="140px" align="center"> 
           <br><br> 유영진 <br>(Back-End) <br></td>
        <td height="140px" align="center"> 
            <br><br> 이다인 <br>(Back-End)  <br></td>
            <td height="140px" align="center"> 
             <br><br> 조다연 <br>(Back-End) <br></td>
    </tr>
    <tr>
        <td align="center">CI/CD<br/>Vue<br/>Blockchain<br/></td>
        <td align="center">UI/UX<br/>Vue<br/>DB 관리<br/></td>
        <td align="center">UI/UX<br/>Vue<br/>UCC<br/></td>
        <td align="center">REST API<br/>Server<br/>디자인<br/></td>
        <td align="center">REST API<br/>Server<br/>Blockchain<br/></td>
        <td align="center">REST API<br/>Server<br/>UCC<br/></td>
    </tr>
</table>
<br />

# 🧞‍♂️ 배포

서버는 AWS EC2 ubuntu를 사용했습니다

## EC2 포트 정리

| 구분    | 포트번호 |
| ------- | -------- |
| Vue     | 80443    |
| Spring  | 8080     |
| Jenkins | 9090     |
| MySQL   | 3306     |

## 배포 플로우

### 1. 프로젝트 기술 스택

```markdown
**Frontend**
Vue3 version
Vuex 3.4.0
CSS3
JavaScript(ES6)
HTML5

**Backend**
SpringBoot 2.7.1
Gradle 7.4.1
Spring Security
Spring data JPA
Querydsl
Node.js
express

**DB**
MySQL : 8.0.29
Redis

**Server**
Ubuntu 20.0
```

### 2. 빌드 설정

```markdown
**소스코드 클론**
git clone <repo URL>

**디렉토리 이동**
cd backend

**gradle 프로젝트 빌드**
./gradlew

**생성된 jar 파일 확인**
cd build/libs ssafy-web-project-1.0-SNAPSHOT.jar
```

### 3. AWS EC2 서버 설정

모든 설치 전 실행

```markdown
패키지 업데이트
apt-get update
```

#### java 설치

```markdown
**JRE 설치**
sudo apt-get install openjdk-8-jre

**JDK 설치**
sudo apt-get install openjdk-8-jdk

**자바 설치 버전 확인**
java -version
javac -version

\*\*자바 환경변수 설정

1.\*\* vi 에디터 열기
sudo vi /etc/profile

2. 맨 아래 추가 하기
   export JAVA_HOME=/user/lib/jvm/java-8-openjdk-amd64
   export PATH=$JAVA_HOME/bin/:$PATH
   export CLASS_PATH=$JAVA_HOME/lib:$CLASS_PATH

3. 변경 내용 즉시 적용하기
   source /etc/profile

4. 재부팅하기
   sudo reboot now
```

#### 방화벽 설정

```markdown
**현재 방화벽 설정 확인**
sudo ufw status

if ufw == inactive

**방화벽 설정**
sudo ufw allow 22
sudo ufw enable
```

#### mysql 설치

```markdown
**mysql 설치**
sudo apt install mysql-server

## mysql 외부 접속 설정

**디렉토리 이동**
cd /etc/mysql/mysql.conf.d

**mysqld.cnf 파일 수정**
sudo vi mysqld.cnf

**설정 변경**
bind-address 127.0.0.1 -> 0.0.0.0

**mysql 접속**
sudo mysql

**외부 접속 계정 생성 & 권한 부여**
create user '계정이름'@'%' identified by '패스워드';
grant all privileges on _._ to '계정이름'@'%' with grant option;

**mysql 접속 포트 추가**
sudo ufw allow 3306
```

#### redis 설치

```markdown
**redis 설치**
sudo apt-get install redis-server

**redis 설치 확인**
redis-server --version

**redis 설정**
sudo vi /etc/redis/redis.conf

**변경**
bind 127.0.0.1 => bind 0.0.0.0

**redis 실행**
sudo systemctl start redis-server

**redis 접속 포트 추가**
sudo ufw allow 6379
```

#### nginx 설치

```markdown
**nginx 접속 포트 추가**
sudo ufw allow 80
sudo ufw allow 443

**Nginx 설치**
sudo apt-get install nginx

**Nginx 시작**
sudo service nginx start

**설정파일 생성**
cd /etc/nginx/sites-available
sudo vi b105.conf

**sites-enabled에 심볼릭 링크 만들기**
udo ln -s /etc/nginx/sites-available/b105.conf /etc/nginx/sites-enabled

**심볼릭 링크 추가 확인**
cd /etc/nginx/sites-enabled
ls -l

**기존 설정파일 삭제**
sudo rm default

**재구동 및 확인**
sudo service nginx restart

**SSL 인증서 발급**
sudo service nginx restart
```
