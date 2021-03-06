<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<script src="js/jquery-1.11.1.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Accomfinder</title>


<link href="css/googlefont.css" rel="stylesheet" type="text/css">
<link id="main-style-file-css" rel="stylesheet" href="css/style.css" />
<style>

</style>
</head>
<body class="property-listing-page grid side-bar">
	<header id="main-header">
		<div class="main-header-cont container">
			<!-- Top Logo -->
			<a href="/accomfinder">
				<div class="logo-main-box col-xs-2 col-sm-3 col-md-5">
					<div class="logo"></div>
					<span> Finder</span>
				</div>
			</a>
			<!-- End of Top Logo -->
			<!-- Main Menu -->
			<div class="menu-container col-xs-10 col-sm-9 col-md-7">
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



	<section class="main-container container">
		<div class="content-box col-sm-8">
			<!-- Properties -->
			<section class="property-listing row-view clearfix">
				<div class="inner-container clearfix ">
					<c:forEach var="listing" items="${listings}">
						<div class="property-box wow fadeInUp">
							<div class="inner-box clearfix myclass">
								<a href="listing/${listing.getId()}"
									class="img-container col-xs-5 col-sm-12 col-md-5"> <c:choose>
										<c:when test="${listing.getRoomFor() == \"male\"}">
											<span class="tag-label featured">
												${listing.getRoomFor()} </span>
										</c:when>
										<c:when test="${listing.getRoomFor() == \"female\"}">
											<span class="tag-label open-house">
												${listing.getRoomFor()} </span>
										</c:when>
										<c:otherwise>
											<span class="tag-label foreclosure">
												${listing.getRoomFor()} </span>
										</c:otherwise>
									</c:choose> <img src="img/property/row/1.jpg" alt="Image of Property">
									<span class="price">Rs. ${listing.getPrice()}</span>xs
								</a>

								<div class="bottom-sec col-xs-7 col-sm-12 col-md-7">
									<a href="listing/${listing.getId()}" class="title">${listing.getTitle()}</a>

									<div class="location">${listing.getAddress().getPlotNo()},
										${listing.getAddress().getPropertyName()},${listing.getAddress().getLocality()}</div>
									<div class="desc">
										<div class="t-sec clearfix">
											<div class="left-sec col-md-12">
												<ul class="main-info-li">
													<li>
														<div class="">
															Property Type :<span style="color: black">${listing.getPropertyType().getType()}</span>
														</div>

													</li>
													<li>
														<div class="">
															Vacancy :<span style="color: black">
																${listing.getVacancyFor()}</span>
														</div>

													</li>
													<li>
														<div class="">
															Furnished :<span style="color: black">
																${listing.getFurnished()}</span>
														</div>

													</li>


												</ul>
											</div>

										</div>
									</div>
									<div class="extra-info clearfix">
										<div class="area col-xs-8">
											Area
											<div class="value">${listing.getArea()}</div>
											sq.ft
										</div>
										<div class="bedroom col-xs-4">
											<div class="value">${listing.getNoBeds()}</div>
											bedroom
										</div>
									</div>
								</div>
								<a href="listing/${listing.getId()}" class="btn-info more-link">Details</a>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- Pagination -->
				<div class="pagination-box">
					<ul class="list-inline">
						<c:url var="back" value="" scope="session">
							<c:forEach items="${param}" var="entry">
								<c:if test="${entry.key != 'page'}">
									<c:param name="${entry.key}" value="${entry.value}" />
								</c:if>
								<c:if test="${entry.key == 'page' && entry.value}">
								</c:if>
							</c:forEach>
							<c:param name="page" value="${param.page-1}" />
						</c:url>
						<c:if test="${param.page >0}">
							<li><a href="${back}"><i class="fa fa-angle-left"></i></a></li>
						</c:if>
						<c:forEach var="page_no"
							begin="${(param.page -1) > 0 ? param.page -1 : 0}"
							end="${(param.page -1) > 0 ? param.page + 2 : 4}">
							<c:url var="nextUrl" value="" scope="session">
								<c:forEach items="${param}" var="entry">
									<c:if test="${entry.key != 'page'}">
										<c:param name="${entry.key}" value="${entry.value}" />
									</c:if>
									<c:if test="${entry.key == 'page' && entry.value}">
									</c:if>
								</c:forEach>
								<c:param name="page" value="${page_no}" />
							</c:url>
							<c:choose>
								<c:when test="${page_no == param.page}">
									<li class="active"><a href="${nextUrl}"><span>${page_no}</span></a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${nextUrl}"><span>${page_no}</span></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:url var="next" value="" scope="session">
							<c:forEach items="${param}" var="entry">
								<c:if test="${entry.key != 'page'}">
									<c:param name="${entry.key}" value="${entry.value}" />
								</c:if>
								<c:if test="${entry.key == 'page' && entry.value}">
								</c:if>
							</c:forEach>
							<c:param name="page" value="${param.page+1}" />
						</c:url>
						<li><a href="${next}"><i class="fa fa-angle-right"></i></a></li>
					</ul>
				</div>
				<!-- End of Pagination -->
			</section>
			<!-- End of Properties -->
		</div>
		<aside class="col-sm-4">
			<!--Sidebar Box-->
			<div class="sidebar-box">
				<h3>Property Search</h3>

				<form method="GET" action="search">

					<div class="box-content">
						<div class="property-search-form vertical">
							<div class="main-search-sec">
								<div class="search-field">
									<button class="btn">Search</button>
									<button class="more-options btn">More Options</button>
								</div>
								<%-- <div class="search-field">
									<select id="sort" name="sortBy">
										<option value="">Vacancy</option>
										<c:forEach var="vacancy" items="${sortby}">
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
								</div> --%>
								<div class="search-field"
									style="color: #B31717; font-size: 1em;">
									Locality <input value="${activeFilters.getLocality()}"
										name="locality" type="text" placeholder="Location"
										id="autocomplete">
								</div>
								<hr>
								<div class="search-field"
									style="color: #B31717; font-size: 1em;">
									Property Type <select id="property-type" name="propertyType">
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
								<div class="search-field"
									style="color: #B31717; font-size: 1em;">
									Bedrooms <select id="bedroom" name="noBeds">
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

								<div class="search-field"
									style="color: #B31717; font-size: 1em;">
									Furnished <select id="furnished" name="furnished">
										<option value="">Furnished Type</option>
										<c:if
											test="${activeFilters.getFurnished() == \"fully-furnished\"}">
											<option value="fully-furnished" selected><b>fully
													Furnished</b></option>
										</c:if>
										<c:if
											test="${activeFilters.getFurnished() != \"fully-furnished\"}">
											<option value="fully-furnished"><b>fully
													Furnished</b></option>
										</c:if>
										<c:if
											test="${activeFilters.getFurnished() == \"semi-furnished\"}">
											<option value="semi-furnished" selected><b>semi
													Furnished</b></option>
										</c:if>
										<c:if
											test="${activeFilters.getFurnished() != \"semi-furnished\"}">
											<option value="semi-furnished"><b>semi Furnished</b></option>
										</c:if>
										<c:if
											test="${activeFilters.getFurnished() == \"unfurnished\"}">
											<option value="unfurnished" selected><b>un
													Furnished</b></option>
										</c:if>
										<c:if
											test="${activeFilters.getFurnished() != \"unfurnished\"}">
											<option value="unfurnished"><b>un Furnished</b></option>
										</c:if>
									</select>
								</div>
								<hr>
								<div class="search-field"
									style="color: #B31717; font-size: 1em;">
									Room For <select id="roomfor" name="roomFor">
										<option value="">Room For</option>
										<c:if test="${activeFilters.getRoomFor() == \"male\"}">
											<option value="male" selected><b>male</b></option>
										</c:if>
										<c:if test="${activeFilters.getRoomFor() != \"male\"}">
											<option value="male"><b>male</b></option>
										</c:if>
										<c:if test="${activeFilters.getRoomFor() == \"female\"}">
											<option value="female" selected><b>female</b></option>
										</c:if>
										<c:if test="${activeFilters.getRoomFor() != \"female\"}">
											<option value="female"><b>female</b></option>
										</c:if>

									</select>
								</div>
								<hr>

								<div class="search-field"
									style="color: #B31717; font-size: 1em;">
									Price <input type="text" id="price_range" class="range-slider"
										name="price" value="" data-min="1000" data-max="40000" />
								</div>
								<hr>
								<div class="search-field "
									style="color: #B31717; font-size: 1em;">
									Area <input type="text" id="area_range" class="range-slider"
										name="area" value="" data-min="400" data-max="5000" />
								</div>
								<hr>

							</div>
							<div class="advanced-search-sec clearfix">
								<div class="search-field"
									style="color: #B31717; font-size: 1em;">
									Vacancy <select id="vacancy" name="vacancyFor">
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
									<span style="color: #B31717; font-size: 1em;">Possession
										Date </span><br />
									<c:choose>
										<c:when test="${activeFilters.getPossessionDate()!= \"\"}">
											<input id="pdate" name="possessionDate" type="date"
												value="${activeFilters.getPossessionDate()}" />
										</c:when>
										<c:otherwise>
											<input id="pdate" name="possessionDate" type="date" />
										</c:otherwise>
									</c:choose>
								</div>
								<hr>
								<!-- <div class="col-xs-6 search-field">
									<div class="hsq-checkbox check-box-container">
										<label for="field-1"> <input name="yolo" type="checkbox"
											value="81" id="field-1"> <span></span> Parking
										</label>
										<label for="field-2"> <input name="yolo" type="checkbox"
											value="84" id="field-2"> <span></span> gym
										</label>
									</div>
								</div>  -->
							</div>
						</div>
					</div>
				</form>
			</div>

		</aside>
	</section>

	<!-- JS Include Section -->
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/helper.js"></script>
	<script type="text/javascript" src="js/select2.min.js"></script>
	<script type="text/javascript" src="js/ion.rangeSlider.min.js"></script>
	<!-- <script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?libraries=places"></script> -->
	<script type="text/javascript" src="js/template.js"></script>
	<!-- End of JS Include Section -->
	<script type="text/javascript">
		var placeSearch, autocomplete;

		function initAutocomplete() {
			var options = {
				types : [ 'geocode' ],
				componentRestrictions : {
					country : 'In'
				}
			};
			autocomplete = new google.maps.places.Autocomplete((document
					.getElementById('autocomplete')), options);

			autocomplete.addListener('place_changed', fillInAddress);
		}

		function fillInAddress() {

			var place = autocomplete.getPlace();
			console.log(place);
			document.getElementById('autocomplete').value = autocomplete
					.getPlace().vicinity;

		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAm95XTLoIBga5JdYinIDroS0HZZNE8jp8&libraries=places&callback=initAutocomplete"
		async defer></script>

</body>
</html>