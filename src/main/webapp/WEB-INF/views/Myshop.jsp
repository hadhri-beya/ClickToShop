<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ page session="false" %>

<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />
 


   
<!--Pre LOADER-->
<div class="loader">
  <div id="cssload-wrapper">
    <div class="cssload-loader">
      <div class="cssload-line"></div>
      <div class="cssload-line"></div>
      <div class="cssload-line"></div>
      <div class="cssload-line"></div>
      <div class="cssload-line"></div>
      <div class="cssload-line"></div>
      <div class="cssload-subline"></div>
      <div class="cssload-subline"></div>
      <div class="cssload-subline"></div>
      <div class="cssload-subline"></div>
      <div class="cssload-subline"></div>
      <div class="cssload-loader-circle-1"><div class="cssload-loader-circle-2"></div></div>
      <div class="cssload-needle"></div>
      <div class="cssload-loading">loading</div>
    </div>
  </div>
</div>
<!--Pre LOader Ends-->



   <!--Content Starts-->
<section id="content-emp">
   <div class="container-fluid equal_parent">
      <div class="row">
         <div class="col-md-4 col-sm-4 bglight blackcolor padding  pull-left equal_inner">
            <div class="sidebar sticky">
               <div >
                  <h1 class="bottom10">${boutique.nomBoutique}</h1>
                 
                 
                <h5> Addresse : ${boutique.adresseBoutique} </h5> 
                 <h5>Tel : ${boutique.telBoutique}  <h5>
				
            </div>
          </div>
         </div>
         <div class="col-md-8  col-sm-8 pull-right equal_inner">
             <a class="add_emp "  href="addProduct"> <i class="icon-icons102"></i> Create </a>
             <c:if test="${empty produits}">
               <p>il n y 'a pas de produits</p>
               </c:if>
            <div id="shop_recent_one" class="cbp top40">
            
            	
				<c:forEach items="${produits}" var="prod">
				
               <div class="cbp-item">
                  <div class="image">
                     <div class="ptags"><span class="off"> 40% </span></div>
                     <div class="fader">
                        <img src="photoProd?idProd=${prod.idProduit}" alt="">
                         <img src="photoProd?idProd=${prod.idProduit}" alt="">
                      

                     </div>
                     <div class="shop_buttons">
                        <a class="add_emp" href="editProd?idProd=${prod.idProduit}"> <i class="icon-icons102"></i> Edit </a>
                         <a class="add_emp" href="suppProd?idProd=${prod.idProduit}"> <i class="icon-icons102"></i>Delete </a>
                     </div>
                  </div>
                  <div class="product_caption padding_b">
                     <a href="#.">
                        <h6 class="bottom10">${prod.designation}</h6>
                     </a>
                     <p class="p-price">${prod.prix}</p>

                  </div>
               </div>
               </c:forEach>
               
               
               


            </div>
         </div>
      </div>
   </div>
</section>
   <!--Content Ends-->
<div class="sticky-stopper"></div>



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
</body>
</html>