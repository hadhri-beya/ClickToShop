<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />
<style>
    .details li {
      list-style: none;
    }
    li {
        margin-bottom:10px;
        
    }
</style>

<div class="container">    
                <div class="jumbotron wrapper" style="margin-top:15px; margin-bottom:15px">
                  <div class="row">
                      <div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
                          <img src="https://www.svgimages.com/svg-image/s5/man-passportsize-silhouette-icon-256x256.png" alt="stack photo" class="img">
                      </div>
                      <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8">
                          <div class="container" style="border-bottom:1px solid black">
                            <h2>${user.username}</h2>
                          </div>
                            <hr>
                         <f:form modelAttribute="user" action="/clicktoshop/saveUser" method="post" name="Login_Form" class="form-signin">       
                            
                          <ul class="container details">
                          <f:input type="hidden" path="iduser" />
                          <li><p><span class="glyphicon glyphicon-user one" style="width:50px;"></span><f:input path="username" value="${user.username}"/></p></li>
                            <li><p><span class="glyphicon glyphicon-envelope one" style="width:50px;"></span><f:input path="email" value="${user.email}"/></p></li>
                            <li><p><span class="glyphicon glyphicon-earphone one" style="width:50px;"></span><f:input path="tel" value="${user.tel}"/></p></li>
                           <li><p><span class="glyphicon glyphicon-home one" style="width:50px;"></span><f:input path="adresse" value="${user.adresse}"/></p></li>
                           <li><p><span class="glyphicon glyphicon-lock one" style="width:50px;"></span><f:input type="password" path="password" placeholder="Password" value=""/></p>
                           </li> 
                           </ul>
                           <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Save" type="Submit">Save</button>  			
						</f:form>
                      </div>
                  </div>
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