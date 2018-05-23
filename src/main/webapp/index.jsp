<%@ page import="ru.levelp.project.module.Match" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:forEach var = "match" items="${indexBean.matches}" >
            <tr>
                <td>
                    ${match.matchId}
                </td>

                <td>
                        ${match.title}
                </td>
            </tr>
        </c:forEach>


        </tbody>

    </table>
    <a href = "addPart.jsp"> Add Matches</a>
</div>
</body>
</html>
