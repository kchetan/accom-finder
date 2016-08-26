<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="js/jquery-1.11.1.min.js"></script>
<meta charset="UTF-8">
<title>Accomfinder</title>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAm95XTLoIBga5JdYinIDroS0HZZNE8jp8&libraries=places&callback=initAutocomplete"
	async defer></script>
<link href="css/googlefont.css" rel="stylesheet" type="text/css">
<link id="main-style-file-css" rel="stylesheet" href="css/style.css" />

</head>
<body class="submit-property">
	<header id="main-header">
		<div class="main-header-cont container">
			<!-- Top Logo -->
			<a href="/" >
			<div  class="logo-main-box col-xs-4 col-sm-4 col-md-6">
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
				
				<%@include
								file="googleSignIn.jsp"%>
			</ul>
				<!-- END of Main Menu -->

			</div>
			<div id="main-menu-handle" class="hidden-md hidden-lg">
				<i class="fa fa-bars"></i>
			</div>
			<!-- Mobile Menu handle -->
			<ul class="main-menu list-inline">
				<!-- <li><a id="submit-property-link" class="btn" href="newproperty"><span>Submit
							Your Property</span></a></li> -->
				
			</ul>

			<!-- End of Main Menu -->
		</div>
		<div id="mobile-menu-container" class="hidden-md hidden-lg"></div>
	</header>


	<section class="main-container container">
		<div class="descriptive-section">
			<h2 class="hsq-heading type-2">Submit Property</h2>

			<div class="content"></div>
		</div>
		<div class="submit-main-box clearfix">
			<form action="submitProperty" id="submit" method="POST">
				<div class="row t-sec">
					<div class="col-md-offset-2 col-md-8 l-sec">
						<div class="information-box">
							<h3>
								Basic Details <i class="fa fa-info"></i>
							</h3>

							<div class="box-content">

								<div class="field-row">
									<div class="input-group l-icon">
										<span class="input-group-addon">Title</span> <input
											name="title" type="text" placeholder="Title" id="p-title"
											autocomplete="off" required>
									</div>
								</div>
								<div class="field-row clearfix">
									<div class="col-xs-6">
										<div class="input-group l-icon">
											<span class="input-group-addon">Plot No.</span> <input
												name="plotNo" type="text" class="form-control" id="plotno"
												placeholder="...">
										</div>
									</div>
									<div class="col-xs-6">
										<div class="input-group l-icon">
											<span class="input-group-addon">Property Name</span> <input
												name="propertyName" type="text" class="form-control "
												id="plotno" placeholder="">
										</div>
									</div>
								</div>

								<div class="field-row clearfix">
									<div class="col-xs-6">
										<div class="search-field">
											<div class="input-group l-icon">
												<span class="input-group-addon">Locality</span> <input
													name="locality" type="text" placeholder="Location"
													id="autocomplete">
											</div>
										</div>
									</div>
									<div class="col-xs-6">
										<div class="input-group l-icon">
											<span class="input-group-addon">Property Type</span> <select
												id="p-type" name="propertyType">
												<c:forEach var="ptype" items="${propertyType}">
													<option value="${ptype.getId()}">${ptype.getType()}</option>
												</c:forEach>

											</select>
										</div>
									</div>
								</div>



								<div class="field-row clearfix">
									<div class="col-xs-6">
										<div class="input-group l-icon">
											<span class="input-group-addon">Rs.</span> <input type="number"
												class="" id="p-price"
												placeholder="Price" name="price">
										</div>
									</div>
									<div class="col-xs-6">
										<div class="input-group l-icon">
											<span class="input-group-addon">Bedrooms</span> <select
												id="bedroom" name="noBeds">
												<c:forEach var="nobed" items="${noBeds}">
													<option value="${nobed}"><b>${nobed}</b> Bedroom
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="field-row clearfix">
									<div class="col-xs-6">
										<div class="input-group l-icon">
											<span class="input-group-addon">Vacant</span> <select
												id="vacancy" name="vacancyFor">
												<c:forEach var="vacancy" items="${noBeds}">
													<option value="${vacancy}"><b>${vacancy}</b>
														Vacant
													</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="search-field col-xs-6">
										<div class="input-group l-icon">
											<span class="input-group-addon">Furnished Type</span> <select
												id="furnished" name="furnished">
												<option value="fully-furnished"><b>Furnished</b></option>
												<option value="semi-furnished"><b>Semi
														Furnished</b></option>
												<option value="unfurnished"><b>UnFurnished</b></option>
											</select>
										</div>
									</div>
								</div>
								<div class="field-row clearfix">
									<div class="col-xs-6">
										<div class="input-group r-icon">
											<input type="number" name="area" class=""
												id="p-land" placeholder="Area"> <span
												class="input-group-addon">sq.ft</span>
										</div>
									</div>

									<div class="col-xs-6">
										<div class="input-group r-icon">
											<span class="input-group-addon">Room For</span> <select
												id="roomfor" name="roomFor">
												<option value="male"><b>Male</b></option>
												<option value="female"><b>Female</b></option>
											</select>
										</div>
									</div>
								</div>

								<div class="field-row clearfix">
									<div class="col-xs-6">
										<div class="input-group l-icon">
											<span class="input-group-addon">Possession date.</span> <input
												name="possessionDate" type="date"
												class="form-control number-field" id="plotno"
												placeholder="...">
										</div>
									</div>
									<div class="col-xs-6">
										<div class="main-search-sec">
											<div class="search-field">
												<button class="btn">Submit</button>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>

					</div>
					<div class="col-md-2 r-sec"></div>
				</div>
				<div class="row b-sec"></div>
			</form>
		</div>
	</section>

	<!--Top Footer-->

	<!--End of Top Footer-->

	<footer id="main-footer">
		<div class="inner-container container">
			<div id="go-up" class="fa fa-angle-double-up"></div>

			<div class="bott-section .clearfix">
				<div class="col-md-6 copy-right">
					Copyright by <a href="" target="_blank">practo.com</a>
				</div>
				<div class="col-md-6 social-icons">
					<!-- <ul class="list-inline">
						<li><a href="#" class="fa fa-facebook"></a></li>
						<li><a href="#" class="fa fa-twitter"></a></li>
						<li><a href="#" class="fa fa-skype"></a></li>
						<li><a href="#" class="fa fa-google-plus"></a></li>
						<li><a href="#" class="fa fa-youtube"></a></li>
					</ul> -->
				</div>
			</div>
		</div>
	</footer>

	<!-- JS Include Section -->
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/helper.js"></script>
	<script type="text/javascript" src="js/select2.min.js"></script>
	<script type="text/javascript" src="js/dropzone.min.js"></script>
	<script type="text/javascript" src="js/template.js"></script>
	<!-- End of JS Include Section -->
	<script type="text/javascript">
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

		/* var myLatLng = new google.maps.LatLng(40.6700, -73.9400);
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
			mapTypeControl : false,
			panControl : false,
			zoomControlOptions : {
				style : google.maps.ZoomControlStyle.SMALL,
				position : google.maps.ControlPosition.LEFT_BOTTOM
			}
		};
		var map = new google.maps.Map(document.getElementById('p-map'),
				mapOptions);
		var image = 'img/marker-1.png';

		var marker = new google.maps.Marker({
			position : myLatLng,
			map : map,
			draggable : true,
			icon : image
		}); */
	</script>
</body>
</html>