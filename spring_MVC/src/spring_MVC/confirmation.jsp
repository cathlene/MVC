
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>StudentConfirmation</title></head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName }
<br><br>
Country: ${student.country}
<br><br>
lanmguage: ${student.favoriteLanguage}
<br><br>
OperatingSystems:
<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
	<li>${temp}</li>
	</c:forEach>
</ul>
</body>


</html>