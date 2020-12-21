<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="en" var="en" />
    <fmt:message bundle="${loc}" key="ru" var="ru" />
    <fmt:message bundle="${loc}" key="news" var="newsList" />
    <fmt:message bundle="${loc}" key="add" var="addNews" />
    <fmt:message bundle="${loc}" key="view" var="view" />
    <fmt:message bundle="${loc}" key="edit" var="edit" />
    <fmt:message bundle="${loc}" key="delete_button" var="delete_button" />
</head>
<body>
<header>
    <table align="center" width="60%">
        <tr>
            <td colspan="3" ><h2>News Management</h2></td>
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
                    <td align="center"><a href="/main">${newsList}</a></td>
                </tr>
                <tr>
                    <td align="center"><a href="/createnews">${addNews}</a></td>
                </tr>
            </table>
        </td>
        <td>
            <form method="get" action="/deletenews">

                <table width="100%">
                    <c:forEach items="${listOfNews}" var="news">
                        <tr>
                            <th colspan="2" align="left"><c:out value="${news.title}"/></th>
                            <td colspan="3" align="center"><c:out value="${news.date}"/></td>
                        </tr>
                        <tr>
                            <td colspan="1"><c:out value="${news.brief}"/></td>
                        </tr>
                        <tr>
                            <td width="70%"></td>
                            <td width="12%"></td>
                            <td width="6%" align="center"><a href="viewnews?id=${news.id}"
                                                             name="view">${view}</a></td>
                            <td width="6%" align="center"><a href="editnews?id=${news.id}"
                                                             name="edit">${edit}</a></td>
                            <td width="6%" align="center"><input type="checkbox" name="deleteId" value="${news.id}">
                            </td>
                        </tr>
                        <tr>
                            <td><br><br></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <c:if test="${not empty listOfNews}">
                            <td align="right" colspan="5"><input type="submit" name="delete" value="${delete_button}"></td>
                        </c:if>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
</body>
</html>

