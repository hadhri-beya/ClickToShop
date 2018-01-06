<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page session="false" %>

<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />
 

   
<!--Shopping Cart-->
<div id="sidebar-wrapper">
   <ul class="nav sidebar-nav">
   <c:set var="total" value="${0}"/>
     <c:forEach items="${panier}" var="p">
     
      <li class="tablecart">
         <div class="photo">
            <a href="#" style="width:200px!important">
               <img  src="photoProdhome?idProd=${p.produit.idProduit}" alt="">
            </a>
         </div>
         <div class="cartbody">
            <h5>${p.produit.designation}</h5>
            <p>${p.produit.description}</p>
            <span>prix:${p.produit.prix}dt</span><br>
            <span>Quantite:${p.quantite}</span>
            <c:set var="total" value="${total +p.produit.prix * p.quantite }" />
        <a href="suppPanier?idProd=${p.produit.idProduit}">   <i class="fa fa-close cross"></i> </a> 
         </div>
      </li>
      </c:forEach>
      <c:if test="${empty panier}">

      <li class="text-center margin40 top40">
         <div class="image-cart bottom10">
            <img src="<%=request.getContextPath()%>/resources/images/shopping-cart.png" alt="">
         </div>
         <h4 class="text-uppercase">no products in the cart.</h4>
      </li>
      </c:if>
   </ul>
   <div class="cart-bottom clearfix">
      <h5 class="pull-left top10 bottom10">SUBTOTAL</h5>
      <h5 class="pull-right top10 bottom10">${total} dt </h5>
      
   </div>
</div>
   <!--Shopping Cart ends-->
   
<!--Search-->
<div id="search">
  <button type="button" class="close">×</button>
  <form action="recherche" method="post" class="centered clearfix">
    <input type="search" name="motcle" value="" placeholder="RBoutique/Produit"  required/>
    <button type="submit" class="btn-search"><i class="icon-icons185"></i></button>
  </form>
</div>
 <!--Search Ends-->


<main>

<!--Gallery Starts-->
<section id="emp_gallery" class="padding">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12 heading_space clearfix">
       
         <a class="btn btn_default button_moema  btnfilter pull-right top10">
           <i class="fa fa-th-large"></i> &nbsp; Filter
         </a>
         <div class="clearfix"></div>
         <div class="container-select top20 equal_parent">
      <f:form action="filter" method="post">
            <div class="row">
            <div class="col-md-4 col-sm-7">
               <div class="emp_cate equal_inner">
                  <h5 class="text-uppercase select-title">Categories</h5>
                  <c:forEach items="${categories}" var="cat">
                  <label class="clearfix">
                    <div class="squaredFour">
                     <input id="squaredFour" value="${cat.nomCategorie}" name="categorie"  type="checkbox">
                     <label for="squaredFour"></label>
                     </div>
                     <h6 class="bottom5">${cat.nomCategorie}</h6>
                  </label>
                  </c:forEach>
              </div>
            </div>

            <div class="col-md-4 col-sm-7">
               <div class="emp_cate dotted equal_inner">
                  <h5 class="text-uppercase select-title">Boutique</h5>
                  <c:forEach items="${boutiques}" var="boutique">
                  <label class="clearfix">
                  <div class="squaredFour">
                     <input id="black" value="${boutique.nomBoutique}" name="boutique" type="checkbox">
                     <label for="black"></label>
                     </div>
                     <h6 class="bottom5">${boutique.nomBoutique} </h6>
                  </label>
                  </c:forEach>
                  
                  
          </div>
            </div>
            <div class="col-md-4 col-sm-7">
               <div class="emp_cate dotted equal_inner">
                  <h5 class="text-uppercase select-title">Prix</h5>
                  <label class="clearfix">
                  <div class="squaredFour">
                     <input id="fifty" value="500" name="prix"  type="checkbox">
                     <label for="fifty"></label>
                     </div>
                     <h6 class="bottom5">0.00 dt  -  500.00 dt</h6>
                  </label>
                  <label class="clearfix">
                  <div class="squaredFour">
                     <input id="hundred" value="1000" name="prix" type="checkbox">
                     <label for="hundred"></label>
                     </div>
                     <h6 class="bottom5">0.00 dt  -  1000.00 dt</h6>
                  </label>
                  <label class="clearfix">
                  <div class="squaredFour">
                     <input id="twoh" value="2000" name="prix"  type="checkbox">
                     <label for="twoh"></label>
                     </div>
                     <h6 class="bottom5">0.00 dt  -  2000.00 dt</h6>
                  </label>
                  <label class="clearfix">
                  <div class="squaredFour">
                     <input id="fourh" value="4000" name="prix" type="checkbox">
                     <label for="fourh"></label>
                     </div>
                     <h6 class="bottom5">0.00 dt  -  4000.00 dt</h6>
                  </label>
                  <label class="clearfix">
                  <div class="squaredFour">
                     <input id="sisteen" value="16000" name="prix"  type="checkbox">
                     <label for="sisteen"></label>
                     </div>
                     <h6 class="bottom5">0.00 dt  -  16000.00 dt</h6>
                  </label>
              </div>
            </div>
         </div>
         
          <input  name="Submit" value="rechercher" type="Submit"/>			
                     
                     </f:form>
         </div>
      </div>
    </div>
   
    <div id="projects" class="cbp">
      
    <c:forEach items="${produits}" var="prod">
    
      <div class="cbp-item sale">
        <div class="image">
           <div class="fader">
             <img class="imPro" src="photoProdhome?idProd=${prod.idProduit}" alt="">
             <img class="imPro" src="photoProdhome?idProd=${prod.idProduit}" alt="">
          </div>
          <div class="shop_buttons">
            <a class="ext_emp" href="Acheteur/indexPanier?idprod=${prod.idProduit}" ></i> add to bag </a>
           <sec:authorize access="isAuthenticated()">  
   			
              <a class="ext_emp" href="Acheteur/indexPanier?idprod=${prod.idProduit}" > <i class="icon-expand"></i></a>
            </sec:authorize>
        </div>
        </div>
        <div class="product_caption padding_b">
          <a href="#.">
            <h6 class="bottom10">${prod.designation}</h6>
          </a>
          <p class="p-price">${prod.prix}</p>
          <sec:authorize access="isAuthenticated()">  
   
   <a class="ext_emp" href="Acheteur/ajoutFavoris?idProd=${prod.idProduit}" >
   <span class="like"><i class="icon-heart3"></i></span></a>
   </sec:authorize>
          
        </div>
      </div>
      </c:forEach>
    
    </div>
  </div>
</section>

 
 </main>
<jsp:include page="footer.jsp" />
