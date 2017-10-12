angular.module('Products')
.controller('productsCtrl', function($scope,$http,$location) {	

	//alert("started controller");
	
	$scope.grandTotal = 0;
	
	$http.get("http://localhost:3000/products")
	.then(function (response) {
		//alert("in products");
		//alert(response.data);
		$scope.products = response.data;
	},function(response) {    		
		$scope.error = "Host down or Network issue!";    		
    	//alert($scope.error);    	
	});
	
	$scope.addToCart = function(product_name,price,num){
		$scope.cart = $scope.cart || [];
		//alert("called addToCart: "+product_name);
		$scope.cart.push({"product_name":product_name,"price":price,"quantity":num});
		$scope.grandTotal = $scope.grandTotal + (price*num);
		
	}
	
	$scope.Range = function(start, end) {
	    var result = [];
	    for (var i = start; i <= end; i++) {
	        result.push(i);
	    }
	    return result;
	};
	
	$scope.order = function(){		
		//alert("order called");
		$scope.orderArray = [];
		angular.forEach($scope.cart, function(order){
			//alert(order.product_name);			
			$scope.orderArray.push({"product_name":order.product_name,"price":order.price,"quantity":order.quantity});
		});		
		//alert($scope.orderArray);		
		var order_id  = Math.floor(Math.random()*10000);
		//alert(order_id);		
		var order_object = {"id":order_id,"order":$scope.orderArray};		
		//alert(order_object);
		var order = JSON.stringify(order_object);		
		//alert(order);
		$http.post("http://localhost:3000/orders",order)
		.then(function(response){
				//alert("success"+response.status);
				$location.path('/orders');			  	
			   }, 
			   function(response){
				   alert("failure"+response.status);
				   alert("failure"+response.statusText);
			   }
		);		
		

	}

});
