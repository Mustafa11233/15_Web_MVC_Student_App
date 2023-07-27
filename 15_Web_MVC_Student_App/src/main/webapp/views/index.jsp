<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h3>Student Enquiry Form</h3>
	<!-- action -> when we click the button which method it should execute -->
	<!-- modelAttribute -> it is used to map the form to java class
	        ,which form is binded to which class object -->
	        <p><font color="green">${msg }</font>
	        </p>
	        
	<form:form action="save" modelAttribute="student" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="name"/>
			</tr>	
			<tr>
				<td>Email:</td>
				<td><form:input path="email"/>
			</tr>	
			<tr>
				<td>Gender:</td>
				<td>
				<form:radiobutton path="gender" value="M"/>Male
				<form:radiobutton path="gender" value="F"/>Fe-Male
				</td>
				</tr>
				<tr>
				<td>Course:</td>
				<td><form:select path="course">
					<form:option value="">-Select-</form:option>
					<!-- collections to print the value as drop downs -->
					<form:options items="${courses}"/>
					
					
					
					<!-- hard coded -->
					<!--<form:option value="Java">Java</form:option>
					<form:option value="Phython">phython</form:option>
					<form:option value="DevOps">devOps</form:option>-->
					</form:select>
				</td>
			</tr>	
			<tr>
				<td>Timings:</td>
				<td><form:checkboxes items="${timings}" path="timings"/></td>
				
				<!-- <td><form:checkbox path="timings" value="Mrng"/>Morning
				<form:checkbox path="timings" value="Aftnoon"/>AfterNoon
				<form:checkbox path="timings" value="Evening"/>Evening </td>-->
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="save"/>
			</tr>
			
		
		
		</table>
	</form:form>

</body>
</html>