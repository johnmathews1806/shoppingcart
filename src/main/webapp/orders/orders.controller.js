angular.module('Orders')
.controller('ordersCtrl', function($scope,$rootScope,$http,$route) {	
	
	$scope.dataLoading = true;
	//alert("started orders controller");
	$http.get("http://localhost:9000/shoppingcart/secure/getOrders/"+$rootScope.globals.currentUser.userid)
	//$http.get("http://localhost:3000/orders/?loginId="+$rootScope.globals.currentUser.userid)
	.then(function (response) {
		//alert("in orders");
		//alert(JSON.stringify(response.data));
		$scope.orders = response.data;
		$scope.dataLoading = false;
	},function(response) {    		
		$scope.error = "Host down or Network issue!";    		
    	//alert($scope.error);    
		$scope.dataLoading = false;
	});
	
	$scope.deleteOrder = function(){		
		//alert("order called"+$scope.orders);		
		alert($scope.selectedOrder);				
		$http.delete("http://localhost:9000/shoppingcart/secure/deleteOrder/"+$scope.selectedOrder)
		//$http.delete("http://localhost:3000/orders/"+$scope.selectedOrder)
		.then(function(response){
				//$location.path('/orders');
				$route.reload();
			  	//alert("success"+response.status);
			  	//alert("success"+response.statusText);
			   }, 
			   function(response){
				   alert("failure"+response.status);
				   alert("failure"+response.statusText);
			   }
		);		
		

	}

});
