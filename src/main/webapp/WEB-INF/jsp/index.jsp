<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>AccomFinder</title>

	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<!-- 
<link href="css/googlefont.css" rel="stylesheet" type="text/css"> -->

<link id="main-style-file-css" rel="stylesheet" href="css/style.css" />

</head>
<body class="home-page-4">
	<header id="main-header">
		<div class="main-header-cont container">
			<!-- Top Logo -->
			<a href="./">
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
<jsp:include page="googleSignIn.jsp" />  
					<%-- <%@include file="googleSignIn.jsp"%> --%>
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

	<!-- Main Slider -->
	<section id="main-slider-fullscreen">
		<div class="items">
			<div class="img-container" data-bg-img="img/slider/1.jpg"></div>
			<!-- Change the URL section based on your image\'s name -->
		</div>
		<div class="items">
			<div class="img-container" data-bg-img="img/slider/2.jpg"></div>
		</div>
		<div class="items">
			<div class="img-container" data-bg-img="img/slider/3.jpg"></div>
		</div>
		<div class="items">
			<div class="img-container" data-bg-img="img/slider/4.jpg"></div>
		</div>
	</section>
	<!-- End of Main Slider -->

	<!-- Property Search Box -->
	<form method="GET" action="search">
		<section id="property-search-container" class="container">

			<div class="property-search-form horizontal">
				<div class="main-search-sec">
					<div class="col-xs-4 col-sm-3 search-field">
						<input type="text" placeholder="Location" id="autocomplete">

					</div>
					<!-- <div class="col-xs-4 col-sm-2 search-field">
                    <select id="proeprty-status">
                        <option value="0">Property Status</option>
                        <option value="1">For Sale</option>
                        <option value="2">For Rent</option>
                    </select>
                </div> -->
					<div class="col-xs-4 col-sm-2 search-field">
						<select id="property-type" name="propertyType">
							<option value="">Property Type</option>
							<c:forEach var="ptype" items="${propertyType}">
								<option value="${ptype.getId()}">${ptype.getType()}</option>
							</c:forEach>

						</select>
					</div>
					<div class="col-xs-4 col-sm-2 search-field">
						<select id="bedroom" name="noBeds">
							<option value="">Bedrooms</option>
							<c:forEach var="nobed" items="${noBeds}">
								<option value="${nobed}"><b>${nobed}</b> Bedroom
								</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-xs-4 col-sm-2 search-field">
						<select id="bathroom" name="vacancyFor">
							<option value="">Vacancy</option>
							<c:forEach var="vacancy" items="${vacancyFor}">
								<option value="${vacancy}"><b>${vacancy}</b> Vacant
								</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-xs-4 col-sm-1 search-field">
						<button class="btn" href="search">Search</button>
					</div>
				</div>
				<div class="advanced-search-sec">
					<div class="col-xs-3 col-sm-3 col-md-2 search-field">
						<div class="hsq-checkbox check-box-container">
							<label for="field-1"> <input type="checkbox" value="81"
								id="field-1"> <span></span> Parking
							</label>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3 col-md-2 search-field">
						<div class="hsq-checkbox check-box-container">
							<label for="field-2"> <input type="checkbox" value="81"
								id="field-2"> <span></span> Balcony
							</label>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3 col-md-2 search-field">
						<div class="hsq-checkbox check-box-container">
							<label for="field-3"> <input type="checkbox" value="81"
								id="field-3"> <span></span> Gym
							</label>
						</div>
					</div>


				</div>
				<button class="more-options btn">
					<i class="fa fa-chevron-down"></i>
				</button>
			</div>
		</section>
	</form>
	<!-- End of Property Search Box -->


	<!-- JS Include Section -->
	<script type="text/javascript" src="js/helper.js"></script>
	<script type="text/javascript" src="js/select2.min.js"></script>
	<script type="text/javascript" src="js/ion.rangeSlider.min.js"></script>
	<script type="text/javascript" src="js/owl.carousel.min.js"></script>
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