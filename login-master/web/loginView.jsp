<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 3/13/2019
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<h3>Login Page</h3>



<form method="POST" action="login">


            <label>User Name</label>
            <input type="text" name="userName" value= "${cookie.name.value}" /> <br>

            <label>Password</label>
            <input type="password" name="password" value= "" />

            <input type="checkbox" name="check"  /><label>Password</label>


                <input type="submit" value= "Submit" />


            <p>${errorMessage}</p>
    </table>
</form>

</body>
</html>