<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<c:if test="${form.id>0}">
				<h1 style="color: navy">Update User</h1>
			</c:if>
			<c:if test="${form.id==0}">
				<h1 style="color: navy">Add User</h1>
			</c:if>
			<h2 style="color: red">${errorMsg}</h2>
			<h2 style="color: green">${successMsg}</h2>
			<table>
				<tr>
					<th align="left">First Name :</th>
					<td><sf:input path="firstName" /></td>
					<td style="color: red;"><sf:errors path="firstName"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Last Name :</th>
					<td><sf:input path="lastName" /></td>
					<td style="color: red;"><sf:errors path="lastName"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Login ID :</th>
					<td><sf:input path="login" /></td>
					<td style="color: red;"><sf:errors path="login"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Password :</th>
					<td><sf:input path="password" /></td>
					<td style="color: red;"><sf:errors path="password"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Address :</th>
					<td><sf:input path="address" /></td>
					<td style="color: red;"><sf:errors path="address"></sf:errors></td>
				</tr>
				<tr>
					<th></th>
					<td><c:choose>

							<c:when test="${form.id > 0}">
								<input type="submit" name="operation" value="Update" />
								<input type="submit" name="operation" value="Cancel"
									formaction="User/search" />
							</c:when>


							<c:otherwise>
								<input type="submit" name="operation" value="Save" />
								<input type="submit" name="operation" value="Reset" />
							</c:otherwise>
						</c:choose></td>
				</tr>
			</table>
		</div>
	</sf:form>
	<%@ include file="Footer.jsp"%>
</body>
</html>