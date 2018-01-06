<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<a href="<c:url value="/j_spring_security_logout" />">logout</a>

<div id="formCat" class="cadre">
	<f:form modelAttribute="produit" action="saveProd" method="post" enctype="multipart/form-data">
	
		<table>
			<tr>
				<td>ID Produit:</td>
				<td>${produit.idProduit}<f:input type="hidden"
						path="idProduit" /></td>
				<td><f:errors path="idProduit"></f:errors></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><f:input path="designation" /></td>
				<td><f:errors path="designation"></f:errors></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><f:textarea path="description" /></td>
				<td><f:errors path="description"></f:errors></td>
			</tr>
			
			<tr>
				<td>Photo</td>
				<c:if test="${produit.idProduit!=null}">
					<td><img src="photoProd?idProd=${produit.idProduit}"></td>
				</c:if>
				<td><input type="file" name="file"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</f:form>
</div>

<div id="tabCategories" class="cadre">
	<table class="tabStyle1">
		<tr>
			<th>ID</th>
			<th>DESIGNATION</th>
			<th>DESCRIPTION</th>
			<th>PHOTO</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${produits}" var="prod">
			<tr>
				<td>${prod.idProduit}</td>
				<td>${prod.designation}</td>
				<td>${prod.description}</td>
				<td><img src="photoProd?idProd=${prod.idProduit}"></td>
				<td><a href="suppProd?idProd=${prod.idProduit}">Supprimer</a></td>
				<td><a href="editProd?idProd=${prod.idProduit}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</div>