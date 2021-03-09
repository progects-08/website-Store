<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" 
 rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" 
 crossorigin="anonymous">
    <title>USER</title>

<style type="text/css">
.form form {
  width: 300px;
  margin: 0 auto;
  padding-top: 200px;
}
</style>
 
  
</head>
<body>

<div class="form">

<form action="/websiteStore/diagram" method="get" >
  <div class="row">
  
    <label for="workTime" class="control-label">Отработанное время:</label>
   
    <div class="col">
      <input type="text" name = "time"  required class="form-control"  pattern="[0-8]*" title="Введите целое число от 0 до 8">
    </div>
    <div class="col">
      <input type="submit" value="Ок" class="btn btn-primary mb-2" >
    </div>
     
  </div>
  <a href="<c:url value="/logout"/>">Выйти</a> 
</form>
</div>


</body>
</html>

