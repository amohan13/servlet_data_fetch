var word=null;
var citynames=null;
function getData(){
	var xmlHttp = new XMLHttpRequest();
	word=document.getElementById("data").value;
	var url ="http://api.openweathermap.org/data/2.5/weather?q="+word+"&appid=4f51cc3581658734467f957800c7625d";
	xmlHttp.open("GET",url, true);
	xmlHttp.send();
	xmlHttp.onreadystatechange = function() {
	   if(this.readyState == 4 && this.status == 200){
	       var myArr= JSON.parse(this.responseText);
	       var dataObj= JSON.stringify(myArr);
	      //document.write(dataObj);
	       document.getElementById("show").innerHTML = "Max_Temprature"+ myArr.main.temp_max +"<br>"+"Humidity" +myArr.main.humidity +"<br>"+" Visibility" + myArr.visibility;
	   }
	};
	console.log(word);
	}

	function servlet_ajax(){
		console.log(word);
		var xmlhttp = new XMLHttpRequest();
	    xmlhttp.open('GET',"http://localhost:8081/weather24/weather?city="+word, true);
	    xmlhttp.send();
		/*xmlhttp.onreadystatechange = function(){
		    if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
		    
		    }
		    };*/
		    }
	function getprevious(city) {
		
		var xmlHttp = new XMLHttpRequest();
		word = city;
		console.log(word);
		var url = "http://api.openweathermap.org/data/2.5/weather?q=" + word
				+ "&appid=4f51cc3581658734467f957800c7625d";
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var myArr = JSON.parse(this.responseText);
				var Obj = "Maximum Temperature " + myArr.main.temp_max + "F"
						+ '<br>' + " Minimum Temperature " + myArr.main.temp_min
						+ "F" + '<br>' + " Current Temperature " + myArr.main.temp
						+ "F" + '<br>' + " Humidity " + myArr.main.humidity + "%";
				var showfav=document.getElementById("show");
				showfav.insertAdjacentHTML('afterend','<div class="card mt-4">'+
				'<div class="card-header" id=\'' + "title" + '\'></div>'+
				'<div class="card-body">'+
					'<p class="card-text" id=\'' + "auth" + '\' ></p>'+
					'</div>'+	
				'</div>');
			
			    console.log("haha"+city);
				document.getElementById("title").innerHTML =city;
				document.getElementById("auth").innerHTML = Obj;
			}
		};
		

	}
	function ShowFavourite() {
		console.log("in new");
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var myArr=JSON.parse(this.responseText);
				citynames = myArr.city;
				console.log(citynames);
				$('#show').empty();
				$('#show').append("<ul>");
				for (var i = 0; i < citynames.length; i++) {
					$('#show').append("<li>"+citynames[i]+"</li>");
					getprevious(citynames[i]);
				}
				$('#show').append("</ul>");
				
			
			}
		};
		console.log("in  again new");
		xmlhttp.open('GET', "http://localhost:8081/weather24/ShowFavourite",
				true);
		xmlhttp.send();
		
	}
