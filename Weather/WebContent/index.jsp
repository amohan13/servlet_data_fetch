<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">

<title>Weather Report</title>

</head>

<body>
<div class="container">
    <div class="row">
        <h3 class="text-center text-primary">Enter City name</h3>
        <span id="error"></span>
    </div>

    <div class="row form-group form-inline text-center">
        <input type="text" name="city" class="form-control" id="data" placeholder="city Name">    
        <button id="submitWeather" class="btn btn-primary" onclick="getData()">Search city</button>
        <button id="data_weather" class="btn btn-primary" onclick="servlet_ajax()">ADD TO FAVOURITE</button>
    </div>
   <div id="show"> </div>
   <div id="addtofav"> </div>
</div>
 

<script type="text/javascript" src="script.js"></script>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>