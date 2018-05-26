<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="bean" scope="request" type="ru.levelp.project.web.AddMatchComletedBean"/>
<html>
<head>
    <title>Match added</title>
</head>
<body>
 <h1> Match added </h1>

<div>
    <p> MatchID : ${bean.matchId}</p>
    <p> Tittle : ${bean.tittle}</p>
    <p> Team : ${bean.team}</p>
</div>
</body>
</html>
