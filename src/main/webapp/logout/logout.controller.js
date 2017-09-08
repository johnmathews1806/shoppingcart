angular.module('Logout')
.controller('logoutCtrl', function($scope,$location,AuthenticationService) {
	
	
		alert('calling logout...');
		AuthenticationService.ClearCredentials();
		$location.path('/login');
	
});
