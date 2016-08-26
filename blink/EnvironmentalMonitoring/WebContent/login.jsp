<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中小学环境监测与预警系统</title>
<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
	
</head>
<script type="text/javascript">

function check(){
	var username = document.getElementsByName("user_name")[0].value;
	var password = document.getElementsByName("user_password")[0].value;

	
	if(username==""){
	alert("请输入用户名！");
		return false;
	}
	if(password==""){
	alert("请输入密码！");
	return false;
	}
	
	
}
</script>


<%String message = String.valueOf(request.getAttribute("message"));

%>
<body class="templatemo-bg-gray" background="img/login_bg.png"  style="background-position:center top;background-size:cover;  " >
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">中小学环境监测与预警系统</h1>
			<form name="form1" class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30"  action="/EnvironmentalMonitoring/myServlet?submit=login" method="post" onSubmit="return check();"> 			
		        <div class="form-group">	     
		          <div class="col-xs-12">		            
		            <div class="control-wrapper">
		            	<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            	<input type="text" class="form-control" name="user_name" placeholder="用户名">
		            	
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		            	<input type="password" class="form-control" name="user_password" placeholder="密 码">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
	             	<div class="checkbox control-wrapper">
	                	<label>
	                  		<input type="checkbox"> 记住账号
                		</label>
	              	</div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<input type="submit" value="登陆" class="btn btn-info">
		          		<a href="forgetPassword.jsp" class="text-right pull-right">忘记密码?</a>
		          	</div>
		          </div>
		        </div>
		        <hr>
		        <div class="form-group">
		        	<div class="col-md-12">
		        		<label>其他的登陆方式： </label>
		        		<div class="">
		        			<a href="https://passport.weibo.com/othersitebind/authorize?entry=miniblog&site=qq"><i class="fa fa-facebook-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-twitter-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-google-plus-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-tumblr-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-github-square login-with"></i></a>
		        		</div>		        		
		        	</div>
		        </div>
		      </form>
		      <div class="text-center">
		      	<a href="regist.jsp" class="templatemo-create-new">注册新用户 <i class="fa fa-arrow-circle-o-right"></i></a>	
		      </div>
		</div>
	</div>
	
	
	
</body>
</html>
<%String sure = String.valueOf(request.getAttribute("sure")); %>
<script type="text/javascript">
var sure0="<%=sure%>";
if(sure0!=="null"){
	alert(sure0);
	
}
</script>