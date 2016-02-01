<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="login" />

<fmt:message key="window_title" var="window_title" />

<jsp:include page="header.jsp">
    <jsp:param name="window_title" value="${window_title}" />
</jsp:include>

<div class="page-header">
    <h1>Connexion à HSECU</h1>
</div>

<form method="post" action="Authenticate">
    <div class="form-group">
        <label for="login"><fmt:message key="login" /></label> <input
            class="form-control" type="text" id="login" name="login"
            placeholder="<fmt:message key="placeholder_login"/>" />
    </div>
    <div class="form-group">
        <label for="pass"><fmt:message key="pass" /></label> <input
            class="form-control" type="password" id="pass" name="pass"
            placeholder="<fmt:message key="placeholder_pass"/>" />
    </div>
    <div class="form-group">
        <input class="btn btn-primary" type="submit"
               value="<fmt:message key="submit"/>" />
    </div>
</form>

<jsp:include page="footer.jsp" />