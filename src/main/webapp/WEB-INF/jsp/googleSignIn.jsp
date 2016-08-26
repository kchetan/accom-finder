<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Submit Property - Responsive RealEstate template</title>
<script src="https://apis.google.com/js/platform.js?onload=oauthReady"
	async defer>
	
</script>

<script src="https://apis.google.com/js/platform.js?onload=renderButton"
	async defer></script>
<meta name="google-signin-client_id"
	content="163874478634-vg4h5dd1gc03uglno5ofob8ilatqqvv8.apps.googleusercontent.com">



</head>
<body class="home-page-4">
<li><a id="my-signin2"></a></li>
<li><a id="submit-property-link" style= "display:none"class="btn" href="newproperty"><span>Submit
							Your Property</span></a></li>
	
	
<li><span id="logout" style="display:none"><a id="login" class="btn">Logout</a></span></li>

	<script type="text/javascript">
		/* window.oauthReady = function() {
			gapi.load('auth2', function() {
				gapi.auth2.init();
			}); */
		function login(googleUser) {
			user = 1;
			var profile = googleUser.getBasicProfile();
			/* console.log(profile);
			console.log('ID: ' + profile.getId());
			console.log('Name: ' + profile.getName());
			console.log('Image URL: ' + profile.getImageUrl());
			console.log('Email: ' + profile.getEmail()); */
			document.getElementById('logout').style.display = "";
			document.getElementById('submit-property-link').style.display = "";
			$.post('loginUser', {
                name : profile.getName(),
                id : profile.getId(),
                email : profile.getEmail()
            });
		}
		function renderButton() {
			gapi.signin2.render('my-signin2', {
				'scope' : 'profile email',
				'width' : 240,
				'height' : 50,
				'longtitle' : true,
				'theme' : 'dark',
				'onsuccess' : login,
				'onfailure' : onFailure

			});
		}
		function onFailure(error) {
			console.log(error);
		}

		function logout() {
			user = 0;
			var auth2 = gapi.auth2.getAuthInstance();
			auth2.signOut().then(function() {
				console.log('User signed out.');

			});
			document.getElementById('logout').style.display = "none";
			document.getElementById('submit-property-link').style.display = "none";
			$.post('logoutUser', {
                
            });
			
		}

		$('#logout').on('click', logout);
		//}
	</script>
</body>


</html>