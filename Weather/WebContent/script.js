var word=null;
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
	    xmlhttp.open('GET',"http://localhost:8081/Weather/weather?city="+word, true);
	    xmlhttp.send();
		/*xmlhttp.onreadystatechange = function(){
		    if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
		    
		    }
		    };*/
		    }