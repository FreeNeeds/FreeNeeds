

![freeneeds](/uploads/2afdeebef89c88a39f2c5013f5fc542f/freeneeds.png)

<br />

프로젝트명 : FreeNeeds  
팀명 : 놀면모하니   
개발기간 : 2022.08.29 ~ 2022.10.06   
프로젝트 개요 : 블록체인 기반 IT프리랜서 매칭 계약 서비스 
[Notion](https://dynamic-lan-3fb.notion.site/749ba73d0de04b219cf2a8293bdbecfb) 


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
일방적 계약 변경으로 인한 피해와 대금 지불의 지연 등을 해결하기 위해 프리니즈가 등장했습니다. <br/>
프리니즈는 `블록체인 기술`을 적용하여 신뢰할 수 있는 계약 서비스를 제공하고 <br/>
안전한 IT 프리랜서 계약 환경을 조성합니다.

<br />

#### 프리랜서 찾기, 프로젝트 찾기, 모두 프리니즈와 함께 하세요!

<br />

# 🛠️ 기술 스택
<img src="https://img.shields.io/badge/Ethereum-3C3C3D?style=for-the-badge&logo=Ethereum&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/Web3.js-F16822?style=for-the-badge&logo=Web3.js&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/><br/>
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=#007396" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/JSON Web Tokens-000000?style=for-the-badge&logo=JSON Web Tokens&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> 
<img src="https://img.shields.io/badge/Nginx-009639?style=for-the-badge&logo=NGINX&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <br>
<img src="https://img.shields.io/badge/Vue.js-4FC08D?style=for-the-badge&logo=Vue.js&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/Node.js-339939?style=for-the-badge&logo=Node.js&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/>  <br>
<img src="https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=Jira&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/GitLab-FCA121?style=for-the-badge&logo=GitLab&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <br/>



## 상세 기술스택 및 버전 - 수정

| 구분       | 기술스택                    | 상세내용                 | 버전          |
| -------- | ----------------------- | -------------------- | ----------- |
| 공통     | 형상관리                    | Gitlab               | \-          |
|          | 이슈관리                    | Jira                 | \-          |
|          | 커뮤니케이션                  | Mattermost   | \-          |
|          | 커뮤니케이션                  | Notion   | \-          |
| Server   | 서버                      | AWS EC2              | \-          |
|          | 플랫폼                     | Ubuntu               | 20.04         |
|          | 배포                      | Docker               | 20.10.17         |
|          | 배포                      | Jenkins              | 2.346.2          |
|          | 배포                      | Nginx              | 1.23.1         |
| BackEnd  | DB                      | MySQL                | 8.0.29         |
|          |                         | JPA                  | 5.0.0          |
|          |                         | QueryDSL             | 5.0.0         |
|          | Java                    | Zulu                 | 8   |
|          | Spring                  | Spring               | 5.3.22         |
|          |                         | Spring Boot          | 2.5.2          |
|          |                         | Spring Security          | 2.7.2          |
|          | IDE                     | Intellij             | 2022.2          |
|          | Build                   | Gradle               | 7.5        |
| FrontEnd | HTML5                   |                      | \-          |
|          | CSS3                    |                      | \-          |
|          | JavaScript(ES6)         |                      |\-           |
|          | Vue         |                      |  3.2.13        |
|          | IDE                     | Visual Studio Code   |1.70.0          |


# 🛠️ 시스템 아키텍처

![프리니즈-최종발표_이다인-017](/uploads/c55ca85ddb95f2086968093b248e0c33/프리니즈-최종발표_이다인-017.png)


# ✨ 주요 기능

## 메인 페이지

![메인페이지](/uploads/1954bc9fdf721ea44d0becd8f6d1a4ec/메인페이지.gif)

- 서비스의 사용 플로우와 핵심 기능을 확인할 수 있습니다.
- 추천 프로젝트와 추천 프리랜서를 제공합니다.

## 프로젝트 찾기 페이지

### 프로젝트 목록

![프로젝트목록페이지](/uploads/73a92678eaad88c7a3c094c3f3139d53/프로젝트목록페이지.gif)

- 등록된 프로젝트 list를 페이징 처리해 제공합니다.
- 프로젝트 카드 클릭 시 프로젝트의 상세 사항을 볼 수 있습니다.

### 필터를 통한 프로젝트 찾기

![프로젝트필터](/uploads/aa239c248422c948c4c23fc28059f0ce/프로젝트필터.gif)

- 분야, 형태, 기술, 지역을 파라미터로 필터링해 프로젝트를 찾아줍니다.


## 프리랜서 찾기 페이지

### 프리랜서 목록

![프리랜서목록](/uploads/99bc88a7b8b44d205c2a94d8a23e2d8c/프리랜서목록.gif)

- 등록된 프리랜서 list를 페이징 처리해 제공합니다.
- 프리랜서 카드 클릭 시 프리랜서의 상세 사항을 볼 수 있습니다.

### 필터를 통한 프리랜서 찾기

![프리랜서필터](/uploads/e50b3bcdd911bcd6056daa122b085888/프리랜서필터.gif)

- 기술을 파라미터로 필터링해 프로젝트를 찾아줍니다.


## 계약 과정 (기업 관점)

### 인터뷰 요청하기

- 프리랜서 상세 페이지에서 원하는 프리랜서에게 인터뷰를 요청할 수 있습니다.

### 마이페이지

- 프로젝트 현황

![image](/uploads/ad19f90e604416da20e7150b88df8200/image.png)

  - 구인중인 프로젝트, 진행중인 프로젝트, 완료된 프로젝트를 분류하여 기업이 등록한 프로젝트 현황을 제공합니다.

- 프로젝트 등록

![image](/uploads/023f6e0e49b06a827b051e930bdfdc61/image.png)
  
  - 프로젝트 등록이 가능합니다.

- 기업 정보 관리

![image](/uploads/0c6f8211028938e9598caf78bab44bd2/image.png)

  - 기업 정보 등록이 가능합니다.


## 계약 과정 (프리랜서 관점)

### 프로젝트 지원하기

- 프로젝트 상세 페이지에서 원하는 프로젝트에 지원할 수 있습니다.

### 마이페이지

- 나의 지원현황

![image](/uploads/ea6b731c1d930f086dc75730bd88e864/image.png)

  - 제의받은 프로젝트, 지원한 프로젝트, 계약중인 프로젝트, 체결된 프로젝트를 분류하여 프리랜서가 진행중인 프로젝트 현황을 제공합니다.

- 커리어 관리

![image](/uploads/57fa3887195e7e0854fa547640af4f91/image.png) ![image](/uploads/03dd9c76f9efd8e587f8a186c0c62793/image.png)

  - 프리랜서의 프로젝트와 이력서 등록 및 수정이 가능합니다.
  
# 📋 프로젝트 산출물
## erd 설계
[erd cloud 보러가기](https://www.erdcloud.com/d/j7nRd349XXnabbYwj) 
![FreeNeeds__1_](/uploads/074b6bd2567b820cd34f3ee672e60001/FreeNeeds__1_.png)

## 와이어프레임 
[figma 보러가기](https://www.figma.com/file/hbIltXjOidNACXJxHGKLE4/%EB%86%80%EB%A9%B4%EB%AD%90%ED%95%98%EB%8B%88?node-id=0%3A1) 


#  🤗 팀원 소개

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

| 구분       | 포트번호                    | 
| -------- | ----------------------- |
| Vue         |  8081               | 
| Jenkins         |  80, 443                 | 
| Spring         | 8080                    | 
| Jenkins         | 9090                    | 
| MySQL         | 3306                 | 

## 배포 플로우 
<!-- 필수 항목 -->


## 카테고리

| Application | Domain | Language | Framework |
| ---- | ---- | ---- | ---- |
| :white_check_mark: Desktop Web | :black_square_button: AI | :white_check_mark: JavaScript | :white_check_mark: Vue.js |
| :white_check_mark: Mobile Web | :black_square_button: Big Data | :black_square_button: TypeScript | :black_square_button: React |
| :white_check_mark: Responsive Web | :black_square_button: Blockchain | :black_square_button: C/C++ | :black_square_button: Angular |
| :black_square_button: Android App | :black_square_button: IoT | :black_square_button: C# | :black_square_button: Node.js |
| :black_square_button: iOS App | :black_square_button: AR/VR/Metaverse | :white_check_mark: Python | :white_check_mark: Flask/Django |
| :black_square_button: Desktop App | :black_square_button: Game | :white_check_mark: Java | :white_check_mark: Spring/Springboot |
| | | :black_square_button: Kotlin | |

<!-- 필수 항목 -->

## 프로젝트 소개

* 프로젝트명: 그룹 비디오 컨퍼런스 서비스
* 서비스 특징: 웹/모바일(웹 기술) 프로젝트를 위한 스켈레톤 프로젝트
* 주요 기능
  - 회원 관리
  - 화상 미팅룸
  - 그룹 채팅
* 주요 기술
  - WebRTC
  - WebSocket
  - JWT Authentication
  - REST API
* 참조 리소스
  * Vuetify: 디자인 전반 적용
  * Vue Argon Design System: 디자인 전반 적용
  * Vue Black Dashboard Pro(유료): 캘린더 컴포넌트 사용
  * AR Core: 구글에서 제공하는 AR 지원 라이브러리. 이미지 인식 및 오버레이 영상에 활용
  * Color Thief: 이미지 색상 추출 라이브러리. 커버 사진 색상 추출 및 배경 변경에 활용
  * Animation.css: CSS 애니메이션 지원 라이브러리. 메인 페이지 진입 애니메이션에 활용
* 배포 환경
  - URL: // 웹 서비스, 랜딩 페이지, 프로젝트 소개 등의 배포 URL 기입
  - 테스트 계정: // 로그인이 필요한 경우, 사용 가능한 테스트 계정(ID/PW) 기입

<!-- 자유 양식 -->

## 팀 소개
* 김ㅇㅇ: 팀장, 프론트엔드 개발
* 이ㅇㅇ: 부팀장, 기획 및 와이어프레임 작성, 프론트엔드 개발
* 박ㅇㅇ: 백엔드 개발 및 QA 담당
* 홍ㅇㅇ: 백엔드 개발, Swagger API 문서 관리
* 전ㅇㅇ: 코드 리뷰 및 인프라 담당, CI/CD, HTTPS, Docker 구성

<!-- 자유 양식 -->

## 프로젝트 상세 설명

// 개발 환경, 기술 스택, 시스템 구성도, ERD, 기능 상세 설명 등
