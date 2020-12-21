<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Edit news</title>
    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="locale" var="loc" />
    <fmt:message bundle="${loc}" key="en" var="en" />
    <fmt:message bundle="${loc}" key="ru" var="ru" />
    <fmt:message bundle="${loc}" key="news" var="newsList" />
    <fmt:message bundle="${loc}" key="add" var="addNews" />
    <fmt:message bundle="${loc}" key="cancel_button" var="cancel_button" />
    <fmt:message bundle="${loc}" key="save_button" var="save_button" />
    <fmt:message bundle="${loc}" key="validation_error" var="validation_error" />
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
            <form:form action="/edit" modelAttribute="news" method="post">
                <form:hidden path="id" />
                News Title <form:input path="title" value="${news.title}"/><br>
                Brief      <form:input path="brief" value="${news.brief}"/><br>
                Content    <form:input path="content" value="${news.content}"/><br>
                <input type="button" name="cancel" value="${cancel_button}" onclick='location.href="/main"'>
                <input type="submit" name="save" value="${save_button}">
            </form:form>
        </td>
    </tr>
    <tr>
        <td width="15%"></td>
        <td align="center" >
            <c:if test="${validationError != null}">
                <span style="color: red; font-size: x-large">${validation_error}</span>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
