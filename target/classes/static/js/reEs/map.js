$(document).ready(function(){
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(37.5066103, 126.9783882), // 지도의 중심좌표
            level: 6 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
    // 지도의 현재 레벨을 얻어옵니다
    var level = map.getLevel();

    var polygons=[];
    var customOverlays=[];
    var si = 5;

    // 행정구역 구분(구)
    deletePolygon(polygons, customOverlays);
    $.getJSON("json/sig.geojson", function(geojson){
        var data = geojson.features;
        var coordinates = []; // 좌표 저장할 배열
        var name = '';  //행정 구 이름
        console.log('name');
        $.each(data, function(index, val){
            coordinates = val.geometry.coordinates;
            name = val.properties.SIG_KOR_NM;
            displayArea(coordinates, name);
        })
    })

    // 지도가 확대 또는 축소되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
    kakao.maps.event.addListener(map, 'zoom_changed', function() {
        if(map.getLevel() >= si && level < si){
            // 행정구역 구분(구)
            deletePolygon(polygons, customOverlays);
            $.getJSON("json/sig.geojson", function(geojson){
                var data = geojson.features;
                var coordinates = []; // 좌표 저장할 배열
                var name = '';  //행정 구 이름

                $.each(data, function(index, val){
                    coordinates = val.geometry.coordinates;
                    name = val.properties.SIG_KOR_NM;
                    console.log(name);
                    displayArea(coordinates, name);
                })
            })
        }else if(map.getLevel() < si && level >= si){
            deletePolygon(polygons, customOverlays);
            $.getJSON("json/emd.geojson", function(geojson){
                var data = geojson.features;
                var coordinates = []; // 좌표 저장할 배열
                var name = '';  //행정 구 이름

                $.each(data, function(index, val){
                    coordinates = val.geometry.coordinates;
                    name = val.properties.EMD_KOR_NM;
                    console.log(name);
                    displayArea(coordinates, name);
                })
            })
        }
        level = map.getLevel();
    });

    // 행정구역 폴리곤
    function displayArea(coordinates, name){

        var path = [];      // 폴리곤을 그려줄 path
        var points = [];    // 중심좌표 구하기위한 지역구 좌표들

        $.each(coordinates[0], function(index, coordinate){
            var point = new Object();
            point.x = coordinate[1];
            point.y = coordinate[0];
            points.push(point);
            path.push(new kakao.maps.LatLng(coordinate[1], coordinate[0]));
        })

        // 다각형을 생성합니다
        var polygon = new kakao.maps.Polygon({
            map: map, // 다각형을 표시할 지도 객체
            path: path,
            strokeWeight:2,
            strokeColor: '#004c80',
            strokeOpacity:0.8,
            fillColor:'#fff',
            fillOpacity:0.7
        })

        polygons.push(polygon);     // 폴리곤을 제거하기 위한 배열

        // 다각형에 mouseover 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 변경합니다.
        kakao.maps.event.addListener(polygon, 'mouseover', function(mouseEvent){
            polygon.setOptions({
            fillColor:'#09f'
            });
        });

        // 다각형에 mousemove 이벤트를 등록하고 이벤트가 발생하면 커스텀 오버레이의 위치를 변경합니다.
//        kakao.maps.event.addListener(polygon, 'mousemove', function(mouseEvent){
//            customOverlay.setPosition(mouseEvent.latLng);
//        });

        // 다각형에 mouseout 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 원래색으로 변경합니다.
        // 커스텀 오버레이를 지도에서 제거합니다.
        kakao.maps.event.addListener(polygon, 'mouseout', function(){
            polygon.setOptions({
                fillColor:'#fff'
            });
        });

        // 다각형에 click 이벤트를 등롟하고 이벤트가 발생하면 해당 지역을 확대합니다.
        kakao.maps.event.addListener(polygon, 'click', function(){
            // 읍면동으로 이동
            var emd = 4;

            // 지도를 클릭된 폴리곤의 중앙 위치를 기준으로 확대합니다
            map.setLevel(emd, {anchor: centroid(points), animate:{
                duration: 350 // 확대시 애니메이션 시간
            }});
        });

        // 이부분이 제일 중요합니다
        // 47 부분을 어디서 가져올건지 확인하면 됨
        var content = '<div class ="customOverlay"><span class="leftNumber">'+ 47 +'</span><span class="center">' + name + '</span><span class="right"></span></div>';
        // 시, 구를 표시해주는 커스텀 오버레이를 생성합니다.
        var customOverlay = new kakao.maps.CustomOverlay({
            position:centroid(points),
            content:content
        });
        customOverlays.push(customOverlay)

        customOverlay.setMap(map);
    }

    // centroid 알고리즘 (폴리곤 중심좌표 구하기 위함)
    function centroid (points){
        var i, j, len, p1, p2, f, area, x, y;

        area = x = y = 0;

        for(i = 0, len = points.length, j=len-1; i<len; j = i++){
            p1 = points[i];
            p2 = points[j];

            f = p1.y * p2.x - p2.y * p1.x;
            x += (p1.x + p2.x) * f;
            y += (p1.y + p2.y) * f;
            area += f * 3;
        }

        return new kakao.maps.LatLng(x / area, y / area);
    }

    function deletePolygon(polygons, customOverlays){
        for(var i = 0; i<polygons.length; i++){
            polygons[i].setMap(null);
        }
        for(var i = 0; i<customOverlays.length; i++){
            customOverlays[i].setMap(null);
        }
        polygons = [];
        customOverlays = [];
    }
})