angular.module('Profile')
.controller('profileCtrl', function($scope,$rootScope,$http,$location) {	

	//alert("started profile controller");

	$http.get("http://localhost:9000/shoppingcart/getContactDetails/"+$rootScope.globals.currentUser.userid)
	.then(function (response) {
		//alert("in profile");
		//alert(response.data);
		$scope.contactDetails = response.data;
	},function(response) {    		
		$scope.error = "Host down or Network issue!";    		
		//alert($scope.error);    	
	});


	$scope.updateContact = function(){				
		alert("contacts: "+JSON.stringify($scope.contactDetails));
		
		$http.post("http://localhost:9000/shoppingcart/updateContacts/"+$rootScope.globals.currentUser.userid, $scope.contactDetails)
			.then(function(response){
				alert("success"+response.status);
				$location.path('/profile');			  	
			}, 
			function(response){
				alert("failure"+response.status);
				alert("failure"+response.statusText);
			}
		);		


	}

});
