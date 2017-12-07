angular.module('Orders')
.controller('ordersCtrl', function($scope,$rootScope,$http,$route) {	
	
	$scope.dataLoading = true;
	//alert("started orders controller");
	$http.get("http://localhost:9000/shoppingcart/secure/getOrders/")	
	//$http.get("http://localhost:3000/orders/?loginId="+$rootScope.globals.currentUser.userid)
	.then(function (response) {
		//alert("in orders");
		//alert(JSON.stringify(response.data));
		$scope.orders = response.data;
		$scope.dataLoading = false;
	},function(response) {
		//alert(response.statusText);
		
		if(response.status=403){
			$scope.error = "Access Denied";
		}else{
			$scope.error = "Host down or Network issue!";
		}
    	alert($scope.error);    
		$scope.dataLoading = false;
	});
	
	$scope.deleteOrder = function(){		
		//alert("order called"+$scope.orders);		
		//alert($scope.selectedOrder);				
		$http.delete("http://localhost:9000/shoppingcart/secure/deleteOrder/"+$scope.selectedOrder)
		//$http.delete("http://localhost:3000/orders/"+$scope.selectedOrder)
		.then(function(response){
				//$location.path('/orders');
				$route.reload();
			  	//alert("success"+response.status);
			  	//alert("success"+response.statusText);
			   }, 
			   function(response){
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
