# choistory
시간이 지나면 선택한 기록 외에는 모두 지워지는 sns

## Feature
### 서비스시작
- 회원가입
- 로그인
### 구독(Follow)
- Follow
- Unfollow
### 타임라인
#### 글 쓰기
- 이미지 올리기
- 남길 글 선택
- 유효시간 선택
#### 글 삭제
#### 글 읽기
- 구독 글까지 시간순 정렬
- 답글달기

### 체크포인트
- [ ] 1.타임라인 조회 전략
- [ ] 2.내가 쓴 글의 캐싱전략
- [ ] 3.구독 관계 테이블 최적화
- [ ] 4.만료된 피드의 삭제
- [ ] 5.오래된 피드의 보관


## 예정 일정
| 주 | 내용                                                 |
|----|----------------------------------------------------|
|10주| ~~화면, 인터페이스, 서비스단위, 클래스 등 구성~~                     |
|11주| ~~네이버 클라우드 등 개발에 필요한 전반적인 구축 완료. api-server 진행시작~~ |
|12주| 구독, 피드 관련 API 진행. 체크포인트 3번 확인                      |
|13주| 유저, 파일 관련 API 진행. 체크포인트 1,2번 준비                    |
|14주| 체크포인트 1,2번 고려해서 타임라인 개발 진행. 스프링 배치 작업 준비           |
|15주| 스프링 배치 task 별 작업(체크포인트 4,5번)                       |
|16주| 인증서버 작업. 테스트 시작                                    |
|17주| 테스트                                                |
|18주| 테스트 및 프로젝트 종료                                      |

## 참고화면
![front 화면1](https://github.com/f-lab-edu/choistory/blob/develop/images/front_01.png)<br>
![front 화면2](https://github.com/f-lab-edu/choistory/blob/develop/images/front_02png)<br>
![front 화면3](https://github.com/f-lab-edu/choistory/blob/develop/images/front_03.png)<br>
** 위 화면은 인터페이스 도출을 위해 참고로 구성한 화면입니다. 실제로는 개발하지 않습니다.

## Infra Structure
![infra structure](https://github.com/f-lab-edu/choistory/blob/develop/images/infra%20structure_v0.1.png)

## ERD
![erd](https://github.com/f-lab-edu/choistory/blob/develop/images/ERD_v1.0.png)
