<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href=".¥common.css">
<style>
body{
	background: #e0e0e0;
	text-align: center;
	font-family: Arial,sans-serif;
}
#btn{

	width:200px;
	padding: 7px;
	color: #fff;
	border-radius: 5px;
	box-shadow: 0 4px 0 #0088cc;
	background: #00aaff;
	cursor: pointer;
	margin:0 auto;
}
#btn:hover{
	opacity: 0.5;
}
</style>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	<P>  The time on the server is ${serverTime}. </P>
	<div id="btn">参加する</div>
</body>
</html>
