<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성적확인</title>
<link rel="stylesheet" type="text/css" href="resources/css/type.css" >
</head>
<body>

<table>
<tr><td>년도</td><td>학기</td><td>이수 학점</td><td>상세 보기</td></tr>
<c:forEach var="course" items="${courses}">
<tr><td><c:out value="${course.year}"/></td><td><c:out value="${course.seme}"/>
</td><td><c:out value="${course.grades}"/></td><td><a href="/HelloManage/detail?${course.year}&${course.seme}">링크</a></td></tr>
</c:forEach>
</table>
<table>
<c:set var = "sum" value = "0" />
<tr><c:forEach var="divi" items="${divi}"><td><c:out value="${divi.divi}"/></c:forEach><td>합계</td></tr>
<tr><c:forEach var="divi" items="${divi}"><td><c:out value="${divi.grades}"/></td><c:set var= "sum" value="${sum + divi.grades}"/>
</c:forEach><td><c:out value="${sum}"/></td></tr>
</table>
</body>
</html>