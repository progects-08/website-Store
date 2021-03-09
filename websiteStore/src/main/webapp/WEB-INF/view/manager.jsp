<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" 
 rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" 
 crossorigin="anonymous">
    <title>MANAGER</title>

</head>
<body>

<c:set var="romagueraList" value="${romagueraList}" />
<table class="table table-bordered">
<thead>
    <tr>
      <th>N</th>
      <th>Name</th>
      <th>Username</th>
      <th>Email</th>
    </tr>
  </thead>
<c:forEach items="${romagueraList}" var="romaguera">
		<c:set var="number" value="${number+1}" />
			<tr>
				<td> <c:out value="${number}"/></td>
				<td>${romaguera[0]}</td>
				<td>${romaguera[1]}</td>
				<td>${romaguera[2]}</td>
			</tr>
		</c:forEach>
</table>		

<a href="<c:url value="/logout"/>">Выйти</a> 
</body>
</html>
