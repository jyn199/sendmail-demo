<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h2>SendMail!</h2>
<form action="/sendmail/send" method="post">
	收件人： <input type="text" name="mailTo" id="mailTo"/><br/>
	邮件主题： <input type="text" name="mailSubject" id="mailSubject"/><br/>
	邮件内容：<textarea name="content" id="content" rows="3" cols="50" placeholder="邮件内容"></textarea>
	<br/>
	<br/>
	<input type="submit">
</form>
</body>
</html>
