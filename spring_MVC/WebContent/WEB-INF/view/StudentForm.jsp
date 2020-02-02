<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head><title>StudentForm</title></head>
<body>
<form:form action="processForm" modelAttribute="student">
First name: <form:input path="firstName"/>
<br><br>
last name: <form:input path="lastName"/>
<br><br>
Country: 

<form:select path="country">
<form:options items="${student.countries}"/>

</form:select>
<br><br>
Fovavorite language
Java <form:radiobutton path ="favoriteLanguage" value="Java"/>
df <form:radiobutton path ="favoriteLanguage" value="Javacc"/>
Javafsd <form:radiobutton path ="favoriteLanguage" value="Javaaa"/>
<br><br>

OPerating systems:
Linux <form:checkbox path="operatingSystems" value="Linux"/>
Window <form:checkbox path="operatingSystems" value="windows"/>
fs <form:checkbox path="operatingSystems" value="dsf"/>
<br><br>
<input type="submit" value="lets go">
</form:form>
</body>


</html>