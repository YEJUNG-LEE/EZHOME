$(document).ready(function(){
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(37.51350466672024, 127.00823440764121),
			level: 3
		};
		var map = new kakao.maps.Map(container, options);
})