<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ page session="false" %>

<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />

<main>
<!--Shop Cart-->
   <section id="emp-cart" class="padding">
      <div class="container">
         <div class="row">
            <div class="col-sm-12">
               <h3 class="text-uppercase heading_space">wishlist</h3>
               <div class="table-responsive emp_cart">
          <table class="table">
            <tbody>
              <c:forEach items="${favoris}" var="f">
              <tr>
                <td>
                  <a href="#" class="shopping-product"><img src="photoFavoris?idProd=${f.produit.idProduit}" alt="your product"></a>   
                </td>
                <td class="product-name">
                    <h5>${f.produit.designation}</h5>
                </td>
                 <td class="cart_price">
                 <strong>${f.produit.prix}</strong>
                </td>
                <td><p class="instock">${f.produit.quantite}</p></td>
                
                <td>
                  <a class="btn btn_default btn_dark button_moema icon-drop" 
                  href="/clicktoshop/Acheteur/indexPanier?idprod=${f.produit.idProduit}">
                     <i class="icon-icons102"></i>add to bag
                  </a>
                </td>
                
               
              </tr>
                    </c:forEach>
           
            </tbody>
          </table>
          </div>
            </div>
         </div>
      </div>
   </section>
   <!--Shop Cart ends-->
   </main>
   <jsp:include page="footer.jsp" />