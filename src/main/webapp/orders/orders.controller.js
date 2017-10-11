angular.module('Orders')
.controller('ordersCtrl', function($scope,$http,$route) {	

	//alert("started orders controller");
	
	$http.get("http://localhost:3000/orders")
	.then(function (response) {
		//alert("in orders");
		//alert(response.data);
		$scope.orders = response.data;
	},function(response) {    		
		$scope.error = "Host down or Network issue!";    		
    	//alert($scope.error);    	
	});
	
	$scope.deleteOrder = function(){		
		//alert("order called"+$scope.orders);		
		//alert($scope.selectedOrder);				
		
		$http.delete("http://localhost:3000/orders/"+$scope.selectedOrder,"")
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
