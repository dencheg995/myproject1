<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="AddBean" type="ru.levelp.project.web.AddMatchBean" scope="application" />
<html>
<head>
    <title>Add Match</title>
</head>
<body>
    <form method ="post" action="/Add-Matches" enctype="application/x-www-form-urlencoded" >
        <p>MatchId : <input type = "text" name="matchId"></p>
        <p>Title : <input type = "text" name = "title"></p>
        <p>Team :
            <select name = "team">
                <c:forEach var = "Team" items = "${AddBean.team}">
                    <option value="${Team.id}">${Team.name} </option>
                </c:forEach>

            </select>

        </p>
        <input type = "submit">
    </form>

</body>
</html>
