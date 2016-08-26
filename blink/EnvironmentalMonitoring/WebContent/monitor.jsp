<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实时数据监测</title>
<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
<script type="text/javascript">
var xmlHttpRequest;
function createXmlHttpRequest(){
	if(window.XMLHttpRequest){
		xmlHttpRequest =new XMLHttpRequest;
	}else if(window.ActiveXObject){
		xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
}
function search(){
	var url="/EnvironmentalMonitoring/myServlet";
	createXmlHttpRequest();
	xmlHttpRequest.onreadystatechange=callback;
	xmlHttpRequest.open("POST",url,true);
	xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlHttpRequest.send("submit=monitor");
}
function callback(){
	if((xmlHttpRequest.readyState==4)&&(xmlHttpRequest.status==200)){
		
		
		document.getElementById("myForm").innerHTML=xmlHttpRequest.responseText;
		setTimeout(search,300);
		
	}
	
}
</script>


</head>




<body class="templatemo-bg-gray" onload="search()" background="img/app_bg.jpg"  style="background-position:center top;background-size:cover;  ">
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">实时监测</h1>
			<form id="myForm" name="form1" class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30"  action="/EnvironmentalMonitoring/myServlet?submit=login" method="post" onSubmit="return check();">				
 
		         
		         
		      </form>
		      
		</div>
	</div>
	
	
	
</body>
</html>