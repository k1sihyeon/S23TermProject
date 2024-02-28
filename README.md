# FV(페스티벌) LineUp

## 1. 서론
- 개발 배경 <br>
  코로나 이후, 공연 문화에 대한 수요가 다시 회복하고 있다. 일상을 벗어난 공간에서 여가 생활과 공연을 함께 즐길 수 있다는 점에서 음악 페스티벌의 인기 또한 다시 회복하고 있다.

  ![image](https://github.com/k1sihyeon/S23TermProject/assets/96001080/9bdda221-4ae4-403b-b0f2-d42ea4e59165)
  - [그림 1] LAB CHASM, 코로나 판데믹 이후 페스티벌 만족도 변화

   [그림 1]은 LAB CHASM에서 조사한 코로나 팬데믹 이후 페스티벌 만족도 변화이다. 팬데믹 이전 오프라인 공연의 평균 만족도는 3.42, 팬데믹 이후 온라인 공연 평균 만족도는 2.26으로 평균 만족도는 오프라인 공연이 더 높은 것을 확인할 수 있다. 또한, 온라인 공연의 단점으로 현장감 부족이 꼽히고 있어 팬데믹 이후 오프라인 공연이 더 성장할 가능성을 보여주고 있다.

  ![image](https://github.com/k1sihyeon/S23TermProject/assets/96001080/af886e83-5301-4ed4-89f8-1bf061b4588f)
  - [그림 2] 뉴스 토마토, 코로나 이후 공연시장 매출

  2022년 12월 뉴스 토마토 기사에 따르면 2022년 전체 공연시장의 매출이 코로나 이전인 2019년의 매출을 뛰어넘을 것으로 예측한다.
  또한, 17년째를 맞은 국내 대표 음악 축제 \'펜타포트 락 페스티벌\'은 역대 최다 관객을 동원해 팬데믹 이후 공연시장이 더욱 확대되는 것을
   확인할 수 있다.

이처럼 공연 시장은 확대되고 있지만, 이와 관련한 공연의 전체적인 정보를
확인할 수 있는 웹사이트는 많지 않다. 예매 사이트의 경우 공연의 장소,
가격 등을 확인할 수 있지만, 공연의 후기, 출연진의 정보, 장소 등에 대한
정보 등 종합적인 공연의 정보를 찾아볼 수 있는 사이트는 거의 없다.
대부분의 공연 정보는 인스타그램 등 SNS 또는 커뮤니티 등에 개별적으로
등록되어 종합적으로 찾을 수 있는 공연 정보 확인 사이트가 필요하다.

이번에 개발하고자 하는 작품의 이름은 'FV LineUp'으로 이 어플에서
사용자들이 공연에 대한 정보를 찾을 때 출연진의 이름, 장르, 페스티벌의
장소, 날짜, 이름 등의 간단한 정보만으로 다양한 페스티벌의 정보를 찾을 수
있도록 도와줄 것이다.

## 2. 작품 개요
- DB 구성도

  ![image](https://github.com/k1sihyeon/S23TermProject/assets/96001080/507c8f70-ac22-4f12-bb63-b3847f31f6f6)

  DB 관리자는 페스티벌, 아티스트, 퍼포먼스 테이블을 관리한다.
	사용자는 페스티벌 리스트, 페스티벌 디테일 정보를 획득한다.
  <br> <br>
- 앱 구성도

  ![image](https://github.com/k1sihyeon/S23TermProject/assets/96001080/35eb222d-13c5-435c-aeae-a731640e25c9)

  앱의 메인 화면이자 첫 화면인 페스티벌 리스트 페이지는 다양한 페스티벌의 라인업 사진과 이름, 개최 장소, 개최일 등의 정보를 담고 있다. 리스트에서 임의의 페스티벌을 클릭하면 해당되는 페스티벌의 디테일 페이지로 넘어간다.

  페스티벌 디테일 페이지에는 페스티벌의 이름, 사진, 개최일, 개최 장소, 주소, 참여하는 가수들의 정보를 담고 있다. 주소 오른쪽의 버튼을 클릭하면 주소 Intent로 지도 앱이 실행되며, 아래의 참여하는 가수를 클릭하면 가수를 검색하는 유튜브 앱이 실행된다.

  디테일 페이지의 아래에는 참여하는 가수들의 정보를 볼 수 있으며 또한, 해당 가수의 공연일, 시간, 스테이지 등을 확인할 수 있다.


## 3. 설계
### 3.1 Use Case
1.  페스티벌 리스트 확인

-   메인화면

2.  특정 페스티벌 세부 정보 확인

-   메인화면 -\> 디테일 화면

3.  특정 페스티벌의 주소 및 길찾기 확인

-   메인화면 -\> 디테일 화면 -\> 버튼 클릭 -\> 지도 앱 실행

4.  특정 페스티벌의 특정 가수의 유튜브 확인

-  메인화면 -\> 디테일 화면 -\> 특정 가수 클릭 -\> 유튜브 앱 실행
 
### 3.2 UI Design
- List

  ![image](https://github.com/k1sihyeon/S23TermProject/assets/96001080/1e9c473c-2239-4399-990f-b92368e1102e)

  
- Detail

  ![image](https://github.com/k1sihyeon/S23TermProject/assets/96001080/52fc2290-13e0-44e6-bd4f-0f6beac5d43c)

### 3.3 DB Design
#### 3.3.1 Conceptual Design
![image](https://github.com/k1sihyeon/S23TermProject/assets/96001080/c50d2c89-0755-4a22-a6d7-0f8a897f8676)

#### 3.3.2 Logical Design
- Artist Table: 가수(아티스트)의 id, 이름, 이미지 주소를 포함한다.
  ```sql
  CREATE TABLE IF NOT EXISTS Artist (
    artist_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    image_url VARCHAR(255), 
    UNIQUE KEY unique_artist_name (name)
  ) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_general_ci;
  
  ```
  
- Festival Table: 페스티벌의 id, 이름, 장소, 주소, 이미지 주소, 시작/종료 날짜를 포함한다.
  ```sql
  CREATE TABLE IF NOT EXISTS Festival (
    festival_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    address VARCHAR(255),
    image_url VARCHAR(255),
    start_date DATE,
    end_date DATE,
    UNIQUE KEY unique_festival_name (name)
  ) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_general_ci;
  
  ```
  
- Performance Table: 아티스트 id와 페스티벌 id를 foreign key로 가지며 공연일, 시작/종료 시간을 포함한다.
  ```sql
  CREATE TABLE IF NOT EXISTS Performance (
    performance_id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    festival_id INT,
    performance_date DATE,
    time_start TIME,
    time_end TIME,
    stage VARCHAR(100), 
    FOREIGN KEY (artist_id) REFERENCES Artist(artist_id),
    FOREIGN KEY (festival_id) REFERENCES Festival(festival_id)
  ) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_general_ci;

  ```

### 3.4 Use Case별 Sequence Diagram
1. 페스티벌 리스트 확인
   ![image](https://github.com/k1sihyeon/S23TermProject/assets/96001080/78cda540-e04f-489f-8b0d-ea6fc9d3d14f)

2. 특정 페스티벌 세부 정보 확인
   ![image](https://github.com/k1sihyeon/S23TermProject/assets/96001080/06379d37-aa36-4362-ae57-f0dac2019e07)

3. 특정 페스티벌의 주소 및 길찾기 확인
  ![image](https://github.com/k1sihyeon/S23TermProject/assets/96001080/3186f12d-9ca7-4d5d-8256-b825bff6bacc)

   
4. 특정 페스티벌의 특정 가수의 유튜브 확인
   ![image](https://github.com/k1sihyeon/S23TermProject/assets/96001080/3186f12d-9ca7-4d5d-8256-b825bff6bacc)

## 4. 구현
- server.js 중 일부
  ```js
  app.get('/festival/:festivalId', (req, res) => {
    const festivalId = req.params.festivalId;
    const sql = `
    SELECT Artist.name AS artistName, Artist.image_url, Performance.performance_date, Performance.time_start, Performance.time_end, Performance.stage 
    FROM Performance 
    JOIN Artist ON Performance.artist_id = Artist.artist_id 
    JOIN Festival ON Performance.festival_id = Festival.festival_id 
    WHERE Festival.festival_id = ?;
    `;
    
    db.query(sql, [festivalId], (err, rows) => {
        if (err) {
            res.json({ result: "error" })
            return console.log(err)
        }
        res.json(rows)
    })
  })

  ```
## 5. 결론 및 평가
초기에 설계한대로 마무리할 수 있었지만 많은 가수들을 DB에 넣는 것은 한계가 있었다. 따라서, 이미지를 업로드하고 문자를 인식하여 손쉽게 DB를 업데이트 할 수 있도록 하는 기능이 필요하다. 
디테일 화면에서 이미지의 작은 글자들은 보기 힘든데, 이미지를 클릭하여 확대한 상태로 볼 수 있도록 하는 기능이 필요하다.

## 6. 참고문헌
https://developer.android.com/jetpack/compose/layout?hl=ko
https://developer.android.com/jetpack/compose/graphics/images/customize?hl=ko
