'use strict';
 
angular.module('Authentication')

.factory('AuthenticationService', function($http) {
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