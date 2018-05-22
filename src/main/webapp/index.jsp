<%@ page import="ru.levelp.project.module.Match" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" %>
<jsp:useBean id="indexBean" type="ru.levelp.project.web.IndexBean" scope="application"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello!</h1>

<div>
    <table>
        <tbody>
        <% for(Match match : indexBean.getMatches()){ %>
        <tr>
            <td>
                <%= match.getMatchId()%>
            </td>
            <td>
                <%= match.getTitle()%>
            </td>
        </tr>
        <% } %>
        </tbody>

    </table>
</div>
</body>
</html>
