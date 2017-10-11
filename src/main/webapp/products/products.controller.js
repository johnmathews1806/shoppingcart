angular.module('Products')
.controller('productsCtrl', function($scope,$http,$location) {	

	//alert("started controller");
	
	$http.get("http://localhost:3000/products")
	.then(function (response) {
		//alert("in products");
		//alert(response.data);
		$scope.products = response.data;
	},function(response) {    		
		$scope.error = "Host down or Network issue!";    		
    	//alert($scope.error);    	
	});
	
	$scope.order = function(){		
		//alert("order called");
		$scope.orderArray = [];
		angular.forEach($scope.products, function(product){
			//alert(product.product_name+' - '+product.selected);
			if(product.selected){	
				$scope.orderArray.push({"product_name":product.product_name});				
			}			
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
