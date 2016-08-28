<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>AccomFinder</title>

	<script type="text/javascript" src="/accomfinder/js/jquery-1.11.1.min.js"></script>
<!-- 
<link href="css/googlefont.css" rel="stylesheet" type="text/css"> -->

<link id="main-style-file-css" rel="stylesheet" href="/accomfinder/css/style.css" />

</head>
<body class="home-page-4">
	<header id="main-header">
		<div class="main-header-cont container">
			<!-- Top Logo -->
			<a href="/accomfinder/">
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

	<!--Breadcrumb Section-->
	<section class="breadcrumb-box" data-parallax="scroll" data-image-src="img/breadcrumb-bg.jpg">
		<div class="inner-container container">
			<h1>Page Not Found</h1>
			<div class="breadcrumb">
				<ul class="list-inline">
					<li class="home"><a href="../index-2.html">Home</a></li>
					<li><a href="#">Page Not Found - ${message} </a></li>
				</ul>
			</div>
		</div>
	</section>
	<!--Breadcrumb Section-->

	<section class="main-container container">
		<div class="not-found-container">
			<h2 class="hsq-heading type-2">Page Not Found</h2>
			<!-- <div class="subtitle">Bad Request</div> -->
			<!-- <div class="searchbox-container">
				<form class="search-form">
					<label>
						<span class="screen-reader-text">Search for:</span>
						<input type="search" class="search-field" placeholder="Search …" value="" name="s" title="Search for:">
					</label>
					<input type="submit" class="search-submit" value="Search">
				</form>
			</div> -->
		</div>

	</section>

	<!--Top Footer-->
	<!--End of Top Footer-->

	


	<!-- JS Include Section -->
	<script type="text/javascript" src="/accomfinder/js/helper.js"></script>
	<script type="text/javascript" src="/accomfinder/js/select2.min.js"></script>
	<script type="text/javascript" src="/accomfinder/js/ion.rangeSlider.min.js"></script>
	<script type="text/javascript" src="/accomfinder/js/owl.carousel.min.js"></script>
	<!-- <script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?libraries=places"></script> -->
	<script type="text/javascript" src="/accomfinder/js/template.js"></script>
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