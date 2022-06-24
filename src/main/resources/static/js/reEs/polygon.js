
// 행정구역 구분

$.getJSON('../sig.geojson', function(geojson){
    var data = geojson.features;
    var coordinates = []; // 좌표 저장할 배열
    var name = '';  //행정 구 이름

    $.each(data, function(index, val){
        coordinates = val.geometry.coordinates;
        name = val.properties.SIG_KOR_NM;

        displayArea(coordinates. name);
    })
})

var polygons=[];

// 행정구역 폴리곤
function displayArea(coordinates, name){

    var path = [];
    var points = [];

    $.each(coordinates[0], function(index, coordinate){
        var point = new Object();
        point.x = coordinate[1];
        point.y = coordinate[0];
        points.push(point);
        path.push(new daum.maps.LatLng(coordinate[1], coordinate[0]));
    })

    // 다각형을 생성합니다
    
}