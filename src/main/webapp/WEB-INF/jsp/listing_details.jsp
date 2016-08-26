<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<script src="../js/jquery-1.11.1.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Accomfinder</title>
<link href="../css/googlefont.css" type="text/css">
<link id="main-style-file-css" rel="stylesheet" href="../css/style.css" />

</head>
<body class="property-details">
	<header id="main-header">

		<div class="main-header-cont container">
			<!-- Top Logo -->
			<a href="/accomfinder">
				<div class="logo-main-box col-xs-4 col-sm-4 col-md-6">
					<div class="logo"></div>
					<span> Finder</span>
				</div>
			</a>
			<!-- End of Top Logo -->
			<!-- Main Menu -->
			<div class="menu-container col-xs-8 col-sm-6 col-md-6">
				<!-- Main Menu -->
				<nav id="main-menu" class="hidden-xs hidden-sm">
					<ul class="main-menu list-inline">
				</nav>
				<ul class="main-menu list-inline">

					<%@include file="googleSignIn.jsp"%>
				</ul>
				<!-- END of Main Menu -->

			</div>
			<div id="main-menu-handle" class="hidden-md hidden-lg">
				<i class="fa fa-bars"></i>
			</div>
			<!-- Mobile Menu handle -->

			<!-- End of Main Menu -->
		</div>
		<div id="mobile-menu-container" class="hidden-md hidden-lg"></div>
	</header>
	<section id="property-slider-section">
		<div class="title-box container">
			<h1>${listing.getTitle()}</h1>
			<div class="location">${listing.getAddress().getPlotNo()},
				${listing.getAddress().getPropertyName()},${listing.getAddress().getLocality()}</div>
		</div>
		<!-- Main Slider -->
		<div id="property-main-slider">
			<c:forEach var="image" items="${listing.getImages()}">
				<div class="items">
					<div class="img-container" data-bg-img="${image.getPath()}"></div>
					<!-- Change the URL section based on your image\'s name -->
				</div>
			</c:forEach>
			<div class="items">
				<div class="img-container" data-bg-img="../img/slider/2.jpg"></div>
			</div>
			<div class="items">
				<div class="img-container" data-bg-img="../img/slider/3.jpg"></div>
			</div>

		</div>
		<!-- End of Main Slider -->

		<div id="property-thumb-slider" class="container">
			<c:forEach var="image" items="${listing.getImages()}">
				<div class="items">
					<div class="img-container" data-bg-img="${image.getPath()}"></div>
					<!-- Change the URL section based on your image\'s name -->
				</div>
			</c:forEach>
			<div class="items">
				<div class="img-container" data-bg-img="../img/slider/2.jpg"></div>
			</div>
			<div class="items">
				<div class="img-container" data-bg-img="../img/slider/3.jpg"></div>
			</div>
		</div>
	</section>

	<section class="main-container container">
		<div class="content-box col-sm-8">
			<div class="t-sec clearfix">
				<div class="col-md-4 left-sec">
					<!--Highlight Section-->
					<div class="highlight-container">
						<div class="highlight-details-box">
							<div class="value">${listing.getArea()}</div>
							<div class="text">Area</div>
							<div class="unit">sq.ft</div>
						</div>
						<div class="highlight-details-box">
							<div class="value">${listing.getNoBeds()}</div>
							<div class="text">Bedroom</div>
						</div>
						<div class="highlight-details-box">
							<div class="value">${listing.getVacancyFor()}</div>
							<div class="text">Vacancy</div>
						</div>
					</div>

					<!-- Property Map -->
					<div class="property-details-map-container">
						<div id="property-details-map"></div>
					</div>

				</div>
				<div class="col-md-8 right-sec">
					<div class="information-box">
						<div class="box-content main-info-box">
							<div class="t-sec clearfix">
								<div class="left-sec col-md-8">
									<ul class="main-info-li">
										<li>
											<div class="title">Property Type :</div>
											<div class="value">${listing.getPropertyType().getType()}</div>
										</li>
										<li>
											<div class="title">Furnishing :</div>
											<div class="value">${listing.getFurnished() }</div>
										</li>
										<li>
											<div class="title">Available For :</div>
											<div class="value">${listing.getRoomFor() }</div>
										</li>
										<li>
											<div class="title">Possession Date :</div>
											<div class="value">
												<c:set var="string1" value="${listing.getPossesionDate()}" />
												<c:if test="${string1 != null}">
													<fmt:parseDate pattern="yyyy-MM-dd HH:mm:ss"
														value="${string1}" var="thedate" />
													<fmt:formatDate value="${thedate}" pattern="dd MMM yyyy"
														var="string2" />
												${string2}
												</c:if>
											</div>
										</li>
										<li>
											<div class="title">Posted By :</div>
											<div class="value">${listing.getUser().getName() }</div>
										</li>
										<li>
											<div class="title">Posted on :</div>
											<div class="value">
												<c:set var="string1" value="${listing.getPostedOn()}" />
												<c:if test="${string1 != null}">
													<fmt:parseDate pattern="yyyy-MM-dd HH:mm:ss"
														value="${string1}" var="thedate" />
													<fmt:formatDate value="${thedate}" pattern="dd MMM yyyy"
														var="string2" />
												${string2}
												</c:if>
											</div>
										</li>

									</ul>
								</div>
								<div class="right-sec col-md-4">
									<div href="#" class="price">Rs. ${listing.getPrice()}</div>
									<div class="price-type">Per Month</div>
								</div>
							</div>
							<!-- <div class="b-sec">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Accusamus assumenda atque deserunt, enim harum
								iure laboriosam minima nisi numquam, obcaecati pariatur quaerat
								quam quasi quod ratione rem rerum sunt, suscipit vel voluptatum.
								Aut beatae dolores magnam nam nobis perspiciatis quaerat quis
								temporibus vero voluptatem? A accusantium animi atque
								consequatur, dolorum eaque fugit molestiae officia recusandae
								vero? Earum, explicabo facilis, fugiat incidunt magnam nihil
								reiciendis repudiandae sapiente sit, soluta sunt voluptas?</div> -->
						</div>
					</div>
					<form action="" id="form" method="POST">
						<div class="information-box">
							<div class="property-agent-container">
								<h3>Contact Owner - ${listing.getUser().getName()}</h3>

								<div class="box-content clearfix">

									<div class="col-md-12 contact-form-container">
										<div class="contact-form">
											<div class="field-box">
												<input name="name" type="text" placeholder="Name *">
											</div>
											<div class="field-box">
												<input name="email" type="email" placeholder="Email *">
											</div>
											<div class="field-box">
												<input name="mobile" type="text" placeholder="Phone">
											</div>
											<input name="listingId" type="text" style="display: none"
												value="${listing.getId()}">
											<textarea name="body" id="message">Your Message *</textarea>
											<button type="submit"  class="btn btn-lg submit">Submit</button>
										</div>
									</div>
								</div>
							</div>

						</div>
					</form>

				</div>
			</div>
		</div>
		<aside class="col-sm-4">
			<!--Sidebar Box-->
			<div class="sidebar-box">
				<h3>Property Search</h3>

				<form method="GET" action="../search">

					<div class="box-content">
						<div class="property-search-form vertical">
							<div class="main-search-sec">
								<div class="search-field">
									<select id="property-type" name="propertyType">
										<option value="">Property Type</option>
										<c:forEach var="ptype" items="${propertyType}">
											<c:choose>
												<c:when
													test="${activeFilters.getPropertyType() == ptype.getId()}">
													<option value="${ptype.getId()}" selected>${ptype.getType()}</option>
												</c:when>
												<c:otherwise>
													<option value="${ptype.getId()}">${ptype.getType()}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>

									</select>
								</div>
								<hr>
								<div class="search-field">
									<select id="bedroom" name="noBeds">
										<option value="">Bedrooms</option>
										<c:forEach var="nobed" items="${noBeds}">
											<c:choose>
												<c:when test="${activeFilters.getNoBeds() == nobed}">
													<option value="${nobed}" selected><b>${nobed}</b>
														Bedroom
													</option>
												</c:when>
												<c:otherwise>
													<option value="${nobed}"><b>${nobed}</b> Bedroom
													</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
								<hr>
								<div class="search-field">
									<select id="bathroom" name="vacancyFor">
										<option value="">Vacancy</option>
										<c:forEach var="vacancy" items="${noBeds}">
											<c:choose>
												<c:when test="${activeFilters.getVacancyFor() == vacancy}">
													<option value="${vacancy}" selected><b>${vacancy}</b>
														Vacant
													</option>
												</c:when>
												<c:otherwise>
													<option value="${vacancy}"><b>${vacancy}</b>
														Vacant
													</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
								<hr>
								<div class="search-field">
									<input type="text" id="price_range" class="range-slider"
										name="price" value="" data-min="0" data-max="50000" />
								</div>
								<div class="search-field">
									<button class="btn">Search</button>
									<button class="more-options btn">More Options</button>
								</div>
							</div>
							<div class="advanced-search-sec clearfix">
								<div class="col-xs-6 search-field">
									<div class="hsq-checkbox check-box-container">
										<label for="field-1"> <input type="checkbox"
											value="81" id="field-1"> <span></span> Parking
										</label>
									</div>
								</div>
								<div class="col-xs-6 search-field">
									<div class="hsq-checkbox check-box-container">
										<label for="field-2"> <input type="checkbox"
											value="81" id="field-2"> <span></span> Balcony
										</label>
									</div>
								</div>
								<div class="col-xs-6 search-field">
									<div class="hsq-checkbox check-box-container">
										<label for="field-3"> <input type="checkbox"
											value="81" id="field-3"> <span></span> Gym
										</label>
									</div>
								</div>
								<div class="col-xs-6 search-field">
									<div class="hsq-checkbox check-box-container">
										<label for="field-4"> <input type="checkbox"
											value="81" id="field-4"> <span></span> Storage
										</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</aside>
	</section>
	-->
	<!-- JS Include Section -->
	<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="../js/helper.js"></script>
	<script type="text/javascript" src="../js/select2.min.js"></script>
	<script type="text/javascript" src="../js/ion.rangeSlider.min.js"></script>
	<script type="text/javascript" src="../js/owl.carousel.min.js"></script>
	<!-- <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?libraries=places"></script> -->
	<script type="text/javascript" src="../js/template.js"></script>
	<!-- End of JS Include Section -->

	<script type="text/javascript">
	$('#form').submit(function(e) {
	    $.ajax({
	    	type: "POST",
	        url: '../contactOwner',
	        data:$('#form').serialize(),
	        beforeSend: function() { $('#loading').show(); },
	        complete: function(response) { $('#loading').hide();window.location.href = './'; }
	    });
	    e.preventDefault();
	    return false;
	});
		
	</script>

</body>
</html>