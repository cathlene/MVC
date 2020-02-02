<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head><title>CustomerForm</title>
<style>
.error{color:red}
</style>
</head>
<body>
<form:form action="processForm" modelAttribute="customer">
First name: <form:input path="firstName"/>
<br><br>
last name: <form:input path="lastName"/>
<form:errors path="lastName" cssClass="error"/>
<br><br>

freepass: <form:input path="freePass"/>
<form:errors path="freePass" cssClass="error"/>
<br><br>


postalCodew: <form:input path="postalCode"/>
<form:errors path="postalCode" cssClass="error"/>
<br><br>
<input type="submit" value="lets go">
</form:form>
</body>


</html>