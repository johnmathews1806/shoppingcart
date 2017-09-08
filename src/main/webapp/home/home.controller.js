angular.module('Home', [])

.controller('homeCtrl', function($scope,$rootScope,$location,AuthenticationService) {	

	alert('in Home controller: '+$rootScope.globals.currentUser.userid);
	$scope.creds = $rootScope.globals.currentUser.userid;
	$scope.message = 'Text put here';



});

