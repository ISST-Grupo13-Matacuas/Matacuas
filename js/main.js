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

function cardPrincipal(lugar,texto){
	$('#listTarjetas').append(
	  '<a class="tarjetaHtml" onclick="historia(id)">'+
      '<div class=" row well animated pulse tarjeta" >'+
          '<div class="col-xs-4 col-sm-3">'+
            '<img src="images/download.jpeg" alt="" class="img img-responsive imgTarjeta">'+
          '</div>'+
          '<div class="col-xs-8 col-sm-9">'+
            '<h2 class="tarjetaTitle">'+texto+'</h2>'+
            '<p class="textOver">'+texto+'</small></p>'+

          '</div>'+  
      '</div>'+
      '</a>')
}

function principal(tipe){
	console.log("a");
	$('#payLoadSP').html('<div class="row listTarjetas" id="listTarjetas">xcxz</div>');


	$.getJSON( "./jsons/all.json", function( json ) {

		console.log(json.length);
		for ( var i in json){
			console.log(json[i].texto);
			cardPrincipal(listTarjetas, json[i].texto)
		}

  console.log( "JSON Data: " + json);
 });
}