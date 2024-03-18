![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=300&section=header&text=withtravel&fontSize=90)

### 🖥️ 프로젝트 소개
#### 주제: 위트(with Travel) 여행지 추천 및 여행기 공유 커뮤니티

여러 여행사 사이트와 추천 사이트의 정보가 너무 방대하여 여행 계획을 세우기가 어려운 문제를 해결하기 위해,  
지역별이 아닌 테마에 따라 여행지를 추천해주는 서비스를 고안했습니다.  
이를 통해 사용자는 자신이 원하는 특정 테마나 상황에 맞는 여행지를 쉽게 선택하고 계획할 수 있게 됩니다.

### 🧑‍🤝‍🧑 멤버 구성
#
팀장 : [신장훈](https://github.com/gamepro6390) -  메인 페이지, 서버 배포  
**팀원 : [김수연](https://github.com/sooyeoning) -   여행지 DB 구축, 여행지 추천 기능**  
팀원 : [신연균](https://github.com/SHIN-YEONGYUN) - 회원가입, 로그인, ID 찾기, PW,찾기, 마이페이지, 관리자페이지  
팀원 : [김도현](https://github.com/DoHyunDaniel) -   고객센터(CRUD), 관리자 전체 조회 및 답글   
팀원 : [안경민](https://github.com/DoHyunDaniel) -   커뮤니티(CRUD), 커뮤니티 댓글

### 🕰️ 개발기간
#
23.06.19 ~ 23.08.09

### ⚙️ 개발환경 
#
FE : 
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
<img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white">  
BE : 
<img src="https://img.shields.io/badge/java-16A5F3?style=for-the-badge&logo=logoColor=white">
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/maven-0C2340?style=for-the-badge&logo=logoColor=white">  
IDE : <img src="https://img.shields.io/badge/sts4-6DB33F?style=for-the-badge&logo=spring&logoColor=white">  
DB : <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">  
Communication Tools : 
<img src="https://img.shields.io/badge/slack-4A154B?style=for-the-badge&logo=slack&logoColor=white">
<img src="https://img.shields.io/badge/figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/ERDCLOUD-16A5F3?style=for-the-badge&logo=logoColor=white">  
![image](https://github.com/gamepro6390/Final_Project/assets/135004060/52f884d3-38db-4ca7-9c08-a6550dc309f5)

   -Front [Figma 바로가기](https://www.figma.com/file/SdxiuzovwfklsQgU4iDFBJ/KDT-Final-Project?type=design&node-id=0%3A1&mode=design&t=u3mTqC4hzJj00vtT-1/)
### 📌 주요 기능
#
#### 메인페이지 
![메인 페이지](https://github.com/gamepro6390/Final_Project/assets/109639714/e4d80eda-32a7-4a97-ae7b-3b307bb9c589)  

#### 여행지 추천 페이지  
![안녕하세요](https://github.com/gamepro6390/Final_Project/assets/135004060/6af781df-0220-4041-bcc9-a219f6812567)
- **여행지 DB 구축**  
   - 한국관광공사에서 제공되는 국문관광정보 OpenAPI 서비스 이용
   - 지역별 여행지: 강원, 부산, 인천, 광주, 울산, 경기(총 6개) 지역에 해당하는 여행지 정보 DB 저장
     1. 지역코드조회 오퍼레이션을 통해 지역코드 받음
     2. 해당 지역코드를 이용하여 지역기반 관광정보조회 오퍼레이션을 실행하면 여행지 정보를 받음
   - 코스별 여행지: 혼자,힐링,캠핑,가족,먹거리(총 5개) 코스에 해당하는 여행지 정보 DB 저장
     1. 지역코드조회 오퍼레이션을 통해 관광타입id, 여행지 코스 게시글id(=여러 여행지를 모아놓은 게시글) 받아옴
     2. 해당 관광타입id, 여행지 코스 게시글id를 이용해서 반복정보조회 오퍼레이션을 실행하면 하위콘텐츠id(=1개 여행지), 하위콘텐츠명을 받아옴
     3. 하위콘텐츠id를 이용해서 공통정보조회 오퍼레이션을 실행하면 하위콘텐츠에 해당하는 여행지 정보를 받음
     4. 하위콘텐츠id, 하위콘텐츠관광타입id를 이용해 소개정보조회 오퍼레이션을 실행하면 하위콘텐츠에 해당하는 여행지 세부 정보를 받음
  - 스케쥴러 기능: 수정된 내용 업데이트를 위해 하루에 한번 정해진 시간에 자동으로 실행되어 수정 테이블에 db 저장  
     1. 기존 내용을 갖는 테이블, 수정될 내용을 갖는 테이블을 두어 기존 테이블의 내용을 수정 테이블의 내용으로 변경
- **여행지 리스트**  
  - 페이징 기능: 10페이지씩 페이징되어 있으며, 10페이지 단위가 넘어가면 이전/이후 버튼을 통해 이전 10페이지, 이후 10페이지가 나오고,
    마지막 페이지수가 10페이지 단위가 아니면 이후 버튼이 나오지 않고 마지막 페이지수에서 페이지수 노출이 끝나게 구현
  - 검색 기능: 장소명, 주소 카테고리를 이용해서 검색 가능
  - 이전 버튼을 통한 이전 페이지 돌아가기 기능
- **여행지 상세 조회**  
  - 여행지 대표사진: 여행지 대표 사진 제공
  - 여행지 상세정보
    - 여행지 지도 제공: 카카오 지도 api를 활용 - 여행지 기반 지도 확대/축소, 여행지 큰지도보기, 길찾기 기능 제공
    - 여행지 날씨 제공: OpenWeatherAPI를 활용 - 여행지 기반 위도와 경도에 따른 현재 날씨 정보 제공
    - 여행지 상세정보 제공
      - 지역별 여행지: 여행지 설명, 대표 홈페이지 링크 연결
      - 테마별 여행지: 문의 및 안내, 유모차 대여여부, 신용카드 사용가능여부, 애완동물 동반가능여부, 쉬는날, 이용시간, 대표메뉴, 할인여부, 포장가능여부 등
  - 여행지 한줄평 남기기
    - 댓글 CRUD 기능: 로그인한 회원만 사용 가능, 수정/삭제 버튼은 해당 글 작성자에게만 노출됨
    - 댓글 신고 기능: 로그인한 회원만 사용 가능
  - 여행지 상세페이지 클릭시 조회수 증가 기능
  - 여행지 상세페이지 링크 공유 기능: 링크가 자동으로 복사
  - 여행지 상세페이지 좋아요 기능
    - 같은 사용자가 중복해서 좋아요를 누를 경우 좋아요 기능 사용 불가(alert창 이용-좋아요 이용 불가 사유 알림)
    - 로그인한 사용자만 이용 가능
    - 좋아요 취소 가능  
  
#### 서버배포
- **NCP(Naver Cloud Platform)**
  - Server, IP 등 서버 정보 생성
- **Putty**
  - 실제 필요한 서버 설정
- **SSL 인증**
  - 웹 브라우저(chrome, edge, etc)가 http로 구성시 권한 막음 //날씨-위치권한 필요
  - SSL 인증서 발급 ->https로 바꿔 권한 활성화
- **Jenkins**
  - Github 소스코드 지속적통합 및 배포(CI/CD)
#### 회원가입 & 로그인 & 마이페이지 
  
![1](https://github.com/gamepro6390/Final_Project/assets/125335424/ceebedbf-2679-43e4-ae63-d2cac741d2fb)
- **회원가입**  
  - 아이디(형식: 4자리), 비밀번호(형식: 4자리), 휴대폰 번호(형식: 010-xxxx-xxxx)    
- **로그인**  
  - 이메일, 비밀번호 일치 시 로그인 성공    
- **회원정보 수정**  
  - 닉네임, 비밀번호, 휴대폰 번호 수정가능    
- **아이디 찾기**  
  - 이름, 휴대폰 번호 일치 시 아이디 조회 가능  
- **비밀번호 찾기**  
  - 이메일, 휴대폰 번호 일치 시 임시 비밀번호 제공  
- **회원 탈퇴**  
  - 회원 탈퇴
    
#### 관리자페이지  
![2](https://github.com/gamepro6390/Final_Project/assets/125335424/0184714f-4acf-4202-bf51-e5d7c987a4aa)  
- **로그인**
  - 지정된 관리자 아이디, 비밀번호 일치 시 로그인 성공 
- **회원정보 수정**  
  - 일반 회원과 마찬가지로 회원정보 수정 가능
- **일반 회원 조회**  
  - 일반 회원 리스트 조회 가능
- **신고당한 게시글 및 댓글 조회**  
  - 신고당한 게시글 및 댓글 조회 가능
- **회원 강제 탈퇴**  
  - 관리자 권한으로 회원의 강제 탈퇴 가능  

#### 고객센터
![안녕하세요](https://github.com/gamepro6390/Final_Project/assets/132706505/05c55730-864c-4fa3-b04a-00a6d39e8fc6)

**(일반 사용자 로그인 시)**
- FAQ 페이지: 토글 기능을 활용하여 항목별로, 글 제목별로 누르면 해당 내용이 표시되도록 함

- 게시글 등록 기능: 문의 분류 및 사용자 아이디가 db에 입력됨
- 게시글 조회 기능: 사용자는 게시글 목록을 조회할 수 있으며, 각 게시글을 클릭하여 상세 정보를 확인할 수 있음
- 게시글 수정 기능: 게시글 작성자는 자신이 작성한 게시글을 수정할 수 있으며, 수정된 내용은 즉시 적용됨.
- 게시글 삭제 기능: 게시글 작성자는 자신이 작성한 게시글을 삭제할 수 있음. 삭제된 게시글은 목록에서 사라지며, 답변 내용도 함께 삭제됨.
  
**(관리자 로그인 시)**
- 관리자 로그인 시 게시글 전체 조회 및 수정 삭제 기능: 관리자 계정으로 로그인한 경우, 모든 게시글을 조회하고, 게시글의 내용을 수정하거나 삭제할 수 있음. 이 기능은 일반 사용자에게는 제공되지 않고, 관리자만 사용할 수 있음.
- 답변 기능: 관리자로 로그인 시, 모든 게시글을 조회하고 그에 답변을 달 수 있음. 답변을 달 경우 답변 여부가 표시되고, 사용자 또한 이를 확인할 수 있음.


### 최종 시연 영상
[![IU(아이유) _ Into the I-LAND](http://img.youtube.com/vi/s074A_Lpl1Q/0.jpg)](https://youtu.be/s074A_Lpl1Q?t=0s)

![Footer](https://capsule-render.vercel.app/api?type=waving&color=auto&height=200&section=footer)

