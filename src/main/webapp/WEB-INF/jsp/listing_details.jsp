<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

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
			<div class="logo-main-box col-xs-4 col-sm-4 col-md-3">
				<div class="logo"></div>
				<span> Finder</span>
			</div>
			<!-- End of Top Logo -->
			<!-- Main Menu -->
			<div class="menu-container col-xs-3 col-sm-4 col-md-6">
				<!-- Main Menu -->
				<nav id="main-menu" class="hidden-xs hidden-sm">
					<ul class="main-menu list-inline">
				</nav>
				<!-- END of Main Menu -->

			</div>
			<div id="main-menu-handle" class="hidden-md hidden-lg">
				<i class="fa fa-bars"></i>
			</div>
			<!-- Mobile Menu handle -->
			<ul class="main-menu list-inline">
				<li><a id="submit-property-link" class="btn"
					href="pages/submit-property.html"><span>Submit Your
							Property</span></a></li>
				<li><a id="login" class="btn" href="pages/submit-property.html"><span>Login</span></a>
				</li>
			</ul>
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

					<div class="information-box">
						<div class="property-agent-container">
							<h3>Contact Owner - ${listing.getUser().getName()}</h3>
							
							<div class="box-content clearfix">

								<div class="col-md-12 contact-form-container">
									<div class="contact-form">
										<div class="field-box">
											<input type="text" placeholder="Name *">
										</div>
										<div class="field-box">
											<input type="email" placeholder="Email *">
										</div>
										<div class="field-box">
											<input type="text" placeholder="Phone">
										</div>
										<textarea id="message">Your Message *</textarea>
										<button class="btn btn-lg submit">Submit</button>
									</div>
								</div>
							</div>
						</div>

					</div>

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
		function initialize() {
			var myLatLng = new google.maps.LatLng(40.6700, -73.9400);
			var mapOptions = {
				zoom : 12,
				center : myLatLng,
				// This is where you would paste any style found on Snazzy Maps.
				styles : [ {
					featureType : "landscape",
					stylers : [ {
						saturation : -100
					}, {
						lightness : 65
					}, {
						visibility : "on"
					} ]
				}, {
					featureType : "poi",
					stylers : [ {
						saturation : -100
					}, {
						lightness : 51
					}, {
						visibility : "simplified"
					} ]
				}, {
					featureType : "road.highway",
					stylers : [ {
						saturation : -100
					}, {
						visibility : "simplified"
					} ]
				}, {
					featureType : "road.arterial",
					stylers : [ {
						saturation : -100
					}, {
						lightness : 30
					}, {
						visibility : "on"
					} ]
				}, {
					featureType : "road.local",
					stylers : [ {
						saturation : -100
					}, {
						lightness : 40
					}, {
						visibility : "on"
					} ]
				}, {
					featureType : "transit",
					stylers : [ {
						saturation : -100
					}, {
						visibility : "simplified"
					} ]
				}, {
					featureType : "administrative.province",
					stylers : [ {
						visibility : "off"
					} ]
				}, {
					featureType : "administrative.locality",
					stylers : [ {
						visibility : "off"
					} ]
				}, {
					featureType : "administrative.neighborhood",
					stylers : [ {
						visibility : "on"
					} ]
				}, {
					featureType : "water",
					elementType : "labels",
					stylers : [ {
						visibility : "off"
					}, {
						lightness : -25
					}, {
						saturation : -100
					} ]
				}, {
					featureType : "water",
					elementType : "geometry",
					stylers : [ {
						hue : "#ffff00"
					}, {
						lightness : -25
					}, {
						saturation : -97
					} ]
				} ],

				// Extra options
				scrollwheel : false,
				mapTypeControl : false,
				panControl : false,
				zoomControlOptions : {
					style : google.maps.ZoomControlStyle.SMALL,
					position : google.maps.ControlPosition.LEFT_BOTTOM
				}
			}
			var map = new google.maps.Map(document
					.getElementById('property-details-map'), mapOptions);

			var image = '../img/marker.png';

			var beachMarker = new google.maps.Marker({
				position : myLatLng,
				map : map,
				icon : image
			});
		}

		google.maps.event.addDomListener(window, 'load', initialize);
	</script>
	
</body>
</html>