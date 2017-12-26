<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>

	<f:form modelAttribute="user" action="saveUser" method="post">
		<table>
		
				<f:input type="hidden" path="iduser" />
			
			<tr>
				<td>Username</td>
				<td><f:input path="username" /></td>
				<td><f:errors path="username"></f:errors></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><f:input type="password" path="password" /></td>
				<td><f:errors path="password"></f:errors></td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td><f:input type="email" path="email" /></td>
				<td><f:errors path="email"></f:errors></td>
			</tr>
			
			<tr>
				<td>Role</td>
				<td><f:select   path="roles" >
				<f:option value="ROLE_Vendeur">Vendeur</f:option>
				<f:option value="ROLE_Acheteur">Acheteur</f:option>
				</f:select></td>
				<td><f:errors path="roles"></f:errors></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</f:form>