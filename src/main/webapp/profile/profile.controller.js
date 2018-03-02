angular.module('Profile')
.controller('profileCtrl', function($scope,$rootScope,$http,$route) {	

	//alert("started profile controller");
	$scope.dataLoading = true;
	$http.get("http://localhost:9000/shoppingcart/secure/getContactDetails/"+$rootScope.globals.currentUser.userid)
	.then(function (response) {
		//alert("in profile");
		//alert(response.data);
		$scope.formDetails = response.data;		 
		$scope.dataLoading = false;
	},function(response) {    		
		$scope.error = "Host down or Network issue!";    		
		//alert($scope.error);    
		$scope.dataLoading = false;
	});


	$scope.updateContact = function(){				
		//alert("in update...");
		//alert("contacts: "+JSON.stringify($scope.formDetails.contactDetails));
		$scope.submitInProcess = true;
		$http.post("http://localhost:9000/shoppingcart/secure/updateContacts/"+$rootScope.globals.currentUser.userid, $scope.formDetails.contactDetails)
			.then(function(response){
				$scope.submitInProcess = false;
				//alert("success"+response.status);
				$route.reload();							  	
			}, 
			function(response){
				$scope.submitInProcess = false;
				if(response.status=403){
					//$scope.error = "You do not have rights to perform this action !";
				   alert("You do not have rights to perform this action !");
				}else{
					$scope.error = "Host down or Network issue!";
				}				
				//alert("failure"+response.statusText);
			}
		);		


	}

});
