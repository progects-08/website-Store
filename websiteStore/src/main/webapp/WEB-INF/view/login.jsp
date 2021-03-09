<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" 
 rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" 
 crossorigin="anonymous">
    <title>Login</title>
<style type="text/css">
.form form {
  width: 300px;
  margin: 0 auto;
  padding-top: 100px;
}
</style>
</head>
<body>

   <!--  <div class="form">

        <h1>Вход в систему</h1><br>
        <form method="post" action="">

            <input type="text" required placeholder="login" name="login"><br>
            <input type="password" required placeholder="password" name="password"><br><br>
            <input class="button" type="submit" value="Войти">

        </form>
    </div>-->
    
    
    <div class="form">
<form class="form-horizontal" role="form" method="POST">
  
    <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Логин</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="login">
    </div>
  </div>
  <br>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Пароль</label>
    <div class="col-sm-10">
      <input type="password" class="form-control"  name="password">
    </div>
  </div>
<br>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary mb-2">Войти</button>
    </div>
  </div>  
</form>
</div>




</body>
</html>
