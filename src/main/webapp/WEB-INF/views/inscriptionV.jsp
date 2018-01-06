<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />

<div class = "container">
	<div class="wrapper" style="margin-top: 80px;">

               <f:form modelAttribute="user" action="saveUser" method="post" name="Login_Form" class="callus bottom30">
                  <div class="row">
                     <div class="col-sm-6 bottom30">
                        <div class="form-group">
                           <f:input path="username" type="text" class="form-control" placeholder="Username"/>
                        </div>
                     </div>
                    
                     <div class="col-sm-6 bottom30">
                        <div class="form-group">
                           <f:input path="email" type="email" class="form-control" placeholder="Email Address"/>
                        </div>
                     </div>
                     <div class="col-sm-12 bottom30">
                        <div class="form-group">
                           <f:input path="tel" type="tel" class="form-control" placeholder="Telephone"/>
                        </div>
                     </div>
                    
                     <div class="col-sm-12 bottom30">
                        <div class="form-group">
                           <f:input path="boutique.nomBoutique" type="text" class="form-control" placeholder="Nom boutique"/>
                        </div>
                     </div>
                    
                     <div class="col-sm-6 bottom30">
                        <div class="form-group">
                           <f:input path="boutique.adresseBoutique" type="text" class="form-control" placeholder="Addresse Boutique"/>
                        </div>
                     </div>
                     <div class="col-sm-6 bottom30">
                        <div class="form-group">
                           <f:input path="boutique.telBoutique" type="tel" class="form-control" placeholder="Telephone Boutique"/>
                        </div>
                     </div>              
                     <div class="col-sm-12 bottom30">
                        <div class="form-group">
                           <f:input path="password" type="password" class="form-control" placeholder="password"/>
                        </div>
                     </div> 
                     </div>
                <f:input path="roles" type="text" value="ROLE_Vendeur" class="form-control hidden" placeholder="password"/>
                     
                      <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Sign Up" type="Submit">Sign Up</button>  			
                     
                     </f:form>
 </div>
    <div>ffffffffffffffffffffffffffff
     <img src="photoProd?idProd=1">
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

 