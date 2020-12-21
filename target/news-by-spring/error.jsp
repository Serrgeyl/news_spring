<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title></title>
    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="en" var="en" />
    <fmt:message bundle="${loc}" key="ru" var="ru" />
    <fmt:message bundle="${loc}" key="news" var="newsList" />
    <fmt:message bundle="${loc}" key="add" var="addNews" />
    <fmt:message bundle="${loc}" key="error_message" var="error_message" />
</head>
<body>
<header>
    <table align="center" width="60%">
        <tr>
            <td colspan="3"><h2>News Management</h2></td>
        </tr>
        <tr>
            <td></td>
            <td width="9%" align="center"><a href="/index?command=setLocale&lang=en">${en}</a></td>
            <td width="9%" align="center"><a href="/index?command=setLocale&lang=ru">${ru}</a></td>
        </tr>
    </table>
</header>

<table align="center" width="60%" border="1">
    <tr>
        <td valign="top" width="15%">
            <table align="center" border="1">
                <tr>
                    <td><a href="/main">${newsList}</a></td>
                </tr>
                <tr>
                    <td><a href="/createnews">${addNews}</a></td>
                </tr>
            </table>
        </td>
        <td>
            <h2>${error_message}</h2>
        </td>
    </tr>
</table>
</body>
</html>
