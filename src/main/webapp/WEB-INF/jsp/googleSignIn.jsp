<style>
#loading {
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	position: fixed;
	display: block;
	opacity: 0.7;
	background-color: #fff;
	z-index: 99;
	text-align: center;
}

#loading-image {
	position: absolute;
	top: 50%;
	left: 50%;
	z-index: 100;
}
</style>
<meta name="google-signin-client_id"
	content="163874478634-vg4h5dd1gc03uglno5ofob8ilatqqvv8.apps.googleusercontent.com">
<div id="loading">
	<img id="loading-image" src="/accomfinder/img/select2-spinner.gif"
		alt="Loading..." />
</div>
<li id="showusername" style="color: #333333; font-size: 1em;display:none">logged in as <span id="username"
	style="color:  #bfa249; font-size: 1em;"> </span>
	</li>
<li style="float: right;"><a id="my-signin2" ></a></li>
<li><a id="submit-property-link" style="display: none" class="btn"
	href="/accomfinder/newproperty"><span>Submit Your Property</span></a></li>
<li><span id="logout" style="display: none"><a id="login"
		class="btn">Logout</a></span></li>


<script type="text/javascript">
	/* window.oauthReady = function() {
		gapi.load('auth2', function() {
			gapi.auth2.init();
		}); */
	function login(googleUser) {
		var profile = googleUser.getBasicProfile();
		var name = profile.getName();
		/* console.log(profile);
		console.log('ID: ' + profile.getId());
		console.log('Name: ' + profile.getName());
		console.log('Image URL: ' + profile.getImageUrl());
		console.log('Email: ' + profile.getEmail());
		console.log(googleUser.getAuthResponse().id_token);
		console.log(googleUser); */
		document.getElementById('logout').style.display = "";
		document.getElementById('submit-property-link').style.display = "";
		//document.getElementById('my-signin2').style.display = "none";
		document.getElementById('showusername').style.display = "";
		document.getElementById('username').innerHTML = name;
		$.post('/accomfinder/loginUser', {
			name : profile.getName(),
			id : profile.getId(),
			email : profile.getEmail()
		});	
	}
	
	function renderButton() {
		gapi.signin2.render('my-signin2', {
			'scope' : 'profile email',
			'width' : 130,
			'height' : 50,
			'theme' : 'dark',
			'onsuccess' : login,
			'onfailure' : onFailure

		});
	}
	function onFailure(error) {
		console.log(error);alert("came");
	}

	function logout() {
		user = 0;
		var auth2 = gapi.auth2.getAuthInstance();
		auth2.signOut().then(function() {
			console.log('User signed out.');

		});
		document.getElementById('logout').style.display = "none";
		document.getElementById('submit-property-link').style.display = "none";
		document.getElementById('my-signin2').style.display = "";
		document.getElementById('showusername').style.display = "none";
		$.post('/accomfinder/logoutUser', {
		});

	}

	$('#logout').on('click', logout);
	//}
</script>
<script type="text/javascript">
	$(window).load(function() {
		$('#loading').hide();
	});
</script>



<script src="https://apis.google.com/js/platform.js?onload=oauthReady"
	async defer>
	
</script>

<script src="https://apis.google.com/js/platform.js?onload=renderButton"
	async defer></script>

