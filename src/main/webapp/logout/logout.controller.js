angular.module('Logout')
.controller('logoutCtrl', function($scope,$location,$http,AuthenticationService) {
	
	
		//alert('calling logout...');
		
		$http({
	        method: 'post',
	        url: 'logout'	        
	    })
		//When Response is OK
		.then(function (response) {    	
			alert("logout success");			
		}
		//When Response is NOT OK
		,function(response) {			    		
			alert("logout failure");			
		});
		AuthenticationService.ClearCredentials();
		//$location.path('/login');
		window.location = 'index.html';
	
});
