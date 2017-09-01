'use strict';
 
angular.module('Authentication')

.controller('loginCtrl',['$scope', 'AuthenticationService', function($scope,AuthenticationService) {	

	$scope.login = function() {
		$scope.dataLoading = true;
		alert("in controller");
		AuthenticationService.Login($scope.userid, $scope.password, function(response) {
				alert("calling service");				
                if(response.success) {
                    //AuthenticationService.SetCredentials($scope.username, $scope.password);
                    //$location.path('app.html');
					window.location = 'app.html';
                } else {
                    $scope.message = "Something went wrong";
                    $scope.dataLoading = false;
                }
            });
		/*$http.get("scripts/users.js").then(function (response) {		
			//alert(response.statusText);
			//alert(response.status);
			//alert(response.data.users);
			$scope.userList = response.data.users;
			//alert($scope.userList[0].name);
			//alert($scope.password);
			var validUser = false;
			$scope.message="incorrect credentials";
			for(var count = 0; count < $scope.userList.length; count++){
				//alert("response name: "+$scope.userList[count].name);
				//alert("response password: "+$scope.userList[count].password);
				//alert("entered name: "+$scope.userid);
				//alert("entered password: "+$scope.password);
				//alert($scope.password==$scope.userList[count].password);
				if($scope.password==$scope.userList[count].password && 
						angular.lowercase($scope.userid)==angular.lowercase($scope.userList[count].name)){
					//alert("validated");
					validUser = true;
					break;					
				}		

			}
			//alert(validUser);
			if(validUser==true){
				//alert("in true");
				window.location = 'app.html';
			}else{
				//alert("in false");
				//window.location = 'index.html';
			}
			//
		}, function(response) {
			//Second function handles error
			$scope.message = "Something went wrong";
		});*/
	};
}]);
/*.service('AuthenticationService', function($http) {
	alert("in service");
	var service = {};
	alert("in service2");
    service.Login = function (userid, password, callback) {
		$http.get("scripts/users.js")
		.then(function (response) {		
			//alert(response.statusText);
			//alert(response.status);
			//alert(response.data.users);			
			var validUser = false;
			response.success=false;
			for(var count = 0; count < response.data.users.length; count++){
				//alert("response name: "+$scope.userList[count].name);
				//alert("response password: "+$scope.userList[count].password);
				//alert("entered name: "+$scope.userid);
				//alert("entered password: "+$scope.password);
				//alert($scope.password==$scope.userList[count].password);
				if(password==response.data.users[count].password && 
						angular.lowercase(userid)==angular.lowercase(response.data.users[count].name)){
					//alert("validated");
					validUser = true;
					response.success=true;
					break;					
				}		

			}
			//alert(validUser);
			if(validUser){
				alert("in true");				
			}else{
				alert("in false");
				response.message="Incorrect Credentials";
			}
			callback(response);
		});
        
    };
	alert("in service3");
});
	  

*/