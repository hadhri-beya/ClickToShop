<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page session="false" %>
<!--HEADER STARTS-->
<header class="default">
  <nav class="navbar navbar-default navbar-sticky bootsnav">
    <div class="container-fluid">
      <div class="side_item">
      <sec:authorize access="isAnonymous()">
        <ul class="cols selection">
          <li><a class="login_toggle" href="<c:url value="/login" />">Login</a></li>
          <li><a class="login_toggle" href="<c:url value="/inscription" />">Sign up</a></li>
          <li><a class="login_toggle" href="<c:url value="/inscriptionV" />">Sign up Vendeur</a></li>   
        </ul>
        </sec:authorize>
        <div class="cols">
          <ul class="empr_nav">
           <sec:authorize access="isAuthenticated()">  
   			<sec:authentication property="principal.username" />
				<li><a href="/clicktoshop/Acheteur/wishlist"><i class="icon-heart3 " ></i></a></li>
				 <li><a href="<c:url value="/Acheteur/profile" />"><i class="fa fa-user"></i></a></li>
            <li class="search_btn"><i class="icon-icons185"></i></li>
            <li><a href="javascript:void(0)" class="hamburger is-closed" data-toggle="offcanvas"><i class="icon-icons102"></i></a>
            </li>
            <li><a href="<c:url value="/j_spring_security_logout" />"><i class="fa fa-sign-out"></i></a></li>
            </sec:authorize>
          </ul>
        </div>
      </div>
      <!-- Start Header Navigation -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                <i class="fa fa-bars"></i>
            </button>
        <a class="navbar-brand" href="<c:url value="/" />"><img src="<%=request.getContextPath()%>/resources/images/logo.png" class="logo" alt=""></a>
      </div>
      <!-- End Header Navigation -->

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="navbar-menu">
        <ul class="nav navbar-nav navbar-left" data-in="fadeIn" data-out="fadeOut">
          <li >
            <a href="<c:url value="/" />" class="dropdown-toggle" data-toggle="dropdown">Home</a>
           
          </li>
          <sec:authorize access="hasRole('ROLE_Vendeur')">
     <li >
            <a href="<c:url value="/Vendeur/myShop" />" class="dropdown-toggle" data-toggle="dropdown">My shop</a>
           
          </li>
    </sec:authorize>
          <li class="dropdown megamenu-fw">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories</a>
            <ul class="dropdown-menu half-content" role="menu">
              <li>
                <div class="row">
                  <div class="col-menu col-md-5">
                    <div class="content">
                    
                      <ul class="menu-col">
                      <c:forEach items="${categories}" var="cat">
                        <li><a href="/clicktoshop/produitCategorie?idCat=${cat.idcategorie}">${cat.nomCategorie}</a></li>
                            </c:forEach>
                      </ul>
                    </div>
                  </div>
                  <!-- end col-6 -->
                  <div class="col-menu col-md-7">
                    <h6 class="title"></h6>
                    <div class="content">
                    </div>
                  </div>
                  <!-- end col-6 -->
                </div>
                <!-- end row -->
              </li>
            </ul>
          </li>
          <li class="dropdown megamenu-fw">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Shop</a>
            <ul class="dropdown-menu half-content" role="menu">
              <li>
                <div class="row">
                  <div class="col-menu col-md-5">
                    <div class="content">
                      <ul class="menu-col">
                          <c:forEach items="${boutiques}" var="boutique">
                       <li><a href="/clicktoshop/produitBoutique?idBou=${boutique.idBoutique}">${boutique.nomBoutique}</a></li>
                            </c:forEach>
                    </div>
                  </div>
                  
                </div>
                <!-- end row -->
              </li>
            </ul>
          </li>
          
      </div>
      <!-- /.navbar-collapse -->
    </div>
  </nav>
</header>
<!--HEADER ENDS-->
