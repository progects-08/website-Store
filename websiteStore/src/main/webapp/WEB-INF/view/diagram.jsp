<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" 
 	rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" 
 	crossorigin="anonymous">
 	<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Все', '8'], 
          ['Отработано',     ${time}],
          ['Осталось',   ${8-time}]  
        ]); 

        var options = {
          title: 'Рабочее время',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
      </script> 
    <script>
   $(document).ready(function () {
        $(window).resize(function(){
            drawChart();
        });
    });
    </script> 

</head>
<body>


<a href="<c:url value="/logout"/>">Выйти</a> 
<div id="piechart_3d" style="width:'100%';height: 100% "></div>


</body>
</html>
