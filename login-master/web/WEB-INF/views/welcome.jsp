<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 3/13/2019
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
<%
if(session.getAttribute("user")==null){
   // response.sendRedirect("login");
}
%>
Welcome in friend!!!
<a href="/logout">Logout</a>
</body>
</html>
