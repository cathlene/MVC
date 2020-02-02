<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head><title>CustomerConfirmation</title></head>
<body>
The customer is confirmed: ${customer.firstName} ${customer.lastName }
<br><br>

Free passes: ${customer.freePass} 
<br><br>
PostaclCode: ${customer.postalCode} 
<br><br>
</body>

</html>