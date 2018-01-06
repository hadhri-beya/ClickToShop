<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ page session="false" %>

<jsp:include page="head.jsp" />
<jsp:include page="header.jsp" />
	<main> <!--Shop  Detail-->
	<section id="shop-detail-one">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-6 pull-left">
					<div class="row">
						<div id="detail_slide" class="owl-carousel owl-theme">
							<div class="item"
								data-dot='<img src="<%=request.getContextPath()%>/images/detail-indicator1.jpg" alt="">'>
								<img src="photoPanier?idProd=${produit.idProduit}" alt="">
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-6 product_detail padding_half">
					<span class="emp-share"><i class="icon-share2"></i></span>
					<ul class="share-holder">
						<li><a href="#." class="facebook"><i
								class="icon-facebook-1"></i></a></li>
						<li><a href="#." class="twitter"><i
								class="icon-twitter-1"></i></a></li>
						<li><a href="#." class="pins"><i class="icon-pinterest2"></i></a></li>
						<li><a href="#." class="instagram"><i
								class="icon-instagram"></i></a></li>
					</ul>
					<h3 class="bottom25 top10">${produit.designation}</h3>
					<p class="p-price"> <span class="default_color">${produit.prix}</span> <span
							class="note bgdefault ">15% off</span> <span class="notify">Free
							Shipping Worldwide</span>
					</p>
					<p class="simple bottom20 top20">${produit.description}
					<div class="row">
						<div class="col-sm-9 col-md-8">
							<f:form modelAttribute="panier" action="ajoutPanier?idProd=${produit.idProduit}" method="post" class="callus">
								
								
								<div class="form-group bottom30">
									
									<div class="row">
										<div class="col-sm-4">
											<div class="quantity">
												<div class="input-group">
													<div class="input-group-btn">
														<button type="button" class="btn btn-default btn-number"
															disabled="disabled" data-type="minus"
															data-field="quant[1]">
															<i class="fa fa-minus"></i>
														</button>
													</div>
													<f:input type="number" name="quant[1]" path="quantite"
														class="input-number text-center" value="${panier.quantite}" min="1"
														max="${produit.quantite}"/>
													<div class="input-group-btn">
														<button type="button" class="btn btn-default btn-number"
															data-type="plus" data-field="quantite">
															<i class="fa fa-plus"></i>
														</button>
													</div>
												</div>
											</div>
										</div>
										
									</div>
								</div>
								<div class="">
									<button type="submit"
										class="btn btn_colored btn_rounded button_moema icon-drop bottom30"
										> <i class="icon-icons102"></i> add to cart
									</button>
									<button type="button" class="heartly bottom30"
										data-container="body" data-toggle="popover"
										data-placement="bottom"
										data-content="This item has been saved
                        for 45 days. View Saved
                        Items">
										<i class="icon-heart3"></i>
									</button>
								</div>
							 </f:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--Shop  Detail ends --> </main>


<jsp:include page="footer.jsp" />