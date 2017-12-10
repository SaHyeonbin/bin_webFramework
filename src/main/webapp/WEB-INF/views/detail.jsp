<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성적 상세 보기</title>
<link rel="stylesheet" type="text/css" href="resources/css/type.css" >
</head>
<body>
<table>

<tr><td>수강 년도</td><td>학기</td><td>교과 코드</td><td>교과목명</td><td>구분</td><td>학점</td></tr>
<c:forEach var="course" items="${courses}">
<tr><td><c:out value="${course.year}"/></td><td><c:out value="${course.seme}"/></td>
<td><c:out value="${course.code}"/></td><td><c:out value="${course.title}"/></td>
<td><c:out value="${course.divi}"/></td><td><c:out value="${course.grades}"/></td></tr>
</c:forEach>
</table>
</body>
</html>