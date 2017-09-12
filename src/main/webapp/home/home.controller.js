angular.module('Home', [])

.controller('homeCtrl', function($scope,$rootScope,$location,$cookieStore,AuthenticationService) {	
    
	$scope.creds = $rootScope.globals.currentUser.userid;
	$scope.message = 'Text put here';



});

