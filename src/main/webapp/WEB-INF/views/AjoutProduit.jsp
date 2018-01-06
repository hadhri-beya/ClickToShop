<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />

<div class = "container">
	<div class="wrapper" style="margin-top: 80px;">

               <f:form action="recherche" method="post" enctype="multipart/form-data" name="Login_Form" class="callus bottom30">
                  <div class="row">
                  	<f:input type="hidden" path="idProduit" />
                  	<f:errors path="idProduit"></f:errors>
                     <div class="col-sm-6 bottom30">
                        <div class="form-group">
                           <f:input path="designation"  type="text" class="form-control" placeholder="Designation"/>
                           <f:errors path="designation"></f:errors>
                        </div>
                     </div>
                    
                     <div class="col-sm-6 bottom30">
                        <div class="form-group">
                           <f:input path="description" type="text" class="form-control" placeholder="Description"/>
                           <f:errors path="description"></f:errors>
                        </div>
                     </div>
                     <div class="col-sm-6 bottom30">
                        <div class="form-group">
                          <f:select class="form-control" path="categorie.idcategorie" items="${categories}" 
                          itemValue="idcategorie" itemLabel="nomCategorie"></f:select>
                           
                        </div>
                     </div>
                      <div class="col-sm-6 bottom30">
                        <div class="form-group">
                           <f:input path="prix"  class="form-control" placeholder="Prix"/>
                           <f:errors path="prix"></f:errors>
                           
                        </div>
                     </div>
                     
                    
                      <div class="col-sm-6 bottom30">
                        <div class="form-group">
                           <f:input path="quantite"  class="form-control" placeholder="Quantite"/>
                           <f:errors path="quantite"></f:errors>
                           
                        </div>
                     </div>
                     <div class="col-sm-12 bottom30">
                        <div class="form-group">
                        	<c:if test="${produit.idProduit!=null}">
								<img src="photoProd?idProd=${produit.idProduit}">
							</c:if>
                           <input type="file" name="file" class="form-control" placeholder=""/>
                        </div>
                     </div>

                     </div>
                     
                      <input  name="Submit" value="Save" type="Submit"/>			
                     
                     </f:form>
 </div>
    
 </div>
                  
 <footer>
<script src="<%=request.getContextPath()%>/resources/js/jquery.2.2.3.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootsnav.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.appear.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-countTo.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.cubeportfolio.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/footer-reveal.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.matchHeight-min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/owl.carousel.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/viedobox_video.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-slider.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap-select.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/select.js"></script>   
<script src="<%=request.getContextPath()%>/resources/js/jquery.themepunch.tools.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.themepunch.revolution.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/revolution.extension.actions.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/revolution.extension.layeranimation.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/revolution.extension.navigation.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/revolution.extension.parallax.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/revolution.extension.slideanims.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/revolution.extension.video.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/functions.js"></script>
</footer>
</body>

</html>
