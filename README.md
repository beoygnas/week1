# Week 1 : 


> 4분반 김상엽, 이상민 팀

몰입캠프 1주차에는 공통과제로 탭 구조를 활용한 안드로이드 앱 제작을 하였다.
Android Studio와 Git을 활용한 협업에 익숙해지는 것이 궁극적인 목표이다.
* 탭 1: 나의 연락처 구축. 휴대폰의 연락처 데이터를 활용하거나, JSON 형식을 이용해서 임의의 연락처 데이터를 구축. (추천: ListView나 RecyclerView 등을 이용해서 데이터 보여 주기)
* 탭 2: 나만의 이미지 갤러리 구축. 이미지는 대략 20개 정도.
* 탭 3: 자유 주제 -> 캘린더를 활용한 일정관리 프로그램(일종의 Todolist + Calendar)


<br/>

## 팀원

* 고려대학교 컴퓨터학과 [김상엽](https://github.com/beoygnas)
* KAIST 전산학부 [이상민](https://github.com/alex6095)

## 개발 환경 (Development Environment)

* OS : Android
* SDK 
```
minSdk 26
targetSdk 32
```
* Language : Kotlin & Java
* IDE : Android Studio
* Target Device : Galaxy S7




<br/>

## 어플리케이션 소개 (Application Introduction)
***

### Tab 1

<p>
    <img src="https://i.imgur.com/yVtzynq.jpg" height="32%" width="32%">
    <img src="https://i.imgur.com/60Ky8DD.jpg" height="32%" width="32%">
    <img src="https://i.imgur.com/eDVwBAg.jpg" height="32%" width="32%">
    <br><br><br>
</p>

연락처 기능을 구현한 탭으로 임의의 연락처 보다는 실제 휴대폰의 연락처 데이터를 활용하는 것이 현실감이 높아 보일 것 같아서 실제 데이터를 불러와서 보여주는 형식으로 구현하였다. 또한 RecyclerView가 작동방식부터 ListView보다 효율적이고, 구글에서 권장하게 되면서 더 많은 기능들이 추가됬기 때문에 RecyclerView를 적극 활용하였다.

<p>
    한글 -> 영어 -> 숫자 & 특수문자 순서대로 정렬하여 화면에 보여주며 검색 기능과 스크롤 시 버블로 초성을 보여줄 수 있도록 하였다. 연락처 리스트를 Json파일에 따로 저장할 수 있게 하여 우리 연락처만의 프로필 사진을 저장 할 수 있도록 구현하였다. 프로필 사진으로 선택한 사진의 Uri를 Json에 이름, 전화번호와 함께 저장하는 방식이다. 실제 연락처와 동기화할 때(연락처 삭제 및 추가) 비효율적이고 문제가 발생할 여지가 크지만 훗날 차이점을 LCS 알고리즘 같은것으로 비교 검증한다면 빠르게 동기화 할 수 있을 것이다.    
</p>

아쉬운 점은 우리의 앱에서 연락처를 추가 및 삭제를 하는 Floating Action Button을 만들 계획이었으나 시간이 부족하여 구현하지 못하였다.


<p>
    기타 디테일 
    <ul>
        <li>프로필 사진 선택 시 음영처리(3,3) </li>
        <li>연락처 스크롤 시 초성자음 표시</li>
        <li>위로 스와이프 시 연락처 새로고침</li>
    </ul>
    
</p>
<p>
    <img src="https://i.imgur.com/3349wpJ.jpg" height="24%" width="24%">
<img src="https://i.imgur.com/FT3Mksu.jpg" height="24%" width="24%">
<img src="https://i.imgur.com/qMjhrtx.jpg" height="24%" width="24%">
    <img src="https://i.imgur.com/2jqt10y.jpg" height="24%" width="24%">


    
</p>




### Tab 2

<p>
    <img src="https://i.imgur.com/Ji25a0g.jpg" height="49%" width="49%">
    <img src="https://i.imgur.com/RTw2ihO.jpg" height="49%" width="49%">
    <br><br><br>
    <img src="https://i.imgur.com/MnTl0kR.png" height="100%" width="100%">
    <br><br><br>
</p>

휴대폰 갤러리에 저장된 사진과 연동하여 사진을 보여주는 갤러리이다. RecyclerView를 이용하여 그리드 형식으로 리스트를 보여주고, 사진 선택 시 dialogue로 확대된 사진을 볼 수 있다. 화면의 크기에 맞춰 보기 편한 그리드 숫자로 자동으로 변경되도록 구현하였고, 태블릿이나 가로로 긴 핸드폰을 가로로 두는 경우에 보기 편해졌다. 스크롤 시 버블에 촬영된 날짜가 나온다.


### Tab 3

    
<p>
    <img src="https://i.imgur.com/wk2GxNw.jpg" height="32%" width="32%">
    <img src="https://i.imgur.com/R76k1rz.jpg" height="32%" width="32%">
<img src="https://i.imgur.com/d03JxGr.jpg" height="32%" width="32%">
    <br><br><br>
</p>



날짜를 확인 할 수 있는 기본적인 캘린더에 그치지 않고, 날짜 선택 시 그 날의 일정을 추가/삭제 할 수 있는 실용적이고 심플한 캘린더를 구현하고자 하였다. 휴대폰의 내부저장소에 json파일을 읽고/쓰는 방식으로 구현했기 때문에, 어플을 삭제하지 않는 이상 데이터를 보존할 수 있다.

기본적인 캘린더는 캘린더뷰를 통해, 일정의 추가/삭제는 각 버튼 클릭 시에 다이얼로그/recyclerview의 새로고침을 통해 구현했다. 


<p>
    연락처, 일정과 관련한 모든 파일은 다음의 내부저장소 디렉토리에 json형태로 저장된다.
</p>
<center>
    <br>
    <img src="https://i.imgur.com/wukmx8z.png" height="33%" width="33%">
    <br>
</center>
    
    




***

## 어려웠던 점

 Kotlin의 경우 null, type등에 의한 에러에 매우 민감하기 때문에 기본적으로 구현할 때 생각이 좀 더 필요했고, 한국어로 검색할 때 Java보다 활용할 수 있을만한 자료가 부족하여서 영어로 최대한 검색했다. 또한 deprecated 함수를 최대한 활용하지 않으려고 노력하여서 더 힘들었던 것도 있다.
 
 또한 Kotlin 문법 자체와 안드로이드 액티비티, 프래그먼트의 생명주기 및 관계에 대해 지식이 부족하여 Context, this 같은 것들에 있어서 올바른 구현을 위해 많은 고뇌를 할 수 밖에 없었다.
 
 Permission 허가를 Permission를 요구하기 전에 받아와야하는데 액티비티 위에서 여러 프래그먼트들을 돌리다보니 적절한 타이밍이 없어서 고민한 결과, 인트로 화면에서 권한을 받아온 후에 메인 액티비티에 전달을 하는 방식으로 구현을 하였다. 받지 못할 경우 다시 권한을 물어보도록 설계를 하였다. 2번 이상 거절 당할 경우 자동으로 다시 묻지 않는다고 하여서 권한 설정 페이지로 직접 이동하도록 구현하였다.
