
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false" %>
<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />
<style>

.wrapper-login {    
	margin-top: 80px;
	margin-bottom: 20px;
}

.form-signin {
  max-width: 420px;
  padding: 30px 38px 66px;
  margin: 0 auto;
  background-color: #eee;
  border: 3px dotted rgba(0,0,0,0.1);  
  }

.form-signin-heading {
  text-align:center;
  margin-bottom: 30px;
}

.form-control {
  position: relative;
  font-size: 16px;
  height: auto;
  padding: 10px;
}

input[type="text"] {
  margin-bottom: 0px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}

input[type="password"] {
  margin-bottom: 20px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.colorgraph {
  height: 7px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}

</style>

<div class = "container">
	<div class="wrapper-login">
		<f:form modelAttribute="user" action="saveUser" method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading"> Please Sign Up</h3>
			  <hr class="colorgraph"><br>
			  <f:input type="hidden" path="iduser" />
			  <f:input path="username" type="text" class="form-control"  placeholder="Username" required="" autofocus="" />
			  <f:errors path="username"></f:errors>
			  <f:input type="email" path="email"  class="form-control"  placeholder="Email" required=""/>
			  <f:errors path="email"></f:errors>
			  <f:input type="text" path="tel"  class="form-control"  placeholder="telephone" required=""/>
			  <f:errors path="tel"></f:errors>
			  <f:input type="text" path="adresse"  class="form-control"  placeholder="adresse" required=""/>
			  <f:errors path="adresse"></f:errors>
			  <f:input type="password" path="password" class="form-control"  placeholder="Password" required=""/> 
			  <f:errors path="password"></f:errors>    
			  
			                  <f:input path="roles" type="text" value="ROLE_Acheteur" class="form-control hidden" placeholder="password"/>

				<f:errors path="roles"></f:errors>     		  
			       		  
			  		  
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Sign Up" type="Submit">Sign Up</button>  			
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

