<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src='<c:url value="/resources/js/jquery.min.js"/>'></script>
<script type="text/javascript">
</script>
</head>
<body>
    <p>spring mvc 测试-注册页</p>
    <div>
        <form action="addadmin.action" "method="post">
            用户名：<input name="name"/> <br>
            年	 齡： <input name="age"/> <br>
            地	 址： <input name="address"/> <br>
                <input type="submit" value="注册"/>
        </form>
    </div>
</body>
</html>