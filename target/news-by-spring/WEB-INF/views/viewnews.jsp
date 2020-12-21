<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc"/>
    <fmt:message bundle="${loc}" key="en" var="en"/>
    <fmt:message bundle="${loc}" key="ru" var="ru"/>
    <fmt:message bundle="${loc}" key="news" var="newsList"/>
    <fmt:message bundle="${loc}" key="add" var="addNews"/>
    <fmt:message bundle="${loc}" key="view" var="view"/>
    <fmt:message bundle="${loc}" key="edit" var="edit"/>
    <fmt:message bundle="${loc}" key="edit_button" var="edit_button"/>
    <fmt:message bundle="${loc}" key="delete_button" var="delete_button"/>
</head>
<body>
<header>
    <table align="center" width="60%">
        <tr>
            <td colspan="3"><h2>News Management</h2></td>
        </tr>
        <tr>
            <td></td>
            <td width="9%" align="center"><a href="/changeLocale?locale=en">${en}</a></td>
            <td width="9%" align="center"><a href="/changeLocale?locale=ru">${ru}</a></td>
        </tr>
    </table>
</header>
<table align="center" width="60%" border="1">
    <tr>
        <td valign="top" width="15%">
            <table align="center">
                <tr>
                    <td><a href="/main">${newsList}</a></td>
                </tr>
                <tr>
                    <td><a href="/createnews">${addNews}</a></td>
                </tr>
            </table>
        </td>
        <td>
            <table width="100%">
                <tr>
                    <td>Title</td>
                    <td colspan="2">${news.title}</td>
                </tr>
                <tr>
                    <td>Date</td>
                    <td colspan="2">${news.date}</td>
                </tr>
                <tr>
                    <td>Brief</td>
                    <td colspan="2">${news.brief}</td>
                </tr>
                <tr>
                    <td>Content</td>
                    <td colspan="2">${news.content}</td>
                </tr>
                <tr>
                    <td><br><br></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right">
                        <form action="/editnews?id=${news.id}" method="post">
                            <input type="submit" name="edit" value="${edit_button}">
                        </form>
                    </td>
                    <td>
                        <form action="/deletenews" method="post">
                            <input type="hidden" name="command" value="delete">
                            <input type="hidden" name="deleteId" value="${news.id}">
                            <input type="submit" name="delete" value="${delete_button}">
                        </form>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
