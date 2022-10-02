# EZ_HOME 🏠
KOSMO 파이널 프로젝트(빅데이터&RPA팀 中 1위)

<img src="https://user-images.githubusercontent.com/106857917/193094201-17000132-77f5-4c95-9625-965302799024.jpg" width="700" >
<hr>
<ul dir="auto">
<li>
<h3 dir="auto">프로젝트 개요</h3>
            <ul>
            <li> <h4>🏠 EZHome </h4></li>
            <li> <code>EZHome</code>은 사용자의 다양한 조건을 맞춰주는 부동산 사이트입니다.<br>
            지역구별로 매물을 검색하거나, 개인별 조건에 해당하는 매물들을 확인할 수 있는 서비스를 제공합니다. </li>
            <li> 프로젝트 기간 : 22.06.07~22.07.06(총 29일)</li>
            <li> 팀원 : 총 6명 [이예중(팀장), 고종욱, 박소현, 이다한, 최유진, 김수환]</li>
            </ul>
</li>
</ul>
<hr>
<ul>
<li>
<h3>주요 기능</h3>
            <ul>
            <li> <h4>조건 검색 리스트 기능 </h4>
                        <blockquote>
                        <ol>
                        <li>부동산 매물에 대한 조건 리스트를 저장 가능</li>
                        <li>기본/맞춤/카테고리 3가지로 나누어짐</li>
                        <li>기본은 지역, 거래유형, 거래금액 등이 포함</li>
                        <li>맞춤은 매물에 대한 특성, 카테고리는 지역적 특성을 가진 조건이 포함</li>
                        </ol>
                        </blockquote>
            </li>
            <li> <h4>카카오맵 API 운용</h4>
                        <blockquote>
                        <ol>
                        <li>부동산 매물에 대한 조건 리스트를 저장 가능</li>
                        <li>기본/맞춤/카테고리 3가지로 나누어짐</li>
                        <li>기본은 지역, 거래유형, 거래금액 등이 포함</li>
                        <li>맞춤은 매물에 대한 특성, 카테고리는 지역적 특성을 가진 조건이 포함</li>
                        </ol>
                        </blockquote>
            </li>
            <li> <h4>일치율(%)을 통한 매물추천</h4>
                        <blockquote>
                        <ol>
                        <li>저장한 조건에 따라 매물의 일치율을(%)로 계산</li>
                        <li>일치율 순으로 매물을 보여주는 기능 구현</li>
                        <li>기본 조건에 해당되지 않는 매물은 추천자격이 없음</li>
                        </ol>
                        </blockquote>
            </li>
            </ul>
</li>
</ul>
<hr>
<ul>
<img src="https://user-images.githubusercontent.com/106857917/193444340-93fff8a4-3d35-42da-b594-b7d5164e7d96.png" width="700" >
<li>
    <h3>🛠 적용 기술 </h3>
        <blockquote>
        <ul>
        <li>언어/개발 Tool
            <ul>
            <li>Java</li>
            <li>jQuery</li>
            <li>ThymeLeaf</li>
            <li>Html</li>
            <li>css5</li>
            <li>Oracle sql</li>
            </ul>
        </li>
        <li>개발환경
            <ul>
                <li>OS : Windows10</li>
                <li>DB : Oracle 11g</li>
                <li>Service : Apach Tomcat9</li>
                <li>Framework : Spring Framework</li>
                <li>Security : Spring Security</li>
                <li>MyBatis</li>
            </ul>
        </li>
        <li>개발 및 형상관리 도구
            <ul>
                <li>SQLdeveloper</li>
                <li>InteliJ</li>
                <li>vsCode</li>
                <li>AdobeXD</li>
                <li>Photoshop</li>
                <li>Git /Github</li>
                <li>Google Docs</li>
            </ul>
        </li>
        </ul>
        </blockquote>
</li>
<hr>
<li>
<h3>⚡서비스 소개</h3>
            <ol>
            <li>
            <h3>메인페이지</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193463285-e640111f-3530-4f1a-8c71-0456ef10edd4.png" width="400" >
            <img src="https://user-images.githubusercontent.com/106857917/193463565-684397f1-a83c-4d5e-842a-3eb4f8431cb4.png" width="470" >
                        <ul>
                        <li>부동산, 고객센터, 커뮤니티, 로그인정보로 들어갈 수 있다.</li>
                        <li>한개의 행정구역의 추천 매물을 띄워줍니다.</li>
                        </ul>
            </li>
            <li>
            <h3>로그인/회원가입</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193463246-cb06e662-315c-4edb-be7e-6d5537d58cef.png" width="300" >
            <img src="https://user-images.githubusercontent.com/106857917/193463248-ac824b0a-667a-4d03-b7b3-427fce9c8e2a.png" width="280" >
                        <ul>
                        <li>아이디, 비밀번호 유효성 검사 실시</li>
                        <li>스프링 시큐리티를 사용하여 비밀번호를 암호화하여 데이터 베이스로 넘어감.</li>
                        <li>회원을 일반회원, 공인중개사 2가지로 분류</li>
                        </ul>
            </li>
            <li>
            <h3>마이페이지</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193463720-dea50deb-e95d-4ad7-8dfa-6a85388eee58.png" width="500" >
                        <ul>
                        <li>일반 회원의 경우 마이페이지에서 저장된 조건 맞춤을 볼 수 있음</li>
                        <li>공인 중개사의 경우 올린 매물을 마이페이지를 통해 확인할 수 있음.</li>
                        </ul>
                        <br>
                        <br>
            <img src="https://user-images.githubusercontent.com/106857917/193464205-d138518f-e0c0-44ca-baac-5dd06bbfbce3.png" width="500" >
                        <ul>
                        <li>회원 정보 수정 / 탈퇴 페이지</li>
                        <li>타임리프를 통해 정보를 가져오고</li>
                        <li>수정 시에도 스프링 시큐리티를 사용해 비밀번호를 암호화 시킴.</li>
                        <li>탈퇴는 MyBatis를 사용하였음</li>
                        </ul>
            </li>
            <li>
            <h3>부동산</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193464660-f91c1c47-be12-40aa-be0d-023da6219e6f.png" width="800" >
                        <ul>
                        <li>기본 부동산 서비스 페이지</li>
                        <li>KaKao Map API를 활용해 지도에 기반한 서비스 제공</li>
                        <li>세분화를 극도로 활용하기는 어렵다 판단하여 '시군구', '읍면동'을 기준으로 매물 정보를 보여줌</li>
                        <li>
                        '지오서비스'에서 제공하는 대한민국 최신 행정구역 데이터(shp)를 활용해,(http://www.gisdeveloper.co.kr/?p=2332)<br>
                        'mapshaper'에서 용량을 위해 폴리곤을 95% 단순화 시킨 후(http://www.gisdeveloper.co.kr/?p=2332)<br>
                        'shp2geojson.js'에서 shp파일을 geojson파일로 변환시켜 좌표를 생성후(http://gipong.github.io/shp2geojson.js/)<br>
                        카카오 맵 API에서 제공하는 폴리곤 생성 이벤트를 활용해 대한민국의 행정구역을 표시함(지도의 level에 따라 시/군/구, 읍/면/동 모두 구현)
                        </li>
                        <li>
                        <code>영등포구/0</code>는 매물이 추가되면 카운트가 올라가고, 이후 개인 조건 설정을 통해 보여지는 것을 조절할 수 있음
                        </li>
                        <li>지역구 클릭시 줌 인 / 매물 위치를 보여주는 기능 / 지역구에 해당하는 매물 리스트가 오른쪽에서 제공</li>
                        <li>매물 클릭 시 간단한 정보 제공 </li>
                        <li><code>필터표시</code> 클릭 시 조건 슬라이드 제공</li>
                        <li><code>목록표시</code> 클릭 시 매물 리스트 슬라이드 제공</li>
                        <li><code>거래유형</code> <code>방유형</code> 등의 네비게이션 클릭시 현재 선택한 조건의 정보 확인 가능 </li>
                        </ul>
                        <br>
                        <br>
            <img src="https://user-images.githubusercontent.com/106857917/193465952-49b08387-85fd-43bd-9544-77c508025f4d.png" width="400" >
            <img src="https://user-images.githubusercontent.com/106857917/193465956-6c10c961-1dd4-4dde-9627-885f826e1795.png" width="400" >
                        <ul>
                        <li>조건 슬라이드 부분</li>
                        <li>기본, 맞춤/카테고리 조건을 DB에 저장 및 적용 기능</li>
                        <li>로그인 시에만 사용 가능</li>
                        <li>이중 슬라이드 스크립트를 임의로 제작</li>
                        </ul>
            <img src="https://user-images.githubusercontent.com/106857917/193471024-2caac591-0f26-4925-95f7-c137795dc0a5.png" width="700" >
                        <ul>
                        <li>매물 리스트 부분</li>
                        <li>비로그인 시 지역구에따른 매물을 보여줌</li>
                        <li>로그인 및 조건 적용 후에는 일치율 정보(%로 보여줌) 및 순위별로 리스트화</li>
                        </ul>                
            </li>
            <li>
            <h3>매물 디테일 페이지</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193471209-2e23a4b5-03e2-4ec3-acf7-c650d433123d.png" width="700" >
                        <ul>
                        <li>매물에 대한 데이터 제공</li>
                        <li>자신이 올린 매물의 경우 삭제 가능</li>
                        </ul>      
            </li>
            <li>
            <h3>고객센터</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193471369-20dc4016-ab40-4677-8322-4d2e27858619.png" width="400" >
            <img src="https://user-images.githubusercontent.com/106857917/193471384-915909f1-c12d-4053-a208-e56d4bf8a4a2.png" width="430" >
                        <ul>
                        <li>자주묻는 질문 / 1:1 문의 / 공지사항 기능 존재</li>
                        <li>1:1 문의의 경우 문의 내용을 DB에 기록</li>
                        </ul>      
            </li>
            </ol>
</li>
<hr>
<li>
<h2>📑기능정의서</h2>
<img src="https://user-images.githubusercontent.com/106857917/193471659-3e9fc508-3478-4b70-bade-753a82b6e0b4.png" width="700" >
</li>
<li>
<h2>DB 설계</h2>
            <ul>
            <li>
            <h3>👓 전체 테이블 한눈에 보기</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193471775-a22763ab-98e7-4f26-a45d-2d3780c7db6d.png" width="700" >
            </li>
            <br><br>
            <li>
            <h3>ERD_회원조건</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193471844-f616f9a8-3bdc-4fdd-be81-81d7b6082bb6.png" width="600" >
            </li>
            <li>
            <h3>ERD_매물</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193471852-d7f13ff7-9966-43a9-ad28-cc3555c04843.png" width="600" >
            </li>
            <li>
            <h3>ERD_공지사항</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193471859-afe1a63d-5734-46f5-a4d5-4777706f1d21.png" width="300" >
            </li>
            </ul>
</li>
<hr>
<li>
<h2>🏃‍♂️이렇게 진행했어요!</h2>
<i>참고 : https://docs.google.com/spreadsheets/d/1iEupyc9HXglEIQ1ceGhqUEvHXmnOqjcqax3ahosVfYM/edit#gid=407317361 </i>
            <ul>
            <li> <h3>개발 일정</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193472052-5d8c6ec1-079d-4620-a408-4dfe52786d8e.png" width="700" >
                        <ul>
                        <li>22.06.07 ~ 22.07.06 총 29일에 걸쳐 진행하였습니다.</li>
                        </ul>
            </li>
            <li> <h3>클래스, 변수명 설계</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193472612-478e39c0-80e7-4994-9015-2e037bb367dd.png" width="700" >
                        <ul>
                        <li>협업간 변수명 중복을 피하기 위해 법칙을 만들고 이를 공유하였습니다.</li>
                        </ul>
            </li>
            <li> <h3>Flow Chart 설계</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193472645-68798847-16ba-4879-940d-a4cfaed0154e.png" width="700" >
                        <ul>
                        <li>사용자의 입장에서 웹페이지를 설계하기 위해, Flow Chart를 작성하였습니다.</li>
                        <li>사용자는 크게 세입자와 공인중개사로 나뉩니다.
                        </ul>
            </li>
            <li> <h3>HTML 개발현황</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193472893-19f6efbf-7df6-49f9-9c29-88aebc84ed9d.png" width="700" >
                        <ul>
                        <li>필요한 레이아웃 정리/파악 및 제작현황 공유</li>
                        </ul>
            </li>
            <li> <h3>회의록</h3>
            <img src="https://user-images.githubusercontent.com/106857917/193473146-cdd37a4c-a92a-4b65-94a4-1d4ebcba749b.png" width="400" >
                        <ul>
                        <li>총 12차에 걸친 회의 진행</li>
                        </ul>
            </li>
            </ul>
</li>
<hr>
<li>
<h2>🏆수상내역</h2>
            <img src="https://user-images.githubusercontent.com/106857917/193473299-a1e87853-fbba-4df2-ae62-621ad8c8dc0b.jpg" width="400" >
            <ul>
            <li>RPA를 활용한 빅데이터 전문가과정(JAVA, RPA)에서 최우수상 수여</li>
            </ul>
</li>
</ul>






