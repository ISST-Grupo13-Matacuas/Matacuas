/*-------------------------------------
----------------LOGIN------------------
--------------------------------------*/
function closeSidebar(){
  var bar = $('.sidebar');
  console.log(bar);
  if(bar.hasClass('sidebar-open')){
    bar.removeClass('sidebar-open');
    console.log("sacada");
  }

}
//auth
function autenticate(){
	//window.location.href = 'singleApp.html';
	window.location.href = 'singleApp';
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
	var lugarb = '#'+lugar;
	$(lugarb).append(
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
	/*$('#payLoadSP').html('<div class="row listTarjetas" id="listTarjetas"></div>');

	$.getJSON( "./jsons/all.json", function( json ) {
		for ( var i in json){
			cardPrincipal('listTarjetas', i, json[i].texto,json[i].imagen)
		}

 });*/
	
	/*$('#payLoadSP').html('<div class="row listTarjetas" id="listTarjetas">'+
		'<c:if test="${not empty quejas }">'+
			'<c:forEach items="${quejas}" var="queja">'+
			
			'<a class="tarjetaHtml" onclick="">'+
				'   <div class=" row well animated pulse tarjeta" >'+
				 '  <div class="col-xs-4 col-sm-3">'+
				  ' <img src="/images/car.jpg" alt="" class="img img-responsive imgTarjeta">'+
				   '</div>'+
				   '<div class="col-xs-8 col-sm-9">'+
				   '<h2 class="tarjetaTitle"><c:out value="${queja.lugar}"/> </h2>'+
				   '<p class="textOver"><c:out value="${queja.descripcion }"/></small></p>'+
				
				   '</div>  '+
				   '</div>'+
				   '</a>'+
				
				
				
		'</c:forEach>'+
		'</c:if>'+
	
	'</div>');*/
	
	
  closeSidebar()
}
function historia(id){
	console.log(id);
	$('#payLoadSP').html('<div class="row historia">'+
		'<div class="col-xs-12 col-sm-6">'+
		'<div class="row">'+
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
closeSidebar()

}

function cardProfile(lugar,tipo){
  var lugarb = '#'+lugar;
  var cardCode = '<div class=" row well animated pulse tarjeta" >'+
   '<div class="col-xs-4 col-sm-3 col-md-2">'+
   '<img src="images/download.jpeg" alt="" class="img img-responsive imgTarjeta">'+
   '</div>'+
   '<div class="col-xs-6 col-sm-7">'+
   '<h3 class="tarjetaTitle">Título de mi tarjeta</h3>'+
   '<p><small>location Lorem ipsum dolor sit amet.</small></p>'+

   '</div>';
   if(tipo < 1){
    cardCode +=   '<div class="col-xs-2  text-center">'+
   '<div class="positiveCard"><span class="glyphicon glyphicon-thumbs-up"></span></div>'+  
    '</br>'+
  '<div class="toolsCard"><span class="glyphicon glyphicon-pencil"></span></div>'+  
   '</br>'+
  '<div class="deleteCard"><span class="glyphicon glyphicon-trash"></span></div>'+  
   '</div>';
   } else{
      cardCode +=   '<div class="col-xs-2  text-center">'+
   '<div class="deleteCard"><span class="glyphicon glyphicon-exclamation-sign"></span></div>'+  
    '</br>'+
  '<div class="toolsCard"><span class="glyphicon glyphicon-save-file"></span></div>'+  
   '</div>';
   }

    cardCode += '</div>';

  $(lugarb).append(cardCode);

}

function profile(){
	$('#payLoadSP').html('<div class="row listTarjetasPerf">'+
   '<div class=" row well animated pulse tarjeta">'+
   '<div class="col-xs-4 col-xs-offset-4 box-img-perfil">'+
   '<img src="https://randomuser.me/api/portraits/med/men/44.jpg" alt="" class="img img-responsive imgTarjeta img-circle img-perfil" style="position: absolute;">'+
   '</div>'+
   '<div class="col-xs-8" style="z-index: 100;">'+
   '<br>'+
   '<br>'+
   '<br>'+
   '<h4 class="nombrePerfil">@JuanitoTaxiCrazy</h4>'+
   '</div>'+
   '<div class="col-xs-4 text-center">'+
   '<br>'+
   '<h4>Karma:</h4>'+
   '<p>+5</p>'+
   '</div>'+
   '<br>'+
   '<div class="col-xs-12">'+
   '<br>'+
   '<hr  style="    height: 0.2vh;'+
   'background-color: #26A4FF">'+
   '</div>'+
   '<div class="col-xs-12">'+
   '<p class="textOver">Conduzco mi Taxi mientras escucho los partidos del equipo de mi barrio por la radio!</p>'+
   '<p><small>Lepe, Españama</small></p>'+

   '</div>'+  
   '</div>'+

   '<div class=" row well animated pulse tarjeta" >'+
   '<div class="col-xs-4" ><button class="btn btn-block" style="background-color: #AAC">Todos</button></div>'+
   '<div class="col-xs-4" ><button class="btn btn-block" style="background-color: #5C5">Positivos</button></div>'+
   '<div class="col-xs-4" ><button class="btn btn-block" style="background-color: #C55">Negativos</button></div>'+
   '</div>'+
   '<div id="ProfileList"></div>'+

   '</div>');
cardProfile('ProfileList',0);
cardProfile('ProfileList',0);
cardProfile('ProfileList',0);
cardProfile('ProfileList',0);
closeSidebar()
}

function newQueja(tipo){
  var nombre = "Nueva queja";
  color = '#C55';
  if (tipo === 2){
    nombre = "Buena acción";
    color = '#5C5';
  }

  $('#payLoadSP').html(
   '<div  class="caja col-xs-8 col-xs-offset-2 text-center  well animated bounceInDown" style="border: solid 0.5vh '+color+';">'+
   '<div class="row">'+
   '<h1 class="LoginText">'+ nombre +'</h1>'+
   '<div class="row">'+
   '<div class="col-xs-10 col-xs-offset-1">'+
   '<button class="btn-login btn" id="locate">Locate me!</button>'+
   '<div class="wrapper">'+
   '<div id="mapa"></div>'+
   '</div>'+
   '</div>'+
   '</div>'+
   '</div>'+

   '<div class="row">'+
   '<div class="col-xs-10 col-xs-offset-1">'+
   '<p>Describa la infracción</p>'+

   '<textarea class="form-control " rows="3">'+

   '</textarea>'+
   '</div>'+
   '</div>'+

   '<div class="row">'+
   '<div class="col-xs-10 col-xs-offset-1">'+
   '<form enctype="multipart/form-data">'+
   '<div class="form-group">'+
   '<input id="file-3" type="file" multiple=true>'+
   '</div>'+
   '<div class="form-group">'+
   '<button class="btn  btn-login">Submit</button>'+
   '<button class="btn  btn-gris" type="reset">Reset</button>'+
   '</div>'+
   '</form>'+
   '</div>'+
   '</div>'+
   '</div>');
create_map(1);
closeSidebar()


}

function settings(){
  $('#payLoadSP').html('<div class="row listTarjetasPerf">'+


   '<div class=" row well animated pulse tarjeta">'+
   '<div class="row">'+
   '<div class="col-xs-12 col-sm-4">'+
   '<div class="row">'+
   '<div class="col-xs-6 col-sm-12">'+
   '<img src="https://randomuser.me/api/portraits/med/men/44.jpg" alt="" class="img img-responsive imgTarjeta img-circle">' +
   '</div>'+
   '<div class="col-xs-6  col-sm-12">' +
   ' <h2>change image</h2>'+
   '</div>'+
   '</div>'+
   '</div>'+
   '<div class="col-xs-12 col-sm-8">'+
   '<div class="row">'+
   '<div class="col-xs-12 text-center">'+
   '<h3>Información</h3>'+
   '</div>'+

   '<div class="col-xs-12">'+
   '<form autocomplete="off" class="form-horizontal" role="form">'+
   '<div class="form-group">'+
   '<label class="control-label col-sm-2" for="alias">Alias:</label>'+
   '<div class="col-sm-10">'+
   '<input type="text" autocomplete="off" class="form-control" id="alias" placeholder="@JuanitoTaxiCrazy">'+
   '</div>'+
   '</div>'+
   '<div class="form-group">'+
   '<label class="control-label col-sm-2" for="bio">Bio:</label>'+
   '<div class="col-sm-10">'+
   '<textarea class="form-control" rows="4"  placeholder="Conduzco mi Taxi mientras escucho los partidos del equipo de mi barrio por la radio!" ></textarea>'+
   '</div>'+
   '</div>'+
   '<div class="form-group">'+
   '<label class="control-label col-sm-2" for="mail">Email:</label>'+
   '<div class="col-sm-10">'+
   '<input type="mail" autocomplete="off" class="form-control" id="mail" placeholder="taxiCrazy@lepeTAxi.lp">'+
   '</div>'+
   '</div>'+

   '<hr>'+
   '<div class="col-xs-12 text-center">'+
   '<h3>Notificaciones</h3>'+
   '</div>'+
   '<div class="form-group">'+
   '<div class="col-xs-4 col-xs-offset-4">'+
   '<input type="checkbox" data-toggle="toggle" data-on="activas" data-off="inactivas" id="not" data-onstyle="success" data-offstyle="danger">'+
   '</div>'+
   '</div>'+
   '<hr>'+
   '<div class="col-xs-12 text-center">'+
   '<h3>Seguridad</h3>'+
   '</div>'+


   '<div class="form-group text-center">'+
   '<label class="control-label col-xs-12  col-sm-5  col-md-6 text-center" for="pass1">Password:</label>'+
   '<div class="col-xs-12 col-sm-7 col-md-6">'+
   '<input type="password" autocomplete="off" class="form-control" id="pass1" placeholder="">'+
   '</div>'+
   '</div>'+
   '<div class="form-group">'+
   '<label class="control-label col-xs-12 col-sm-5 col-md-6 text-center" for="pass2">Repite password:</label>'+
   '<div class="col-xs-12 col-sm-7 col-md-6">'+
   '<input type="password" autocomplete="off" class="form-control" id="pass2" placeholder="">'+
   '</div>'+
   '</div>'+

   '<br>'+

   '<div class="form-group">'+
   '<div class="col-xs-2 col-xs-offset-2">'+

   '<button type="submit" class="btn btn-default btn-valid" onclick="profile();">Guardar</button>'+
   '</div>'+
   '<div class="col-xs-2 col-xs-offset-2">'+

   '<button type="submit" class="btn btn-default  btn-cancel" onclick="profile();">Cancelar</button>'+
   '</div>'+
   '</div>'+
   '</form>'+

   '</div>'+
   '</div>'+
   '</div>'+

   '</div>'+


   '</div>'+
   '</div>');
closeSidebar()


}

function notification() {
  $('#payLoadSP').html('<div class="row listTarjetasPerf">'+
    '<div id="ProfileList"></div>'+
    '</div>');
  cardProfile('ProfileList',1);
  cardProfile('ProfileList',1);

  closeSidebar()

}



/*-----------------------
--------MAPS------------
----------------------*/
function create_map(tarea, position, coordenadas){
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

	
	if (position){
		map.setCenter(
				new OpenLayers.LonLat(position.lon,position.lat),15);
	}
	
	else{
		map.setCenter(
				new OpenLayers.LonLat(-3.704,40.416).transform(
					new OpenLayers.Projection("EPSG:4326"),
					map.getProjectionObject()
					), 11
				);
	}
	
	
/*	map.events.register("click", map, function(e) {
      //var position = this.events.getMousePosition(e);
      var position = map.getLonLatFromPixel(e.xy);
      
      vector.removeAllFeatures();
      
   
      createMarker(position);

 });*/

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
        var longitud = map.getCenter().lon;
        var latitud = map.getCenter().lat;
        document.getElementById("longitud").value=''+longitud;
        document.getElementById("latitud").value=''+latitud;
        console.log("Punto: " + map.getCenter());
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
    var longitud = map.getCenter().lon;
    var latitud = map.getCenter().lat;
    
  //  document.getElementById("longitud").value=''+longitud;
   // document.getElementById("latitud").value=''+latitud;
   // $('#longitud').html(map.getCenter().lon);
   // $('#latitud').html(map.getCenter().lat);
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
	console.log("Creando marcador en: " + position);
   var size = new OpenLayers.Size(50,50);
   var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
   var icon = new OpenLayers.Icon('images/mark.png', size, offset);   
   var markerslayer = map.getLayer('Markers');
   //markerslayer.clearMarkers();
    markerslayer.addMarker(new OpenLayers.Marker(position,icon));
   
  

 };
 
 

 if (tarea){

   geolocalizar();
 }
 if (position){
	 console.log("Posición: " + position);
	 console.log("Longitud: " + position.lon);
	 console.log("Latitud: " + position.lat);
	/* var proj = new OpenLayers.Projection("EPSG:4326");
	 var point = new OpenLayers.LonLat(position.lon, position.lat);
	 point.transform(proj, map.getProjectionObject());
	 console.log("Point: " + point);*/

	 createMarker(position);
 }
 if (coordenadas){
	 //console.log("Ola ke ase " + coordenadas);
	 var size = new OpenLayers.Size(50,50);
	 var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
	 var icon = new OpenLayers.Icon('images/mark.png', size, offset);   
	 var markerslayer = map.getLayer('Markers');
	 var position = {lat:0, lon:0};
	  
	 
	 for (var i = 0; i<coordenadas.length; i++){
		 position.lat = coordenadas[i].lat;
		 position.lon = coordenadas[i].lng;
		 var marker = new OpenLayers.Marker(new OpenLayers.LonLat(position.lon, position.lat), icon.clone());
		 markerslayer.addMarker(marker);
		 
		 
		 //console.log(position);
		 //createMarker(position,i);
	 }
	 
	   
	  // var marker = new OpenLayers.Marker(new OpenLayers.LonLat(-414204.57813,4927313.34394), icon.clone());
	  // markerslayer.addMarker(marker);
	  // var marker = new OpenLayers.Marker(new OpenLayers.LonLat(-414897,4931584), icon.clone());
	  // markerslayer.addMarker(marker);
 }
 
 
 
//$('#OpenLayers_Map_2_OpenLayers_ViewPort').css('position','ABSOLUTE')
}



