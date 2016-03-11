/*-------------------------------------
----------------LOGIN------------------
--------------------------------------*/

//auth
function autenticate(){
	window.location.href = 'singleApp.html';
}
//signup

//--------!!------------TO DO

//forgot passWord

//--------!!-----------TO DO


/*¨^^^^^------------------------------
---------------Sigle Page View ------
-------------------------------------*/

/* Principal 
----tipe:  0 list, 1 map ... more numbers for some new great ideas!
*/

function cardPrincipal(lugar, i, texto,img){
	$('#listTarjetas').append(
	  '<a class="tarjetaHtml" onclick="historia('+i+')">'+
      '<div class=" row well animated pulse tarjeta" >'+
          '<div class="col-xs-4 col-sm-3">'+
            '<img src="'+img+'" alt="" class="img img-responsive imgTarjeta">'+
          '</div>'+
          '<div class="col-xs-8 col-sm-9">'+
            '<h2 class="tarjetaTitle">'+texto+'</h2>'+
            '<p class="textOver">'+texto+'</small></p>'+

          '</div>'+  
      '</div>'+
      '</a>')
}

function principal(tipe){
	$('#payLoadSP').html('<div class="row listTarjetas" id="listTarjetas"></div>');

	$.getJSON( "./jsons/all.json", function( json ) {
		for ( var i in json){
			cardPrincipal(listTarjetas, i, json[i].texto,json[i].imagen)
		}

 });
}
function historia(id){
	console.log(id);
	$('#payLoadSP').html('<div class="row historia">'+
		'<div class="col-xs-12 col-sm-6">'+
		'<dic class="row">'+
		'<div class="col-xs-12 col-sm-offset-0  col-sm-11 col-md-9"><img class="img img-responsive img-rounded imgTarjeta" src="images/car.jpg" alt=""></div>'+
		'</dic>'+
		'</div>'+
		'<div class="col-xs-12 col-sm-6">'+
		'<h1 class="tarjetaTitle">Título de mi tarjeta</h1><span class="glyphicon glyphicon-star "></span>'+
		'<span class="glyphicon glyphicon-star-empty "></span>'+
		'<span class="glyphicon glyphicon-star-empty "></span>'+
		'<span class="glyphicon glyphicon-star-empty "></span>'+
		'<span class="glyphicon glyphicon-star-empty "></span>'+

		'<hr class="hrBar">'+

		'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore earum incidunt, libero itaque accusantium. Laudantium ad odit expedita mollitia inventore cupiditate non commodi velit nam dolorum maiores iusto accusantium pariatur esse officiis atque ratione est, rerum earum autem minima, modi!'+

		'<div class="row">'+
		'<div class="col-xs-10 col-xs-offset-1" >'+

		'<div class="wrapper" >'+

		'<div id="mapa"></div>'+

		'</div>'+

		'</div>'+
		'</div>'+

		'</div>'+
		'</div >');

create_map();

}


/*-----------------------
--------MAPS------------
----------------------*/
function create_map(tarea){
	var style = {
		fillColor: '#000',
		fillOpacity: 0.1,
		strokeWidth: 0
	};
	console.log("creando");
	var map = new OpenLayers.Map('mapa');
	var layer = new OpenLayers.Layer.OSM( "Simple OSM Map");

	var vector = new OpenLayers.Layer.Vector('vector');
	map.addLayers([layer, vector]);
	var markers = new OpenLayers.Layer.Markers( "Markers" );
	markers.id = "Markers";
	map.addLayer(markers);

	map.setCenter(
		new OpenLayers.LonLat(-3.704,40.416).transform(
			new OpenLayers.Projection("EPSG:4326"),
			map.getProjectionObject()
			), 12
		);

	map.events.register("click", map, function(e) {
      //var position = this.events.getMousePosition(e);
      var position = map.getLonLatFromPixel(e.xy);
      vector.removeAllFeatures();
      /*var size = new OpenLayers.Size(25,25);
   var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
   var icon = new OpenLayers.Icon('images/mark.png', size, offset);   
   var markerslayer = map.getLayer('Markers');
   markerslayer.clearMarkers();
   markerslayer.addMarker(new OpenLayers.Marker(position,icon));*/
   createMarker(position);

});

	var pulsate = function(feature) {
		var point = feature.geometry.getCentroid(),
		bounds = feature.geometry.getBounds(),
		radius = Math.abs((bounds.right - bounds.left)/2),
		count = 0,
		grow = 'up';

		var resize = function(){
			if (count>16) {
				clearInterval(window.resizeInterval);
			}
			var interval = radius * 0.03;
			var ratio = interval/radius;
			switch(count) {
				case 4:
				case 12:
				grow = 'down'; break;
				case 8:
				grow = 'up'; break;
			}
			if (grow!=='up') {
				ratio = - Math.abs(ratio);
			}
			feature.geometry.resize(1+ratio, point);
			vector.drawFeature(feature);
			count++;
		};
		window.resizeInterval = window.setInterval(resize, 50, point, radius);
	};

	var geolocate = new OpenLayers.Control.Geolocate({
		bind: false,
		geolocationOptions: {
			enableHighAccuracy: false,
			maximumAge: 0,
			timeout: 7000
		}
	});

	map.addControl(geolocate);
	var firstGeolocation = true;
	geolocate.events.register("locationupdated",geolocate,function(e) {
		vector.removeAllFeatures();
		console.log("event register");
		var circle = new OpenLayers.Feature.Vector(
			OpenLayers.Geometry.Polygon.createRegularPolygon(
				new OpenLayers.Geometry.Point(e.point.x, e.point.y),
				e.position.coords.accuracy/2,
				40,
				0
				),
			{},
			style
			);
		vector.addFeatures([
			new OpenLayers.Feature.Vector(
				e.point,
				{}
				),
			circle
			]);
		if (firstGeolocation) {
        //console.log(vector.getDataExtent());
        map.zoomToExtent(vector.getDataExtent());
        pulsate(circle);
        createMarker(map.getCenter());
        firstGeolocation = false;
        this.bind = true;
    }
});
	geolocate.events.register("locationfailed",this,function() {
		console.log("fuerita");
		OpenLayers.Console.log('Location detection failed');
	});



	var geolocalizar = function(){
		vector.removeAllFeatures();
		geolocate.deactivate();
    //console.log(geolocate);
    console.log("DAT CENTRO" + map.getCenter());
    geolocate.watch = false;
    firstGeolocation = true;
    geolocate.activate();
}
//document.onload(geolocalizar());

if (document.getElementById('locate')){

	document.getElementById('locate').onclick = function() {
		geolocalizar();

	};
}

var createMarker = function(position){
   //var position = map.getLonLatFromPixel(e.xy);
   var size = new OpenLayers.Size(25,25);
   var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
   var icon = new OpenLayers.Icon('images/mark.png', size, offset);   
   var markerslayer = map.getLayer('Markers');
   markerslayer.clearMarkers();
   markerslayer.addMarker(new OpenLayers.Marker(position,icon));

};

if (tarea){

	geolocalizar();
}
//$('#OpenLayers_Map_2_OpenLayers_ViewPort').css('position','ABSOLUTE')
}
